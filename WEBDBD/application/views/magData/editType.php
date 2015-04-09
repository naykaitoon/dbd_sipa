<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<center><h2>แก้ไข ธุรกิจประเภท <?php	echo $type[0]['companyTypeName']; ?></h2></center>
  <form action="<?php echo base_url();?>index.php/dbdHome/editTypeAction/<?php	echo  $type[0]['companyTypeId']; ?>" method="post">
   <?php foreach($type as $g){ ?> 
<table class="tableData" width="700" border="0" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th width="10%" align="right" valign="middle" nowrap="nowrap">รหัสประเภท</th>
      <td align="left" valign="top" nowrap="nowrap"><?php	echo $g['companyTypeId']; ?></td>
    </tr>
  <tbody>
    <tr>
      <th align="right" valign="top" nowrap="nowrap">ชื่อประเภท</th>
      <td width="71%" align="left" valign="top" nowrap="nowrap"><input name="companyTypeName" type="text"  value="<?php	echo $g['companyTypeName']; ?>" size="70" required></td>
    </tr>

  <tr>
      <th align="right" valign="top" nowrap="nowrap">กลุ่ม </th>
      <td align="left" valign="top" nowrap="nowrap">
      <select name="groupCompanyId">
         <?php foreach($group as $gg){ ?> 
      	<option value="<?php echo $gg['groupCompanyId']?>" <?php if($gg['groupCompanyId']==$g['groupCompanyId']){ echo "selected";}?> ><?php echo $gg['detail']?></option>
        <?php	 }?>
      </select>
      </td>
    </tr>

  <tr>
    <td colspan="2" align="center" valign="top" nowrap="nowrap"><input type="submit" class="buttonHome" name="button" id="button" value="บันทึก"></td>
  </tr>
  </tbody>
    <?php	 }?>
</table>
</form>
<br>
<br>