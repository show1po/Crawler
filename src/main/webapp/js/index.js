/**
 * Created by Show on 2016/10/23.
 */
var mapResult;
var itemsPerPage=3;
Ext.onReady(function() {
    Ext.Ajax.request({
        url: 'Position/getData',
        params: {
            account: 'albert'
        },
        success: function(response){
            var text = response.responseText;
            var detailData=JSON.parse(text);
            console.log(detailData);
            mapResult=detailData;
            var detailStore= new Ext.data.Store({
                autoLoad: false,
                pageSize:itemsPerPage,
                fields:[
                    {name:"display"},
                    {name:"dateTime"},
                    {name:"address"}
                ],
                proxy: {
                    type: 'memory',
                    enablePaging: true,
                    reader: {
                        type: 'json'
                    }
                },
                data:detailData
                //     [
                //     {
                //         "type":"geo",
                //         "value":{"lat": 25.047923, "lng": 121.51708},
                //         "date":"2016-09-23 19:20:30"
                //     },{
                //         "type":"geo",
                //         "value":{"lat": 23.89571, "lng": 120.5808},
                //         "date":"2016-09-23 22:20:30"
                //     }
                // ]
            });
            detailStore.load({
                params:{
                    start:0,
                    limit: itemsPerPage
                }
            });
            tt=detailStore;
            var detailColumns= [{
                flex:  1,
                header: '顯示',
                dataIndex: 'display',
                // renderer:function (display) {
                //     return {checked: display, xtype: 'checkbox'};
                // }
            },{
                flex:  1,
                header: '時間',
                sortable: true,
                dataIndex: 'dateTime'
            }, {
                header: '地點',
                width: 200,
                sortable: true,
                dataIndex: 'address'
            }];
            var pagingtoolbar =Ext.create("Ext.PagingToolbar",{
                store:detailStore,
                displayInfo:true,
                displayMsg : '目前顯示{0} - {1}, 共 {2} 筆。',
                beforePageText : '頁數:',
                afterPageText : '/ {0}',
            })
            var detailGrid=Ext.create('Ext.grid.Panel', {
                enableDragDrop: true,
                forceFit:true,
                stripeRows: true,
                width: 140,
                margins: '0 5 0 0',
                store:detailStore,
                columns:detailColumns,
                bbar:pagingtoolbar
                // ,
                // viewConfig:
                // {
                //     plugins: {
                //         ddGroup: 'grid-to-form',
                //         ptype
                //             :
                //             'gridviewdragdrop',
                //         enableDrop
                //             :
                //             false
                //     }
                // }
            });
            Ext.create('Ext.panel.Panel', {
                title: 'Hello',
                width: 1200,
                height: 500,
                layout:'border',
                items: [{
                    split: true,
                    title: 'West Region is collapsible',
                    region:'west',
                    xtype: 'panel',
                    tbar: [
                        {},{
                            xtype: 'datefield',
                            // fieldLabel: 'Drag this date',
                            value: new Date(),
                            format: 'Y-m-d'
                        },{xtype: 'tbfill'}
                        ,{ xtype: 'button', text: '查詢' }
                    ],
                    items:[detailGrid],
                    margins: '5 0 0 5',
                    width: 350,
                    collapsible: true,   // make collapsible
                    id: 'west-region-container',
                    layout: 'fit'
                },{
                    title: 'Center Region',
                    region: 'center',     // center region is required, no width/height specified
                    xtype: 'panel',
                    layout: 'fit',
                    margins: '5 5 0 0',
                    contentEl:'map'
                    // html: '<div id="map"></div>'
                }],
                renderTo: Ext.getElementById("main")
            });


        }
    });

    // Ext.MessageBox.alert('title', 'msg');
});
