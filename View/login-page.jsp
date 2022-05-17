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
<title>Login</title>
</head>
<style>
#main{
 margin: 100px 400px 0px 400px;
background-color:white;	
padding-top:75px;
padding-bottom:75px;

}

#logi{
margin-left:120px;
}
h5{
color:blue;
}
p{
color:red;
}
body{
background-color:#FDEFB2;
}
</style>
<body>
<div id ="main" align="center" >

<h5><b>Welcome to BlueBus!! Login</b></h5>
<br>
<br>	
<form action="last">
<div >
<div >
<label for="name">Enter UserName</label>
<input type="text" class="col-xs-2"  id="name"name="Number" required/>
<br>
<br>
<label for="pass">Enter Password &nbsp;</label>
<input type="Password" class="col-xs-2" id="pass" name="Password" required>
<br>
</div>
<br>
</div>
<input type="submit" value="Log in" class="btn btn-success btn-sm" id="logi">
<a  href="forgot" class="btn btn-outline-warning btn-sm" role ="button">Forgot Password ?</a>
<br>
<br>
<p>${message}</p>
</form>
<form action="register" id="signin">
New User! Register Here 
 &nbsp;&nbsp;<input type="submit" value="Sigin" class="btn btn-outline-warning btn-sm">

</form>

</div>


</body>
</html>