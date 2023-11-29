
$(document).ready(function () {

    toastr.options.timeOut = 2000; // 2.0s
    let  deletesubjectId=-1;
    let  updateStudentId=-1

    $(".create-subject-btn").click(function () {
        $("#subject-creation-modal").modal("show");
    });

    $("#save-subject-btn").click(function () {
        // const name = $("#name").val();
        // const address = $("#address").val();

        const formData = $('#create-subject-form').serializeArray();
        if (!formData || formData.length === 0) {
            return;
        }
        const requestBody = {};
        for (let i = 0; i < formData.length; i++) {
            requestBody[formData[i].name] = formData[i].value;
        }

        // call api lên backend
        $.ajax({
            url: "/subjects",
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
    $(".delete-subject-btn").click(function (event){
        deletesubjectId=parseInt($(event.currentTarget).attr("subject-id"))
        console.log(deletesubjectId)
        $("#subject-delete-modal").modal("show");
    });
    $("#delete-subject-btn").click(function (){
        $.ajax({
            url: "/subjects/"+deletesubjectId,
            type: "DELETE",
            success:function (data){
                toastr.success("xóa sinh viên thanh công");
                setTimeout(() => {
                    location.reload();
                }, 1000);
            },
            error:function (err){
                console.log(err);
                toastr.success("Đã có lỗi xảy ra, vui lòng thử lại mặc dù vẫn lỗi");

            }
        })
    })
//     $(".update-student-modal-open").click(function (event){
//
//         updateStudentId=parseInt($(event.currentTarget).attr("student-update-id"))
//         console.log(updateStudentId)
//
//         $.ajax({
//             url: "/students/"+updateStudentId,
//             type: "GET",
//             success: function (data) {
//                 console.log(data);
//                 $("#update-student-form #name").val(data.name);
//                 $("#update-student-form #address").val(data.address);
//                 $("#update-student-form #phone").val(data.phone);
//
//
//
//
//
//                 $("#student-update-modal").modal("show");
//             },
//             error: function (err) {
//                 console.log(err);
//                 toastr.warning("Đã có lỗi xảy ra, vui lòng thử lại");
//             }
//         });
//
//
//     });
//     $("#update-student-btn").click(function () {
//         const formData = $('#update-student-form').serializeArray();
//         if (!formData || formData.length === 0) {
//             return;
//         }
//         const requestBody = {};
//         for (let i = 0; i < formData.length; i++) {
//             requestBody[formData[i].name] = formData[i].value;
//         }
//
//         // call api lên backend
//         $.ajax({
//             url: "/students/"+updateStudentId,
//             type: "PUT",
//             data: JSON.stringify(requestBody), // dữ liệu được gửi vào trong body của HTTP message lên backend
//             contentType: "application/json; charset=utf-8",
//             success: function (data) {
//                 toastr.success("ypdate a new student successfully");
//                 setTimeout(() => {
//                     location.reload();
//                 }, 1000);
//             },
//             error: function (err) {
//                 console.log(err);
//                 toastr.warning("Đã có lỗi xảy ra, vui lòng thử lại");
//             }
//         });
//
//     })
//
});
