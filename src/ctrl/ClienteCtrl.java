/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

/**
 *
 * @author Adm
 */
public class ClienteCtrl {
    private int id;
    private String codigo;
    private String nome;
    private String data_nasc;
    private String apelido;
    private String estado_civil;
    private int cpf_cnpj;
    private String cpf_or_cnpj;
    private int rg;
    private String celular;
    private String tel_resi;
    private String tel_comer;
    private String email;
    private Double valor_credito;
    private int cep;
    private String rua;
    private int numero;
    private String bairro;
    private String complem;
    private String cidade;
    private String estado;
    private String referencia;
    private String foto;
    private int bonus_acumulado;
    private String obs;

    public ClienteCtrl(){};
    
    public ClienteCtrl(int id, String codigo, String nome, String data_nasc, String apelido, String estado_civil, int cpf_cnpj, String cpf_or_cnpj, int rg, String celular, String tel_resi, String email, String tel_comer, Double valor_credito, int cep, String rua, int numero, String bairro, String complem, String cidade, String estado, String referencia, String foto, String obs, int cod_familia, int bonus_acumulado) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.apelido = apelido;
        this.estado_civil = estado_civil;
        this.cpf_cnpj = cpf_cnpj;
        this.cpf_or_cnpj = cpf_or_cnpj;
        this.rg = rg;
        this.celular = celular;
        this.tel_resi = tel_resi;
        this.tel_comer = tel_comer;
        this.valor_credito = valor_credito;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complem = complem;
        this.cidade = cidade;
        this.estado = estado;
        this.referencia = referencia;
        this.foto = foto;
        this.bonus_acumulado = bonus_acumulado;
        this.email = email;
        this.obs = obs;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
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
    
     public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTel_resi() {
        return tel_resi;
    }

    public void setTel_resi(String tel_resi) {
        this.tel_resi = tel_resi;
    }

    public String getTel_comer() {
        return tel_comer;
    }

    public void setTel_comer(String tel_comer) {
        this.tel_comer = tel_comer;
    }

    public Double getValor_credito() {
        return valor_credito;
    }

    public void setValor_credito(Double valor_credito) {
        this.valor_credito = valor_credito;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getBonus_acumulado() {
        return bonus_acumulado;
    }

    public void setBonus_acumulado(int bonus_acumulado) {
        this.bonus_acumulado = bonus_acumulado;
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

   
    
    
}
