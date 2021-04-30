<?php
  session_start();
  if (!isset($_SESSION['authenticated']) || !$_SESSION['authenticated']) {
     header('Location: book2.php');
     exit;
  }
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
        <a class="active"href="about.php">Check trip</a></li>

</div>
<br>
<div class="body">
<form method="post" action="gettrips.php">
     <div class="input_box">
        <label for="name">ID</label>
        <input value="<?php echo isset($_SESSION['trips']['name']) ? $_SESSION['trips']['name'] : '';  ?>" type="text" id="name" name="name">      </div>
 <input class = "input_box" type="submit" value="Submit">
    </form>

<?php
    if (isset($_SESSION['messages'])) {
      foreach ($_SESSION['messages'] as $message) {
        echo "<div class='" . $_SESSION['class'] . " message'>{$message}</div>";
      }
    }
    unset($_SESSION['messages']);
?>
   <table id="comments">
      <thead>
        <tr>
          <th>Name</th>
          <th>Last name</th>
 <th>ID</th>
 <th>Destination</th>
        </tr>
      </thead>
      <tbody>
<?php

    $ID = $_SESSION['mytrips'];
 require_once 'Dao.php';
    $dao = new Dao();
    $comments = $dao->getTrips($ID);
          foreach ($comments as $comment) {

            echo " <tr><td>{$comment['name']}</td>
            <td> ". htmlspecialchars($comment['lastName'])."
            <td> " . htmlspecialchars($comment['person_ID'])."
           <td> " . htmlspecialchars($comment['destination'])."</td></tr>";}
 unset($_SESSION['myytrips']);
 ?>
      </tbody>
    </table>
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

