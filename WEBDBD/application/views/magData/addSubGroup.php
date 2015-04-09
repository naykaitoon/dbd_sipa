<script type="text/javascript" src="<?php echo base_url();?>js/jquery.js"></script>
<script type="text/javascript">

</script>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<center><h2>เพิ่ม หมวดหมู่ย่อยในกลุ่มธุรกิจ <?php	echo $data1['groupCompanyId']; ?></h2></center>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<?php echo base_url();?>index.php/dbdHome/addGroupBack">กลับ</a>
  <form action="<?php echo base_url();?>index.php/dbdHome/addSubGroupAction" method="post">
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" nowrap="nowrap">รหัสกลุ่ม</th>
      <th nowrap="nowrap">ชื่อกลุ่ม</th>
    </tr>

    <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $data1['groupCompanyId']; ?></td>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><?php	echo $data1['detail']; ?></td>
    </tr>
      <tbody class="addRow">
      </tbody>

</table>
<br>
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" nowrap="nowrap">รหัสประเภท</th>
      <th nowrap="nowrap">ชื่อประเภท</th>
    </tr>
       <?php for($i=$numrow;$i>0;$i--){?>
      <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $companyTypeId++; ?><input name="companyTypeId[]" type="hidden" size="60" value="<?php	echo $companyTypeId; ?>" required></td>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><input name="companyTypeName[]" type="text" size="60" required></td>
    </tr>
    <?php }?>
  <tr>
      <td colspan="2" align="center" valign="top" nowrap="nowrap"><input type="submit" class="buttonHome" name="button" id="button" value="บันทึก"></td>
    </tr>

</table>
</form>
<br>
<br>