<?php
	require 'db.php';
	$json = json_decode(file_get_contents("php://input"),true);
	$email = $json['email'];
	$password = $json['password'];
	$result = mysqli_query($conn,"SELECT U.user_id, U.user_name, U.user_email, U.user_city as cityid, U.user_password, U.user_mobile, U.user_image, C.city_name as cityname, CONCAT(U.user_add1, ' ', U.user_add2) as address".
		" FROM user U".
		" INNER JOIN city C on U.user_city = C.city_id".
		" WHERE U.user_email = '$email' AND U.user_password = '$password'");
	if(mysqli_num_rows($result)>0)
	{
	    $row=mysqli_fetch_assoc($result);
	    echo json_encode(array("status"=>"true","data"=>$row));
	}
	else
	{
	    echo json_encode(array("status"=>"false"));
	}
	mysqli_close($conn); 
?>