<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link rel="stylesheet" href="<?php echo base_url("assets/css/bootstrap.min.css"); ?>" /> -->
    <script src="<?php echo base_url("assets/js/jquery.min.js"); ?>"></script>
    <script src="<?php echo base_url("assets/js/bootstrap.min.js"); ?>"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
    <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>

<div class="container">
  <h2>Dynamic Tabs</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
    <li><a data-toggle="tab" href="#menu1">Prestasi</a></li>
    <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
    <li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
        <!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

  <div class="container">
    <h1>Grid</h1>
    <p>This example demonstrates a 50%/50% split on small, medium and large devices. On extra small devices, it will stack (100% width).</p>
    <p>Resize the browser window to see the effect.</p>
    <div class="row">
      <div class="col-sm-6" style="background-color:white;">
          <img src="<?php echo base_url("assets/images/destanti.jpg"); ?>" class="img-rounded" alt="Foto.jpg" width="150px" height="210px">
      </div>
      <div class="col-sm-6" style="background-color:white;">
        <!-- Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto.     -->

        <div class="w3-container">
          <h2>London</h2>
          <p>London is the most populous city in the United Kingdom,
          with a metropolitan area of over 9 million inhabitants.</p>
          <div class='embed-responsive' style='padding-bottom:150%'>
              <object data="<?php echo base_url("assets/document/cv.pdf"); ?>" type='application/pdf' width='100%' height='100%'></object>
          </div>
          <hr>
        </div>

        <article class="w3-container">
          <h2>Paris</h2>
          <p>The Paris area is one of the largest population centers in Europe,
          with more than 2 million inhabitants.</p>
          <hr>
        </article>

        <section class="w3-container">
          <h2>Tokyo</h2>
          <p>Tokyo is the center of the Greater Tokyo Area,
          and the most populous metropolitan area in the world.</p>
          <hr>
        </section>
      </div>
    </div>
    </div>

    </div>
    <div id="menu1" class="tab-pane fade" name="Prestasi" value="Prestasi">
      <h3>Prstasi</h3>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>
    <div id="menu2" class="tab-pane fade">

      <h3>Menu 2</h3>
      <div id="example1"></div>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="menu3" class="tab-pane fade">
      <h3>Menu 3</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
</div>

</body>
</html>
