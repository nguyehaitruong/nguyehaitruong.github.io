$(document).ready(function () {

    toastr.options.timeOut = 2000; // 2.0s

    let updateProductId = -1
    let currentTime = new Date();
    document.getElementById('save-Registration-btn').addEventListener('click', function() {

        currentTime = new Date();
    })


    $("#save-Registration-btn").click(function () {


        const formData = $('#create-Registration-form').serializeArray();
        if (!formData || formData.length === 0) {
            return;
        }
        const requestBody = {};
        for (let i = 0; i < formData.length; i++) {
            requestBody[formData[i].name] = formData[i].value;

        }
        // call api lên backend
        $.ajax({
            url: "/Registration-form",
            type: "POST",
            data: JSON.stringify(requestBody), // dữ liệu được gửi vào trong body của HTTP message lên backend
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("Create a new student successfully");

                setTimeout(() => {
                    location.reload();
                }, 1000);
            },
            error: function (err) {
                console.log(err);
                toastr.warning("Đã có lỗi xảy ra, vui lòng thử lại");
            }
        });

    })
})

