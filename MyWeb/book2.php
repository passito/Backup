<?php
  session_start();
?>
<html>
  <head>
<img class="logo" src="logo.png"/>
<link rel="stylesheet" href="stylehome.css">
<link rel="stylesheet" href="comment.css">
<link rel="stylesheet" href="top.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

         <div class="topnav">

        <a href="home.php">Destinations</a></li>
        <a href="review.php">Reviews</a></li>
        <a href="about.php">Check trip</a></li>

</div>
<div id="centerbox">
<p id="centerbox" class="tittle"> LOG IN PAGE </p>
</div>
<div id="center">
 <form method="post" action="login_handler2.php">
      <div class="input_box">
        <label for="username">Username:</label>
      <input value="<?php echo isset($_SESSION['form_login']['name']) ? $_SESSION['form_login']['name'] : ''; ?>" type="text" id="name" name="name">  </div>
      <br/>
      <div class="input_box">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
      </div>
      <input type="submit" value="Submit">  
 </form>
<form method="post" action="create_account2.php">
<input type="submit" value="Create account">
</form>
<?php
    if (isset($_SESSION['messages'])) {
        echo $_SESSION['messages'];
      }
    
    unset($_SESSION['messages']);
?>
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
