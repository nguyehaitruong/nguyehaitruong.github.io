$(document).ready(function() {
    $("#submitButton").on("click", function() {
      let name = $("#name").val();
      let birthday = $("#birthday").val();
      let mobile = $("#mobile").val();
      let hometown = $("#hometown").val();

  
      $("#alertBoxBirthday").hide();
      $("#alertBoxMobile").hide();

      let isValid = true;

      if (!isValidDate(birthday)) {

        $("#alertBoxBirthday").show();
        isValid = false;
      }

      if (mobile.length !== 10) {
        $("#alertBoxMobile").show();
        isValid = false;
      }

      if (isValid) {
        let tableBody = $("#studentTableBody");
        let newRow = $("<tr>");
        let selectCell = $("<td>").html('<input type="checkbox" name="selectStudent">');
        let nameCell = $("<td>").text(name);
        let birthdayCell = $("<td>").text(birthday);
        let mobileCell = $("<td>").text(mobile);
        let hometownCell = $("<td>").text(hometown);

        newRow.append(selectCell, nameCell, birthdayCell, mobileCell, hometownCell);
        tableBody.append(newRow);
      }
    });

    $("#deleteButton").on("click", function() {
        let tableBody = $("#studentTableBody");
        let rows = tableBody.find("tr");
        let confirmDelete = false;

      rows.each(function() {
        let row = $(this);
        let checkbox = row.find("input[type='checkbox']");

        if (checkbox.prop("checked")) {
          confirmDelete = true;
          row.remove();
        }
      });

      if (confirmDelete) {
        if (confirm("bạn có chắc chắn không")) {
          alert("chưa chắc vẫn xóa");
        }
      } 
    });

    function isValidDate(dateString) {
        let today = new Date();
        let inputDate = new Date(dateString);

      return inputDate <= today;
    }
  });