<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<h1>Picture Gallery</h1>
</head>
<body>

	<img id="image" src="data:image/jpeg;base64,${image}">
    <input type="button" value="Next" onclick="show_image()"/>
    <input type="button" value="Prev" onclick="show_image()"/>

</body>

</html>
