$(document).ready(function () {
    $('#registerButton').click( function() {
        console.log(5)
        var email = $('#emailInput').val();

        var password = $('#passwordInput').val();
        var user = {
            email: email,
            password: password
        };
        console.log(user);

        // Gửi yêu cầu AJAX POST đến API của bạn
        $.ajax({
            type: 'POST',
            url: '/api/auth/signup',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function(data) {
                console.log(data);
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    });
});

$(document).ready(function () {

    $('#employeesLoginBtn').click(function() {
        // Lấy dữ liệu đăng nhập từ form hoặc nơi khác
        var username = $('.employerUsernameInput').val();
        var password = $('.employerPasswordInput').val();
        var user = {
            email: username,
            password: password
        };
        console.log(user)

        $.ajax({
            type: 'POST',
            url: '/api/auth/login',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function(data) {
                console.log(user);



            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    });
    $('.btn-submit-recuitment').click(function()  {

        var formData = {
            title: $('#title').val(),
            location: $('#location').val(),

        };
        console.log(formData)
        $.ajax({
            type: 'POST',
            url: '/published-recruitments/create',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function (response) {
                console.log('Job created successfully');

            },
            error: function (error) {
                console.error('Error creating job:', error.responseJSON.message);

            }
        });
    });})
