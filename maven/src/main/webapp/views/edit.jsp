<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<style>
    body {
        box-sizing: border-box;
    }

    .w-90 {
        width: 90%;
    }

    .margin-left-20 {
        margin-left: 20px;
    }

    .margin-top-20 {
        margin-top: 20px;
    }

    .table-right {
        float: right;
        box-sizing: border-box;
        margin: 10px 10px;
    }

    .table-title {
        height: 100px;
        box-sizing: border-box;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }

    .table-title-content {
        padding: 20px 20px;
    }

    #message-alert {
        width: 100vw;
        position: fixed;
        bottom: 0;
    }

    .hide {
        display: none;
    }

    .alert-danger {
        padding: 1rem 135px;
    }

    .alert-danger>label {
        display: list-item;
    }

    .valid {
        color: blue;
        list-style-type: none;
    }
</style>

<body>
    <div class="container-fluid">
        <div class="table container-fluid w-90">
            <div class="bg-primary table-title">
                <div class="row margin-left-20">
                    <div class="col-5 table-title-content text-light">
                        <h2>Update customer information</h2>
                    </div>
                    <div class="col-7 table-title-content">
                        <a href="#" class="btn btn-outline-light table-right" onclick="goIndexPage()">
                            <i class="fa-solid fa-bars"></i>
                            <span>List Of Customer</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <form action="edit.jsp" class="table container-fluid w-90" id="editForm">
            <div class="form-group row">
                <div class="col-md-6">
                    <label class="form-label font-weight-bold">Full Name</label>
                    <input type="text" class="w-100 form-control" id="fullName" name="fullName" value="">
                </div>
                <div class="col-md-6">
                    <label class="form-label font-weight-bold">Email</label>
                    <input type="text" class="w-100 form-control" id="email" name="email">
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="col-md-6">
                    <label class="form-label font-weight-bold">Phone</label>
                    <input type="text" class="w-100 form-control" id="phone" name="phone">
                </div>
                <div class="col-md-6">
                    <label class="form-label font-weight-bold">Address</label>
                    <input type="text" class="w-100 form-control" id="address" name="address">
                </div>
                <div class="col-12 margin-top-20">
                    <button type="submit" class="btn btn-outline-secondary" id="submitchange">
                        <i class="fa-solid fa-pen-to-square"></i>
                        Save Change
                    </button>
                </div>
            </div>
        </form>
        <div class="toast" data-delay="10000">
            <div class="toast-header">
                <strong class="mr-auto text-primary">toast header</strong>
                <small class="text-muted"></small>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
            </div>
            <div class="toast-body">
                Success
            </div>
        </div>
        <div class="footer">
            <div id="message-alert">
                <div class="alert-danger hide">

                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="bootstrap/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="bootstrap/js/jquery.validate-1.19.3.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/popper-v1.16.0.min.js"></script>
    <script src="index.js"></script>
    <script src="https://kit.fontawesome.com/dccec83b30.js" crossorigin="anonymous"></script>

    <script>
        $(document).ready(function () {
            $("#editForm").validate({
                onclick: false,
                rules: {
                    fullName: {
                        required: true,
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    phone: "required",
                    address: "required",
                },
                messages: {
                    fullName: "please enter you name",
                    email: "please enter your email",
                    phone: "please enter your phone number",
                    address: "please enter your address"
                },
                success: "valid",
                success: function () {
                },
                errorLabelContainer: ".alert-danger",
                showErrors: function (errorMap, errorList) {
                    if (this.numberOfInvalids() > 0) {
                        $("#message-alert .alert-danger").removeClass("hide");
                    } else {
                        $("#message-alert .alert-danger").addClass("hide");
                    }
                    this.defaultShowErrors();
                },
                highlight: function (element, errorClass) {
                    $(element).fadeOut(function () {
                        $(element).fadeIn();
                    });
                },
            });
        });
    </script>
</body>

</html>