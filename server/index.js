function showBoxDeposit(i) {
  $("#mdDeposits").modal("show");
  var table = document.getElementById("table");
  document.getElementById("fullNameDe").value =
    table.rows[i].cells[1].innerHTML;
  document.getElementById("emailDe").value = table.rows[i].cells[2].innerHTML;
  document.getElementById("balanceDe").value = table.rows[i].cells[5].innerHTML;
}
function showBoxCreate() {
  $("#mdCreate").modal("show");
}

function showBoxTransfer(i) {
  $("#mdTransfer").modal("show");
  var table = document.getElementById("table");
  document.getElementById("senderId").value = table.rows[i].cells[0].innerHTML;
  document.getElementById("senderName").value = table.rows[i].cells[1].innerHTML;
  document.getElementById("senderBalance").value = table.rows[i].cells[5].innerHTML;
  document.getElementById("senderEmail").value = table.rows[i].cells[2].innerHTML;
}

function showBoxWithdraw(i) {
  $("#mdWithdraw").modal("show");
  var table = document.getElementById("table");
  document.getElementById("customerIdWd").value =
    table.rows[i].cells[0].innerHTML;
  document.getElementById("fullNameWd").value =
    table.rows[i].cells[1].innerHTML;
  document.getElementById("emailWd").value = table.rows[i].cells[2].innerHTML;
  document.getElementById("balanceWd").value = table.rows[i].cells[5].innerHTML;
}

function showBoxSuspended(i) {
  $("#mdDeposits").modal("show");
    var table = document.getElementById("table");
    document.getElementById("fullNameDe").value =
      table.rows[i].cells[1].innerHTML;
    document.getElementById("emailDe").value = table.rows[i].cells[2].innerHTML;
    document.getElementById("balanceDe").value =
      table.rows[i].cells[5].innerHTML;
      document.getElementById("addressDe").value =
      table.rows[i].cells[4].innerHTML;
}
