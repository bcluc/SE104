<?php
require 'db.php';

$query=mysqli_query($conn,"SELECT * FROM tbl_banner");
$response=array();
if (mysqli_num_rows($query)>0) {
	while($row =mysqli_fetch_array($query))
	{
		array_push($response,array("id"=>$row[0],"image"=>$row[1],"p_id"=>$row[2]));
	}
	echo json_encode(array("status"=>"true","data"=>$response));
}
else{
	echo json_encode(array("status"=>"false"));
} 
mysqli_close($conn);
?>