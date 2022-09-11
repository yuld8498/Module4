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
    this.deleted = deleted;
}
}



// $(function() {
//     $(".num-space").number(true, 0, ',', ' ');
//     $(".num-point").number(true, 0, ',', '.');
//     $(".num-comma").number(true, 0, ',', ',');

//     $('[data-toggle="tooltip"]').tooltip();
// });
