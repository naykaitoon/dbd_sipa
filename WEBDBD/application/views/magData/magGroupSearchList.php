<style>
.drag{

	list-style:none;
}

.tdd tr td{
	text-wrap:normal;
	font-size: 12px;
	border:solid 1px #6C6C6C;
}
.tdd{
	margin-left:30px;
	width:95%;
}
</style>
<script>
$('#div1').load('<?php echo base_url();?>index.php/dbdHome/listSearch');
$('.addListSearch').click(function(event){
			 event.preventDefault();
	  var id = $(this).attr('id');
	
	  $('#drag'+id+'').hide();
		    var href = $(this).attr('href');
			$('#div1').load(href);
});
</script>

  <table class="tdd"  border="0" align="center" cellspacing="3" cellpadding="5">
   
      <tr>
   
        <td  width="280" align="left" valign="top" > <?php
 $i=1;
 $col=0;
  foreach($type as $t){ 
  ?> 
<div id="drag<?php echo $i;?>">
<p><?php echo "หมายเลข : ".$t['companyTypeId'].'<br>';?>
<?php echo "ชื่อประเภท : ".substr($t['companyTypeName'],7);?></p>
<p style="margin-right:0;margin-left:280;"><a id="<?php echo $i;?>" href="<?php echo base_url();?>index.php/dbdHome/addListSearch/<?php echo $t['companyTypeId']?>/<?php echo $t['groupCompanyId']?>" class="addListSearch">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<?php echo base_url();?>img/add.png" width="30" /></a></p><hr></div>

  <?php	
  $i++;
    if($col==50){
	
			echo "</td><td  width='280' align='left' valign='top'>";
			$col=0;
	}
	$col++;
  
}
?></td>
    
      </tr>

  </table>


 