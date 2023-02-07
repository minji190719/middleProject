$(function () {

    var test = function (event) {
        console.log(event.target);
    };

    $("#btn").on("click", test);

});
