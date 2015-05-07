<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<style>
select{
	font-size:12px;
}
</style>
<center>
  <h2>จัดการข้อมูลส่วนตัว</h2></center>
  	<?php foreach($profi as $g){ ?>
    <form action="<?php echo base_url();?>index.php/dbdHome/editProFiAction" method="post">
    <input type="hidden" name="memId" value="<?php echo $g['memId'];?>"/>
<table class="tableData" width="700" border="0" align="center" cellpadding="8" cellspacing="2">
 <tr>
      <th width="13%" valign="middle" nowrap="nowrap">username</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="hidden" class="inputText"  name="memUsername" value="<?php echo $g['memUsername'];?>"/><?php echo $g['memUsername'];?></td>
    </tr>
    <tr>
      <th width="13%" valign="middle" nowrap="nowrap">password</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="password" class="inputText"  name="memPassword" value="" required/></td>
    </tr>
     <tr>
      <th width="13%" valign="middle" nowrap="nowrap">ยืนยันpassword</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="password" class="inputText"  name="memPassword2" value="" required/></td>
    </tr>
    <tr>
      <th width="13%" valign="middle" nowrap="nowrap">ชื่อ</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="text" class="inputText"  name="memName" value="<?php echo $g['memName'];?>"/></td>
    </tr>
        <tr>
      <th width="13%" valign="middle" nowrap="nowrap">นามสกุล</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="text" class="inputText"  name="memLastName" value="<?php echo $g['memLastName'];?>"/></td>
    </tr>
       <tr>
      <th width="13%" valign="middle" nowrap="nowrap">ที่อยู่</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="text" class="inputText"  name="memAddress" value="<?php echo $g['memAddress'];?>"/></td>
    </tr>
        <tr>
      <th width="13%" valign="middle" nowrap="nowrap">e-mail</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="text" class="inputText"  name="memEmail" value="<?php echo $g['memEmail'];?>"/></td>
    </tr>
        <tr>
      <th width="13%" valign="middle" nowrap="nowrap">เบอร์โทร</th>
      <td width="87%" valign="middle" nowrap="nowrap"><input type="text" class="inputText"  name="memTel" value="<?php echo $g['memTel'];?>"/></td>
    </tr>
     <tr>
      <td width="13%" colspan="2" align="center" valign="middle" nowrap="nowrap"><input type="submit" value="ยืนยัน" class="buttonHome" ></td>
    </tr>
</table>
</form>
	<?php }?>
<br>
<br>