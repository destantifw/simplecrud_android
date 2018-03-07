<?php

defined('BASEPATH') OR exit('No direct script access allowed');

require('application/libraries/REST_Controller.php');


class Api extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
    }

    //Menampilkan data kontak
    function index_get() {
        $this->load->database();
        $this->load->model('M_profil');

        $id = $this->get('id');
        if ($id == '') {
            $data = $this->M_profil->GetDataMahasiswa();
        } else {
            $data = $this->M_profil->GetDataMahasiswa_withId($id);
        }
        $this->response($data, 200);
    }

    //Masukan function selanjutnya disini

    function index_post(){
        $this->load->database();
        $this->load->model('Mahasiswa');
        $nim = $this->input->post['nim'];
        $password = $this->input->post['password'];



        // $data = $this->Mahasiswa->cekLogin("1304349", "311295");
        $this->response($data, 201);
    }
  }
?>
