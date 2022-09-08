function loadCustomer() {
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/customers?deleted=0",
  }).done((data) => {
    $.each(data, (i, item) => {
      let str = `
        <tr>
        <td class="id">${item.id}</td>
        <td class="fullName">${item.fullName}</td>
        <td class="email">${item.email}</td>
        <td class="phone">${item.phone}</td>
        <td class="address">${item.address}</td>
        <td class="balance">${item.balance}</td>
        <td class="text-center">
            <button onclick="showBoxDeposit(${data.length - i})"
                class="btnDeposits fa-solid fa-plus border-1-radius text-color-blue deposit-hover text-decoration-none"
                data-toggle="tooltip" data-placement="top" title="Deposit">
            </button>
        </td>
        <td class="text-center">
            <button onclick="showBoxWithdraw(${data.length - i})"
                class="btnWithdraw fa-solid fa-minus border-1-radius text-color-yellow withdraw-hover text-decoration-none"
                data-toggle="tooltip" data-placement="top" title="Withdraw">
            </button>
        </td>
        <td class="text-center">
            <button onclick="showBoxTransfer(${data.length - i})"
                class="btnTransfer fa-solid fa-arrow-right-arrow-left border-1-radius text-color-blue transfer-hover text-decoration-none"
                data-toggle="tooltip" data-placement="top" title="Transfer">
            </button>
        </td>
        <td class="text-center">
            <button onclick="suspended(${item.id})"
                class="btnSuspended fa-solid fa-ban border-1-radius text-color-red suspended-hover text-decoration-none"
                data-toggle="tooltip" data-placement="top" title="Suspended">
            </button>
        </td>
    </tr>
                `;
      $("#table tbody").prepend(str);
    });
  });
  $(function () {
    $('[data-toggle="tooltip"]').tooltip();
  });
}
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
  $("#mdTransfer").modal("show");
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
  })
  .done((data) => {
    let str = "<option value=0>-- Recipient --</option>";
    $.each(data, (i, item) => {
      str += `<option value="${item.id}">(${item.id})${item.fullName}</option>`;
    });
    document.getElementById("recipientId").innerHTML =str;
  });
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
}
