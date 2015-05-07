<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<center><h2>แก้ไข ธุรกิจประเภท <?php	echo $type[0]['companyTypeName']; ?></h2></center>
  <form action="<?php echo base_url();?>index.php/dbdHome/editTypeAction/<?php	echo  $type[0]['companyTypeId']; ?>" method="post">
   <?php foreach($type as $g){ ?> 
<table class="tableData" width="90%" border="0" align="center" cellpadding="8" cellspacing="1">
    <tr>
      <th colspan="2" align="center" valign="middle" nowrap="nowrap">รหัสประเภท : 
      <?php	echo $g['companyTypeId']; ?></th>
    </tr>
  <tbody>
    <tr>
      <th width="10%" align="right" valign="middle" nowrap="nowrap">ชื่อประเภท</th>
      <td width="71%" align="left" valign="middle" nowrap="nowrap"><input name="companyTypeName" type="text"  value="<?php	echo $g['companyTypeName']; ?>" size="70" class="inputText" required></td>
    </tr>

  <tr>
      <th align="right" valign="middle" nowrap="nowrap">กลุ่ม </th>
      <td align="left" valign="middle" nowrap="nowrap">
      <select name="groupCompanyId" class="inputText">
         <?php foreach($group as $gg){ ?> 
      	<option value="<?php echo $gg['groupCompanyId']?>" <?php if($gg['groupCompanyId']==$g['groupCompanyId']){ echo "selected";}?> ><?php echo $gg['detail']?></option>
        <?php	 }?>
      </select>
      </td>
    </tr>

  <tr>
    <td colspan="2" align="center" valign="middle" nowrap="nowrap"><input type="submit" class="buttonHome" name="button" id="button" value="บันทึก"></td>
  </tr>
  </tbody>
    <?php	 }?>
</table>
</form>
<br>
<br>