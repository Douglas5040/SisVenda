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
public class ControleProCtrl {
    private int id;
    private int codPro;
    private int qtd;
    private int codOpera;
    private int codUser;
    private int codFornece;
    private int codCli;
    private String date;
    private String hora;
    private String obs;

     public ControleProCtrl(){}
    public ControleProCtrl(int id, int codPro, int qtd, int codOpera, int codUser, int codFornece, int codCli, String date, String hora, String obs) {
        this.id = id;
        this.codPro = codPro;
        this.qtd = qtd;
        this.codOpera = codOpera;
        this.codUser = codUser;
        this.codFornece = codFornece;
        this.codCli = codCli;
        this.date = date;
        this.hora = hora;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCodOpera() {
        return codOpera;
    }

    public void setCodOpera(int codOpera) {
        this.codOpera = codOpera;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    public int getCodFornece() {
        return codFornece;
    }

    public void setCodFornece(int codFornece) {
        this.codFornece = codFornece;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
