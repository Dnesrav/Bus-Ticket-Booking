<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<style>
#e{color:red;
}
#s{color:green;
}

#main{
margin: 100px 400px 0px 40px;
padding-top:75px;
padding-bottom:75px;

}
h6{
text-align:center;}
body{
 background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYabJCdT48u9C46nNeO316nMTwOVL1utuLEg&usqp=CAU);
 
 background-repeat: no-repeat;
background-size: 1300px 800px;
}
label{
color:blue;
}
</style>
<script>

function change() {
	
    var tmp = document.getElementById('from').value;
    document.getElementById('from').value = document.getElementById('to').value;
    document.getElementById('to').value = tmp;
};
function check(){
	if((document.getElementById('from').value !="")&&(document.getElementById('to').value!=""))
	{
		if(document.getElementById('from').value == document.getElementById('to').value)
		{
		alert("source and destination cant be same");
		document.getElementById("page").reset();
		}
		
	}
	
	//form.reset();
};
function minDate(){
	var date=new Date();
	var CurDay=date.getDate();
	var curMonth=date.getMonth()+1;
	var curYear=date.getFullYear();
if(CurDay<10 && curMonth<10 )	
	document.getElementById("calendar").min = curYear+"-0"+curMonth+"-0"+CurDay;
else if (curMonth<10 && CurDay>9)
	document.getElementById("calendar").min = curYear+"-0"+curMonth+"-"+CurDay;
else if (curMonth>9 && CurDay<10)
	document.getElementById("calendar").min = curYear+"-"+curMonth+"-0"+CurDay;
else
	document.getElementById("calendar").min = curYear+"-"+curMonth+"-"+CurDay;

};
</script>

<body >
<div id="main"  >
<h6>Hi ${Dbuser}</h6>
<br>
<br>
<form id="page" action="trip">
<div align ="center"><label for="bdate">Boarding point:</label>
<select id ="from" name="fromDest" class="dropdown">
<option></option>
<option>Chennai</option>
<option>Bangalore</option>
<option>Mumbai</option>
<option>Delhi</option>
<option>Kolkata</option>
</select>&nbsp;&nbsp;&nbsp;
<input type="button" value="Swap" onclick="change()" class="btn btn-warning btn-sm"/>&nbsp;&nbsp;&nbsp;
 <label for="ddate">Destination point:</label>
<select id="to"  name="toDest"   >
<option></option>
<option>Bangalore</option>
<option>Chennai</option>
<option>Mumbai</option>
<option>Delhi</option>
<option>Kolkata</option>

</select><br><br>
<p id="toerror"></p>
<label for="calendar">Boarding Date</label>
<input type="date" id="calendar" name="date" onclick="minDate()" required/>
<br>
<br>
<input type="submit" value="Search" onclick="check()" class="btn btn-success btn-sm"/>
<a  href="viewbook" class="btn btn-success btn-sm" role ="button">My Bookings</a>

</form>

</div>
</div>
</body>
</html>