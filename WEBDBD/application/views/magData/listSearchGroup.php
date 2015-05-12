<script>
 $('.searchGroup').click(function(event) {
			      event.preventDefault();
				 var href = $(this).attr('href');
				$('html').addClass('loading');
	
				 $('.loadcombobox').load(href);
	
        });
	$('.detialSearchGroup').fancybox({
		maxWidth	: 1500,
		maxHeight	: 1200,
		fitToView	: false,
		width		: '90%',
		height		: '90%',
		autoSize	: false,
		closeClick	: false,
		openEffect	: 'none',
		closeEffect	: 'none',
		padding     : 0
	
});
</script>

<center><h2>ค้นหาแบบชุด</h2>
  <table class="tableData" width="50%" border="0" cellspacing="0" cellpadding="3">
    <tbody>
      <tr>
        <th width="14%" nowrap="nowrap">ลำดับ</th>
        <th width="60%" nowrap="nowrap">ชื่อชุดการค้นหา</th>
       
        <th width="12%" nowrap="nowrap">รายละเอียด</th>
        <th width="7%" nowrap="nowrap">ลบ</th>
         <th width="7%" nowrap="nowrap">ค้นหา</th>
      </tr>
      <?php
	  $i=1;
	   foreach($list as $a){?>
      <tr>
        <td align="center"><?php echo $i;$i++;?></td>
        <td align="left"><?php echo $a['searchName'];?></td>

       <td align="center"><a class="detialSearchGroup" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/searchGroupDetail/<?php echo $a['searchGroupProfiId'];?>"><img src="<?php echo base_url();?>img/detail.png" width="30" height="30"/></a></td>
       <td align="center"><a class="deleteGroupSeaech" data-fancybox-type="iframe" href="<?php echo base_url();?>index.php/dbdHome/deleteSearchGroup/<?php echo $a['searchGroupProfiId'];?>"><img src="<?php echo base_url();?>img/delete.png" width="30" height="30"/></a></td>
               <td align="center"><a class="searchGroup" href="<?php echo base_url();?>index.php/dbdHome/searchByGroup/<?php echo $a['searchGroupProfiId'];?>"><img src="<?php echo base_url();?>img/search.png" width="30" height="30"/></a></td>
      </tr>
      <?php }?>
    </tbody>
  </table>

</center>

<div class="loadcombobox">

</div>
<br>
<br>
<script>

$( "html" ).removeClass( "loading" );

</script>