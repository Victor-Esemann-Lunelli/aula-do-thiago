<?php
date_default_timezone_set('America/Sao_Paulo');
$nome = "joão";

echo "aula do $nome <br>  <br>";

$hora = (int)date("H");

echo ("$hora<br>");

if($hora >=5 && $hora < 12){
echo "bom dia";
}elseif($hora >= 12 && $hora < 18){
    echo "boa  tarde";
}else{
    echo "boa noite";
}
echo ("<br> Apremdemdo repetição <br>");

for($i = 1; $i<=5; $i++){
echo "numero: $i <br>";
}
?>