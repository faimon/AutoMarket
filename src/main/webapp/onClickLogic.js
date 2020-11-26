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
        $('#mileage').val() === "" || $('#price').val() === "") {
        alert('Заполните все поля')
        return false;
    }
}



