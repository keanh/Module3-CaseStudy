<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/04/2020
  Time: 10:54 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="/login/test1.css" type="text/css">
</head>
<body>
<div class="container-fluid" style="height: auto">
    <header class="row">
        <img class="col-sm-12" src="https://img.atpsoftware.vn/2019/05/the-gioi-di-dong-logo.png" height="300px" width="400px">
    </header>
    <div class="row">
<%--        <aside class="col-sm-7">--%>
<%--            <img src="https://znews-photo.zadn.vn/Uploaded/wyhktpu/2019_07_18/cover_1.jpg" height="400px" width="520px">--%>
<%--        </aside>--%>
        <article class="col-sm-12">
            <caption><h2 align="center">Đăng nhập</h2></caption>
            <table border="1" cellpadding="5" align="center" style="height: max-content">
                <tr>
                    <td>Tên đăng nhập</td>
                    <td><input type="text" name="user" id="user" placeholder="Email,số điện thoại, tài khoản..." size="35"></td>
                </tr>
                <tr>
                    <td>Mật khẩu</td>
                    <td><input type="password" name="password" id="password" size="35"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Đăng nhập">
                        <a href="#" style="color: blue">Quên mật khẩu?</a>
                    </td>
                </tr>
            </table>
        </article>
    </div>
    <footer class="footer">
        <div class="class-heading text-center">
            <p>Nguyễn Kế Anh C1219G1</p>
        </div>
    </footer>
</div>
</body>
</html>
