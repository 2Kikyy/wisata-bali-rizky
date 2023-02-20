<?php

$servername = "localhost";

// for testing the user name is root
$db_username = "root";

// the password for testing is "blank"
$db_password = "";

// below is the name for our database which we have added
$db_name = "wisata_rizky28";

// Create connection
$conn = new mysqli($servername, $db_username, $db_password, $db_name);

// An array to display response
$response = array();

// On below line we are checking if the body provided by user contains
// this keys as course name, course description and course duration

if($_POST['username'] && $_POST['password'] && $_POST['role']) {
    // if above 3 parameters are present then we are extracting values from it and storing it in new variables.
    $username = $_POST['username'];
    $password = $_POST['password'];
    $role = $_POST['role'];

    /**
     * after that we are writing an sql query to add this data to our database.
     * We have create our table name as user and add all column headers to it except our id.
     */
    $statement = $conn->prepare("INSERT INTO 'user' ('username', 'password', 'role') VALUES (?,?,?)");
    $statement->bind_param("sss", $username, $password, $role);

    // checking if sql query is executed successfully.
    if($statement->execute() == TRUE) {
        // if executed successfully we're passing data to response object with a success message.
        $response['error'] = false;
        $response['message'] = "Register success!";
    } else {
        // if error do this
        $response['error'] = true;
        $response['message'] = "failed\n " . $conn->error;
    }
} else {
    // this method is called when user don't enter sufficient parameters
    $response['error'] = true;
    $response['message'] = "Insufficient parameters";
}
// printing response which we get.
echo json_encode($response);
?>