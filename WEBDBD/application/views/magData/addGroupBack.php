<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<center><h2>เพิ่ม หมวดหมู่ธุรกิจ</h2></center>
  <form action="<?php echo base_url();?>index.php/dbdHome/addGroupAction" method="post">
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" nowrap="nowrap">รหัสกลุ่ม</th>
      <th nowrap="nowrap">ชื่อกลุ่ม</th>
    </tr>
  <tbody>
    <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $groupCompanyId; ?></td>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><input name="detail" type="text" size="70" placeholder="ชื่อกลุ่มที่ต้องการ" value="<?php echo $detail;?>" required/></td>
    </tr>
     <tr>
      <td align="center" valign="top" nowrap="nowrap">จำนวนประเภทในกลุ่มนี้</td>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><input name="numrow" type="number" max="999" min="1"  value="<?php echo $numrow;?>" width="18px" /> 
        &nbsp;ประเภท</td>
    </tr>
  <tr>
      <td colspan="2" align="center" valign="top" nowrap="nowrap"><input type="submit" class="buttonHome" name="button" id="button" value="บันทึก"></td>
    </tr>
  </tbody>
</table>
</form>
<br>
<br>