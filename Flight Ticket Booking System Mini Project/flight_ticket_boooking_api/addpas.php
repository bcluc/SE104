<?php
    require 'db.php';
    $json =json_decode(file_get_contents("php://input"), true);

    $type =$json['type'];
    $name =$json['name'];
    $gender = $json['gender'];
    $age = $json['age'];
    $id = $json['id'];

    $Query = "INSERT INTO passengar(passengar_booking_id, passengar_type,".
        " passengar_name, passengar_gender, passengar_age)".
        " VALUES ('$id', '$type', '$name', '$gender', '$age')";
    if(mysqli_query($conn,$Query))
    {
        echo json_encode(array("data"=>"true"));
    }
    else
    {
        echo json_encode(array("data"=>"false"));
    }
mysqli_close($conn);
?>