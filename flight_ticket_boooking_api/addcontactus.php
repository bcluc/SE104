<?php
 require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$text =$json['text'];
$id = $json["id"];
$query ="INSERT INTO contactus(userid, text, adddate)
          VALUES ($id,'$text', NOW())";
if(mysqli_query($conn,$query))
{
	echo json_encode(array("data"=>"true"));
}
else
{
	echo json_encode(array("data"=>"false"));
}
mysqli_close($conn);
?>