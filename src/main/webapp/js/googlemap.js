/**
 * Created by Show on 2016/10/24.
 */
function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: {lat: 40.731, lng: -73.997}
    });
    // var geocoder = new google.maps.Geocoder;
    // var infowindow = new google.maps.InfoWindow;
    geocodeLatLng( map,mapResult);
    // document.getElementById('submit').addEventListener('click', function() {
    // });
}
// var marker;
var markers=[];
function geocodeLatLng( map,mapResult) {
    // var input = document.getElementById('latlng').value;
    // var latlngStr = input.split(',', 2);
    // var latlngStr="25.13684,121.50408".split(',', 2);
    // var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};
    var image = {
        url: '../images/beachflag.png',
        // This marker is 20 pixels wide by 32 pixels high.
        size: new google.maps.Size(20, 32),
        // The origin for this image is (0, 0).
        origin: new google.maps.Point(0, 0),
        // The anchor for this image is the base of the flagpole at (0, 32).
        anchor: new google.maps.Point(0, 32)
    };
    var geocoder = new google.maps.Geocoder;
    for(var i in mapResult){
        var latlng = mapResult[i].latlng[0];
        var marker = new google.maps.Marker({
            position: latlng,
            icon: image,
            animation: google.maps.Animation.DROP,
            title:mapResult[i].dateTime,
            map: map
        });
        markers.push(marker);


        // geocoder.geocode({'location': latlng}, function(results, status) {
        //     if (status === google.maps.GeocoderStatus.OK) {
        //         var marker = new google.maps.Marker({
        //             position: latlng,
        //             icon: image,
        //             animation: google.maps.Animation.DROP,
        //             // title:mapResult[i].dateTime,
        //             map: map
        //         });
        //         if (results[1]) {
        //             var infowindow = new google.maps.InfoWindow;
        //             infowindow.setContent(results[1].formatted_address);
        //             infowindow.open(map, marker);
        //             // map.setZoom(16);
        //         } else {
        //             window.alert('No results found');
        //         }
        //     } else {
        //         window.alert('Geocoder failed due to: ' + status);
        //     }
        // });

    }
    mappingAdress();
    var bounds = new google.maps.LatLngBounds();
    //加入標示點(Marker)
    for (var i = 0; i < markers.length; i++) {
        var m = markers[i];
        //將此座標納入檢視範圍
        bounds.extend(m.position);
        var marker = new google.maps.Marker({
            position: m.latlng,
            title: m.title,
            map: map
        });
    }
    //調整檢視範圍
    map.fitBounds(bounds);
}
function mappingAdress() {
    // for(var m in markers){
    var def = new jQuery.Deferred();
    function geocodeAjax(marker){var geocoder = new google.maps.Geocoder;
        var formatted_address='No results found';
        var latlng =marker.position.toJSON();
        // mark=markers[m];
        console.log(latlng);
        geocoder.geocode({'location': latlng},function(results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                if (results[1]) {
                    console.log(marker);
                    formatted_address='<b>地址: </b> '+results[1].formatted_address;
                    var date_time='<b>時間: </b> '+marker.title;
                    console.log(formatted_address);
                    // map.setZoom(16);
                    var infowindow = new google.maps.InfoWindow;
                    infowindow.setContent(formatted_address+'<br/>'+date_time);
                    infowindow.open(map, marker);

                } else {
                    window.alert('No results found');
                }
                def.resolve();
            } else {
                window.alert('Geocoder failed due to: ' + status);
                def.reject();
            }
        });
        return def.promise();}
    var deferredArray = [];
    for (var i = 0; i < markers.length; i++) {
        // var parts = lines[i].split(',');
        //以AJAX進行地址轉換，並將$.ajax() deferred物件放入陣列中
        deferredArray.push(geocodeAjax(markers[i]));
    }
    // console.log(formatted_address);
    // setTimeout(function() {}, 1000);
    // }
}
// function toggleBounce() {
//     if (marker.getAnimation() !== null) {
//         marker.setAnimation(null);
//     } else {
//         marker.setAnimation(google.maps.Animation.BOUNCE);
//     }
// }