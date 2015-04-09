<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Home extends CI_Controller {

	function index()
	{
		$this->session->unset_userdata('dataLogin');
		$this->load->view('loginPage');
	}
	
	function Login(){
		$username = $this->input->post('username');
		$password = $this->input->post('password');

		if($username!=""&&$password!=""){
			$dataLogin = $this->Member->login($username,$password);
		
			if($dataLogin){
				$this->session->set_userdata('dataLogin',$dataLogin);
				echo "1";
			}else{
				echo "0";
			}
		}else{
			
			echo "3";
		}
	}
	function logOut(){
		$this->session->unset_userdata('dataLogin');
		echo"<script langquage='javascript'>window.location='".base_url()."index.php/home';</script>";
	}
	
	function register(){
		$this->load->view('register');
	}
	function checkUserName(){
		$username = $this->input->post('username');
		$usernameValue = $this->Member->checkUserName($username);
		if($usernameValue){
			echo "0";
		}else{
			echo "1";
		}
	}
	function registerAction(){
		$memUsername = $this->input->post('username');
		$memPassword = MD5($this->input->post('password'));
		$memName = $this->input->post('memName');
		$memLastName = $this->input->post('memLastName');
		$memAddress = $this->input->post('address');
		$memEmail = $this->input->post('email');
		$memTel = $this->input->post('tel');
		
		$data = compact('memUsername','memPassword','memName','memLastName','memAddress','memEmail','memTel');
		$memId = $this->Member->addNewRegister($data);
		$mem = $this->Member->checkRegister($memId);
		if($mem){
			echo "1";
		}else{
			echo "0";
		}
	}
		function magGuoupAndType(){
		$data['type']=$this->GroupAndType->getAllDataType();
		$data['group']=$this->GroupAndType->getAllDataGroup();
		$this->load->view('magData/magGuoupAndType',$data);

	}
	

}

?>