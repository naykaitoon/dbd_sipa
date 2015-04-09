<script>
$('.del').click(function(event){
			 event.preventDefault();
		    var href = $(this).attr('href');
			$('#div1').load(href);
});
</script>
<style>
.tableData tr td {
	font-size:11px;
}
</style>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table class="tableData" style="margin-top:-10px" width="300" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="157" nowrap="nowrap">รหัส</th>
      <th width="83" nowrap="nowrap">หมวด</th>
      <th width="30" nowrap="nowrap">ลบ</th>
    </tr>
  <tbody>
 <?php 
 $i=0;
 if($lists){
 foreach($lists as $l){ ?> 
    <tr>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $l['id']; ?></td>
      <td align="center" valign="top" nowrap="nowrap"><?php	echo $l['g']; ?></td>
      <td align="center" valign="top" nowrap="nowrap"><a class="del" href="<?php echo base_url();?>index.php/dbdHome/delListSearch/<?php echo $i;?>"><img src="<?php echo base_url();?>img/delete.png" width="20" /></a></td>
    </tr>
  <?php	 
  $i++;
 }}else{ ?>
 	  <tr>
      <td colspan="3" align="center" valign="top" nowrap="nowrap">ไม่มีข้อมูลรายการ</td>
    </tr>
<?php  }?>
  </tbody>
</table>