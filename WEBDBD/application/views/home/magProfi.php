
<style>
select{
	font-size:12px;
}
</style>
<center>
  <h2>จัดการข้อมูลส่วนตัว</h2></center>
  	<?php foreach($profi as $g){ ?>
<table class="tableData" width="700" border="0" align="center" cellpadding="8" cellspacing="2">
    <tr>
      <th width="13%" nowrap="nowrap">ชื่อ</th>
      <td width="87%" nowrap="nowrap"><?php echo $g['memName'];?></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">นามสกุล</th>
      <td width="87%" nowrap="nowrap"><?php echo $g['memLastName'];?></td>
    </tr>
       <tr>
      <th width="13%" nowrap="nowrap">ที่อยู่</th>
      <td width="87%" nowrap="nowrap"><?php echo $g['memAddress'];?></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">e-mail</th>
      <td width="87%" nowrap="nowrap"><?php echo $g['memEmail'];?></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">เบอร์โทร</th>
      <td width="87%" nowrap="nowrap"><?php echo $g['memTel'];?></td>
    </tr>
     <tr>
      <th width="13%" colspan="2" nowrap="nowrap"><a class="magProfi" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/editProFi" >แก้ไขข้อมูลส่วนตัว</a></th>
    </tr>
</table>
	<?php }?>
<br>
<br>

<script>
$( "html" ).removeClass( "loading" );
</script>