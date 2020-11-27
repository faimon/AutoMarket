$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/carsale/carsUser.auth',
        dataType: 'json'
    }).done(function (data) {
        console.log(data);
        data.forEach(car => {
            $('#announce').text("Ваши объявления, " + car.user.login + "!");
            $('#table').append(
                '<div class="row mt-3 border"> ' +
                '<div class="col-md-4 car-image-block">' +
                '<a href="' + 'photo?name=' + car.pathImage + '">' +
                '<img src="' + 'photo?name=' + car.pathImage + '"</a>' +
                '</div>' +
                '<div class="col-md-8 card-body ">' +
                '<a href="/carsale/carInfo?id=' + car.id + '"><h3>' + car.model + ', ' + car.yearRelease + '</h3></a>' +
                '<h5><strong>' + car.price.toLocaleString() + ' ₽ ' + '</strong></h5>' +
                '<ul class="list-inline">' +
                '<li class="list-inline-item">' + car.mileage.toLocaleString() + ' км,</li>' +
                '<li class="list-inline-item">' + car.engine.power + ' л.с, </li>' +
                '<li class="list-inline-item">' + car.body.toLocaleLowerCase() + ', </li>' +
                '<li class="list-inline-item">' + car.gear + '</li>' + '</ul>' +
                '<button id="' + car.id + '" type="button" class="btn btn-danger" value="' + car.user.phoneNumber + '" onclick="getPhone(this.id)">Снять с продажи</button>\n' +
                '</div> ' +
                '</div>');
        })
    }).fail(function (err) {
    });
})