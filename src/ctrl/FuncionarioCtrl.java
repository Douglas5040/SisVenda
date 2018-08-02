/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

/**
 *
 * @author Douglas
 */
public class FuncionarioCtrl {
    private int id;
    private String nome;
    private int rg;
    private int cpf;
    private int cart_trab;
    private String data_nasc;
    private int  cep;
    private String rua;
    private int numero;
    private String bairro;
    private String complem;
    private String celular;
    private String tel1;
    private String tel2;
    private byte[] foto;
    private String cargo;
    private int cod_user;

    public FuncionarioCtrl(){}
    public FuncionarioCtrl(int id, String nome, int rg, int cpf, int cart_trab, String data_nasc, int cep, String rua, int numero, String bairro, String complem, String celular, String tel1, String tel2, byte[] foto, String cargo, int cod_user) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cart_trab = cart_trab;
        this.data_nasc = data_nasc;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complem = complem;
        this.celular = celular;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.foto = foto;
        this.cargo = cargo;
        this.cod_user = cod_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCart_trab() {
        return cart_trab;
    }

    public void setCart_trab(int cart_trab) {
        this.cart_trab = cart_trab;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplem() {
        return complem;
    }

    public void setComplem(String complem) {
        this.complem = complem;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCod_user() {
        return cod_user;
    }

    public void setCod_user(int cod_user) {
        this.cod_user = cod_user;
    }
    
    

}
