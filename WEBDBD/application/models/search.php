<?php 
class Search extends CI_Model {

    function __construct(){
	   parent::__construct();
    }
	
	function getDataSelecter($id,$filde,$table){
		$this->db->where($filde,$id);
		return $this->db->get($table)->result_array();			
	}
	
	function getGroupYear($id,$filde,$table){
		$this->db->select('year');
		$this->db->where($filde,$id);
		$this->db->group_by('year');

		return $this->db->get($table)->result_array();			
	}
	
	function getDataSelecterJoinDetial($id){
		$this->db->join('detailcompany','company.companyId = detailcompany.companyId');
		$this->db->where('company.companyId',$id);
		$this->db->limit(1);
		return $this->db->get('company')->result_array();	
	}
	
	function getCompany($data){
	$pageValue= 15;
	$this->db->select('company.companyId,company.companyName,detailcompany.syndicate,detailcompany.titleCompany,detailcompany.dateRegister,detailcompany.status,budgetandfinace.totalIncome AS monnySum,budgetandfinace.profitLoss AS monnyRecive');
	$this->db->join('budgetandfinace','budgetandfinace.companyId = company.companyId');

	$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
			if($data['order']==1){
			$this->db->order_by('monnySum',$data['orderBy']);
		}else if($data['order']==2){
			$this->db->order_by('monnyRecive',$data['orderBy']);
		}
		$this->db->where('company.provinceId',$data['provinceId']);
	if($data['districtId']!="-"){
		$this->db->where('company.districtId',$data['districtId']);
	}
	if($data['cantonId']!="-"){
		$this->db->where('company.cantonId',$data['cantonId']);
	}
		$this->db->where('company.companyTypeId',$data['companyTypeId']);

		
		$this->db->where('budgetandfinace.year',$data['year']);

		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');
		$returnData = $this->db->get('company',$pageValue,$data['page'])->result_array();
		$this->db->from('company');
		
		$this->db->select('company.companyId');
		$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
		$this->db->where('company.provinceId',$data['provinceId']);
	if($data['districtId']!="-"){
		$this->db->where('company.districtId',$data['districtId']);
	}
	if($data['cantonId']!="-"){
		$this->db->where('company.cantonId',$data['cantonId']);
	}
		$this->db->where('company.companyTypeId',$data['companyTypeId']);
		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');
		$config['uri_segment'] = 10;
		$config['total_rows'] = $this->db->count_all_results(); // ส
		
	
		 $config['per_page'] = $pageValue;
	
		 $config['base_url'] = "".base_url()."/index.php/".$data['url'];

  		 
		 $this->pagination->create_links();
  		 $this->pagination->initialize($config);   
		 return $returnData;

	}
		function getCompanyByText($data,$orderBy){
	$pageValue= 15;
	$this->db->select('company.companyId,company.companyName,detailcompany.syndicate,detailcompany.titleCompany,detailcompany.dateRegister,detailcompany.status,budgetandfinace.totalIncome AS monnySum,budgetandfinace.profitLoss AS monnyRecive');
		$this->db->join('budgetandfinace','budgetandfinace.companyId = company.companyId');
		$this->db->where('budgetandfinace.year',$data['year']);
		$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
		$this->db->like('company.companyName',$data['text']);
		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');
		$this->db->where('detailcompany.titleCompany',$data['corporate']);
		$returnData = $this->db->get('company',$pageValue,$data['page'])->result_array();
		$this->db->from('company');
		
		$this->db->select('company.companyId,company.companyName');
		$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
		$this->db->like('company.companyName',$data['text']);
		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');
		$this->db->where('detailcompany.titleCompany',$data['corporate']);
		$config['total_rows'] = $this->db->count_all_results(); // ส
		$config['uri_segment'] = 5;
	
		 $config['per_page'] = $pageValue;
	
		 $config['base_url'] = "".base_url()."/index.php/".$data['url'];

  		 
		 $this->pagination->create_links();
  		 $this->pagination->initialize($config);   
		 return $returnData;

	}
	function countAllResultSearch($data){
	$this->db->select('company.companyId');
	$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
		$this->db->where('company.provinceId',$data['provinceId']);
	if($data['districtId']!="-"){
		$this->db->where('company.districtId',$data['districtId']);
	}
	if($data['cantonId']!="-"){
		$this->db->where('company.cantonId',$data['cantonId']);
	}
		$this->db->where('company.companyTypeId',$data['companyTypeId']);

		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');

		$returnData = $this->db->get('company')->result_array();
		return count($returnData);
	}
	
	function countAllResultText($data){
		$this->db->select('company.companyId,company.companyName');
	$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
	$this->db->like('company.companyName',$data['text']);
	

		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');
		$this->db->where('detailcompany.titleCompany',$data['corporate']);
		$returnData = $this->db->get('company')->result_array();
		return count($returnData);
	}
	function getCompanyIdAllGroup($data){
		$this->db->select('company.companyId');
		$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
		$this->db->where('company.provinceId',$data['provinceId']);
	if($data['districtId']!="-"){
		$this->db->where('company.districtId',$data['districtId']);
	}
	if($data['cantonId']!="-"){
		$this->db->where('company.cantonId',$data['cantonId']);
	}
		$this->db->where('company.companyTypeId',$data['companyTypeId']);
		$this->db->where('detailcompany.status','ยังดำเนินกิจการอยู่');
	

		return $this->db->get('company')->result_array();
		

	}
	
	function getCompanyAllGroup($data,$page,$url,$year){
		$pageValue= 15;
		$this->db->select('company.companyId,company.companyName,detailcompany.titleCompany,detailcompany.syndicate,detailcompany.dateRegister,detailcompany.status,budgetandfinace.year,budgetandfinace.totalIncome AS monnySum,profitLoss AS monnyRecive');
		$this->db->join('budgetandfinace','budgetandfinace.companyId = company.companyId');
		$this->db->join('detailcompany','detailcompany.companyId = company.companyId');
		foreach($data as $d){
			$this->db->or_where('company.companyId',$d['companyId']);
		}
		$this->db->where('budgetandfinace.year',$year);
		$this->db->group_by('company.companyId');
		$returnData = $this->db->get('company',$pageValue,$page)->result_array();
		$this->db->from('company');
		$this->db->select('companyId');
		foreach($data as $d){
			$this->db->or_where('companyId',$d['companyId']);
		}
		$this->db->where('budgetandfinace.year',$year);
		$this->db->group_by('company.companyId');
		$config['uri_segment'] = 4;
		$config['total_rows'] = count($data); // ส
		
	
		 $config['per_page'] = $pageValue;
	
		 $config['base_url'] = "".base_url()."/index.php/".$url;

  		 
		 $this->pagination->create_links();
  		 $this->pagination->initialize($config);   
		 return $returnData;

	}
	
	
	function listSearchGroup(){
		$loginData = $this->session->userdata('dataLogin');
		$this->db->where('memId',$loginData[0]['memId']);
		return $this->db->get('searchgroupprofi')->result_array();
	}
	function searchGroup($id){
		$loginData = $this->session->userdata('dataLogin');
		$this->db->join('searchlog','searchlog.searchGroupProfiId = searchgroupprofi.searchGroupProfiId');
		$this->db->where('memId',$loginData[0]['memId']);
		$this->db->where('searchgroupprofi.searchGroupProfiId',$id);
		return $this->db->get('searchgroupprofi')->result_array();
	}
	function addGroup($data){
		$this->db->insert('searchgroupprofi',$data);
		return $this->db->insert_id();
	}
	
	function addGroupSub($data){
		$this->db->insert('searchlog',$data);
	}
	function editDetail($data,$datadetail,$companyId){
		$this->db->where('companyId',$companyId);
		$this->db->update('company',$data);
		
		$this->db->where('companyId',$companyId);
		$this->db->update('detailcompany',$datadetail);
	}
	function getDetailSearchGroup($searchGroupProfiId){
		$this->db->join('searchlog','searchgroupprofi.searchGroupProfiId = searchlog.searchGroupProfiId');
		$this->db->join('province','searchlog.provinceId = province.provinceId');
		$this->db->join('companytype','companytype.companyTypeId = searchlog.companyTypeId');
		$this->db->join('groupcompany','groupcompany.groupCompanyId = companytype.groupCompanyId');
		$this->db->where('searchgroupprofi.searchGroupProfiId',$searchGroupProfiId);
		return $this->db->get('searchgroupprofi')->result_array();
	
	}
	function deleteSearchGroup($searchGroupProfiId){
		$this->db->where('searchgroupprofi.searchGroupProfiId',$searchGroupProfiId);
		$this->db->delete('searchgroupprofi');
		
		$this->db->where('searchlog.searchGroupProfiId',$searchGroupProfiId);
		$this->db->delete('searchlog');
		
	}
	
	function getCorporate(){
		$this->db->select('titleCompany');
		$this->db->group_by('titleCompany');
		return $this->db->get('detailcompany')->result_array();
	}
	

}
?>
