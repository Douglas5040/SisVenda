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
public class FornecedorCtrl {
    
    private int ID;
    private String codigo;
    private int cpf_cnpj;
    private String cpf_or_cnpj;
    private String razao_social;
    private String nome_fantazia;
    private String ender;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;
    private String email;
    private String obs;
    private String celular;
    private String telefone;


   
    
    public FornecedorCtrl(int ID, String codigo, int cpf_cnpj, String cpf_or_cnpj, String email, String obs, String celular, String telefone, int cep, String razao_social, String nome_fantazia, String bairro, String ender, String cidade, String estado) {
        this.ID = ID;
        this.codigo = codigo;
        this.cpf_cnpj = cpf_cnpj;
        this.cpf_or_cnpj = cpf_or_cnpj;
        this.razao_social = razao_social;
        this.nome_fantazia = nome_fantazia;
        this.ender = ender;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
        this.obs = obs;
        this.celular = celular;
        this.telefone = telefone;
    }
    
    public FornecedorCtrl(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getCpf_or_cnpj() {
        return cpf_or_cnpj;
    }

    public void setCpf_or_cnpj(String cpf_or_cnpj) {
        this.cpf_or_cnpj = cpf_or_cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantazia() {
        return nome_fantazia;
    }

    public void setNome_fantazia(String nome_fantazia) {
        this.nome_fantazia = nome_fantazia;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
