<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/04/2020
  Time: 12:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Account</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/login/registration.css">
</head>
<body>
<div class="container">
    <h1 class="well">Registration Form</h1>
    <div class="col-lg-12 well">
        <div class="row">
            <form method="post">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Name</label>
                            <input type="text" placeholder="Enter First Name Here.." class="form-control" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Phone Number</label>
                        <input type="text" placeholder="Enter Phone Number Here.." class="form-control" name="phoneNumber">
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea placeholder="Enter Address Here.." rows="3" class="form-control" name="address"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="text" placeholder="Enter Email Address Here.." class="form-control" name="email">
                    </div>
                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" placeholder="Enter Username Here.." class="form-control" name="username">
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" placeholder="Enter Password Here.." class="form-control" >
                    </div>
                    <div class="form-group">
                        <label>Password again</label>
                        <input type="password" placeholder="Enter Password Again Here.." class="form-control" name="password">
                    </div>
                    <button type="submit" class="btn btn-lg btn-info">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
