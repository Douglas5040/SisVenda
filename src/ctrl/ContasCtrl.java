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
public class ContasCtrl {
    private int cod_conta;
    private int cod_cli;
    private String status;
    private Double valor;
    private String data_pag;
    
    public ContasCtrl(){}
            
    public ContasCtrl(int cod_conta, int cod_cli, Double valor, String data_pag, String status) {
        this.cod_conta = cod_conta;
        this.cod_cli = cod_cli;
        this.valor = valor;
        this.data_pag = data_pag;
        this.status = status;
    }
    

    public int getCod_conta() {
        return cod_conta;
    }

    public void setCod_conta(int cod_conta) {
        this.cod_conta = cod_conta;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData_pag() {
        return data_pag;
    }

    public void setData_pag(String data_pag) {
        this.data_pag = data_pag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
