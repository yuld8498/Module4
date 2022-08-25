<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="bootstrap/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <script src="index.js"></script>
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
    .margin-top-20{
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
    .margin-bottom-30{
        margin-bottom: 30px;
    }
</style>

<body>
    <div class="container-fluid">
        <div class="table container-fluid w-90">
            <div class="bg-primary table-title">
                <div class="row margin-left-20">
                    <div class="col-7 table-title-content text-light">
                        <h2>Withdraw money from the customer's account</h2>
                    </div>
                    <div class="col-5 table-title-content">
                        <a href="#" class="btn btn-outline-light table-right" onclick="goIndexPage()">
                            <i class="fa-solid fa-bars"></i>
                            <span>List Of Customer</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <form class=" table container-fluid w-90">
            <div class="form-group row input-group-lg">
                <div class="col-md-6 margin-bottom-30">
                    <label class="form-label font-weight-bold">Customer ID</label>
                    <input type="text" class="w-100" id="customerID" readonly>
                </div>
                <div class="col-md-6 margin-bottom-30">
                    <label class="form-label font-weight-bold">Full Name</label>
                    <input type="text" class="w-100" id="fullName" readonly>
                </div>
                <div class="col-md-6 margin-bottom-30">
                    <label class="form-label font-weight-bold">Current balance ($)</label>
                    <input type="text" class="w-100" id="currentBalance" readonly>
                </div>
                <div class="col-md-6 margin-bottom-30">
                    <label class="form-label font-weight-bold">Transaction Amount ($)</label>
                    <input type="text" class="w-100" id="transactionAmount">
                </div>
                <div class="col-12 margin-top-20 margin-bottom-30">
                    <button type="submit" class="btn btn-outline-warning">
                        <i class="fa-solid fa-minus"></i>
                        Widthdraw
                    </button>
                </div>
            </div>
        </form>
    </div>
</body>
<script src="https://kit.fontawesome.com/dccec83b30.js" crossorigin="anonymous"></script>

</html>