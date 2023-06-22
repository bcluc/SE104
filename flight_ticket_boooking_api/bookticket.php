<?php
 require 'db.php';
$json =json_decode(file_get_contents("php://input"), true);
$userid =$json['userid'];
$routeid =$json['routeid'];
$fare =$json['fare'];
$traveldate =$json['traveldate'];
$seattype =$json['seattype'];
$cardnum = $json['cardnum'];
$month = $json['month'];
$year = $json['year'];
$cvv = $json['cvv'];
$bid = $json['bid'];

    $QueryB = "UPDATE booking SET booking_user_id = '$userid',
         booking_route_id = '$routeid',
         booking_date = NOW(), 
         booking_total_fare = '$fare',
         booking_journey_date  = '$traveldate',
         booking_seat_type = '$seattype',
         booking_status = 0
         WHERE booking_id = '$bid'";
    if(mysqli_query($conn,$QueryB))
    {
        $Q = "INSERT INTO `payment`(`bookid`, `cardnum`, `month`, `year`, `cvv`)".
            " VALUES ('$bid', '$cardnum', '$month', '$year', '$cvv')";
        if(mysqli_query($conn, $Q))
        {
            echo json_encode(array("data"=>"true"));
            die;
        }
        else
        {
            echo json_encode(array("data"=>"false"));
            die;
        }
    }
    else
    {
       echo json_encode(array("data"=>"false"));
        die;
    }
mysqli_close($conn);
?>