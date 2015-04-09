<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Detial</title>
<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 00px;
	margin-bottom: 0px;
}
</style>
</head>

<body>

<table class="tableData"  width="100%" border="0" align="center" cellpadding="8" cellspacing="2">

 <tr>
 <?php
 $col = 0;
  foreach($year as $y){ 
  $col++;?>
      <th width="*" align="center" nowrap="nowrap"><?php echo $y['year'];?>
      <table class="tableData" width="100%" border="0" align="center" cellpadding="8" cellspacing="2">
      <tr>
      <?php if( $col == 1){?>
      <th width="*">ประเภทการเงิน</th>
          <?php }?>
            <th width="*">
            	จำนวน/บาท
            </th>
          </tr>
      <?php foreach($detial as $d){ if($y['year']==$d['year']){?>
      	<tr>
           <tr>
           <?php if( $col == 1){?>
        	<td width="*" style="font-size: 12px">ลูกหนี้การค้าสุทธิ</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['tradeReceivablesNet'],2,'.',',');?></td>
           </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">สินค้าคงเหลือ</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['inventories'],2,'.',',');?></td>
              </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">สินทรัพย์หมุนเวียน</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['assets'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">ที่ดิน อาคารและอุปกรณ์</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['plantAndEquipment'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">สินทรัพย์ไม่หมุนเวียน</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['nonCurrentAssets'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">สินทรัพย์รวม</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['totalAssets'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">หนี้สินหมุนเวียน</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['liabilities'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">หนี้สินไม่หมุนเวียน</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['nonCurrentLiabilities'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">หนี้สินรวม</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['totalLiabilities'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">ส่วนของผู้ถือหุ้น</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['equityShares'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">หนี้สินรวมและส่วนของผู้ถือหุ้น</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['totalLiabilitiesAndShareholdersEquity'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">รายได้หลัก</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['revenue'],2,'.',',');?></td>
               </tr>
                <tr>
                <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">รายได้รวม</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['totalIncome'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">ต้นทุนขาย</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['costOfSales'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">กำไร(ขาดทุน) ขั้นต้น</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['profitLoss'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">ค่าใช้จ่ายในการขายและบริการ</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['costOfSalesAndServices'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">รายจ่ายรวม</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['totalExpenditures'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">ดอกเบี้ยจ่าย</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['interest'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">กำไร(ขาดทุน) ก่อนภาษี</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['profitLossBeforeTax'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">ภาษีเงินได้</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['incomeTax'],2,'.',',');?></td>
               </tr>
            <tr>
            <?php if( $col == 1){?>
            <td width="*" style="font-size: 12px">กำไร(ขาดทุน)สุทธิ</td>
             <?php }?>
            <td width="*" style="font-size: 12px"><?php echo number_format($d['profitLossNet'],2,'.',',');?></td>
          </tr>

         
        </tr>
            <?php }
			}?>
      </table>
      
      </th>
 <?php }?>
  </tr>
</table>
<br>
<br>
</body>
</html>