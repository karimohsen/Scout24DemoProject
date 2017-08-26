<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<h1>Picture Gallery</h1>
<style>
img {
    width: 100%;
    height: auto;
}
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    width:100%;
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
</script>
</head>

<body>

	<img id="image" src="data:image/jpeg;base64,${image}">
    <input class="button" type="button" value="Next" onclick="show_image('next')" />
    <input class="button" type="button" value="Previous" onclick="show_image('prev')" />

</body>

</html>
