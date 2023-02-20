<?php

class DbOperation {
    // Database connection link
    private $con;

    // Class constructor
    function __construct() {
        // Getting the dbconnect.php file
        require_once dirname(__FILE__) . '/dbconnect.php';

        // Creating a dbconnect object to connect to the database
        $db = new Dbconnect();

        /**
         * Initializing our connection link of this class
         * by calling the method connect of DbConnect class
         */
        $this->con = $db->connect();
    }

    /**
     * The create operation
     * When this method is called a new record is created in the database
     */
    function createUser($name, $pwd, $role) {
        $statement = $this->con->prepare("INSERT INTO user (name, password, role) VALUES (?, ?, ?)");
        $statement->bind_param("ssis", $name, $pwd, $role);
        if($statement->execute())
        return true;
        return false;
    }

    function getUser() {
        $statement = $this->con->prepare("SELECT id, name, password, role FROM user");
        $statement->execute();
        $statement->bind_result($id, $name, $pwd, $role);

        $users = array();

        while($statement->fetch()) {
            $user = array();
            $user['id'] = $id;
            $user['name'] = $name;
            $user['password'] = $pwd;

            array_push($users, $user);
        }

        return $users;
    }

    /**
     * The update operation when this method is 
     * called the record with the given id is 
     * updated with the new given values
     */
    function updateUser($id, $name, $pwd, $role) {
        $statement = $this->con->prepare("UPDATE user SET name = ?, pwd = ?, $role = ? WHERE id = ?");
        $statement->bind_param("ssisi", $name, $pwd, $role, $id);
        if($statement->execute())
        return true;
        return false;
    }

    /**
     * The delete operation
     * When this method is called record is deleted for the given id
     */
    function deleteUser($id) {
        $statement = $this->con->prepare("DELETE FROM user WHERE id = ? ");
        $statement->bind_param("i", $id);
        if($statement->execute())
        return true;

        return false;
    }
}
?>