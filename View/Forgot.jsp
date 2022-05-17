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
<title>Change password</title>
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

}</style>
<body>

<div id="main" align="center">
<h5>Change password</h5>
<br>
<form action="change">
<label>Enter Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="text" class="col-xs-2" name="Name"/>
<br>
<br>
<label>Enter Number:&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="text"  class="col-xs-2" name="Number"/>
<br>
<br>
<label>Enter Password:&nbsp;&nbsp;&nbsp;</label>
<input type="text" class="col-xs-2" name="Password"/>
<br>
<br>
<p id="s">${smessage}</p>
<p id="e">${message}</p>

<br>
<input type="submit" value="Change Password" class="btn btn-primary btn-sm">
<a href="login"><input type="button" value="back" class="btn btn-primary btn-sm" /></a>
</form>

</div>
</body>
</html>