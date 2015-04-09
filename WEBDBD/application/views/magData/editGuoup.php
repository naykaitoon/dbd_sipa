<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<center><h2>แก้ไข หมวดหมู่ธุรกิจ <?php	echo $group[0]['detail']; ?></h2></center>
  <form action="<?php echo base_url();?>index.php/dbdHome/formeditGroupAction/<?php	echo $group[0]['groupCompanyId']; ?>" method="post">
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" nowrap="nowrap">รหัสกลุ่ม</th>
      <th nowrap="nowrap">ชื่อกลุ่ม</th>
    </tr>
  <tbody>
 <?php foreach($group as $g){ ?> 
    <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $g['groupCompanyId']; ?></td>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><input name="detail" type="text" required value="<?php	echo $g['detail']; ?>" size="70"></td>
    </tr>
  <?php	 }?>
  <tr>
      <td colspan="2" align="center" valign="top" nowrap="nowrap"><input type="submit" class="buttonHome" name="button" id="button" value="บันทึก"></td>
    </tr>
  </tbody>
</table>
</form>
<br>
<br>