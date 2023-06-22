<?php
require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$userid =$json['userid'];
$Q = "SELECT B.booking_id AS id, B.booking_journey_date AS traveldate, B.booking_total_fare AS fare, B.booking_seat_type AS vclass,
 C.city_name As fromcity, CC.city_name as tocity, B.booking_total_fare as fare
FROM booking B
INNER JOIN route R ON B.booking_route_id = R.route_id
INNER JOIN city C ON R.route_from_city = C.city_id
INNER JOIN city CC ON R.route_to_city = CC.city_id
WHERE B.booking_user_id = '$userid'";
 $query=mysqli_query($conn, $Q);
 $response =array();
  if (mysqli_num_rows($query)>0) 
  {
    while($row =mysqli_fetch_array($query))
	{
        
	    array_push($response,array("id"=>$row[0],"traveldate"=>$row[1],
        "fare"=>$row[2],"vclass"=>$row[3],"fromcity"=>$row[4],"tocity"=>$row[5],"fare"=>$row[6],
       ));
	}
    echo json_encode(array("status"=>"true","data"=>$response));
  }
  else{
    	echo json_encode(array("status"=>"false"));
 } 
mysqli_close($conn);
?>