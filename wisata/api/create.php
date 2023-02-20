<?php
require_once('koneksi.php');
$username=$_GET['username'];
$password=$_GET['password'];
$role=$_GET['role'];
mysqli_query($conn,"INSERT INTO pengguna (username, password, role) values ('123','123','ADMIN')");


mysqli_close($conn);
?>