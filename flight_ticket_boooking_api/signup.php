<?php
 require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$user_name =$json['user_name'];
$user_email =$json['user_email'];
$user_password =$json['user_password'];
$cityid =$json['cityid'];
$user_mobile =$json['user_mobile'];
$address =$json['address'];
$user_image =$json['user_image'];
$imagename = $json['user_email'];
$imagepath = "images/user/$imagename.jpg";
$img = "$imagename.jpg";

$query ="INSERT INTO user(user_password, user_name, user_add1, user_city, user_email, user_mobile, user_image) 
          VALUES ('$user_password','$user_name','$address', '$cityid','$user_email', '$user_mobile', '$img')";
if(mysqli_query($conn,$query))
{
	file_put_contents($imagepath, base64_decode($user_image));
	echo json_encode(array("data"=>"true"));
}
else
{
	echo json_encode(array("data"=>"false"));
}
mysqli_close($conn);
?>