<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Detial</title>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<?php foreach($detial as $d){?>
<table class="tableData" width="85%" border="0" align="center" cellpadding="8" cellspacing="2">
 <tr>
      <th width="13%" align="right" nowrap="nowrap">ชื่อ</th>
      <td width="87%"><?php echo $d['companyName'];?></td>
  </tr>
   <tr>
      <th width="13%" align="right" nowrap="nowrap">หมายเลขนิติบุคคล</th>
      <td width="87%"><?php echo $d['companyNo'];?></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">วันที่จดทะเบียน</th>
      <td width="87%"><?php echo $d['dateRegister'];?></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">สถานะ</th>
      <td width="87%"><?php echo $d['status'];?></td>
  </tr>
       <tr>
      <th width="13%" align="right" nowrap="nowrap">เงินจดทะเบียน</th>
      <td width="87%"><?php echo $d['moneyRegister'];?></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">ที่อย่</th>
      <td width="87%"><?php echo $d['address'];?></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">จุดประสงค์</th>
      <td width="87%"><?php echo $d['object'];?></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">ปีที่ส่งงบ</th>
      <td width="87%"><?php echo $d['yearSentStament'];?></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">คณะกรรมการ</th>
      <td width="87%"><?php echo $d['syndicate'];?></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">หุ้นส่วน</th>
      <td width="87%"><?php echo $d['partner'];?></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">เบอร์โทร</th>
      <td width="87%"><?php echo $d['tel'];?></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">FAX</th>
      <td width="87%"><?php echo $d['fax'];?></td>
  </tr>
   <tr>
      <th width="13%" align="right" nowrap="nowrap">E-mail</th>
      <td width="87%"><?php echo $d['email'];?></td>
  </tr>
   <tr>
      <th colspan="2" align="center" nowrap="nowrap"><a href="<?php echo base_url();?>index.php/dbdHome/getDetialEdit/<?php echo $d['detailcompanyid'];?>"><button class="buttonHome"> แก้ไข</button></a>&nbsp;&nbsp;<a href="<?php echo base_url();?>index.php/dbdHome/changeGroupType/<?php echo $d['companyId'];?>"><button class="buttonHome"> ย้ายหมวด</button></a></th>
  </tr>
</table>
<?php }?>
</body>
</html>