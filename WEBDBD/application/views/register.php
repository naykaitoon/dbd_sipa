<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Register</title>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="<?php echo base_url();?>js/jquery.js"></script>
<script>
	 $(document).ready(function(){
	 	$("#registerBt").click(function(){
			if($("#username").val()&&$("#password").val()&&$("#memName").val()&&$("#memLastName").val()&&$("#address").val()&&$("#email").val()&&$("#tel").val()){
			 $.post("<?php echo base_url();?>index.php/home/checkUserName",
			  {
				username:$("#username").val()
				 },
			  function(result){
		if(result!=0){
			if($("#password").val()==$("#passwordCheck").val()){
			  $.post("<?php echo base_url();?>index.php/home/registerAction",
			  {
				username:$("#username").val(),
				password:$("#password").val(),
				memName:$("#memName").val(),
				memLastName:$("#memLastName").val(),
				address:$("#address").val(),
				email:$("#email").val(),
				tel:$("#tel").val()
			  },
			  function(data){
				  if(data==1){
					alert("ลงทะเบียนสำเร็จ สามารถเข้าใช้งานได้เลย");
				  }else{
					 alert("ลงทะเบียนล้มเหลวกรุณาลงทะเบียนใหม่");
				  }
				  	parent.$.fancybox.close();
			  });
				}else{
					alert("password ไม่ตรงกัน");
				}
		}else{
			alert("Username ไม่สามารถใช้ได้");
		}
			});
			}else{
				alert("กรุณากรอกข้อมูลให้ครบถ้วน");
			}
			  });
	 });
</script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	text-align: center;
}
.inputTextRegis {
 padding: 5px;
  border: solid 1px #dcdcdc;
  transition: box-shadow 0.3s, border 0.3s;
}
.inputTextRegis:focus {
   border: solid 1px #707070;
  box-shadow: 0 0 5px 1px #969696;
}
table tbody tr th{
padding:10;
	color:#FFFFFF;
	text-shadow:2px 2px 2px 0px #7A7A7A;
	background: rgb(122,188,255); /* Old browsers */
background: -moz-linear-gradient(top,  rgba(122,188,255,1) 0%, rgba(96,171,248,1) 44%, rgba(64,150,238,1) 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(122,188,255,1)), color-stop(44%,rgba(96,171,248,1)), color-stop(100%,rgba(64,150,238,1))); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  rgba(122,188,255,1) 0%,rgba(96,171,248,1) 44%,rgba(64,150,238,1) 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  rgba(122,188,255,1) 0%,rgba(96,171,248,1) 44%,rgba(64,150,238,1) 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  rgba(122,188,255,1) 0%,rgba(96,171,248,1) 44%,rgba(64,150,238,1) 100%); /* IE10+ */
background: linear-gradient(to bottom,  rgba(122,188,255,1) 0%,rgba(96,171,248,1) 44%,rgba(64,150,238,1) 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#7abcff', endColorstr='#4096ee',GradientType=0 ); /* IE6-9 */

	border-top-left-radius:5px;
	border-top-right-radius:5px;
}
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tbody>
    <tr>
      <th colspan="2" align="center" valign="middle" nowrap="nowrap">ลงทะเบียน</th>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">ชื่อเข้าใช้งานระบบ : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="username" id="username" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">รหัสผ่าน : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="password" name="password" id="password" class="inputTextRegis"  required>
      &nbsp;ยืนยันรหัสผ่าน 
      <input type="password" name="passwordCheck" id="passwordCheck" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">ชื่อ&nbsp;: </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="memName" id="memName" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">นามสกุล&nbsp;: </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="memLastName" id="memLastName" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">ที่อยู่ : </td>
      <td align="left" valign="middle" nowrap="nowrap"><textarea name="address" cols="40" rows="3" id="address" class="inputTextRegis"  required></textarea></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">E-mail : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="email" name="email" id="email" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">เบอร์โทร : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="tel" id="tel" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td colspan="2" align="center" valign="middle" nowrap="nowrap"><input type="button" name="registerBt" id="registerBt" value="ลงทะเบียน" class="buttonHome"></td>
    </tr>
  </tbody>
</table>
</body>
</html>