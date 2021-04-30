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
        <a class="active"href="Florida.php">Florida</a></li>
        <a href="review.php">Reviews</a></li>
        <a href="about.php">Check trip</a></li>

</div>

<div id="box">
<p> <span class="tittle">1. Orlando-Walt Disney World<span></p>
<p>
The Walt Disney World Resort, also called Walt Disney World and Disney World, is an entertainment complex in Bay Lake and Lake Buena Vista, Florida, in the United States, near the cities of Orlando and Kissimmee.<span id="text"> In 2018, Walt Disney World was the most visited vacation resort in the world, with an average annual attendance of more than 58 million.[4] The resort is the flagship destination of Disney's worldwide corporate enterprise and has become a popular staple in American culture. 
</span id="text"></p>
<p>
<button id="hide">Hide</button>
<button id="show">Show</button></p>
<p><img class="image" src="https://i0.wp.com/www.disneytouristblog.com/wp-content/uploads/2020/09/cinderella-castle-central-plaza-disney-world-orlando-786.jpg"/>
 </p>
<div id="book">
<a href="book.php">Book</a>
</div>
</div>
<div id="box">
<p> <span class="tittle">2. Miami Beach<span></p>
<p>
Miami Beach caters to the moneyed crowd. At upscale shopping centers like Lincoln Road Mall and renowned spas (agua Spa at the Delano South Beach is a particular favorite), residents and visitors spend boat loads for decadent experiences and comfortable clothing. Night owls shell out hundreds on drinks at dance clubs and bars.<span id="text2"> Sophisticated types observe the art deco architecture and stop by the Ancient Spanish Monastery in the afternoons. Relaxing on the sand is truly the best "free" activity. Most cost-conscious visitors spend their days lounging on the beach or swimming, surfing and kayaking in the Atlantic Ocean. Also, don't forget to stop by the very moving Holocaust Memorial.</span id="text2"></p>
<p>
<button id="hide2">Hide</button>
<button id="show2">Show</button></p>
<p><img class="image" src="https://content.r9cdn.net/rimg/dimg/17/74/0ca6e469-city-30651-1632b88f203.jpg"/> </p>
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
        
