<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/lk.css" type="text/css"/>
    <style>
        img {
            width: 100%;
        }

        .car-image-block {
            padding: 0px;
            margin: 0px;
        }

        .car-image-block img {
            min-height: 200px;
            overflow: hidden;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="scripts/cabinet_scripts.js" type="text/javascript"></script>

</head>
<body>
<div class="container-xl">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6"><h2>Личный <b>Кабинет пользователя</b></h2></div>
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
                                    <button type="submit" class="btn btn-primary ml-2" onclick="return authorize()">
                                        Войти
                                    </button>
                                </div>
                                <a class="btn-link pt-2" href="/carsale/reg">Регистрация</a>
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
                            <div class="col-md-7 car-image-block">
                                <h3 id="announce"></h3>
                            </div>
                        </div>

                        <div id="table">

                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>