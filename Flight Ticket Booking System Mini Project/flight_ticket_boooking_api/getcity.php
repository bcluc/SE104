<?php
require 'db.php';
 $query=mysqli_query($conn,"SELECT * FROM city");
 $response =array();
  if (mysqli_num_rows($query)>0) 
  {
    while($row =mysqli_fetch_array($query))
	{
	    array_push($response,array("cityid"=>$row[0],"cityname"=>$row[1]));
	}
    echo json_encode(array("status"=>"true","City"=>$response));
  }
  else{
    	echo json_encode(array("status"=>"false"));
 } 
mysqli_close($conn);
?>