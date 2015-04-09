<?php 
class Member extends CI_Model {

    function __construct(){
	   parent::__construct();
    }
	function login($username,$password){
		$this->db->where('memUsername',$username);
		$this->db->where('memPassword',MD5($password));
		return $this->db->get('member')->result_array();		
		
	}
	
	function checkUserName($username){
		$this->db->select('memUsername');
		$this->db->where('memUsername',$username);
		return $this->db->get('member')->result_array();
	}
	function addNewRegister($data){
		$this->db->insert('member',$data);
		return $this->db->insert_id();
	}
	
	function checkRegister($memId){
		$this->db->select('memId');
		$this->db->where('memId',$memId);
		return $this->db->get('member')->result_array();
	}
	function updateProfi($memId,$data)
	{
		$this->db->where('memId',$memId);
		$this->db->update('member',$data);
	}
}
?>
