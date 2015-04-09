
<style>
select{
	font-size:12px;
}
</style>
<center>
  <h2>ค้นหาข้อมูลธุรกิจ</h2></center>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td width="70%">
      
      <table class="tableData" width="100%" border="0" align="center" cellpadding="8" cellspacing="2">
             <tr>
       <th colspan="2" align="center" nowrap="nowrap">ค้นหาแบบเงื่อนไง</th>
     </tr>
    <tr>
      <th width="13%" nowrap="nowrap">หมวดธุรกิจ&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap">
      <select name="group" id="group" class="inputText"  required>
      		<option value="">เลือกหมวดธุรกิจ</option>
	<?php foreach($group as $g){ ?>
    <option value="<?php echo $g['groupCompanyId'];?>"><?php echo $g['detail'];?></option>
	<?php }?>
      </select></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">ประเภทธุรกิจ&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap">
      <select name="type" id="type" class="inputText"  >
      	<option value="">กรุณาเลือกหมวดธุรกิจ</option>
      </select></td>
    </tr>
       <tr>
      <th width="13%" nowrap="nowrap">ภาค&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap">
     <select name="sector" id="sector" class="inputText"  required>
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
      <th width="13%" nowrap="nowrap">จังหวัด&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap"><select name="p" id="p" class="inputText"  required>
       <option value="">กรุณาเลือกภาค</option>
      
      </select></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">อำเภอ</th>
      <td width="87%" nowrap="nowrap"><select name="d" id="d" class="inputText"  required>
       <option value="-" >ไม่เลือก</option>
      </select></td>
    </tr>
        <tr>
      <th width="13%" nowrap="nowrap">ตำบล</th>
      <td width="87%" nowrap="nowrap"><select name="c" id="c" class="inputText" required>
      <option value="-" >ไม่เลือก</option>
      </select></td>
    </tr>
     <tr>
      <th width="13%" nowrap="nowrap">ข้อมูลปี&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap">      <?php
	  $minYear = 2555;
	  $maxYear = date("Y")+543;
	  
	  $sumYear =  $maxYear - $minYear;
	    ?><select name="y" id="y" class="inputText" >
	<?php for($loopYear=0;$loopYear<$sumYear;$loopYear++){?>
    <option value="<?php  echo  $minYear+$loopYear;?>"><?php echo $minYear+$loopYear;?></option>
	<?php }?>
      </select></td>
    </tr>
     <tr>
       <td colspan="2" align="center" nowrap="nowrap"><button id="searchBt" class="buttonHome" style="height:45px;"><img src="<?php echo base_url();?>img/searchBt.png" width="20" /> ค้นหา</button></td>
     </tr>
</table>

</td>
      <td width="30%" align="center" valign="top"><table class="tableData" width="100%" border="0" align="center" cellpadding="8" cellspacing="2">
        <tr>
          <th colspan="2" nowrap="nowrap">ค้นหาแบบง่าย</th>
          </tr>
        <tr>
          <th width="13%" nowrap="nowrap">คำค้น&nbsp;<font color="RED">*</font></th>
          <td width="87%" nowrap="nowrap"><input name="searchText" type="text" class="inputText"  id="searchText" size="30" placeholder="คำที่ต้องการค้นหา"></td>
        </tr>
       <tr>
      <th width="13%" nowrap="nowrap">ประเภทนิติบุคคล&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap"><select name="corporate" id="corporate" class="inputText" >
	<?php foreach($corporate as $c){?>
    <option value="<?php  echo  $c['titleCompany'];?>"><?php echo  $c['titleCompany'];?></option>
	<?php }?>
      </select></td>
    </tr>
     <tr>
      <th width="13%" nowrap="nowrap">ข้อมูลปี&nbsp;<font color="RED">*</font></th>
      <td width="87%" nowrap="nowrap">      <?php
	  $minYear = 2555;
	  $maxYear = date("Y")+543;
	  
	  $sumYear =  $maxYear - $minYear;
	    ?><select name="yearText" id="yearText" class="inputText" >
	<?php for($loopYear=0;$loopYear<$sumYear;$loopYear++){?>
    <option value="<?php  echo  $minYear+$loopYear;?>"><?php echo $minYear+$loopYear;?></option>
	<?php }?>
      </select></td>
    </tr>
        <tr>
          <td colspan="2" align="center" nowrap="nowrap"><button id="searchBt2" class="buttonHome" style="height:45px;"><img src="<?php echo base_url();?>img/searchBt.png" width="20" /> ค้นหา</button></td>
        </tr>
      </table></td>
    </tr>
  </tbody>
</table>

<div id="resultSearch">
</div>
<br>
<br>
<script type="text/javascript">
$('#group').change(function(e) {
     
				var href = "<?php echo base_url();?>index.php/dbdHome/loadformOptionTypeSearchId/"+$(this).val()+"";
				 $('#type').fadeOut("fast").load(href).fadeIn("fast");
        });
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
$('#searchBt').click(function(){

	var href = "<?php echo base_url();?>index.php/dbdHome/searchResult/"+$('#p').val()+"/"+$('#d').val()+"/"+$('#c').val()+"/"+$('#type').val()+"/"+$('#y').val()+"/1";

$( "html" ).addClass( "loading" );

	$('#resultSearch').load(href);	 
});
	$("#searchBt2").click(function(){
		if($('#searchText').val()!=''){
				$( "html" ).addClass( "loading" );
			  $.post("<?php echo base_url();?>index.php/dbdHome/searchResultText",
			  {
				searchText:$("#searchText").val(),
				corporate:$("#corporate").val(),
				yearText:$("#yearText").val()
			  },
			  function(data){
			
					$('#resultSearch').html(data);
			
			  });
		}else{
			alert("กรุณาใส่คำค้นหา");
		}
			});
</script>

<script>
$( "html" ).removeClass( "loading" );
</script>