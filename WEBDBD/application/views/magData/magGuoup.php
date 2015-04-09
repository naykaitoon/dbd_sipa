<center><h2>จัดการ หมวดหมู่ธุรกิจ</h2>
  <p style="width:60%;" align="right"><a class="addGroup" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/addGroup"><img src="<?php echo base_url();?>img/addGroup.png" width="30" height="30"/> เพิ่มกลุ่ม</a></p>
</center>
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" nowrap="nowrap">รหัสกลุ่ม</th>
      <th nowrap="nowrap">ชื่อกลุ่ม</th>
      <th nowrap="nowrap">แก้ไข</th>
      <th nowrap="nowrap">ลบ</th>
    </tr>
  <tbody>
 <?php foreach($group as $g){ ?> 
    <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $g['groupCompanyId']; ?></td>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><?php	echo $g['detail']; ?></td>
      <td width="10%" align="center" valign="top" nowrap="nowrap"><a class="editGroup" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/formeditGroup/<?php echo $g['groupCompanyId']; ?>"><img src="<?php echo base_url();?>img/edit.png" width="30" height="30"/></a></td>
      <td width="9%" align="center" valign="top" nowrap="nowrap"><a class="deleteGroup" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/deleteGroup/<?php echo $g['groupCompanyId']; ?>"><img src="<?php echo base_url();?>img/delete.png" width="30" height="30"/></a></td>
    </tr>
  <?php	 }?>
  <tr>
      <td colspan="4" align="center" valign="top" nowrap="nowrap">---------------------------------------------------------------------</td>
    </tr>
  </tbody>
</table>
<br>
<br>
<script>
$( "html" ).removeClass( "loading" );
</script>