<?php
require 'db.php';

$json =json_decode(file_get_contents("php://input"), true);
$userid =$json['userid'];
$routeid =$json['routeid'];

$QueryB = "INSERT INTO booking(booking_user_id, booking_route_id, booking_date,".
" booking_total_fare, booking_journey_date, booking_seat_type, booking_status)".
" VALUES ('$userid', '$routeid', NOW(), '', '', '', 0)";
$response =array();
if(mysqli_query($conn,$QueryB))
{
    $id = mysqli_insert_id($conn);
    array_push($response,array("bid"=>$id));
    echo json_encode(array("status"=>"true","data"=>$response));
}
else{
	echo json_encode(array("status"=>"false"));
} 
mysqli_close($conn);
?>