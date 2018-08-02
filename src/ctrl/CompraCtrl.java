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
public class CompraCtrl {
    
    private int codigo;
    private int codCli;
    private Double valorTotal;
    private String horaCompra;
    private String dataCompra;
    private String situation;

    public CompraCtrl(){}
      
    public CompraCtrl(int codigo, int codCli, Double valorTotal, String horaCompra, String dataCompra, String situation) {
        this.codigo = codigo;
        this.codCli = codCli;
        this.valorTotal = valorTotal;
        this.horaCompra = horaCompra;
        this.dataCompra = dataCompra;
        this.situation = situation;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    
    
    
}

