<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Detial</title>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<style>
#companyTypeId{
	max-width:500px;
	overflow:hidden;
}
</style>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<p>
  <?php foreach($company as $c){?>
</p>
<p>&nbsp; </p>
<form action="<?php echo base_url();?>index.php/dbdHome/editChangeGroupType/<?php echo $c['companyId'];?>" method="post">
  <table class="tableData" width="95%" border="0" align="center" cellpadding="8" cellspacing="2">
 <tr>
      <th width="13%" align="right" nowrap="nowrap">ชื่อ</th>
      <td width="43%"><?php echo $c['companyName'];?></td>
      <td width="44%" align="center">เลือก กลุ่ม / หมวด ที่ต้องการ</td>
  </tr>
 <tr>
      <th width="13%" align="right" nowrap="nowrap">รหัส/กลุ่มปัจุบัน</th>
      <td width="43%"><?php echo $c['groupCompanyId'];?> <br> <?php echo $c['detail'];?></td>
      <td width="44%" align="center">
        <label for="groupCompanyId">กลุ่ม:</label>
        <select name="groupCompanyId" id="groupCompanyId">
        <?php foreach($group as $g){?>
        	<option value="<?php echo $g['groupCompanyId']?>" <?php if($g['groupCompanyId']==$c['groupCompanyId']){ echo "selected";}?>><?php echo $g['detail']?></option>
        <?php }?>
      </select></td>
  </tr>
  <tr>
      <th width="13%" align="right" nowrap="nowrap">รหัส/หมวดปัจุบัน</th>
      <td width="43%"><?php echo $c['companyTypeId'];?> <br> <?php echo $c['companyTypeName'];?></td>
      <td width="44%" align="center">
      <label for="companyTypeId">ประเภท:</label>
      <select name="companyTypeId" id="companyTypeId">
        <?php foreach($type as $t){?>
        	<option value="<?php echo $t['companyTypeId']?>" <?php if($t['companyTypeId']==$c['companyTypeId']){ echo "selected";}?>><?php echo $t['companyTypeName']?></option>
        <?php }?>
      </select></td>
  </tr>
   <tr>
      <th colspan="3" align="center" nowrap="nowrap"><input type="submit" value="บันทึก" class="buttonHome">&nbsp;&nbsp;<input type="button" onClick="window.history.back();" value="ยกเลิก/กลับ" class="buttonHome"></th>
  </tr>
</table>
</form>
<?php }?>
<script type="text/javascript" src="<?php echo base_url();?>js/jquery.js"></script>
<script>
$('#groupCompanyId').change(function(e) {
     
				var href = "<?php echo base_url();?>index.php/dbdHome/loadformOptionTypeSearchId/"+$(this).val()+"";
				 $('#companyTypeId').fadeOut("fast").load(href).fadeIn("fast");
        });
</script>
</body>
</html>