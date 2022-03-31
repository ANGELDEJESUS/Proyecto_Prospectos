<?php
include_once 'db.php';
header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS, PUT, DELETE");
header("Allow: GET, POST, OPTIONS, PUT, DELETE");

$datosRecibidos = file_get_contents("php://input");
$archivo = json_decode($datosRecibidos);
$doc=$archivo->doc;
$name =$archivo->name;
$url =$archivo->url;
# Ahora podemos acceder a los datos, accederemos a unos pocos para demostrar
# Finalmente armamos la respuesta, igualmente como JSON
# sería como un espejo pero en otras circunstancias podrías devolver
# datos de una base de datos u otro medio
# Codificarla e imprimirla

     $sql = "INSERT INTO `tbarchivos` (`doc`,`idre`, `url`) VALUES ('$doc','$name', '$url')";
 
     if (mysqli_query($conn, $sql)) {
        echo "New record has been added successfully !";
     } else {
        echo "Error: " . $sql . ":-" . mysqli_error($conn);
     }
     mysqli_close($conn);
 
?>