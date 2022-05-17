<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<script>
/*function book(){
	window.alert("Booked");
	document.location = "mybooking";
};*/
</script>
<style>
body{
 background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYabJCdT48u9C46nNeO316nMTwOVL1utuLEg&usqp=CAU);
 
 background-repeat: no-repeat;
 background-size: 1300px 800px;
}
#seats{
color:red;
}
#main{
background-color:white;
margin-top:30px;
margin-left:300px;
margin-right:300px;
padding-top: 50px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 80px;
}
.in{    
    border:none;
}
#but{
margin-left:250px;
}
H4{
TEXT-ALIGN:CENTER;
color:red;}</style>
<body>

<form action="mybooking">
<div id="main">
<h4><b>CONFIRMATION</b></h4><BR>
<table class="table">
 	<tbody>
  		<tr>
      <th scope="row"> Boarding point </th>
   	  <td><input value="${fromDest}" class="in" name="fromDest" size="5" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Destination point </th>
      <td><input value="${toDest}"  class="in" name="toDest" size="5" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Date of Boarding </th>
      <td><input value="${bDate}"  class="in" name="bDate" size="8" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Bus Name </th>
      <td><input value="${busName}" class="in"  name="busName" size="10" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Start time  </th>
      <td><input value="${startTime}"  class="in"  name="startTime" size="5" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> End Time </th>
      <td><input value="${endTime}"  class="in" name="endTime" size="5" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Ac_type   </th>
      <td><input value="${ac_type}" class="in"  name="ac_type" size="3" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Sleep_type  </th>
      <td><input value="${sleep_type}" class="in"  name="sleep_type" size="8" readonly/></td>
     	</tr>
     	<tr>
      <th scope="row"> Rate </th>
      <td><input value="${rate}"  class="in" name="rate" size="3" readonly/></td>
     	</tr>
     	
     	
     </tbody>
</table>	
Seats wanted <input type=number id="seater" name="seater" size="1" min="1" max="${seatNumber}" required/>
<p id="seats">No of seats left :${seatNumber} </p>

<input type ="submit" id="but" value="confirm" class="btn btn-success btn-sm"/></div>
<!--  <a  href="back" class="btn btn-success btn-sm" >Back</a>-->
</form>

</body>
</html>