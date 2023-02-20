<?php
require_once('../koneksi.php');
$pid=$_GET['id'];
$pusername=$_GET['username'];
$ppassword=$_GET['password'];
$query = "update pengguna set username='".$pusername."', password='".$ppassword."' where id='".$pid."'";
if(mysqli_query($conn, $query))
{
    echo "success";
}
else
{
    echo "failed";
}

mysqli_close($conn);

?>