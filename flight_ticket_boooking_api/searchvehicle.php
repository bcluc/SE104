<?php
require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$fromcity =$json['fromcity'];
$tocity =$json['tocity'];
$Q = "SELECT R.route_id as rid, R.route_from_city AS fromcityid, ".
" R.route_to_city as tocityid, C.city_name AS fromcity, CC.city_name AS tocity,".
" R.route_from_departure as deptime, R.route_from_arrival as arivaltime, ".
" R.route_economy_fare AS efare, R.route_business_fare AS bfare, R.route_duration AS duration, V.vehicle_name".
    " FROM route R ".
    " INNER JOIN vehicle V  ON R.route_vehicle_id = V.vehicle_id".
    " INNER JOIN city C ON R.route_from_city = C.city_id".
    " INNER JOIN city CC ON R.route_to_city = CC.city_id".
    " WHERE R.route_from_city = '$fromcity' AND R.route_to_city = '$tocity'";
 $query=mysqli_query($conn, $Q);
 $response =array();
  if (mysqli_num_rows($query)>0) 
  {
    while($row =mysqli_fetch_array($query))
	{
	    array_push($response,array("rid"=>$row[0],"fromcityid"=>$row[1],
        "tocityid"=>$row[2],"fromcity"=>$row[3],"tocity"=>$row[4],"deptime"=>$row[5],
        "arivaltime"=>$row[6],"efare"=>$row[7],"bfare"=>$row[8],"duration"=>$row[9],"vehicle_name"=>$row[10]));
	}
    echo json_encode(array("status"=>"true","data"=>$response));
  }
  else{
    	echo json_encode(array("status"=>"false"));
 } 
mysqli_close($conn);
?>