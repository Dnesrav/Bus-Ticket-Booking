<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>

<style>
#e{color:red;
}
#s{color:green;
}
body{
background-color:#3C99DC;
}
#main{
margin: 100px 400px 0px 400px;
background-color:white;	
padding-top:75px;
padding-bottom:75px;

}
label{
color:blue;
}</style>


<body>

<div align="center" id="main">
<h5>New User!! Register here</h5><br>	
<form action="confirm">
<label>Enter Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="text" name="Name" required/>
<br>
<br>
<label>Enter Number:&nbsp;&nbsp;&nbsp;</label>
<input type="text" name="Number" required/>
<br>
<br>
<label>Enter EmailId:&nbsp;&nbsp;&nbsp;</label>
<input type="text" name="EmailId" required/>
<br>
<br>
<label>Enter Password:&nbsp;</label>
<input type="text" name="Password" required/>
<br>
<br>
<label id="g" >Gender :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="radio" class="form-check-input" name="gender" value="Male" required/>&nbsp;Male
<input type="radio" class="form-check-input" name="gender" value="Female" required/>&nbsp;Female
<br>
<br>
<p id="e">${emessage}</p>
<p id="s">${smessage}</p>
<br>
<input type="submit" value="Register" class="btn btn-success btn-sm"/>

<a href="login"><input type="button" value="Back" class="btn btn-primary btn-sm" /></a>
</form>
</div>
</body>
</html>