<p align="center">ผลลัพทั้งหมด = <?php
if($allResultCount){
 echo $allResultCount-1;?> รายการ | จำนวนหน้าทั้งหมด = <?php echo ceil( ($allResultCount-1)/15 );?> หน้า
 <?php }else{
	 echo "ไม่พบผลการค้นหา";
 }?>
 </p>
<div class="ajax_paging" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<?php echo $this->pagination->create_links(); ?></div>
<?php 
function imgSelect($links){
	if(substr($links, -4)=="DESC"){
			$imgFile = "desc.png";
		} else{
			$imgFile = "asc.png";
		}
	return $imgFile;
}

?>
<table width="90%" border="0" align="center" cellpadding="5" cellspacing="0" class="tableData">
<tr>
      <th width="4%" nowrap="nowrap">ลำดับ</th>
      <th width="10%" nowrap="nowrap">ประเภทนิติบุคคล</th>
      <th width="17%" nowrap="nowrap">ชื่อนิติบุคคล</th>
      <th width="20%" nowrap="nowrap">ผู้บริหาร</th>
      <th width="9%" nowrap="nowrap">วันที่จดทะเบียน</th>
      <th width="7%" nowrap="nowrap"><a class="order" href="<?php echo base_url().$link1;?>">รายได้&nbsp;<img src="<?php echo base_url()."img/".imgSelect($link1); ?>" width="20"/></a></th>
      <th width="6%" nowrap="nowrap"><a class="order" href="<?php echo base_url().$link2;?>">กำไร&nbsp;<img src="<?php echo base_url()."img/".imgSelect($link2); ?>" width="20"/></a></th>
      <th width="12%" nowrap="nowrap">สถานะนิติบุคล</th>
      <th width="7%" nowrap="nowrap">รายละเอียด</th>
      <th width="8%" nowrap="nowrap">ข้อมูลการเงิน</th>
</tr>
  <tbody>
  <?php
  $i=1;
  if($searchResult){
   foreach($searchResult as $sr){?>
    <tr>
      <td align="center" style="font-size: 14px"><?php echo $i+$page-1; $i++;?></td>
      <td align="center" style="font-size: 12px"><?php echo $sr['titleCompany'];?></td>
      <td style="font-size: 12px"><?php echo $sr['companyName'];?></td>
      <td style="font-size: 12px"><?php echo $sr['syndicate'];?></td>
      <td align="center" style="font-size: 12px"><?php echo $sr['dateRegister'];?></td>
      <td align="right" style="font-size: 12px"><?php echo number_format($sr['monnySum'],2,'.',',');?></td>
      <td align="right" style="font-size: 12px"><?php echo number_format($sr['monnyRecive'],2,'.',',');?></td>
      <td align="center" style="font-size: 12px"><?php echo $sr['status'];?></td>
      <td align="center" valign="middle" style="font-size: 14px"><a class="detial" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/getDetial/<?php echo $sr['companyId'];?>"><img src="<?php echo base_url();?>img/detail.png" width="30" height="30"/></a></td>
            <td align="center" valign="middle" style="font-size: 14px"><a class="budgetandfinace" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/budgetandfinace/<?php echo $sr['companyId'];?>"><img src="<?php echo base_url();?>img/money.png" width="30" height="30"/></a></td>
    </tr>
    <?php }
  }else{
  	?>
    <tr>
      <td colspan="10" align="center" style="font-size: 19px"> -------  ไม่พบข้อมูล  -------</td>
    </tr>
    <?php
  }
	?>
<tr>
  	<td colspan="10" align="center"><div class="ajax_paging"><?php echo $this->pagination->create_links(); ?></div></td>
  </tr>
  </tbody>
</table>
<br>
<script>
  $(function() {
    applyPagination();
    function applyPagination() {
      $(".ajax_paging a").click(function(event) {
		 $( "html" ).addClass( "loading" );
        var url = $(this).attr("href");
        $.ajax({
          type: "POST",
          data: "$page=1",
          url: url,
          success: function(msg) {
			 event.preventDefault();
            $("#resultSearch").load(url);
            applyPagination();
          }
        });
        return false;
      });
    }
  });
</script>
<script>
$(".order").click(function(event){
	 event.preventDefault();
	 var href = $(this).attr('href');
	$( "html" ).addClass( "loading" );
	 $('#resultSearch').load(href);
});
$( "html" ).removeClass( "loading" );
</script>