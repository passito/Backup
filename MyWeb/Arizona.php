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
$(document).ready(function(){
  $("#hide2").click(function(){
    $("#text2").hide();
  });
  $("#show2").click(function(){
    $("#text2").show();
  });
});
</script>
</head>
<body>

         <div class="topnav">

        <a href="home.php">Destinations</a></li>
        <a class="active"href="Arizona.php">Arizona</a></li>
        <a href="review.php">Reviews</a></li>
        <a href="about.php">Check trip</a></li>

</div>
<div id="box">
<p> <span class="tittle">1. Grand Canyon National Park<span></p>
<p>
Located in Arizona, Grand Canyon National Park encompasses 277 miles (446 km) of the Colorado River and adjacent uplands. The park is home to much of the immense Grand Canyon; a mile (1.6 km) deep, and up to 18 miles (29 km) wide. <span id="text">Layered bands of colorful rock reveal millions of years of geologic history. Grand Canyon is unmatched in the incomparable vistas it offers visitors from the rim.</span id="text"></p>
<p>
<button id="hide">Hide</button>
<button id="show">Show</button></p>
<p><img class="image" src="https://cdn2.civitatis.com/estados-unidos/las-vegas/guia/gran-canon.jpg"/>
</p>
<div id="book">
<a href="book.php">Book</a>
</div>
</div>
<div id="box">
<p> <span class="tittle">2. Sedona - A Desert Village<span></p>
<p>
Sedona’s iconic red rock backdrop has long been a classic setting for western films, and only recently has the city become a tourist attraction. But, if you’re not familiar with Sedona — make no mistake about it — geographically and culturally, Sedona is not your typical desert town.<span id="text2">

Situated at 4,350 ft above sea level in Arizona’s high desert, Sedona’s 1.8 million acres of Red Rock Country is blessed with a mild climate, making it comfortable to visit year-round. Aside from its geographical advantages, Sedona is well known as a spiritual refuge for travelers seeking otherworldly experiences and as an outdoors destination for hiking, cycling, rock climbing, and much more.</span id="text2"></p>
<p>
<button id="hide2">Hide</button>
<button id="show2">Show</button></p>
<p><img class="image" src="https://sedona.org/wp-content/uploads/2020/01/vacation-rentals-sedona-az-village-of-oak-creek.jpg"/> </p>
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
