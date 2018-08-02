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
public class EntregaPro {
    private int id;
    private int cod_status_entre;
    private int cod_cli;
    private int cod_func;
    private String data_opem;
    private String data_entrega;
    private String hora_entrega;
    private double frete;
    private int cod_nf;
    private int serie_nf;

    public EntregaPro(int id, int cod_status_entre, int cod_cli, int cod_func, String data_opem, String data_entrega, String hora_entrega, double frete, int cod_nf, int serie_nf) {
        this.id = id;
        this.cod_status_entre = cod_status_entre;
        this.cod_cli = cod_cli;
        this.cod_func = cod_func;
        this.data_opem = data_opem;
        this.data_entrega = data_entrega;
        this.hora_entrega = hora_entrega;
        this.frete = frete;
        this.cod_nf = cod_nf;
        this.serie_nf = serie_nf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_status_entre() {
        return cod_status_entre;
    }

    public void setCod_status_entre(int cod_status_entre) {
        this.cod_status_entre = cod_status_entre;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public int getCod_func() {
        return cod_func;
    }

    public void setCod_func(int cod_func) {
        this.cod_func = cod_func;
    }

    public String getData_opem() {
        return data_opem;
    }

    public void setData_opem(String data_opem) {
        this.data_opem = data_opem;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getHora_entrega() {
        return hora_entrega;
    }

    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public int getCod_nf() {
        return cod_nf;
    }

    public void setCod_nf(int cod_nf) {
        this.cod_nf = cod_nf;
    }

    public int getSerie_nf() {
        return serie_nf;
    }

    public void setSerie_nf(int serie_nf) {
        this.serie_nf = serie_nf;
    }
    
    
}
