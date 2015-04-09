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
<script type="text/javascript" src="<?php echo base_url();?>js/main.js"></script>
<script>
 $(document).ready(function(){
		<?php echo $script;?>
		 $('.submenucl').click(function() {

				 var href = $(this).attr('href');

				 window.location.href=href; 
		
        });
	 });
</script>
</head>
<body>
<div id="header">
<li id="logo"><img src="/img/logo.png" /></li>
<li id="textTitle">ระบบฐานข้อมูลธุรกิจ Sipa</li>
<li id="loginBox">
  <table width="100%" border="0" cellspacing="0" cellpadding="6">
    <tbody>
      <tr>
        <td align="right" valign="middle">ยินดีต้อนรับคุณ : </td>
        <td align="left" valign="middle"><?php echo $dataLogin['memName'].'  '.$dataLogin['memLastName']?></td>
      </tr>
      <tr>
        <td colspan="2" align="center" valign="middle"><a href="<?php echo base_url();?>index.php/home/logOut" class="logOutBt">ออกจากระบบ</a></td>
        </tr>
    </tbody>
  </table>
</li>
</div>
<div id="menu">
<ul>
		<li class="bottomMenu"><a id="loadFormSearch"  href="<?php echo base_url();?>index.php/dbdHome/page/loadFormSearch" class="submenucl">ค้นหาข้อมูล</a></li>
        <li class="bottomMenu"><a id="magSearch"  href="<?php echo base_url();?>index.php/dbdHome/page/listSearchGroup" class="submenucl">ค้นหาตามชุด</a></li>
        <li class="bottomMenu"><a id="magSearch"  href="<?php echo base_url();?>index.php/dbdHome/page/magGroupSearch" class="submenucl">จัดการชุดการค้นหา</a></li>
         <li class="bottomMenu"><a id="magGuoup"  href="<?php echo base_url();?>index.php/dbdHome/page/magGuoup" class="submenucl">จัดการ หมวดหมู่ธุรกิจ</a></li>
        <li class="bottomMenu"><a id="magType"  href="<?php echo base_url();?>index.php/dbdHome/page/magType" class="submenucl">จัดการ ประเภท</a></li>
        <li class="bottomMenu"><a id="profi"  href="<?php echo base_url();?>index.php/dbdHome/page/magProfi" class="submenucl">จัดการข้อมูลส่วนตัว</a></li>
   </ul>
</div>
<div class="content" id="content">
</div>
</body>
</html>
