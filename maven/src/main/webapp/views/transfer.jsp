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

    .border-1px{
        border: 1px solid black;
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
    select>option{
        border: none;
        width: 100%;
    }
</style>

<body>
    <div class="container-fluid">
        <div class="table container-fluid w-90">
            <div class="bg-primary table-title">
                <div class="row margin-left-20">
                    <div class="col-7 table-title-content text-light">
                        <h1>Transfer money Information</h1>
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
            <div class="form-group row">
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Sender ID</label>
                    <input type="text" class="w-100" id="senderID" readonly>
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Sender Name</label>
                    <input type="text" class="w-100" id="senderName" readonly>
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Email</label>
                    <input type="text" class="w-100" id="email" readonly>
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Sender balance</label>
                    <input type="text" class="w-100" id="senderBalance" readonly>
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Recipient Name</label>
                    <div class="col-md-12 h-50 w-100 border-1px">
                        <select name="cars" id="cars" class="w-100 h-100 border-0">
                            <option value="volvo">Volvo</option>
                            <option value="saab">Saab</option>
                            <option value="mercedes">Mercedes</option>
                            <option value="audi">Audi</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Transfer Amount ($)</label>
                    <input type="text" class="w-100" id="transferAmount">
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Fees (%)</label>
                    <input type="text" class="w-100" id="fees" readonly>
                </div>
                <div class="col-md-3 margin-top-20">
                    <label class="form-label font-weight-bold">Total amount of transaction ($)</label>
                    <input type="text" class="w-100" id="total" readonly>
                </div>
                <div class="col-12 margin-top-20">
                    <button type="submit" class="btn btn-outline-primary">
                        <i class="fa-solid fa-arrow-right-arrow-left"></i>
                        Transfer
                    </button>
                </div>
            </div>
        </form>
    </div>
</body>
<script src="https://kit.fontawesome.com/dccec83b30.js" crossorigin="anonymous"></script>

</html>