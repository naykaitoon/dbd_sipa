<?php 
class GroupAndType extends CI_Model {

    function __construct(){
	   parent::__construct();
    }
	function getAllDataGroup(){
		return $this->db->get('groupcompany')->result_array();			
	}
	
	function getAllDataType(){
		return $this->db->get('companytype')->result_array();			
	}
	
	function getAllDataTypeByGroup($id){
		$this->db->where('groupCompanyId',$id);
		return $this->db->get('companytype')->result_array();			
	}
	
	function getAllDataTypeByGroupText($id,$text){
		$this->db->like('companyTypeName',$text);
		$this->db->where('groupCompanyId',$id);
		return $this->db->get('companytype')->result_array();			
	}
	
	function getDataGroupPK($id){
		$this->db->where('groupCompanyId',$id);
		return $this->db->get('groupcompany')->result_array();			
	}
	
	function editGroup($id,$data){
		$this->db->where('groupCompanyId',$id);
		$this->db->update('groupcompany',$data);
	}
	
	function getDataTypePK($id){
		$this->db->where('companyTypeId',$id);
		return $this->db->get('companytype')->result_array();			
	}
	
	function editData($id,$filde,$table,$data){
		$this->db->where($filde,$id);
		$this->db->limit(1);
		$this->db->update($table,$data);
	}
	
	function deleteData($id,$filde,$table){
		$this->db->where($filde,$id);
		$this->db->limit(1);
		$this->db->delete($table);
	}
	function getMaxValueIdGroup(){
		$this->db->select('groupCompanyId');
		$this->db->limit(1);
		$this->db->order_by('groupCompanyId','DESC');
		return $this->db->get('groupcompany')->result_array();
	}
	
	function getMaxValueIdSubGroup(){
		$this->db->select('companyTypeId');
		$this->db->limit(1);
		$this->db->order_by('companyTypeId','DESC');
		return $this->db->get('companytype')->result_array();
	}
	
	function addGroup($data){
		$this->db->insert('groupcompany',$data);
	}
	function addSubGroup($data){
		$this->db->insert('companytype',$data);
	}
	
	function editTypeCompany($data){
		$dataUpdate = array("companyTypeId" => $data['companyTypeId']);
		$this->db->where('companyId',$data['companyId']);
		$this->db->update('company',$dataUpdate);
	}
}
?>
