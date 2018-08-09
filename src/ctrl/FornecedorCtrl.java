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
    private int Cpf_cnpj;
    private String razao_social;
    private String nome_fantazia;
    private String ender;
    private String bairro;
    private String cidade;
    private String uf;

    public FornecedorCtrl(int ID, String codigo, int Cpf_cnpj, String razao_social, String nome_fantazia, String bairro, String ender, String cidade, String uf) {
        this.ID = ID;
        this.codigo = codigo;
        this.Cpf_cnpj = Cpf_cnpj;
        this.razao_social = razao_social;
        this.nome_fantazia = nome_fantazia;
        this.ender = ender;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
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
        return Cpf_cnpj;
    }

    public void setCpf_cnpj(int Cpf_cnpj) {
        this.Cpf_cnpj = Cpf_cnpj;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
}
