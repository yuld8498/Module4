class LocationRegion{
    constructor(provinceId, provinceName,districtId,districtName,wardId, wardName,address){
        this.provinceId = provinceId;
        this.provinceName=provinceName;
        this.districtId=districtId;
        this.districtName=districtName;
        this.wardId=wardId;
        this.wardName=wardName;
        this.address=address;
    }
}
class Img{
    constructor(id, name) {
        this.id=id;
        this.name =name;
    }
}

class Categories{
    constructor(id,category) {
        this.id=id;
        this.category=category;
    }
}
class Role{
    constructor(id, code,name) {
        this.id=id;
        this.code=code;
        this.name = name;
    }
}
class User{
    constructor(id,username, password, role) {
        this.id=id;
        this.username =username;
        this.password=password;
        this.role =role;
    }
}
class Customer{
    constructor(id,fullName,email,phone,user,locationRegion){
        this.id=id;
        this.fullName =fullName;
        this.email=email;
        this.phone=phone;
        this.user = user;
        this.locationRegion = locationRegion;
    }
}

class Product{
    constructor(id,productName,description,quantity,price,category, img) {
        this.id=id;
        this.productName=productName;
        this.description=description;
        this.quantity=quantity;
        this.price=price;
        this.category=category;
        this.img =img;
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