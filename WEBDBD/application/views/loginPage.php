<!doctype html>
<html class="loading">
<head>
<meta charset="utf-8">
<title>SIPA-DBD</title>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="<?php echo base_url();?>js/jquery.js"></script>
<script type="text/javascript" src="<?php echo base_url();?>fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>
<link rel="stylesheet" href="<?php echo base_url();?>fancybox/source/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
<script type="text/javascript" src="<?php echo base_url();?>fancybox/source/jquery.fancybox.pack.js?v=2.1.5"></script>
<link rel="stylesheet" href="<?php echo base_url();?>fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css" media="screen" />
<script type="text/javascript" src="<?php echo base_url();?>fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
<script type="text/javascript" src="<?php echo base_url();?>fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>
<link rel="stylesheet" href="<?php echo base_url();?>fancybox/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css" media="screen" />
<script type="text/javascript" src="<?php echo base_url();?>fancybox/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>
 <script>
	 $(document).ready(function(){
$('.regis').fancybox({
		maxWidth	: 800,
		maxHeight	: 600,
		fitToView	: false,
		width		: '80%',
		height		: '80%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0
});
$(document).keypress(function(e) {
    if(e.which == 13) {
        if($("#username").val()==""){
			$("#username").focus();
		}
		if($("#password").val()==""&&$("#username").val()==""){
			$("#username").focus();
		}
		if($("#password").val()==""&&$("#username").val()!=""){
			$("#password").focus();
		}
		if($("#password").val()!=""&&$("#username").val()!=""){
			$("#loginBt").trigger("click");
		}
    }
});
			$("#loginBt").click(function(){
				$( "html" ).removeClass( "loading" );
			  $.post("<?php echo base_url();?>index.php/home/login",
			  {
				username:$("#username").val(),
				password:$("#password").val()
			  },
			  function(data){
				if(data==1){
					window.location.replace("<?php echo base_url();?>index.php/dbdHome");
				}else if(data==0){
					$( "html" ).removeClass( "loading" );
					alert('ไม่พบผู้ใช้งานนี้ในระบบ');
				}else if(data==3){
					$( "html" ).removeClass( "loading" );
					alert('กรุณากรอกข้อมูลให้ครบถ้วน');
				}
			  });
			});
 });
	 </script>
</head>

<body>
<div id="header">
<li id="logo"><img src="/img/logo.png" /></li>
<li id="textTitle">ระบบฐานข้อมูลธุรกิจ Sipa</li>
</div>
<div id="loginForm">
  <table width="100%" border="0" cellspacing="0" cellpadding="10">
    <tbody>
      <tr>
        <th colspan="2" align="center" valign="middle" nowrap="nowrap">ลงชื่อเข้าใช้ระบบ</th>
      </tr>
      <tr>
        <td align="right" valign="middle" nowrap="nowrap">ชื่อเข้าใช้งาน : </td>
        <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="username" id="username" class="inputText" ></td>
      </tr>
      <tr>
        <td align="right" valign="middle" nowrap="nowrap">รหัสผ่าน : </td>
        <td align="left" valign="middle" nowrap="nowrap"><input type="password" name="password" id="password" class="inputText"></td>
      </tr>
      <tr>
        <td colspan="2" align="center" valign="middle" nowrap="nowrap">
           <button id="loginBt" class="buttonHome">ลงชื่อเข้าใช้</button>  <a class="regis" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/home/register"> <button id="registerBt" class="buttonHome">ลงทะเบียน</button></a>
  
        </td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>
<script>
$( "html" ).removeClass( "loading" );
</script>
