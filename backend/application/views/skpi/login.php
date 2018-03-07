<!DOCTYPE html>
<html lang="en">
<head>
      <title>SSKPI - Login</title>
      <script type="text/javascript" src="<?php echo base_url("assets/js/jquery-3.1.1.js"); ?>"></script>
      <link rel="stylesheet" href="<?php echo base_url("assets/css/bootstrap.css"); ?>" />
      <script type="text/javascript" src="<?php echo base_url("assets/js/bootstrap.js"); ?>"></script>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/hmac-sha512.js"></script>
      <script type="text/javascript" src="<?php echo base_url("assets/js/crypto-js.js"); ?>"></script>
      <script type="text/javascript">
       $(document).ready(function () {
         var loggedIn = false;

        // LOGIN PROCESS
           $('form[name=loginForm]').submit(function () {
                 var nim = document.getElementById("nim_mhs").value;
                 var password = document.getElementById("pwd_mhs").value;

                 // $.post("http://192.168.100.9/skpi_kimia/api/Api", function(nim, password) {
                 //      //As soon as the browser finished downloading, this function is called.
                 //
                 //      $('#demo').html(data);
                 // });
             // }


                var md5 = function(value) {
                  var encrypted = CryptoJS.SHA256(value).toString();
                               // var encrypted =CryptoJS.AES.encrypt(values, 'secret key 123');
                  return encrypted;
                }

               return false; // prevent default action
           });
       });
   </script>

</head>

<body>
  <div class="jumbotron text-center">
    <h1>Selamat Datang di Sistem SKPI</h1>
    <p>Selamat Datang di Sistem SKPI</p>
  </div>

  <form name="loginForm" class="form-horizontal" method="post">
  <div class="form-group">
    <label class="control-label col-sm-2" for="nim_mhs">NIM:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="nim_mhs" placeholder="Masukkan NIM Anda" name="nim_mhs">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="pwd_mhs" placeholder="Enter password" name="pwd_mhs" value="">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label><input type="checkbox"> Remember me</label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button class="btn btn-default" type="submit">Submit</button>
    </div>
  </div>
</form>

<hr/>
<em>&copy; 2018</em>

</body>
</html>
