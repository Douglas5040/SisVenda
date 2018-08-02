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
public class VendaCtrl {
    private int cod;
    private int codPro;
    private int qtd;
    private Double valorUnit;
    private Double descont;
    private Double valorPago;
    private int idCli;
    private int codCompra;
    
    public VendaCtrl() {}
    
    public VendaCtrl(int cod, int codPro, int qtd, Double valorUnit, Double descont, Double valorPago, int idCli, int codCompra) {
        this.cod = cod;
        this.codPro = codPro;
        this.qtd = qtd;
        this.valorUnit = valorUnit;
        this.descont = descont;
        this.valorPago = valorPago;
        this.idCli = idCli;
        this.codCompra = codCompra;
    }

    
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Double getDescont() {
        return descont;
    }

    public void setDescont(Double descont) {
        this.descont = descont;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }
    
}
