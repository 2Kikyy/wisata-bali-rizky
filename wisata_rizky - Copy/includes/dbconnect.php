<?php

// class dbconnect
class DbConnect {
    // Variable to store database link
    private $con;

    // class constructor
    function __construct() {}

    // This method will connect to the database
    function connect() {
        // Including the constanst.php file to get the database constants
        include_once dirname(__FILE__) . '/constants.php';

        // Connecting to mysql database
        $this->con = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

        // Checking if any error occured while connecting
        if (mysqli_connect_errno()) {
            echo "Failed to connect to MYSQL: " . mysqli_connect_error();
        }

        // Finally returning the connection link
        return $this->con;
    }
}
?>