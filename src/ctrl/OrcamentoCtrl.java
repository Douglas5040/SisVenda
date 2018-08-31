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
public class OrcamentoCtrl {
    private int id;
    private String data_orc;
    private int cod_vendedor;
    private int cod_cli;
    private double valor_total;
    private double descont;
    private String obs;

    public OrcamentoCtrl(){}
    public OrcamentoCtrl(int id, String data_orc, int cod_vendedor, int cod_cli, double valor_total, double descont, String obs) {
        this.id = id;
        this.data_orc = data_orc;
        this.cod_vendedor = cod_vendedor;
        this.cod_cli = cod_cli;
        this.valor_total = valor_total;
        this.descont = descont;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_orc() {
        return data_orc;
    }

    public void setData_orc(String data_orc) {
        this.data_orc = data_orc;
    }

    public int getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(int cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public int getCodCli() {
        return cod_cli;
    }

    public void setCodCli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getDescont() {
        return descont;
    }

    public void setDescont(double descont) {
        this.descont = descont;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
