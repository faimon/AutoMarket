function authorize() {
    if ($('#login').val() === "" || $('#password').val() === "") {
        alert('Заполните все поля для авторизации')
        return false;
    }
    $.post(
        "http://localhost:8080/carsale/auth",
        {
            login: $('#login').val(),
            password: $('#password').val()
        },
        function (data) {
            if (data === "invalid") {
                $('#loginForm').append('<div class="alert ml-2 pt-3" id="successLogin" role="alert"> </div>');
                $('#successLogin').addClass('alert-danger')
                    .html('Неправильный логин или пароль');
            } else {
                $('#loginForm').empty();
                $('#loginForm').append('<div class="alert" id="successLogin" role="alert"> </div>');
                $('#successLogin').addClass('alert-success')
                    .html('Добро пожаловать, ' + '<strong>' + data + '</strong>' +
                        '<a class="pl-5" href="/carsale/">Выйти</a>');
                $('#addButton').removeClass("disabled").attr("href", "addCar.jsp?login=" + data);
            }
        }
    );
}

function validate() {
    if ($('#model').val() === "" || $('#yearRelease').val() === "" ||
        $('#color').val() === "" || $('#powerEngine').val() === "" ||
        $('#capacityEngine').val() === "" || $('#body').val() === "" ||
        $('#mileage').val() === "" || $('#price').val() === "" || $('#imgData').val() === "") {
        alert('Заполните все поля')
        return false;
    }
}

$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/carsale/cars.do',
        dataType: 'json'
    }).done(function (data) {
        console.log(data)
        data.forEach(car => {
            $('#table').append(
                '<div class="row mt-3 border"> ' +
                '<div class="col-md-4 car-image-block">' +
                '<a href="' + 'photo?name=' + car.pathImage + '">' +
                '<img src="' + 'photo?name=' + car.pathImage + '"</a>' +
                '</div>' +
                '<div class="col-md-8 card-body ">' +
                '<a href="#"><h3>' + car.model + ', ' + car.yearRelease + '</h3></a>' +
                '<h5><strong>' + car.price.toLocaleString() + ' ₽ ' + '</strong></h5>' +
                '<ul class="list-inline">' +
                '<li class="list-inline-item">' + car.mileage.toLocaleString() + ' км,</li>' +
                '<li class="list-inline-item">' + car.engine.power + ' л.с, </li>' +
                '<li class="list-inline-item">' + car.body.toLocaleLowerCase() + ', </li>' +
                '<li class="list-inline-item">' + car.gear + '</li>' + '</ul>' +
                '<button id="' + car.id + '" type="button" class="btn btn-outline-success" value="' + car.user.phoneNumber + '" onclick="getPhone(this.id)">Контакты продавца</button>\n' +
                '</div> ' +
                '</div>');
        })
    }).fail(function (err) {
        alert("error: " + err);
    });
})

function getPhone(clicked_id) {
    let button = $('#' + clicked_id + '');
    let phone = button.val();
    button.text("Телефон: " + phone);
}



