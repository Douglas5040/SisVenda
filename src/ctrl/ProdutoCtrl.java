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
public class ProdutoCtrl {
    private int ID;    
    private int cod_barras;
    private String nome;
    private int estoq_min;
    private int estoq_max;
    private int estoq_atual;
    private String descri;
    private double custo_fabrica;
    private double preco_varejo;
    private double preco_atacado;
    private int peso;
    private int pontos_bonus;
    private double valor_bonus;
    private double markup_lucro;
    private double ipi_impost;
    private double cest_impost;
    private double icms_impost;
    private double ncm_impost;
    private int cod_fornecedor;
    private int cod_categoria;
    private int cod_und_med;
    private int cod_marca;
    private int cod_status;
    private String data_fabrica;
    private String validade;
    private byte[] img1;
    private byte[] img2;

    public ProdutoCtrl(){};
    public ProdutoCtrl(int ID, int cod_barras, String nome, int estoq_min, int estoq_max, int estoq_atual, String descri, double custo_fabrica, double preco_varejo, double preco_atacado, int peso, int pontos_bonus, double valor_bonus, double markup_lucro, byte[] img1, byte[] img2, double ipi_impost, double cest_impost, double icms_impost, double ncm_impost, int cod_fornecedor, int cod_categoria, int cod_und_med, int cod_marca, int cod_status, String data_fabrica, String validade) {
        this.ID = ID;
        this.cod_barras = cod_barras;
        this.nome = nome;
        this.estoq_min = estoq_min;
        this.estoq_max = estoq_max;
        this.estoq_atual = estoq_atual;
        this.descri = descri;
        this.custo_fabrica = custo_fabrica;
        this.preco_varejo = preco_varejo;
        this.preco_atacado = preco_atacado;
        this.peso = peso;
        this.pontos_bonus = pontos_bonus;
        this.valor_bonus = valor_bonus;
        this.markup_lucro = markup_lucro;
        this.ipi_impost = ipi_impost;
        this.cest_impost = cest_impost;
        this.icms_impost = icms_impost;
        this.ncm_impost = ncm_impost;
        this.cod_fornecedor = cod_fornecedor;
        this.cod_categoria = cod_categoria;
        this.cod_und_med = cod_und_med;
        this.cod_marca = cod_marca;
        this.cod_status = cod_status;
        this.data_fabrica = data_fabrica;
        this.validade = validade;
        this.img1 = img1;     
        this.img2 = img2;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(int cod_barras) {
        this.cod_barras = cod_barras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoq_min() {
        return estoq_min;
    }

    public void setEstoq_min(int estoq_min) {
        this.estoq_min = estoq_min;
    }

    public int getEstoq_max() {
        return estoq_max;
    }

    public void setEstoq_max(int estoq_max) {
        this.estoq_max = estoq_max;
    }

    public int getEstoq_atual() {
        return estoq_atual;
    }

    public void setEstoq_atual(int estoq_atual) {
        this.estoq_atual = estoq_atual;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public double getCusto_fabrica() {
        return custo_fabrica;
    }

    public void setCusto_fabrica(double custo_fabrica) {
        this.custo_fabrica = custo_fabrica;
    }

    public double getPreco_varejo() {
        return preco_varejo;
    }

    public void setPreco_varejo(double preco_varejo) {
        this.preco_varejo = preco_varejo;
    }

    public double getPreco_atacado() {
        return preco_atacado;
    }

    public void setPreco_atacado(double preco_atacado) {
        this.preco_atacado = preco_atacado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPontos_bonus() {
        return pontos_bonus;
    }

    public void setPontos_bonus(int pontos_bonus) {
        this.pontos_bonus = pontos_bonus;
    }

    public double getValor_bonus() {
        return valor_bonus;
    }

    public void setValor_bonus(double valor_bonus) {
        this.valor_bonus = valor_bonus;
    }

    public double getMarkup_lucro() {
        return markup_lucro;
    }

    public void setMarkup_lucro(double markup_lucro) {
        this.markup_lucro = markup_lucro;
    }

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }

    
    
    public double getIpi_impost() {
        return ipi_impost;
    }

    public void setIpi_impost(double ipi_impost) {
        this.ipi_impost = ipi_impost;
    }

    public double getCest_impost() {
        return cest_impost;
    }

    public void setCest_impost(double cest_impost) {
        this.cest_impost = cest_impost;
    }

    public double getIcms_impost() {
        return icms_impost;
    }

    public void setIcms_impost(double icms_impost) {
        this.icms_impost = icms_impost;
    }

    public double getNcm_impost() {
        return ncm_impost;
    }

    public void setNcm_impost(double ncm_impost) {
        this.ncm_impost = ncm_impost;
    }

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getCod_und_med() {
        return cod_und_med;
    }

    public void setCod_und_med(int cod_und_med) {
        this.cod_und_med = cod_und_med;
    }

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public int getCod_status() {
        return cod_status;
    }

    public void setCod_status(int cod_status) {
        this.cod_status = cod_status;
    }

    public String getData_fabrica() {
        return data_fabrica;
    }

    public void setData_fabrica(String data_fabrica) {
        this.data_fabrica = data_fabrica;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }



}
