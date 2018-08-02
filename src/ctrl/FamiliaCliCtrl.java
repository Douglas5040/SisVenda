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
public class FamiliaCliCtrl {
    
    private int ID;
    private int cpf;
    private int rg;
    private String nome;
    private String relacao;
    private int cod_cli;

    public FamiliaCliCtrl(int ID, int cpf, int rg, String nome, String relacao, int cod_cli) {
        this.ID = ID;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.relacao = relacao;
        this.cod_cli = cod_cli;
    }

    public FamiliaCliCtrl(){};

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }
   
    
    
}
