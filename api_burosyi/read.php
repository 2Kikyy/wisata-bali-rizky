<?php
require_once('../koneksi.php');
$pid=$_GET['id'];
$records = mysqli_query($conn,"select * from pengguna where id=".$pid);
$data = array();
while($row = mysqli_fetch_assoc($records))
{
    $data[] = $row;
}

echo json_encode($data);
mysqli_close($conn);

?>