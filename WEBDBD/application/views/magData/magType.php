<script>
$('.loadcombobox').hide().load('<?php echo base_url();?>index.php/dbdHome/magTypeList/').fadeIn('fast');
$('#groupCompanyId').change(function(){

	$('.loadcombobox').fadeOut('fast').load('<?php echo base_url();?>index.php/dbdHome/magTypeList/'+$(this).val()+'').fadeIn('fast');
});
</script>

<center><h2>จัดการ ประเภทธุรกิจ</h2>
  <p>
    <label for="select">เลือกกลุ่มธุรกิจ:</label>
    <select name="groupCompanyId" id="groupCompanyId" class="inputText"  size="6">
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
