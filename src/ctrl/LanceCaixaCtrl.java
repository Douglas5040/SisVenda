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
public class LanceCaixaCtrl {
    private int id;
    private int cod_caixa;
    private String descri;
    private String obs;

    public LanceCaixaCtrl(int id, int cod_caixa, String descri, String obs) {
        this.id = id;
        this.cod_caixa = cod_caixa;
        this.descri = descri;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_caixa() {
        return cod_caixa;
    }

    public void setCod_caixa(int cod_caixa) {
        this.cod_caixa = cod_caixa;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    
}
