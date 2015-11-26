<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MasterBooks</title>
<!-- jTable Metro styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- jTable script file. -->
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<!-- User Defined Jtable js file -->
<script src="js/bookJTableJs.js" type="text/javascript"></script>

</head>
<body>
<center>

<div class="filtering">
    <form>
        Book Title: <input type="text" name="title" id="title" />
        Author First Name: 
        <select id="authorFName" name="authorFName">
            <option selected="selected" value="ALL">All Authors</option>
            <option value="Ashish">Ashish</option>
            <option value="Tanya">Tanya</option>
        </select>
        <button type="submit" id="LoadRecordsButton">Search Books</button>
    </form>
</div>


<div style="text-align: center;">
	<h2>MastersBook Inventory House</h2>
	<div id="BookContainer"></div>
</div>

</center>	
</body>
</html>