$(document).ready(function () {
  getPhonebookRecordList();
});

function getPhonebookRecordList() {
  $.ajax({
    type: "GET",
    dataType: "json",
    url: "/api/getPhonebookRecordList",
    success: function (data) {
      var htmlValue = "";

      for (var i = 0; i < data.length; i++) {
        htmlValue +=
          "<tr>" +
          "<td>" + data[i].fullname + "</td>" +
          "<td>" + data[i].phoneNumber + "</td>" +
          "<td>" + data[i].email + "</td>" +
          "</tr>";
      }

      $('#phonebook-list').html(htmlValue);
    }
  });
}
