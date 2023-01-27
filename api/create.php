<?php
require_once('../koneksi.php');
$pusername=$_GET['username'];
$ppassword=$_GET['password'];
$query = "insert into pengguna (username, password) values ('".$pusername."','".$ppassword."')";
if(mysqli_query($conn, $query)) {
    echo "success";
} else {
    echo "failed";
}

mysqli_close($conn);
?>