
function showBoxDeposit(i) {
  $("#mdDeposits").modal("show");
  var table = document.getElementById("table");
  document.getElementById("customerIdDe").value =
    table.rows[i].cells[0].innerHTML;
  document.getElementById("fullNameDe").value =
    table.rows[i].cells[1].innerHTML;
  document.getElementById("emailDe").value = table.rows[i].cells[2].innerHTML;
  document.getElementById("balanceDe").value = table.rows[i].cells[5].innerHTML;
}
function showBoxCreate() {
  $("#mdCreate").modal("show");
}

function showBoxTransfer(i) {
  // $("#mdTransfer").modal("show");
  var table = document.getElementById("table");
  document.getElementById("senderId").value = table.rows[i].cells[0].innerHTML;
  document.getElementById("senderName").value =
    table.rows[i].cells[1].innerHTML;
  document.getElementById("senderBalance").value =
    table.rows[i].cells[5].innerHTML;
  document.getElementById("senderEmail").value =
    table.rows[i].cells[2].innerHTML;
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/customers?deleted=0",
  }).done((data) => {
    let str = "<option value=0>-- Recipient --</option>";
    $.each(data, (j, item) => {
      if (table.rows[j].cells[0].innerHTML != item.id) {
        str += `<option value="${item.id}">(${item.id})${item.fullName}</option>`;
      }
    });
    document.getElementById("recipientId").innerHTML = str;
  }).fail((error)=>{
    App.showErrorAlert("Can't find recipient name")
  })
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
  document.getElementById("balanceDe").value = table.rows[i].cells[5].innerHTML;
  document.getElementById("addressDe").value = table.rows[i].cells[4].innerHTML;
};



