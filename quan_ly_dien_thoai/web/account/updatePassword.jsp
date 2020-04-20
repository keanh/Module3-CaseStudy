<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/04/2020
  Time: 11:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Update Account</title>
    <link rel="stylesheet" href="/view/home.css" type="text/css">
</head>
<body>
<div class="container-fluid" style="height: auto">
    <header class="row">
        <div class="col-sm-6 shopping-mall">
            <h1>Thế giới di động</h1>
            <h5>Kính chào quý khách</h5>
        </div>
        <img class="col-sm-6 pull-right" src="https://livestream.vn/wp-content/uploads/2018/10/c2-kinh-doanh-dien-thoai-va-phu-kien-2.jpg">
    </header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/home?action=home">
            <span class="glyphicon glyphicon-home"></span>
            Trang chủ
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav navbar-nav navbar-left">
                <li class="nav-item active">
                    <a class="nav-link" href="#">
                        <span class="glyphicon glyphicon-list-alt"></span>
                        Giới thiệu <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <span class="glyphicon glyphicon-earphone"></span>
                        Liên hệ
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <span class="glyphicon glyphicon-envelope"></span>
                        Góp ý
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        Hỏi đáp
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-user"></span>
                        Tài khoản
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/login?action=view">Thông tin tài khoản (<c:out value="${account.getName()}"/>) </a>
                        <a class="dropdown-item" href="/login?action=update">Cập nhật thông tin tài khoản</a>
                        <a class="dropdown-item" href="/login?action=password">Đổi mật khẩu</a>
                        <a class="dropdown-item" href="/login?action=logout">Đăng xuất</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/home?action=create">
                        <span class="glyphicon glyphicon-question-sign"></span>
                        Thêm mới sản phẩm
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="row">
        <article class="col-sm-9">
            <caption><h3 align="center">Đổi mật khẩu</h3></caption>
            <form method="post">
                <table border="1" cellpadding="5" align="center">
                    <tr>
                        <td>Tài khoản </td>
                        <td><input type="text" id="username" name="username" size="45" ></td>
                    </tr>
                    <tr>
                        <td>Mật khẩu</td>
                        <td><input type="password" id="password" name="password" size="45" ></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu</td>
                        <td><input type="password"  name="passWord" size="45" ></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" id="submit" value="Sửa thông tin">
                        </td>
                    </tr>
                </table>
            </form>
        </article>
        <aside class="col-sm-3">
            <div class="poly-cart">
                <div class="card">
                    <div class="card-body" align="center">
                        <img class="col-sm-12" src="https://demo.codegym.vn/web/15/layout-bootstrap/images/shoppingcart.gif" width="154px" height="160px"/>
                        <ul class="col-sm-12">
                            <li><a href="/shopping">Xem giỏ hàng</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="card card-default">
                <div class="card-body">
                    <form method="post" action="/home?action=search">
                        <input placeholder="Bạn cần tìm..." name="search" id="search" class="form-control" />
                        <br>
                        <div align="center">
                            <button type="submit" class="btn btn-primary" style="text-align: center">Tìm kiếm</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    <span class="glyphicon glyphicon-th-list"></span>
                    <strong>Các thể loại khác</strong>
                </div>
                <div class="list-group">
                    <a href="#" class="list-group-item">Điện thoại di động</a>
                    <a href="#" class="list-group-item">Máy tính xách tay</a>
                    <a href="#" class="list-group-item">Máy tính để bàn</a>
                    <a href="#" class="list-group-item">Máy tính bảng</a>
                    <a href="#" class="list-group-item">Phụ kiện điện thoai</a>
                    <a href="#" class="list-group-item">Loa</a>
                </div>
            </div>
        </aside>
    </div>
    <br>
    <footer class="card card-default">
        <div class="card-heading text-center">
            <p>Nguyễn Kế Anh</p>
        </div>
    </footer>
</div>
</body>
</html>
