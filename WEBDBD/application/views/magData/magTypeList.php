<table class="tableData" width="850" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="56" nowrap="nowrap">รหัส</th>
      <th nowrap="nowrap">ชื่อ</th>
      <th nowrap="nowrap">กลุ่ม</th>
      <th nowrap="nowrap">แก้ไข</th>
      <th nowrap="nowrap">ลบ</th>
    </tr>
  <tbody>
 <?php foreach($type as $t){ ?> 
    <tr>
      <td align="center" valign="top" nowrap="nowrap" style="font-size: 12px"><?php	echo $t['companyTypeId']; ?></td>
      <td width="622" align="left" valign="top" nowrap="nowrap" style="font-size: 12px"><?php	echo $t['companyTypeName']; ?></td>
      <td width="22" align="center" valign="top" nowrap="nowrap"><?php	echo $t['groupCompanyId']; ?></td>
      <td width="70" align="center" valign="top" nowrap="nowrap"><a class="editType" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/formeditType/<?php echo $t['companyTypeId']; ?>"><img src="<?php echo base_url();?>img/edit.png" width="30" height="30"/></a></td>
      <td width="30" align="center" valign="top" nowrap="nowrap"><a class="deleteType" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/deleteType/<?php echo $t['companyTypeId']; ?>"><img src="<?php echo base_url();?>img/delete.png" width="30" height="30"/></a></td>
    </tr>
  <?php	 }?>
  <tr>
      <td colspan="5" align="center" valign="top" nowrap="nowrap">---------------------------------------------------------------------</td>
    </tr>
  </tbody>
</table>

<script>
$( "html" ).removeClass( "loading" );
</script>