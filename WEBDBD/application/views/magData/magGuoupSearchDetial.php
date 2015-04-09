<center></center>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" nowrap="nowrap">รหัสประเภท</th>
      <th nowrap="nowrap">ขื่อประเภท</th>
      <th nowrap="nowrap">หมวด</th>
      <th nowrap="nowrap">จังหวัด</th>
       <th nowrap="nowrap">ปี</th>
     <!-- <th nowrap="nowrap">ลบ</th> -->
    </tr>
  <tbody>
 <?php foreach($gro as $g){ ?> 
    <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $g['companyTypeId']; ?></td>
      <td width="66%" align="left" valign="top" nowrap="nowrap"><?php	echo substr($g['companyTypeName'],6); ?></td>
       <td width="9%" align="center" valign="top" nowrap="nowrap"><?php	echo $g['groupCompanyId']; ?></td>
      <td width="6%" align="left" valign="top" nowrap="nowrap"><?php	echo $g['provinceName']; ?></td>
        <td width="9%" align="center" valign="top" nowrap="nowrap"><?php echo $g['year']; ?></td>
   <!--    <td width="9%" align="center" valign="top" nowrap="nowrap"><a class="deleteGroup" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/deleteGroup/<?php echo $g['groupCompanyId']; ?>">ลบ</a></td>-->
    </tr>
  <?php	 }?>
  </tbody>
</table>
<br>
<br>
<script>
$( "html" ).removeClass( "loading" );
</script>