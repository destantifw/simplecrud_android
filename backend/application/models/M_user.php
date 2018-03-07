<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class M_user extends CI_Model{

    public function insert_user($data){
        $this->db->insert("user",$data);

    }

    public function get_user(){

      $data = $this->db->get('user')->result();
      return $data;


    }

    public function login($username, $password){

      $this->db->select('count(*)');
      $this->db->from('user');
      $this->db->where('username', $username);
      $this->db->where('password', $password);
      return $this->db->count_all_results();;
      // return $data;

    }

    public function edit_user($data){
        $this->db->set($data);
        $this->db->where('id_user', $data['id_user']);
        $this->db->update('user');

    }

    public function delete_user($id){

      $this->db->where('id_user', $id);
      return $this->db->delete('user');

    }
}
?>
