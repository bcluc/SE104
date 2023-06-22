<?php
 require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$detail =$json['detail'];
$email =$json['email'];
$cityid =$json['cityid'];
$bloodgroup =$json['bloodgroup'];
$phone =$json['phone'];

$result = mysqli_query($conn,"SELECT id FROM users ". 
	" WHERE email= '$email' ");
$row=mysqli_fetch_assoc($result);
$id = $row["id"];
$query ="INSERT INTO donation_post(cityid, phone, bloodgroup, userid, details, adddate) ".
" VALUES ($cityid, '$phone', '$bloodgroup', $id, '$detail', NOW())";
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