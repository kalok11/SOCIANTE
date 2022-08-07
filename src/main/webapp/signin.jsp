<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>HTML5 Login Form with validation Example</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/signin.css">

</head>
<body style="background-image: url('assets/img/car3.jpg');">
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<div id="login-form-wrap">
  <h2>Login</h2>
  <form id="login-form" method="post" action="login">
    <p>
    <input type="text" id="username" name="username" placeholder="Username" required="required"  />
    </p>
    <p>
    	<input type="password" name="password" id="password" placeholder="Password" required="required" />
    </p>
    <p>
    <input type="submit" id="login" value="Login">
    </p>
  </form>
  <div id="create-account-wrap">
    <p>Not a member? <a href="register.jsp">Create Account</a><p>
  </div>
</div>


<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
	var status=document.getElementById("status").value;
	
	if(status =="failed"){
		
		swal("Sorry","Wrong Username or Password.","error");
	}
	else if(status =="invalidUserName"){
		
		swal("Sorry","Inser UserName.","error");
	}
	else if(status =="invalidPassword"){
	
	swal("Sorry","Insert Password.","error");
}
	</script>
  
</body>
</html>
