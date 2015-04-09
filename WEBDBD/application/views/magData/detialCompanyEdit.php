<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Detial</title>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="<?php echo base_url();?>index.php/dbdHome/editDetail" method="post">
<?php foreach($detial as $d){?>
<table class="tableData" width="85%" border="0" align="center" cellpadding="8" cellspacing="2">
 <tr>
      <th width="13%" align="right" nowrap="nowrap">ชื่อ</th>
      <td width="87%"><input name="companyName" type="text" value="<?php echo $d['companyName'];?>" size="80"/></td>
  </tr>
   <tr>
      <th width="13%" align="right" nowrap="nowrap">หมายเลขนิติบุคคล</th>
      <td width="87%"><input name="companyNo" type="text" value="<?php echo $d['companyNo'];?>" size="80"/></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">วันที่จดทะเบียน</th>
      <td width="87%"><input name="dateRegister" type="text" value="<?php echo $d['dateRegister'];?>" size="80"/></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">สถานะ</th>
      <td width="87%"><input name="status" type="text" value="<?php echo $d['status'];?>" size="50"/></td>
  </tr>
       <tr>
      <th width="13%" align="right" nowrap="nowrap">เงินจดทะเบียน</th>
      <td width="87%"><input type="text" name="moneyRegister" value="<?php echo $d['moneyRegister'];?>"/></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">ที่อย่</th>
      <td width="87%"><input name="address" type="text" value="<?php echo $d['address'];?>" size="80"/></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">จุดประสงค์</th>
      <td width="87%"><input name="object" type="text" value="<?php echo $d['object'];?>" size="70"/></td>
  </tr>
        <tr>
      <th width="13%" align="right" nowrap="nowrap">ปีที่ส่งงบ</th>
      <td width="87%"><input name="yearSentStament" type="text" value="<?php echo $d['yearSentStament'];?>" size="60"/></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">คณะกรรมการ</th>
      <td width="87%">
      <textarea name="syndicate" cols="50" rows="5" id="syndicate"><?php echo $d['syndicate'];?></textarea></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">หุ้นส่วน</th>
      <td width="87%">
      <textarea name="partner" cols="50" rows="5" id="partner"><?php echo $d['syndicate'];?></textarea>
</td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">เบอร์โทร</th>
      <td width="87%"><input type="text" name="tel" value="<?php echo $d['tel'];?>"/></td>
  </tr>
    <tr>
      <th width="13%" align="right" nowrap="nowrap">FAX</th>
      <td width="87%"><input type="text" name="fax" value="<?php echo $d['fax'];?>"/></td>
  </tr>
   <tr>
      <th width="13%" align="right" nowrap="nowrap">E-mail</th>
      <td width="87%"><input name="email" type="email" value="<?php echo $d['email'];?>" size="40"/></td>
  </tr>
   <tr>
      <th colspan="2" align="center" nowrap="nowrap"><input type="submit" value="บันทึก" class="buttonHome"><input type="hidden" name="companyId" value="<?php echo $d['companyId'];?>"/></th>
  </tr>
</table>
<?php }?>
</form>
</body>
</html>