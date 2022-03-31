<?php 
include_once 'db.php';
header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, DELETE");
header("Allow: GET, POST, OPTIONS, PUT, DELETE");
$sql = "SELECT * FROM tbarchivos";
 
$query = mysqli_query($conn,$sql);
$resultado = $query;
$datos = [];
if($resultado->num_rows) {
    while($row = $resultado->fetch_assoc()) {
        $datos[] = [
            'id' => $row['id'],
            'doc' => $row['doc'],
            'idre' => $row['idre'],
            'url'=>$row['url']
        ];
    }//end while
    echo json_encode($datos);
    return json_encode($datos);
}//end if
return json_encode($datos);

?>