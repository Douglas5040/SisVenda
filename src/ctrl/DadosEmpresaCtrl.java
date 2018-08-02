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
public class DadosEmpresaCtrl {
    private int id;
    private String nome;
    private String ender;
    private String cidade;
    private String estado;
    private String cnpj;
    private String tel;
    private String cell;
    private String email;
    private String nome_dono;
    private byte[] logo;

    public DadosEmpresaCtrl(int id, String nome, String ender, String cidade, String estado, String cnpj, String tel, String cell, String email, String nome_dono, byte[] logo) {
        this.id = id;
        this.nome = nome;
        this.ender = ender;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
        this.tel = tel;
        this.cell = cell;
        this.email = email;
        this.nome_dono = nome_dono;
        this.logo = logo;
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

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_dono() {
        return nome_dono;
    }

    public void setNome_dono(String nome_dono) {
        this.nome_dono = nome_dono;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    
}
