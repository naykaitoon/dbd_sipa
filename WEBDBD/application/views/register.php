<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="<?php echo base_url();?>js/jquery.js"></script>
<script>
	 $(document).ready(function(){
	 	$("#registerBt").click(function(){
			if($("#username").val()&&$("#password").val()&&$("#memName").val()&&$("#memLastName").val()&&$("#address").val()&&$("#email").val()&&$("#tel").val()){
			 $.post("<?php echo base_url();?>index.php/home/checkUserName",
			  {
				username:$("#username").val()
				 },
			  function(result){
		if(result!=0){
			if($("#password").val()==$("#passwordCheck").val()){
			  $.post("<?php echo base_url();?>index.php/home/registerAction",
			  {
				username:$("#username").val(),
				password:$("#password").val(),
				memName:$("#memName").val(),
				memLastName:$("#memLastName").val(),
				address:$("#address").val(),
				email:$("#email").val(),
				tel:$("#tel").val()
			  },
			  function(data){
				  if(data==1){
					alert("ลงทะเบียนสำเร็จ สามารถเข้าใช้งานได้เลย");
				  }else{
					 alert("ลงทะเบียนล้มเหลวกรุณาลงทะเบียนใหม่");
				  }
				  	parent.$.fancybox.close();
			  });
				}else{
					alert("password ไม่ตรงกัน");
				}
		}else{
			alert("Username ไม่สามารถใช้ได้");
		}
			});
			}else{
				alert("กรุณากรอกข้อมูลให้ครบถ้วน");
			}
			  });
	 });
</script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: -10px;
	margin-right: 0px;
	margin-bottom: 0px;
	text-align: center;
}
.inputTextRegis {
 padding: 5px;
  border: solid 1px #dcdcdc;
  transition: box-shadow 0.3s, border 0.3s;
}
.inputTextRegis:focus {
   border: solid 1px #707070;
  box-shadow: 0 0 5px 1px #969696;
}
</style>
<table width="90%" border="0" align="center" cellpadding="5" cellspacing="0" class="tableData">
  <tbody>
    <tr>
      <th colspan="2" align="center" valign="middle" nowrap="nowrap">ลงทะเบียน</th>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">ชื่อเข้าใช้งานระบบ : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="username" id="username" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">รหัสผ่าน : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="password" name="password" id="password" class="inputTextRegis"  required>
      &nbsp;ยืนยันรหัสผ่าน 
      <input type="password" name="passwordCheck" id="passwordCheck" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">ชื่อ&nbsp;: </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="memName" id="memName" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">นามสกุล&nbsp;: </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="memLastName" id="memLastName" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">ที่อยู่ : </td>
      <td align="left" valign="middle" nowrap="nowrap"><textarea name="address" cols="40" rows="3" id="address" class="inputTextRegis"  required></textarea></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">E-mail : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="email" name="email" id="email" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td align="right" valign="middle" nowrap="nowrap">เบอร์โทร : </td>
      <td align="left" valign="middle" nowrap="nowrap"><input type="text" name="tel" id="tel" class="inputTextRegis"  required></td>
    </tr>
    <tr>
      <td colspan="2" align="center" valign="middle" nowrap="nowrap"><input type="button" name="registerBt" id="registerBt" value="ลงทะเบียน" class="buttonHome"></td>
    </tr>
  </tbody>
</table>