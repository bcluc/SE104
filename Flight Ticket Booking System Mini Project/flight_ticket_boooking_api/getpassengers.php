<?php
require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$bid =$json['bid'];
$Q = "SELECT * FROM `passengar` WHERE passengar_booking_id = '$bid'";
 $query=mysqli_query($conn, $Q);
 $response =array();
  if (mysqli_num_rows($query)>0) 
  {
    while($row =mysqli_fetch_array($query))
	{
        
	    array_push($response,array("type"=>$row[2],"name"=>$row[3],
        "gender"=>$row[4],"age"=>$row[5]));
	}
    echo json_encode(array("status"=>"true","data"=>$response));
  }
  else{
    	echo json_encode(array("status"=>"false"));
 } 
mysqli_close($conn);
?>