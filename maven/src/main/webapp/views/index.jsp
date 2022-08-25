<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap/css/sweetalert2.min.css">
    <!-- <script src="index.js"></script> -->
</head>
<style>
    body {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
    }

    .table-center {
        text-align: center;
    }

    .table-right {
        float: right;
        box-sizing: border-box;
        margin: 10px 10px;
    }

    .float-right {
        text-align: right;
    }

    .float-center {
        text-align: center;
    }

    .table-title {
        height: 100px;
        box-sizing: border-box;
        border-top-left-radius: 5px;
        border-top-right-radius: 5px;
    }

    .border-1-radius {
        border: 1px solid black;
        border-radius: 5px;
        padding: 10px;
    }

    .w-90 {
        width: 90%;
    }

    .table-title-content {
        padding: 20px 20px;
    }

    .edit-hover:hover {
        background-color: gray;
        color: rgb(238, 242, 246);
        cursor: pointer;
    }

    .deposit-hover:hover {
        background-color: rgb(17, 168, 17);
        color: aliceblue;
        cursor: pointer;
    }

    .text-color-blue {
        color: blue;
    }

    .text-color-yellow {
        color: rgb(206, 177, 33);
    }

    .text-color-red {
        color: red;
    }

    .widthdraw-hover:hover {
        background-color: rgb(206, 177, 33);
        color: black;
        cursor: pointer;
    }

    .transfer-hover:hover {
        background-color: rgb(82, 96, 249);
        color: aliceblue;
        cursor: pointer;
    }

    .suspended-hover:hover {
        color: aliceblue;
        background-color: rgb(201, 23, 23);
        cursor: pointer;
    }
</style>

<body>
    <div>
        <div class="table container-fluid w-90">
            <div class="table-header">
                <div class="bg-primary table-title">
                    <div class="row">
                        <div class="col-5 table-title-content">
                            <h1>List Of Customer</h1>
                        </div>
                        <div class="col-7 table-title-content">
                            <a href="#" class="btn btn-outline-light table-right" onclick=goCreatePage()>
                                <i class="fa-solid fa-square-plus"></i>
                                <span>Add New Customer</span>
                            </a>
                            <a href="#" class="btn btn-outline-light table-right">
                                <i class="fa-solid fa-clock-rotate-left"></i>
                                <span>Transfer Money Infomation</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table-tab">
                <table class="w-100">
                    <thead class="w-100 border-none bg-success align-middle">
                        <tr class="float-center">
                            <th>#</th>
                            <th>Full Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Balance</th>
                            <th colspan="5" class="table-center">Action</th>
                        </tr>
                    </thead>
                    <tbody class="w-100 align-middle">
                    <tr class="align-middle">
                        <td>695</td>
                        <td>Emi Fry</td>
                        <td>voxyp@mailinator.com</td>
                        <td>+1 (973) 259-2726</td>
                        <td>Consectetur veniam</td>
                        <td class="float-right">0</td>
                        <td class="text-center"><i class="fa-solid fa-pen-to-square border-1-radius edit-hover"
                                                   data-toggle="tooltip" data-placement="top" title="Edit" onclick=goEditPage()></i>
                        </td>
                        <td class="text-center"><i
                                class="fa-solid fa-plus border-1-radius text-color-blue deposit-hover"
                                data-toggle="tooltip" data-placement="top" title="Deposit"
                                onclick=goDepositPage()></i></td>
                        <td class="text-center"><i
                                class="fa-solid fa-minus border-1-radius text-color-yellow widthdraw-hover"
                                data-toggle="tooltip" data-placement="top" title="Widthdraw"
                                onclick=goWidthdrawPage()></i></td>
                        <td class="text-center"><i
                                class="fa-solid fa-arrow-right-arrow-left border-1-radius text-color-blue transfer-hover"
                                data-toggle="tooltip" data-placement="top" title="Transfer"
                                onclick=goTranferPage()></i></td>
                        <td class="text-center"><i
                                class="fa-solid fa-ban border-1-radius text-color-red suspended-hover"
                                data-toggle="tooltip" data-placement="top" title="Suspended"
                                onclick=goSuspentionPage()></i></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="bootstrap/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.bundle.js"></script>
    <script type="text/javascript" src="bootstrap/js/popper-v1.16.0.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="bootstrap/js/sweetalert2.min.js"></script>
    <script src="https://kit.fontawesome.com/dccec83b30.js" crossorigin="anonymous"></script>
    <script>
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
        function goDepositPage() {
            location.replace("deposit.jsp");
        }
        function goEditPage() {
            location.replace("edit.jsp");
        }
        function goCreatePage() {
            location.replace("CreateCustomer.jsp");
        }
        function goTranferPage() {
            location.replace("transfer.jsp");
        }
        function goSuspentionPage() {
            location.replace("suspension.jsp");
        }
        function goWidthdrawPage() {
            location.replace("withdraw.jsp");
        }

    </script>
</body>

</html>