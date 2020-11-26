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

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="onClickLogic.js" type="text/javascript"></script>
</head>
<body>
<form class="form-horizontal" style="width:60%" action="<c:url value='/saveCar.do'/>"
      method="post" enctype="multipart/form-data">
    <fieldset>

        <!-- Form Name -->
        <legend class="text-center">Добавить объявление</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="model">Модель</label>
            <div class="col-md-4">
                <input id="model" type="text" name="model" placeholder="Модель автомобиля"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="yearRelease">Год выпуска</label>
            <div class="col-md-4">
                <input id="yearRelease" type="text" name="yearRelease" placeholder="Год выпуска"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="color">Цвет</label>
            <div class="col-md-4">
                <input id="color" type="text" name="color" placeholder="Цвет автомобиля" class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Тип двигателя</label>
            <div class="col-md-4">
                <label class="radio-inline" for="radios-0">
                    <input type="radio" name="engine" id="radios-0" value="Бензиновый" checked="checked">
                    Бензиновый
                </label>
                <label class="radio-inline" for="radios-1">
                    <input type="radio" name="engine" id="radios-1" value="Дизельный">
                    Дизельный
                </label>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Мощность двигателя, л.с.</label>
            <div class="col-md-4">
                <input name="powerengine" type="text" placeholder="Мощность двигателя"
                       class="form-control input-md">
            </div>
        </div>
e
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="capacityEngine">Объем двигателя, л</label>
            <div class="col-md-4">
                <input id="capacityEngine" name="capacityEngine" type="text" placeholder="Объем двигателя"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="body">Тип кузова</label>
            <div class="col-md-4">
                <input id="body" type="text" name="body" placeholder="Тип кузова автомобиля"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Тип коробки передач</label>
            <div class="col-md-4">
                <label class="radio-inline" for="mech1">
                    <input type="radio" name="transmission" id="mech1" value="Автоматическая" checked="checked">
                    Автоматическая
                </label>
                <label class="radio-inline" for="mech2">
                    <input type="radio" name="transmission" id="mech2" value="Механическая">
                    Механическая
                </label>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label">Привод</label>
            <div class="col-md-4">
                <label class="radio-inline" for="gear1">
                    <input type="radio" name="gear" id="gear1" value="2WD" checked="checked">
                    2WD
                </label>
                <label class="radio-inline" for="gear2">
                    <input type="radio" name="gear" id="gear2" value="4WD">
                    4WD
                </label>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="mileage">Пробег, км</label>
            <div class="col-md-4">
                <input id="mileage" type="text" name="mileage" placeholder="Пробег автомобиля"
                       class="form-control input-md">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="price">Цена (в руб.)</label>
            <div class="col-md-4">
                <input id="price" type="text" name="price" placeholder="Цена автомобиля" class="form-control input-md">
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="desc">Дополнительно</label>
            <div class="col-md-4">
                <textarea class="form-control" id="desc" name="desc"></textarea>
            </div>
        </div>

        <!-- File Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="imgData">Добавить изображение</label>
            <div class="col-md-4">
                <input id="imgData" name="file" class="input-file" type="file">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-primary"
                        onclick="return validate()">Добавить объявление
                </button>
            </div>
        </div>

    </fieldset>
</form>
</body>
</html>