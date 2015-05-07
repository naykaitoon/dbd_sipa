<html>

<head>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8"/> 
</head>
<body>

<?php
$path = getcwd();
exec('D: & cd wamp/www/WEBDBD/java & java -jar 16.jar', $output);
var_dump($output);
?>
</body>
</html>