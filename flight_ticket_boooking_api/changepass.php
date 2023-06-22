<?php
require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$oldpass =$json['oldpass'];
$newpass =$json['newpass'];
$email =$json['email'];

 $query=mysqli_query($conn,"SELECT * FROM users WHERE  email = '$email' AND password = '$oldpass'");
 $response =array();
  if (mysqli_num_rows($query)>0) 
  {
      $Query = "UPDATE `users` SET `password`= '$newpass' WHERE email = '$email'";
      @mysqli_query($conn, $Query);
      echo json_encode(array("status"=>"true"));
  }
  else
  {
    echo json_encode(array("status"=>"false"));
  }
   
mysqli_close($conn);
?>

