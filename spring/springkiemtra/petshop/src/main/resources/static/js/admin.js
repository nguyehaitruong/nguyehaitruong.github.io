
$(document).ready(function () {

    toastr.options.timeOut = 2000; // 2.0s

    let  updateProductId=-1

    $(".create-produvt-btn").click(function () {
        $("#product-creation-modal").modal("show");
    });

    $("#save-product-btn").click(function () {
        const  isValidForm=$("#create-product-form").valid();
            if(!isValidForm){
                return;
            }


        const formData = $('#create-product-form').serializeArray();
        if (!formData || formData.length === 0) {
            return;
        }
        const requestBody = {};
        for (let i = 0; i < formData.length; i++) {
            requestBody[formData[i].name] = formData[i].value;
        }

        // call api lên backend
        $.ajax({
            url: "/product-admin",
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

    });
    $(".update-product-modal-open").click(function (event){

        updateProductId=parseInt($(event.currentTarget).attr("product-update-id"))
        console.log(updateProductId)

        $.ajax({
            url: "/product-admin/"+updateProductId,
            type: "GET",
            success: function (data) {
                console.log(data);
                $("#update-product-form #name").val(data.name);
                $("#update-product-form #price").val(data.price);
                $("#update-product-form #description").val(data.description);
                $("#update-product-form #image").val(data.image);

                $("#product-update-modal").modal("show");
            },
            error: function (err) {
                console.log(err);
                toastr.warning("Đã có lỗi xảy ra, vui lòng thử lại");
            }
        });


    });
    $("#update-product-btn").click(function () {
        const formData = $('#update-product-form').serializeArray();
        if (!formData || formData.length === 0) {
            return;
        }
        const requestBody = {};
        for (let i = 0; i < formData.length; i++) {
            requestBody[formData[i].name] = formData[i].value;
        }

        // call api lên backend
        $.ajax({
            url: "/product-admin/"+updateProductId,
            type: "PUT",
            data: JSON.stringify(requestBody), // dữ liệu được gửi vào trong body của HTTP message lên backend
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                toastr.success("ypdate a new student successfully");
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
    const  validator= $("#create-product-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            "name": {
                required: true,
                maxlength: 255

            },
            "price": {
                required: true,
                maxlength: 255


            },"description": {
                required: true,
                maxlength: 2048 ,


            },
            "image": {
                required: true,
                maxlength: 2048,


            }

        },
        messages: {
            "name": {
                required: "Task name is required",
                maxlength: "Task name must be less than 255 characters"
            },
            "price": {
                required: "Task name is required",
                maxlength: "Task name must be less than 255 characters",

            },"description": {
                required: "Task name is required",
                maxlength: "Task name must be less than 2048 characters",

            }
            ,"image": {
                required: "Task name is required",
                maxlength: "Task name must be less than 2048 characters",

            }
        }

    });

});
