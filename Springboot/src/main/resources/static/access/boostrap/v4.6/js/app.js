class LocationRegion {
    constructor(provinceId, provinceName, districtId, districtName, wardId, wardName, address) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
        this.address = address;
    }
}

class Categories {
    constructor(id, category) {
        this.id = id;
        this.category = category;
    }
}

class Role {
    constructor(id, code, name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}

class User {
    constructor(id, username, password, role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

class Customer {
    constructor(id, fullName, email, phone, user, locationRegion) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.user = user;
        this.locationRegion = locationRegion;
    }
}

class Product {
    constructor(id, productName, description, quantity, price, category, imgUrl, deleted) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.imgUrl = imgUrl;
        this.deleted = deleted;
    }
}

class CartItems {
    constructor(id, productId, productName, price, quantity, amount, imgUrl, checked) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.amount = amount;
        this.imgUrl = imgUrl;
        this.checked = checked;
    }
}

class OrderItems {
    constructor(id, quantity, districtName, provinceName, wardName, address, productId, productName, orderId,
                price, idCustomer, customerName) {
        this.id = id;
        this.quantity = quantity;
        this.districtName = districtName;
        this.provinceName = provinceName;
        this.wardName = wardName;
        this.address = address;
        this.productId = productId;
        this.productName = productName;
        this.orderId = orderId;
        this.price = price;
        this.idCustomer = idCustomer;
        this.customerName = customerName;
    }
}

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

    static showConfirmDialog(message) {
        return Swal.fire({
            icon: "warning",
            text: message,
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, Sign in Now !"
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

    static toastSuccess(t) {
        iziToast.success({
            title: 'OK',
            position: 'bottomLeft',
            timeout: 1500,
            message: t
        });
    }

    static toastError(t) {
        iziToast.error({
            title: 'ERROR',
            position: 'bottomLeft',
            timeout: 2000,
            message: t
        });
    }
}