/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var dateInput = document.getElementById("myDate");

dateInput.addEventListener("input", function () {
    var dateValue = this.value;
    var formattedDate = formatDate(dateValue);
    this.value = formattedDate;
});

function formatDate(date) {
    var parts = date.split("-");
    var day = parts[2];
    var month = parts[1];
    var year = parts[0];

    return day + "/" + month + "/" + year;
}

formatDate(date)
