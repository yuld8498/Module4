class App {
    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: "warning",
            text: "Are you sure you want to delete the selected data ?",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, delete it !"
        });
    };

    static showSuccessAlert(t) {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: t,
            showConfirmButton: true,
            timer: 5000,
        })
    };

    static showErrorAlert(t) {
        Swal.fire({
            icon: "error",
            title: "Warning",
            text: t,
        });
    };


}

class Customer {
    constructor(id, fullName, email, phone, address, balance = 0, deleted = 0) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
    }
}
class Deposit{
    constructor(customerId, fullName, balance , transactionAmount) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }
}
class Withdraw{
    constructor(customerId, fullName, balance , transactionAmount) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }
}
class Transfer{
    constructor(senderId, senderName,senderBalance,recipientId, recipientName,recipientBalance,transferAmount, feesAmount, fees, totalTransfer) {
        this.senderId = senderId;
        this.senderName= senderName;
        this.senderBalance = senderBalance;
        this.recipientId = recipientId;
        this.recipientName= recipientName;
        this.recipientBalance = recipientBalance;
        this.transferAmount = transferAmount;
        this.feesAmount = feesAmount;
        this.fees = fees;
        this.totalTransfer = totalTransfer;
    }
}



// $(function() {
//     $(".num-space").number(true, 0, ',', ' ');
//     $(".num-point").number(true, 0, ',', '.');
//     $(".num-comma").number(true, 0, ',', ',');

//     $('[data-toggle="tooltip"]').tooltip();
// });
