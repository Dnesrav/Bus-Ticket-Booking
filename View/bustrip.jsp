
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Bus trip details</title>
</head>

<style>

body{
 background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYabJCdT48u9C46nNeO316nMTwOVL1utuLEg&usqp=CAU);
 
 background-repeat: no-repeat;
background-size: 1300px 800px;
}

#main{
background-color:white;
margin-top:150px;
}
H4{
TEXT-ALIGN:CENTER;
color:red;}
</style>
<script>


</script>
<body>
<
<div id="main" >
<h4><b>AVAILABLE TRIPS</b></h4>
<table class="table">
  <tr>
    <th>Source</th>
    <th>Destination</th>
    <th>Date</th>
    <th>Bus Name</th>
    <th>Start time</th>
    <th>End time</th>
    <th>ac type</th>
    <th>sleep type</th>
    <th>rate</th>
  </tr>
  
 
    
   	<c:forEach var="list" items="${busList}">
   	 <tr>
   	 <form action="book">
   	 <td><input style="border:none" value="${list.fromDest}" name="fromDest" size="5" readonly/></td>
   	 <td><input style="border:none" value="${list.toDest}" name="toDest" size="5" readonly/></td>
   	 <td><input style="border:none" value="${bDate}" name="bDate" size="8" readonly/></td>
   	 <td><input style="border:none" value="${list.busName}" name="busName" size="10" readonly/></td>
   	 <td><input style="border:none" value="${list.startTime}" name="startTime" size="5" readonly/></td>
   	 <td><input style="border:none" value="${list.endTime}" name="endTime" size="5" readonly/></td>
   	 <td><input style="border:none" value="${list.ac_type}" name="ac_type" size="3" readonly/></td>
   	 <td><input style="border:none" value="${list.sleep_type}" name="sleep_type" size="8" readonly/></td>
   	 <td><input style="border:none" value="${list.rate}" name="rate" size="3" readonly/></td>
   	 <td><input type ="Submit" value="confirm" class="btn-primary primary btn-sm"/></td>
	</form>	
	</tr>	
  		
		
		</c:forEach>
  
 
</table>

</div>
<br>
<br>
<div class="text-center">
<form action="back">
<input type="submit" value="Back" id="back" class="btn-success success btn-sm"/></form>
</div>

</body>
</html>