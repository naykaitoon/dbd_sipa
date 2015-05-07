<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<script>
function alertCheck(c,message){
	if(c==false){
		alert(message);
	}
}

function checknum(num){
	if(num*1!=num){
		return false;
	}else{
		return true;
	}
}

function checkmiuns(num){
	if(num<0){
		return false;
	}else{
		return true;
	}
}
function checktel(tel){

	if(tel*1==tel&&tel>0&&tel[0]==0){
		if(tel.length==10){
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
	
}
function main(){
	var c = true;
	c = checknum(document.getElementById('num').value);
	alertCheck(c,'กรุณากรอกตัวเลข');
	if(c==true){
		c = checkmiuns(document.getElementById('num').value);
		alertCheck(c,'ไม่สามารถใส่ค่าติดลบได้');
	
		if(c==true){
			c =checktel(document.getElementById('tel').value);
			alertCheck(c,'กรุณาใส่เบอร์โทรให้ถูกต้อง');
			return c;
		}else{
			return false;
		}
	}else{
		return false;
	}
}

function confirme(){
	var x = confirm("คุณต้องการลบหรือไม่");
	return x;
}
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="<?php echo base_url();?>index.php/home/main" onSubmit="return main()">
  <p>
    <label for="numText">เลข:</label>
    <input type="text" name="num" id="num">
  </p>
   <p>
    <label for="numText">เบอร์โทร:</label>
    <input type="text" name="tel" id="tel">
  </p>
    <p>
    <input type="submit" name="submit" id="submit" value="เช็ค">
  </p>
</form>
<a href="<?php echo base_url();?>index.php/home/main" onClick="return confirme()">ลบ</a>
</body>
</html>