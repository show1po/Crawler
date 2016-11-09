<%--
  Created by IntelliJ IDEA.
  User: Show
  Date: 2016/10/21
  Time: 上午 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>地圖</title>
    <script type='text/javascript'
            src='http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.js'></script>
    <script type="text/javascript" src="/extjs/ext-all.js"></script>
    <link rel="stylesheet" type="text/css" href="/extjs/resources/css/ext-all.css">
    <script type="text/javascript" src="../js/index.js"></script>
    <style type="text/css">
        html, body { height: 100%; margin: 0; padding: 0; }
        #map { height: 100%; }
    </style>
    <script type="text/javascript" src="../js/googlemap.js"></script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBXEYwOgKuDi97xxGVpzxFfb9EmPy8Kc6c&callback=initMap">
    </script>
</head>
<body>
<div id ="main"></div>
<div id ="map"></div>
</body>
</html>
