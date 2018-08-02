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
public class OrdemServiceCtrl {
    private int id;
    private double valor;
    private String data_hora_opem;
    private String data_hora_close;
    private int cod_vendedor;
    private int cod_cli;
    private double descont;
    private int cod_status_os;
    private String obs;

    public OrdemServiceCtrl(int id, double valor, String data_hora_opem, String data_hora_close, int cod_vendedor, int cod_cli, double descont, int cod_status_os, String obs) {
        this.id = id;
        this.valor = valor;
        this.data_hora_opem = data_hora_opem;
        this.data_hora_close = data_hora_close;
        this.cod_vendedor = cod_vendedor;
        this.cod_cli = cod_cli;
        this.descont = descont;
        this.cod_status_os = cod_status_os;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_hora_opem() {
        return data_hora_opem;
    }

    public void setData_hora_opem(String data_hora_opem) {
        this.data_hora_opem = data_hora_opem;
    }

    public String getData_hora_close() {
        return data_hora_close;
    }

    public void setData_hora_close(String data_hora_close) {
        this.data_hora_close = data_hora_close;
    }

    public int getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(int cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public double getDescont() {
        return descont;
    }

    public void setDescont(double descont) {
        this.descont = descont;
    }

    public int getCod_status_os() {
        return cod_status_os;
    }

    public void setCod_status_os(int cod_status_os) {
        this.cod_status_os = cod_status_os;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
