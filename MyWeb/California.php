<php>
<html>
  <head>
<img class="logo" src="logo.png"/>
<link rel="stylesheet" href="stylehome.css">
<link rel="stylesheet" href="top.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#hide").click(function(){
    $("#text").hide();
  });
  $("#show").click(function(){
    $("#text").show();
  });
});
</script>
</head>
<body>

         <div class="topnav">

        <a href="home.php">Destinations</a></li>
        <a class="active"href="California.php">California</a></li>
        <a href="review.php">Reviews</a></li>
        <a href="about.php">Check trip</a></li>

</div>

<div id="box">
<p> <span class="tittle">1. San Diego: Sunshine, Beaches, and Spanish Architecture<span></p> 
<p> 
With its balmy year-round climate, San Diego is the place to experience California's laid-back lifestyle of sun-drenched days at the beach and fun-loving outdoor adventures.

Besides the expansive shoreline of beautiful sandy beaches, the main tourist attractions in San Diego proper are Balboa Park, a lovely green space with distinctive gardens and several museums; <span id="text">the historic Gaslamp Quarter, which is full of boutiques, art galleries, and good restaurants; and the Old Town San Diego State Historic Park, where museums, retail shops, and restaurants occupy the old adobe buildings.</span id="text"></p> 
<p>
<button id="hide">Hide</button>
<button id="show">Show</button></p>
<p><img class="image" src="https://www.planetware.com/wpimages/2019/07/california-best-places-to-visit-san-diego.jpg"/> </p>
<div id="book">
<a href="book.php">Book</a>
</div>
</div>

<div id="bottom">
<p><span class="tittle" >Famous Routes<span>
</p>
<ol>
        <li><a class="white" href="https://en.wikipedia.org/wiki/Oregon_Trail">The Oregon trail</a></li>
        <li><a class="white" href="https://en.wikipedia.org/wiki/U.S._Route_101">Route 101</a></li>
        <li><a class="white" href="https://www.blueridgeparkway.org">Blue Ridge Parkway</a></li>
      </ol>
</div>

</body>
</html>
