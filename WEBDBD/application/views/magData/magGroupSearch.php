<script>
$('.loadcombobox').hide().load('<?php echo base_url();?>index.php/dbdHome/magGroupSearchList/').fadeIn('fast');
$('#groupCompanyId').change(function(){
	$('.loadcombobox').fadeOut('fast').load('<?php echo base_url();?>index.php/dbdHome/magGroupSearchList/'+$(this).val()+'').fadeIn('fast');

});
</script>
<script type="text/javascript">
$('#sector').change(function(e) {
				var href = "<?php echo base_url();?>index.php/dbdHome/loadformOptionProvinceSearchId/"+$(this).val()+"";
				$('#d').html("<option value='-'>ไม่เลือก</option>");
				$('#c').html("<option value='-'>ไม่เลือก</option>");
				 $('#p').fadeOut("fast").load(href).fadeIn("fast");
  });
$('#p').change(function(e) {
				var href = "<?php echo base_url();?>index.php/dbdHome/loadformOptionDistrictIdSearchId/"+$(this).val()+"";
				$('#c').html("<option value='-'>ไม่เลือก</option>");
				 $('#d').fadeOut("fast").load(href).fadeIn("fast");
				 
  });
$('#d').change(function(e) {
				var href = "<?php echo base_url();?>index.php/dbdHome/loadformOptionCantonIdSearchId/"+$(this).val()+"";
				 $('#c').fadeOut("fast").load(href).fadeIn("fast");	 
  });

</script>
<script type="text/javascript">

	$("#sentData").click(function(){
		if($("#searchName").val()!=""&&$("#p").val()!="-"){
			  $.post("<?php echo base_url();?>index.php/dbdHome/addGroupList",
			  {
				searchName:$("#searchName").val(),
				provinceId:$("#p").val(),
				districtId:$("#d").val(),
				cantonId:$("#c").val(),
				year:$("#y").val()
			  },
			  function(data){
				  if(data!=0&&data!=1){
				window.location.href='<?php echo base_url();?>index.php/dbdHome/page/listSearchGroup';
				  }else if(data==0){
				  	alert("กรุณาเลือกกลุ่มในการค้นหา");
				  }else if(data == 1){
					  alert("กรุณาเลือกจังหวัด");
				  }
			  });
		}else{
			alert("กรุณาเลือกข้อมูลให้ครบถ้วน");
		}
			});



</script>
<style>
.inputText {
	width:90%;
}
#div1{
	margin-left:72%;
	bottom:0px;
	position:fixed;
	z-index:9999;
	box-shadow:2px 0px 0px #646464;
	float:none;
	min-width:0;
	height:*;
	max-height:300px;
	overflow-y: scroll; scrollbar-arrow-color:blue; scrollbar-face-color: #e7e7e7; scrollbar-3dlight-color: #a0a0a0; scrollbar-darkshadow-color:#888888;
}
</style>
<div id="div1" ></div>
<center><h2>จัดการ ประเภทธุรกิจ</h2>
  <p>&nbsp;
  </p>
  <table width="95%" border="0" cellspacing="0" cellpadding="0">
    <tbody>
      <tr>
        <td width="50%">     
        <table class="tableData" width="100%" border="0" align="center" cellpadding="8" cellspacing="2">
         <tr>
      <th width="13%" nowrap="nowrap">ชื่อการค้นหา</th>
      <td width="87%" nowrap="nowrap"><input type="text" name="searchName" id="searchName" class="inputText" required></td>
    </tr>
    <tr>
      <th width="13%" nowrap="nowrap">ภาค</th>
      <td width="87%" nowrap="nowrap">
     <select  class="inputText" name="sector" id="sector" required>
    <option value="">เลือกภาค</option>
    <option value="1">ภาคเหนือ</option>
    <option value="2">ภาคกลาง</option>
	<option value="3">ภาคตะวันออกเฉียงเหนือ</option>
	<option value="4">ภาคตะวันออก</option>
	<option value="5">ภาคตะวันตก</option>
	<option value="6">ภาคใต้</option>
      </select></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">จังหวัด</th>
      <td width="87%" nowrap="nowrap"><select  class="inputText" name="p" id="p" required>
       <option value="">กรุณาเลือกภาค</option>
      
      </select></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">อำเภอ</th>
      <td width="87%" nowrap="nowrap"><select  class="inputText" name="d" id="d" required>
       <option value="-" >ไม่เลือก</option>
      </select></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">ตำบล</th>
      <td width="87%" nowrap="nowrap"><select  class="inputText" name="c" id="c" required>
      <option value="-" >ไม่เลือก</option>
      </select></td>
    </tr>
     <tr>
      <th width="13%" nowrap="nowrap">ข้อมูลปี</th>
      <td width="87%" nowrap="nowrap">      <?php
	  $minYear = 2555;
	  $maxYear = date("Y")+543;
	  
	  $sumYear =  $maxYear - $minYear;
	    ?><select  class="inputText" name="y" id="y">
	<?php for($loopYear=0;$loopYear<$sumYear;$loopYear++){?>
    <option value="<?php  echo  $minYear+$loopYear;?>"><?php echo $minYear+$loopYear;?></option>
	<?php }?>
      </select></td>
    </tr>
     <tr>
       <th colspan="2" nowrap="nowrap"><input type="button" name="button" id="sentData" class="buttonHome" value="ยืนยัน/บันทึก"></th>
       </tr>
     </table>
    </td>
        <td width="50%" align="center" valign="top"> 
        
        <p>
    <label for="select">เลือกกลุ่มธุรกิจ</label>
    <select  name="groupCompanyId" id="groupCompanyId" class="inputText" size="15" autofocus>
      <?php foreach($group as $g){ ?> 
      <option value="<?php echo $g['groupCompanyId'];?>" <?php if($g['groupCompanyId']==$group[0]['groupCompanyId']){ ?> selected <?php }?>><?php echo $g['detail'];?></option>
      <?php	 } ?>
    </select>
    
  </p>
</td>
      </tr>
    </tbody>
  </table>
 
</center>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <td><div class="dragBox">
<div class="loadcombobox">

</div>
  </div></td>
      <td align="center" valign="top">
</td>
    </tr>
  </tbody>
</table>

<br>
<br>
<script>
$( "html" ).removeClass( "loading" );
</script>
