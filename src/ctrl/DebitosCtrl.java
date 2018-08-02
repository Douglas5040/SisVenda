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
public class DebitosCtrl {
    private int id;
    private int cod_os;
    private double valor_deb;
    private int cod_status_deb;
    private String data_hora;
    private String obs;

    public DebitosCtrl(int id, int cod_os, double valor_deb, int cod_status_deb, String data_hora, String obs) {
        this.id = id;
        this.cod_os = cod_os;
        this.valor_deb = valor_deb;
        this.cod_status_deb = cod_status_deb;
        this.data_hora = data_hora;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_os() {
        return cod_os;
    }

    public void setCod_os(int cod_os) {
        this.cod_os = cod_os;
    }

    public double getValor_deb() {
        return valor_deb;
    }

    public void setValor_deb(double valor_deb) {
        this.valor_deb = valor_deb;
    }

    public int getCod_status_deb() {
        return cod_status_deb;
    }

    public void setCod_status_deb(int cod_status_deb) {
        this.cod_status_deb = cod_status_deb;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    
}
