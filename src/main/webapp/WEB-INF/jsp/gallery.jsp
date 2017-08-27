<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="/css/main.css" rel="stylesheet" />
<link rel="stylesheet" href="/css/bootstrap.css">
<script type="application/javascript" src="/js/hammer.js"></script>
    <script>
        function show_image(value) {
             var imageNum;
             if(value === "prev"){
                imageNum = Number(${imageId}) - 1;
             }else{
                imageNum = Number(${imageId}) + 1;
             }
             sendRequest('/pic?image='+imageNum);
        }


        function sendRequest(url){
            window.location.href = url;
        }

        window.onload = function setImageCounter(){
            document.getElementById("counter").textContent="( "+${imageId} + " / " + ${numberOfImages}+" )";
            Hammer(document.getElementById("image")).on("swipeleft", function() {
                    show_image('prev');
                });
                Hammer(document.getElementById("image")).on("swiperight", function() {
                    show_image('next');
                });
        };
    </script>

</head>

<body>
    <div class="container">
        <h1 class="text-center">Picture Gallery</h1>
        <div class="row">
            <p id="counter" class="p"></p>
            <div class="col-md-12">
                <img class="slider-img" id="image" src="data:image/jpeg;base64,${image}"/>
                <button class="slider-button slider-right" onclick="show_image('next')"><i class='fa fa-angle-right'></i></button>
                <button class="slider-button slider-left" onclick="show_image('prev')" /><i class='fa fa-angle-left'></i></button>
            </div>
        </div>
    </div>
</body>

</html>