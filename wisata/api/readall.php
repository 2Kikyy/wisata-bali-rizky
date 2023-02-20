<?php
require_once('koneksi.php');
$records = mysqli_query($conn,"select * from pengguna");
$data = array();
while($row = mysqli_fetch_assoc($records))
{
    $data[] = $row;
}

echo json_encode($data);
mysqli_close($conn);

?>