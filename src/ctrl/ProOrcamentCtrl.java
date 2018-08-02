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
public class ProOrcamentCtrl {
    private int id;
    private int cod_pro;
    private int cod_orc;
    private int qtd;
    private double valor_unit;
    private double descont;
    private double sub_total;

    public ProOrcamentCtrl(){}
    public ProOrcamentCtrl(int id, int cod_pro, int cod_orc, int qtd, double valor_unit, double descont, double sub_total) {
        this.id = id;
        this.cod_pro = cod_pro;
        this.cod_orc = cod_orc;
        this.qtd = qtd;
        this.valor_unit = valor_unit;
        this.descont = descont;
        this.sub_total = sub_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(int cod_pro) {
        this.cod_pro = cod_pro;
    }

    public int getCod_orc() {
        return cod_orc;
    }

    public void setCod_orc(int cod_orc) {
        this.cod_orc = cod_orc;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(double valor_unit) {
        this.valor_unit = valor_unit;
    }

    public double getDescont() {
        return descont;
    }

    public void setDescont(double descont) {
        this.descont = descont;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }
    
     
}
