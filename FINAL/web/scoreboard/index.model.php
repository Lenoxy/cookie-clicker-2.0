<?php
$user ='d041e_leos';
$pass = '54321_Db!!!';

    $conn = new PDO("mysql:host=mysql5.webland.ch;dbname=d041e_leos", $user, $pass);

    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    
    $stmt = $conn->prepare('SELECT * FROM board ORDER BY score DESC');
    $stmt->execute();
    $allscores = $stmt->fetchAll();
?>