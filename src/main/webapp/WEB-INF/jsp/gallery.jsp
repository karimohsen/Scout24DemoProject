<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://hammerjs.github.io/dist/hammer.js"></script>
<head>
<h1>Picture Gallery</h1>
<style>
img {
    width: 100%;
    height: auto;
}
.p{
    border: none;
    color: #4CAF50;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    width:100%;
}
.button {
    background-color: #4CAF50;
    border: 2px solid black;
    border-radius: 12px;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    width:100%;
}
@keyframes slideInFromLeft {
  0% {
    transform: translateX(-100%);
  }
  100% {
    transform: translateX(0);
  }
}

img {  
  animation: 1s ease-out 0s 1 slideInFromLeft;

  background: #333;
  padding: 30px;
}

</style>
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
    <p id="counter" class="p"></p>
	<img id="image" src="data:image/jpeg;base64,${image}"/>
    <input class="button" type="button" value="Next" onclick="show_image('next')" />
    <input class="button" type="button" value="Previous" onclick="show_image('prev')" />

</body>

</html>
