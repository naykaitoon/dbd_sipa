<script>
$('.loadcombobox').load('<?php echo base_url();?>index.php/dbdHome/magTypeList/');
$('#groupCompanyId').change(function(){
	$('.loadcombobox').load('<?php echo base_url();?>index.php/dbdHome/magTypeList/'+$(this).val()+'');
});
</script>

<center><h2>จัดการ ประเภทธุรกิจ</h2>
  <p>
    <label for="select">เลือกกลุ่มธุรกิจ:</label>
    <select name="groupCompanyId" id="groupCompanyId" size="6">
     <?php foreach($group as $g){ ?> 
    <option value="<?php echo $g['groupCompanyId'];?>"><?php echo $g['detail'];?></option>
     <?php	 }?>
    </select>
  </p>
</center>

<div class="loadcombobox">

</div>
<br>
<br>
