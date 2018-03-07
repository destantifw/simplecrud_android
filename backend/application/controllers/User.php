<?php

class User extends CI_Controller{

    function __construct() {
      parent::__construct();
      $this->load->helper('url'); //Loading url helper
    }

    public function index()
  	{

  	}

    public function insert_user() {
      $this->load->database();
      $this->load->model('M_user');

      $data['username'] = $this->input->post('username');
      $data['password'] = $this->input->post('password');
      $data['fullname'] = $this->input->post('fullname');
      $data['city'] = $this->input->post('city');
      $data['status']  = $this->input->post('status');

      $this->M_user->insert_user($data);

    echo "success";
    }

    public function get_user(){
        $this->load->database();
        $this->load->model('M_user');

        echo json_encode($this->M_user->get_user());
    }

    public function login(){
        $this->load->database();
        $this->load->model('M_user');

        $username = $this->input->post('username');
        $password = $this->input->post('password');

        $isTrue = $this->M_user->login($username, $password);
        if($isTrue== 1){
          echo "ada";
        } else {
          echo $isTrue;
        }
    }

    public function edit_user(){
        $this->load->database();
        $this->load->model('M_user');

        $data['id_user'] = $this->input->post('id_user');
        $data['username'] = $this->input->post('username');
        $data['password'] = $this->input->post('password');
        $data['fullname'] = $this->input->post('fullname');
        $data['city'] = $this->input->post('city');
        $data['status']  = $this->input->post('status');

        echo $this->M_user->edit_user($data);
    }

    public function delete_user(){
        $this->load->database();
        $this->load->model('M_user');

        $id = $this->input->post('id_user');

        echo $this->M_user->delete_user($id);
    }
    // public function get_user($keyword){
    //     $this->load->database();
    //     $this->load->model('M_user');
    //
    //     $data['keyword'] = $this->input->post('keyword');
    //
    //     $this->M_user->get_by_keyword('data');
    // }

}
?>
