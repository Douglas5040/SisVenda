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
public class CategoriaCtrl {
    
    private int ID;
    private String nome;
    private String descri;

    public CategoriaCtrl(int ID, String nome, String descri) {
        this.ID = ID;
        this.nome = nome;
        this.descri = descri;
    }
    
    public CategoriaCtrl(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }
    
    
}
