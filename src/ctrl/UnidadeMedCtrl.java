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
public class UnidadeMedCtrl {
    
    private int ID;
    private String abrev;
    private String nome;

    public UnidadeMedCtrl(int ID, String abrev, String nome) {
        this.ID = ID;
        this.abrev = abrev;
        this.nome = nome;
    }
    
    public UnidadeMedCtrl(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
