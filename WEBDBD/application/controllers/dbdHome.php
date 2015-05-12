<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class DbdHome extends CI_Controller {
 function __construct(){
	   parent::__construct();
	   $this->checkLogin();
    }
	function index()
	{
		$data['script'] = "$('.content').load('".base_url()."index.php/dbdHome/loadFormSearch');";
		$data['dataLogin'] = $this->session->userdata('dataLogin');
		$data['dataLogin'] = $data['dataLogin'][0];
		$this->load->view('homePage',$data);

	}
	function page($pageC){
		
		$data['script'] = "$('.content').load('".base_url()."index.php/dbdHome/".$pageC."');";
		$data['dataLogin'] = $this->session->userdata('dataLogin');
		$data['dataLogin'] = $data['dataLogin'][0];
		$this->load->view('homePage',$data);
	}
	function checkLogin(){
		if($this->session->userdata('dataLogin')==NULL){
			echo"<script>alert('กรุณาล็อกอินก่อนใช้งาน ทำการล็อกอินใหม่');</script>";
			$this->session->unset_userdata('dataLogin');
			echo"<script langquage='javascript'>window.location='".base_url()."index.php/home';</script>";
			
		}
	}
	function loadFormSearch(){
		$data['corporate'] = $this->getCorporate();
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$this->load->view('home/home',$data);
	}
	function loadformOptionTypeSearchId($id){
		$typeData = $this->Search->getDataSelecter($id,'groupCompanyId','companytype');
		foreach($typeData as $t){
			echo '<option value="'.$t['companyTypeId'].'">'.$t['companyTypeName'].'</option>';
		}
	}
	function loadformOptionProvinceSearchId($id){
		$provinceData = $this->Search->getDataSelecter($id,'provinceSector','province');
		echo '<option value="0">เลือกจังหวัด</option>';
		foreach($provinceData as $p){
			echo '<option value="'.$p['provinceId'].'">'.$p['provinceName'].'</option>';
		}
	}
	
	function loadformOptionDistrictIdSearchId($id){
		$disticData = $this->Search->getDataSelecter($id,'provinceId','district');
		echo '<option value="-" selected>ไม่เลือก</option>';
		foreach($disticData as $d){
			echo '<option value="'.$d['districtId'].'">'.$d['districtName'].'</option>';
		}
	}
	
	function loadformOptionCantonIdSearchId($id){
		$disticData = $this->Search->getDataSelecter($id,'districtId','canton');
			echo '<option value="-" selected>ไม่เลือก</option>';
		foreach($disticData as $d){
			echo '<option value="'.$d['cantonId'].'">'.$d['cantonName'].'</option>';
		}
	}
	
	
	
	function searchResult($provinceId=NULL,$districtId=NULL,$cantonId=NULL,$companyTypeId=NULL,$year=NULL,$order=1,$orderBy="DESC",$page = 1){
		$data['provinceId'] = $provinceId;
		$data['districtId'] = $districtId;
		$data['cantonId'] = $cantonId;
		$data['companyTypeId'] = $companyTypeId;
		$data['year'] = $year;
		
		if($order==1){
			$data['orderBy'] = 'budgetandfinace.totalIncome';
		}
		else if($order==2){
			$data['orderBy'] = 'budgetandfinace.profitLoss';
		}else{
			$data['orderBy'] = 'budgetandfinace.totalIncome';
		}
		
		$data['order'] = $orderBy;
		
		$data['allResultCount']=$this->countAllResult($data);
		$valiError = 0;
		if($data['provinceId']==0||$data['provinceId']==NULL){
			$valiError = 1;
		}
		
		else if($data['districtId']||$data['districtId']){
			$valiError = 2;
		
		}
		
		else if($data['cantonId']||$data['cantonId']){
			$valiError = 3;
		
		}
		
		else if($data['companyTypeId']||$data['companyTypeId']){
			$valiError = 4;
		
		}else{
		$valiError = 0;
		}
		
		
		if($valiError>0&&$valiError!=2&&$valiError!=3){
			echo "<script>
			$( 'html' ).removeClass( 'loading' );
			alert('กรุณาเลือกข้อมุลที่ค้นหาให้ครบถ้วน');
			</script>";
		}else{
			$data['page']=$page;
			$data['url']="dbdHome/searchResult/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/".$order."/".$orderBy;
			
		if($order==1&&$orderBy=="ASC"){
			$data['link1']="index.php/dbdHome/searchResult/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/1/DESC";
		}else{
			$data['link1']="index.php/dbdHome/searchResult/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/1/ASC";
		}
		
		if($order==2&&$orderBy=="ASC"){
			$data['link2']="index.php/dbdHome/searchResult/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/2/DESC";
		}else{
			$data['link2']="index.php/dbdHome/searchResult/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/2/ASC";
		}

		$result = $this->Search->getCompany($data);
		$data['searchResult'] =$result;
		

		$this->load->view('home/searchResult',$data);
		}
	}
	
function searchResultText($order=1,$orderBy="DESC",$page = 1){

		$data['text']=$this->input->post('searchText');
		$data['corporate']=$this->input->post('corporate');
		$year=$this->input->post('yearText');
		$data['year']=$year;
		$data['page']=$page;

		$data['url']="dbdHome/searchResultText/".$order."/".$orderBy;

		if(!$data['text']){
			 
			 $data =$this->session->userdata('searchText');
			 $data['page'] = $page;
			 $year = $data['year'];
			
		}else{
			$this->session->set_userdata('searchText',$data);
		}
		if($order==1){
			$data['orderBy'] = 'รายได้รวม';
		}
		else if($order==2){
			$data['orderBy'] = 'กำไร(ขาดทุน)สุทธิ';
		}else{
			$data['orderBy'] = 'รายได้รวม';
		}
		if($order==1&&$orderBy=="ASC"){
			$data['link1']="index.php/dbdHome/searchResultText/1/DESC";
		}else{
			$data['link1']="index.php/dbdHome/searchResultText/1/ASC";
		}
		
		if($order==2&&$orderBy=="ASC"){
			$data['link2']="index.php/dbdHome/searchResultText/2/DESC";
		}else{
			$data['link2']="index.php/dbdHome/searchResultText/2/ASC";
		}
		$data['allResultCount']=$this->countAllResultText($data);
		$result = $this->Search->getCompanyByText($data,$orderBy);
		$data['searchResult'] =$result;
		

		$this->load->view('home/searchResult',$data);
		
	}
		function countAllResultText($data){

		$result = $this->Search->countAllResultText($data);
		return $result;
	}
	function countAllResult($data){

		$result = $this->Search->countAllResultSearch($data);
		return $result;
	}
	function formeditGroup($id){
	    $data['group']=$this->GroupAndType->getDataGroupPK($id);
		$this->load->view('magData/editGuoup',$data);
	}
	
	function formeditGroupAction($id){
		$detail = $this->input->post('detail');
		$data = compact('detail');
	    $this->GroupAndType->editGroup($id,$data);
		echo "<script>parent.$.fancybox.close();</script>";
		
	}
	function magGuoup(){
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$this->load->view('magData/magGuoup',$data);

	}
	function magType(){
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$this->load->view('magData/magType',$data);

	}
	
	function magTypeList($id="A"){
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$data['type']=$this->GroupAndType->getAllDataTypeByGroup($id);
		$this->load->view('magData/magTypeList',$data);

	}
	
	function formeditType($id){
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$data['type'] = $this->GroupAndType->getDataTypePK($id);
		$this->load->view('magData/editType',$data);
	}
	
	function editTypeAction($id){
		$companyTypeId = $id;
		$companyTypeName = $this->input->post('companyTypeName');
		$groupCompanyId = $this->input->post('groupCompanyId');
		$data = compact('companyTypeId','companyTypeName','groupCompanyId');
		$this->GroupAndType->editData($id,'companyTypeId','companytype',$data);
		echo "<script>parent.$.fancybox.close();</script>";
	}
	
	
	function deleteType($id){
			echo "<br><center><font color='RED'>คุณต้องการลบข้อมูลหรือไม่</font></center><br>";
		echo "<center><a href='".base_url()."index.php/dbdHome/deletypeAction/".$id."'><button>ใช่</button></a>&nbsp;&nbsp;<button onClick='parent.$.fancybox.close();'>ยกเลิก</botton></center>";
	}
	
	function deleteGroup($id){
		echo "<br><center><font color='RED'>คุณต้องการลบข้อมูลหรือไม่</font></center><br>";
		echo "<center><a href='".base_url()."index.php/dbdHome/deleteGroupAction/".$id."'><button>ใช่</button></a>&nbsp;&nbsp;<button onClick='parent.$.fancybox.close();'>ยกเลิก</botton></center>";
	}
	
	function deleteGroupAction($id){
		$data = $this->GroupAndType->getAllDataTypeByGroup($id);
		if($data){
			echo "<br><center><font color='RED'>ERROR ไม่สามารถลบข้อมูลได้เนื่องจากมีข้อมูลที่อยู่ในกลุ่มนี้อยู่</font></center><br>";
			echo "<center><button onClick='parent.$.fancybox.close();'>ปิด</botton></center>";
		}else{
		$this->GroupAndType->deleteData($id,"groupCompanyId","groupcompany");
		echo "<script>parent.$.fancybox.close();</script>";
		}
		
	}
	
	function deletypeAction($id){
		$this->GroupAndType->deleteData($id,"companyTypeId","companytype");
		echo "<script>parent.$.fancybox.close();</script>";
	}
	
	function magGroupSearch(){
		
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$this->load->view('magData/magGroupSearch',$data);
	}
	
	function magGroupSearchList($id="A"){
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$data['type']=$this->checkAddList($id);
	

		$this->load->view('magData/magGroupSearchList',$data);

	}
	

	function magGroupSearchListText($id="A",$text=""){

		$data['type']=$this->GroupAndType->getAllDataTypeByGroupText($id,$text);
		$this->load->view('magData/magGroupSearchList',$data);

	}
	function listSearch(){
		$list['lists'] = $this->session->userdata('listSearch');
		$this->load->view('magData/addListSearch',$list);
	}
	function addListSearch($id,$gid){
			
			$list = $this->session->userdata('listSearch');
			$check=0;
			for($i=0;$i<count($list);$i++){
				if($list[$i]['id']==$id){
					$check = 1;
				}
			}
	if($check==0){
			if($list){
				$data = $list;
				$data[count($list)]['id']=$id;
				$data[count($list)]['g']=$gid;
			}else{
				$data[0]['id']=$id;
				$data[0]['g']=$gid;

			}
				$this->session->set_userdata('listSearch',$data);
	}
				$list['lists'] = $this->session->userdata('listSearch');
		
			$this->load->view('magData/addListSearch',$list);
	}
	
	function checkAddList($id){
		$data=$this->GroupAndType->getAllDataTypeByGroup($id);
		$list = $this->session->userdata('listSearch');
		if($list){
			
	
			for($ii=0;$ii<count($data);$ii++){
				for($i=0;$i<count($list);$i++){
	
					if($list[$i]['id']==$data[$ii]['companyTypeId']&&$list[$i]['g']==$data[$ii]['groupCompanyId']){
						
						unset($data[$ii]);
							$ii++;
					}
					
				}
			
			}
			
		}
		return $data;
	}
	
	function delListSearch($id){
		$list = $this->session->userdata('listSearch');

		unset($list[$id]);
		sort($list);
		$this->session->set_userdata('listSearch',$list);
		$list['lists'] = $this->session->userdata('listSearch');
			
		$this->load->view('magData/addListSearch',$list);
	}
	
	function listSearchGroup(){
		$data['list']=$this->Search->listSearchGroup();
		$this->load->view('magData/listSearchGroup',$data);
	}
	
	function searchByGroup($id,$page=0){
		$getSearchLog = $this->Search->searchGroup($id);
		$allResult = array();

		$sentdata['allResultCount']=0;
		foreach($getSearchLog as $rLog){
		$search['provinceId'] = $rLog['provinceId'];
		if($rLog['districtId']==00000){
			$districtId = "-";
		}else{
			$districtId = $rLog['districtId'];
		}
		$search['districtId'] = $districtId;
		if($rLog['cantonId']==00000){
			$cantonId = "-";
		}else{
			$cantonId = $rLog['cantonId'];
		}
		$search['cantonId'] = $cantonId;
		$search['companyTypeId'] = $rLog['companyTypeId'];
		$search['year'] = $rLog['year'];
		$year = $search['year'];
		$result = $this->Search->getCompanyIdAllGroup($search);
			
			foreach($result as $r){
				array_push($r,$rLog['year']);
				array_push($allResult,$r);
		
			}
		}
	
		$sentdata['allResultCount'] = count($allResult)+1;

		$realResult = $this->Search->getCompanyAllGroup($allResult,$page,"dbdHome/searchByGroup/".$id,$year);
		

		$sentdata['searchResult'] = $realResult;
		$sentdata['page'] = $page+1;
		$this->load->view('magData/searchResultGroup',$sentdata);
	}
	
	function addGroupList(){
		$searchName = $this->input->post('searchName');
		$provinceId = $this->input->post('provinceId');
		$districtId = $this->input->post('districtId');
		$cantonId = $this->input->post('cantonId');
		$year = $this->input->post('year');

	
		$list['lists'] = $this->session->userdata('listSearch');
		if($provinceId!="00000"){
				if($list['lists']){

				$loginData = $this->session->userdata('dataLogin');
				
				$memId = $loginData[0]['memId'];
				
				$dataAdd1 = compact('searchName','memId');
				
				$searchGroupProfiId = $this->Search->addGroup($dataAdd1);
				
				foreach($list['lists'] as $l){
					$companyTypeId = $l['id'];
					$dataAdd2 = compact('companyTypeId','provinceId','districtId','cantonId','cantonId','year','searchGroupProfiId');
					$this->Search->addGroupSub($dataAdd2);
				}
				$this->session->unset_userdata('listSearch');
				$data['list']=$this->Search->listSearchGroup();
		
				echo '<script>
		$( "html" ).removeClass( "loading" );
		</script>';
				$this->load->view('magData/listSearchGroup',$data);
				}else{
					echo 0;
				}
		}else{
			echo 1;
		}
		
	}
	
	
	function getDetial($id){
		$data['detial'] = $this->Search->getDataSelecterJoinDetial($id);
		$this->load->view('magData/detialCompany',$data);
	}
	
	function budgetandfinace($id){
		$data['detial'] = $this->Search->getDataSelecter($id,'companyId','budgetandfinace');
		$data['year'] = $this->Search->getGroupYear($id,'companyId','budgetandfinace');
		$this->load->view('magData/budgetandfinace',$data);
	}
	
	function getDetialEdit($id){
		$data['detial'] = $this->Search->getDataSelecterJoinDetial($id);
		$this->load->view('magData/detialCompanyEdit',$data);
	}
	function changeGroupType($id){
		$data['company'] = $this->Search->getDataToChange($id);
		$data['group'] = $this->GroupAndType->getAllDataGroup();
		$data['type'] = $this->GroupAndType->getAllDataType();
		$this->load->view('magData/changeGroupType',$data);

	}
	
	function editChangeGroupType($id){
		$data['companyId'] = $id;
		$data['companyTypeId'] = $this->input->post('companyTypeId');
		$this->GroupAndType->editTypeCompany($data);
		echo "<script>alert('แก้ไขสำเร็จ คลิก เพื่อกลับไปหน้ารายละเอียด');window.location.href = '".base_url()."index.php/dbdHome/getDetial/".$id."'</script>";
	}
	function editDetail(){
		
	$companyName = $this->input->post('companyName');
	$companyNo = $this->input->post('companyNo');
	$dateRegister = $this->input->post('dateRegister');
	$status = $this->input->post('status');
	$moneyRegister = $this->input->post('moneyRegister');
	$address = $this->input->post('address');
	$object = $this->input->post('object');
	$yearSentStament = $this->input->post('yearSentStament');
	$syndicate = $this->input->post('syndicate');
	$partner = $this->input->post('partner');
	$fax = $this->input->post('fax');
	$tel = $this->input->post('tel');
	$email = $this->input->post('email');
	$companyId = $this->input->post('companyId');
	//$detailcompanyid = $this->input->post('detailcompanyid');

	$data = compact('companyName','companyNo');
	$datadetail = compact('dateRegister','status','moneyRegister','address',
	'object','yearSentStament','syndicate','partner','fax','tel','email');
	
	
	$this->Search->editDetail($data,$datadetail,$companyId);
	$this->getDetial($companyId);
	}
	
	function searchGroupDetail($searchGroupProfiId){
		
		$data['gro'] = $this->Search->getDetailSearchGroup($searchGroupProfiId);
		$this->load->view('magData/magGuoupSearchDetial',$data);
		
	}
	
	function deleteSearchGroup($searchGroupProfiId){
		echo '<link  href="<?php echo base_url();?>css/main.css" rel="stylesheet" type="text/css"/>';
		echo "<br><center><font color='RED'>คุณต้องการลบข้อมูลหรือไม่</font></center><br>";
		echo "<center><a href='".base_url()."index.php/dbdHome/deleteSearchGroupAction/".$searchGroupProfiId."'><button>ใช่</button></a>&nbsp;&nbsp;<button onClick='parent.$.fancybox.close();'>ยกเลิก</botton></center>";

		
	}
	function deleteSearchGroupAction($searchGroupProfiId){
		$this->Search->deleteSearchGroup($searchGroupProfiId);
		echo "<br><center>ลบข้อมูลสำเร็จ</center><br>";
		echo "<center><button onClick='parent.$.fancybox.close();'>ปิด</botton></center>";
		
	}
	
	function magProfi(){
		$data['profi'] = $this->session->userdata('dataLogin');
		$this->load->view('home/magProfi',$data);
	}
	
	function editProFi(){
		$data['profi'] = $this->session->userdata('dataLogin');
		$this->load->view('home/editProFi',$data);
	}
	function editProFiAction(){
		$memId = $this->input->post('memId');
		$memName = $this->input->post('memName');
		$memUsername = $this->input->post('memUsername');
		$memLastName = $this->input->post('memLastName');
		
		$memPassword = $this->input->post('memPassword');
		$memPassword2 = $this->input->post('memPassword2');
		$memAddress = $this->input->post('memAddress');
		$memEmail = $this->input->post('memEmail');
		$memTel = $this->input->post('memTel');
		$memStatus = 'emp';
		if($memPassword==$memPassword2){
			$memPassword = MD5($memPassword);
	
			$data = compact('memUsername','memPassword','memName','memLastName','memAddress','memEmail','memTel','memStatus');
			$this->Member->updateProfi($memId,$data);
			$dataLogin = $this->Member->login($memUsername,$memPassword);
			$this->session->set_userdata('dataLogin',$dataLogin);
			echo "<center>แก้ไขข้อมูลสำเร็จ กรุณาล็อกอินใหม่</center>";
			
		}else{
			echo "<script>alert('รหัสผ่านไม่ตรงกันกรุณาทำรายการใหม่ค่ะ');</script>";
			$this->editProFi();
		}
	}
	
	function addGroup(){
		$data = $this->GroupAndType->getMaxValueIdGroup();
		if($data){
			$a = dechex(ord($data[0]['groupCompanyId']))+1;
			$data['groupCompanyId'] = chr(hexdec($a));
		}else{
			$data['groupCompanyId'] = "A";
		}
		$this->load->view('magData/addGroup',$data);
	
	}

	function addGroupAction(){
		$data = $this->GroupAndType->getMaxValueIdGroup();
		if($data){
			$a = dechex(ord($data[0]['groupCompanyId']))+1;
			$groupCompanyId = chr(hexdec($a));
		}else{
			$groupCompanyId = "A";
		}
		$detail = $this->input->post('detail');
		$numrow = $this->input->post('numrow');
		$data1 = compact('groupCompanyId','detail','numrow');
		$this->session->set_userdata('groupCompany',$data1);
		$result['data1']=$data1;
		$result['numrow']=$numrow;
		$companyTypeId= $this->GroupAndType->getMaxValueIdSubGroup();
		$result['companyTypeId'] =$companyTypeId[0]['companyTypeId'];

		$this->load->view('magData/addSubGroup',$result);
		
	}
	
	function addGroupBack(){
		$data = $this->session->userdata('groupCompany');
		$this->load->view('magData/addGroupBack',$data);
	
	}
	function addSubGroupAction(){
		$TypeName = $this->input->post('companyTypeName');
		$TypeId = $this->input->post('companyTypeId');
		$groupCompany = $this->session->userdata('groupCompany');
		$groupCompanyId = $groupCompany['groupCompanyId'];
		$detail = $groupCompanyId.' : '.$groupCompany['detail'];
		$data1 = compact('groupCompanyId','detail');
		
		$this->GroupAndType->addGroup($data1);
		for($i=0;$i<count($TypeName);$i++){
			$companyTypeName = $TypeId[$i].' : '.$TypeName[$i];
			$companyTypeId = $TypeId[$i];
			$dataAddSub = compact('companyTypeId','companyTypeName','groupCompanyId');
			$this->GroupAndType->addSubGroup($dataAddSub);
		}
		$this->session->unset_userdata('groupCompany');
		echo "<br><center>เพิ่มข้อมูลสำเร็จ</center><br>";
		echo "<center><button onClick='parent.$.fancybox.close();'>ปิด</botton></center>";
	}
	
	function getCorporate(){
		$data = $this->Search->getCorporate();
		return $data;
	}
	
	
	
	function searchResultT($provinceId=NULL,$districtId=NULL,$cantonId=NULL,$companyTypeId=NULL,$year=NULL,$order=1,$orderBy="DESC",$page = 1){
		$data['provinceId'] = $provinceId;
		$data['districtId'] = $districtId;
		$data['cantonId'] = $cantonId;
		$data['companyTypeId'] = $companyTypeId;
		$data['year'] = $year;
		
		if($order==1){
			$data['orderBy'] = 'budgetandfinace.totalIncome';
		}
		else if($order==2){
			$data['orderBy'] = 'budgetandfinace.profitLoss';
		}else{
			$data['orderBy'] = 'budgetandfinace.totalIncome';
		}
		
		$data['order'] = $orderBy;
		
		$data['allResultCount']=$this->countAllResult($data);
		$valiError = 0;
		if($data['provinceId']==0||$data['provinceId']==NULL){
			$valiError = 1;
		}
		
		else if($data['districtId']||$data['districtId']){
			$valiError = 2;
		
		}
		
		else if($data['cantonId']||$data['cantonId']){
			$valiError = 3;
		
		}
		
		else if($data['companyTypeId']||$data['companyTypeId']){
			$valiError = 4;
		
		}else{
		$valiError = 0;
		}
		
		
		if($valiError>0&&$valiError!=2&&$valiError!=3){
			
			echo "<script>
			$( 'html' ).removeClass( 'loading' );
			alert('กรุณาเลือกข้อมุลที่ค้นหาให้ครบถ้วน');
			</script>";
			
		}else{
		$data['page']=$page;
		$data['url']="dbdHome/searchResult/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/".$order."/".$orderBy;
		
		if($order==1&&$orderBy=="ASC"){
			$data['link1']="index.php/dbdHome/searchResultT/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/1/DESC";
		}else{
			$data['link1']="index.php/dbdHome/searchResultT/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/1/ASC";
		}
		
		if($order==2&&$orderBy=="ASC"){
			$data['link2']="index.php/dbdHome/searchResultT/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/2/DESC";
		}else{
			$data['link2']="index.php/dbdHome/searchResultT/".$data['provinceId']."/".$data['districtId']."/".$data['cantonId']."/".$data['companyTypeId']."/".$data['year']."/2/ASC";
		}

		$result = $this->Search->getCompany($data);
		$data['searchResult'] =$result;
		
	
		$this->load->view('home/searchResult',$data);

		}
	}
function a($pass=false){
		if($pass=="123456789"){
		$data2 = $this->db->get('detailcompany')->result_array();
		$dss = array();
		foreach($data2 as $dssssss){
			array_push($dss,$dssssss['companyId']);
		}

		$this->db->select('companyId');
		$this->db->where_not_in('companyId', $dss);
		$data = $this->db->get('company')->result_array();
		var_dump($data);
		
		foreach($data as $d){
			$this->db->where('companyId',$d['companyId']);
			$this->db->delete('company');
			$this->db->where('companyId',$d['companyId']);
			$this->db->delete('company');
		}
		$this->db->select('companyId');
		$this->db->where_not_in('companyId', $dss);
		$data = $this->db->get('company')->result_array();
		var_dump($data);
		}else{
			echo "รหัสผิด";
		}

	}
	
	function aa($pass=false){
		if($pass=="123456789"){
		$data2 = $this->db->get('company')->result_array();
		$dss = array();
		foreach($data2 as $dssssss){
			array_push($dss,$dssssss['companyId']);
		}

		$this->db->select('companyId');
		$this->db->where_not_in('companyId', $dss);
		$data = $this->db->get('detailcompany')->result_array();
		var_dump($data);
		
		foreach($data as $d){
			$this->db->where('company.companyId',$d['companyId']);
			$this->db->delete('company');
			$this->db->where('detailcompany.companyId',$d['companyId']);
			$this->db->delete('detailcompany');
		}
		$this->db->select('companyId');
		$this->db->where_not_in('companyId', $dss);
		$data = $this->db->get('company')->result_array();
		var_dump($data);
		}else{
			echo "รหัสผิด";
		}

	}
}

?>