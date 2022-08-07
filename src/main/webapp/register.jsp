<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Registration Page</title>
    <link rel="stylesheet" href="css/register.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body style="background-image: url('assets/img/1.png');">
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
  <div class="container">
    <div class="title">Registration</div>
    <div class="content">
      <form method="post" action="register">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Full Name</span>
           <input type="text" name="fname" id="name" placeholder="Your First Name" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Middle Name</span>
            <input	type="text" name="midname" id="name" placeholder="Your Middle Name" required="required"/>
          </div>
          
          <div class="input-box">
            <span class="details">Last Name</span>
            <input	type="text" name="lname" id="name" placeholder="Your Last Name" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Address</span>
           <input	type="text" name="address" id="name" placeholder="Your Address" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
          <input	type="password" name="pass" id="pass" placeholder="Password" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password</span>
            <input type="password" name="re_pass" id="re_pass"	placeholder="Repeat your password" required="required"/>
          </div>
                 <div class="input-box">
            <span class="details">Phone Number</span>
            <input	type="text" name="pnumber" id="pnumber" placeholder="Your Phone number" required="required" />
          </div>
          <div class="input-box">
            <span class="details">Email</span>
            <input	type="email" name="email" id="email" placeholder="Your Email" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Civil Status</span>
          <input	type="text" name="civilStatus" id="civilStatus" placeholder="Your civilStatus" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Age</span>
           <input	type="text" name="age" id="age" placeholder="Your age" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">Dob</span>
            <input	type="text" name="dob" id="dob" placeholder="Your dob" required="required"/>
          </div>
          <div class="input-box">
            <span class="details">UserName</span>
            <input	type="text" name="username" id="username" placeholder="Your username" required="required" />
          </div>
           <div class="input-box">
            <span class="details">Gender</span>
             <input	type="text" name="gender" id="gender" placeholder="Your gender" required="required"/>
          </div>
        </div>
        
       
        <div class="button">
          <input type="submit" value="Register">
        </div>
      </form>
    </div>
    <div class="signup-image">	<a href="signin.jsp" class="signup-image-link">I am already member</a>
	</div>
  </div>


	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
	var status=document.getElementById("status").value;
	
	if(status =="success"){
		
		swal("Congrats","Account created successfully.","success");
	}
if(status =="invalidfname"){
		
		swal("Sorry","Input the First Name.","error");
	}
if(status =="invalidmidname"){
	
	swal("Sorry","Input the Middle Name.","error");
}
if(status =="invalidlname"){
	
	swal("Sorry","Input the Last Name.","error");
}
if(status =="invalidaddress"){
	
	swal("Sorry","Input the Address.","error");
}
if(status =="invalidemail"){
	
	swal("Sorry","Input the email.","error");
}
if(status =="invalidpnumber"){
	
	swal("Sorry","Input the Phone number.","error");
}
if(status =="invalidcivilStatus"){
	
	swal("Sorry","Input the Civil Status.","error");
}
if(status =="invalidgender"){
	
	swal("Sorry","Input the gender.","error");
}
if(status =="invalidage"){
	
	swal("Sorry","Input the Age.","error");
}
if(status =="invaliddob"){
	
	swal("Sorry","Input the DOB.","error");
}
if(status =="invalidusername"){
	
	swal("Sorry","Input the User Name.","error");
}
if(status =="invalidpass"){
	
	swal("Sorry","Input the Password.","error");
}

if(status =="invalidpnumberLength"){
	
	swal("Sorry","Input the Phone Number between 10.","error");
}
	</script>



</body>
</html>