<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Продажа авто</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/acfc8580ab.js" crossorigin="anonymous"></script>
    <script src="scripts/main_pagescripts.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/car.css" type="text/css"/>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script>
        function main() {
            window.location.href = "cabinet.jsp"
        }
    </script>

    <style>
        .left, .right {
            height: 600px
        }

        .left {
            float: left;
            width: 40%;
        }

        .sale {
            color: #228B22;
        }

        .saled {
            color: #B22222;
        }


    </style>

</head>
<body>
<div class="container-xl">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6"><h2>Продажа <b>автомобилей</b></h2></div>
                <div class="col-sm-6">
                    <div class="container">
                        <div id="loginForm" class="form-inline" style="text-align: right">

                            <c:if test="${login != null}">
                                <div class="alert alert-success" id="successLogin" role="alert">
                                    Добро пожаловать, <strong> ${login} </strong>
                                    <a class="pl-5" href="/carsale">Выйти</a>
                                </div>
                                <button type="button" class="btn btn-primary ml-2" onclick="return main()">Главная
                                </button>
                            </c:if>
                            <c:if test="${login == null}">
                                <div>
                                    <input type="text" class="form-control mr-sm-2" id="login" placeholder="Логин">
                                    <input type="text" class="form-control" id="password" placeholder="Пароль">
                                    <a class="btn-link pt-2 mr-3" href="/carsale/">Главная</a>
                                    <a class="btn-link pt-2 mr-3" href="/carsale/reg">Регистрация</a>
                                    <button type="submit" class="btn btn-primary ml-2 pt-1" onclick="return authorize()">
                                        Войти
                                    </button>

                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="cars-horizon">
            <div class="container">
                <div class="row">
                    <div class="col-md-9">
                        <div class="row py-2">
                            <div class="col-md-7">
                                <h3> Объявление № ${car.id}</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="left">
            <img src="<c:url value='/photo?name=${car.pathImage}'/>" width="380px" height="285px">
            <br>
            <br>
            <h5>Телефон продавца: ${car.user.phoneNumber} </h5>
            <br>
            <c:if test="${car.saleStatus == true}">
                <h5 class="font-weight-light">Статус объявления: <span class="sale"> Продается</span></h5>
                <br>
                <h5 class="font-weight-light">Дата публикации: <fmt:formatDate pattern="dd.M.yyyy" value="${car.created}" /></h5>


            </c:if>
            <c:if test="${car.saleStatus == false}">
                <h5 class="font-weight-light">Статус объявления: <span class="saled"> Продано</span></h5>
                <br>
                <h5 class="font-weight-light">Дата публикации: <fmt:formatDate pattern="dd.M.yyyy" value="${car.created}" /></h5>
            </c:if>
        </div>

        <div class="right">
            <ul class="list-group">
                <li class="list-group-item"><span class="font-weight-bolder">Модель: </span>${car.model}</li>
                <li class="list-group-item"><span class="font-weight-bolder">Год выпуска: </span>${car.yearRelease}</li>
                <li class="list-group-item"><span class="font-weight-bolder">Двигатель: </span>${car.engine.capacity} л,
                    ${car.engine.power} л.с.

                </li>
                <li class="list-group-item"><span class="font-weight-bolder">Тип двигателя: </span>${car.engine.type}
                </li>
                <li class="list-group-item"><span class="font-weight-bolder">Коробка передач: </span>${car.transmission}
                </li>
                <li class="list-group-item"><span class="font-weight-bolder">Тип кузова: </span>${car.body}</li>
                <li class="list-group-item"><span class="font-weight-bolder">Цвет: </span>${car.color}</li>
                <li class="list-group-item"><span class="font-weight-bolder">Привод: </span>${car.gear}</li>
                <li class="list-group-item"><span class="font-weight-bolder">Пробег: </span>${car.mileage}&nbsp;км</li>
                <li class="list-group-item"><span class="font-weight-bolder">Цена: </span>${car.price} руб</li>
                <li class="list-group-item"><span class="font-weight-bolder">Дополнительно : </span>${car.description}
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>