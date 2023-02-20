<?php
require_once('koneksi.php');
$pid=$_GET['id'];
$query = "delete from pengguna where id=".$pid."";
if(mysqli_query($conn, $query))
{
    echo "success";
}
else
{
    echo mysqli_error($conn);
}

mysqli_close($conn);
?>
