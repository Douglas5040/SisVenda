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
public class SaidaProDao {
    private int ID;
    private int COD_PRO;
    private double VALOR_PRO;
    private int QTD;
    private double VALOR_TOTAL;  
    private double DESCONT;      
    private int COD_OS;

    public SaidaProDao(){}
    public SaidaProDao(int ID, int COD_PRO, double VALOR_PRO, int QTD, double VALOR_TOTAL, double DESCONT, int COD_OS) {
        this.ID = ID;
        this.COD_PRO = COD_PRO;
        this.VALOR_PRO = VALOR_PRO;
        this.QTD = QTD;
        this.VALOR_TOTAL = VALOR_TOTAL;
        this.DESCONT = DESCONT;
        this.COD_OS = COD_OS;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCOD_PRO() {
        return COD_PRO;
    }

    public void setCOD_PRO(int COD_PRO) {
        this.COD_PRO = COD_PRO;
    }

    public double getVALOR_PRO() {
        return VALOR_PRO;
    }

    public void setVALOR_PRO(double VALOR_PRO) {
        this.VALOR_PRO = VALOR_PRO;
    }

    public int getQTD() {
        return QTD;
    }

    public void setQTD(int QTD) {
        this.QTD = QTD;
    }

    public double getVALOR_TOTAL() {
        return VALOR_TOTAL;
    }

    public void setVALOR_TOTAL(double VALOR_TOTAL) {
        this.VALOR_TOTAL = VALOR_TOTAL;
    }

    public double getDESCONT() {
        return DESCONT;
    }

    public void setDESCONT(double DESCONT) {
        this.DESCONT = DESCONT;
    }

    public int getCOD_OS() {
        return COD_OS;
    }

    public void setCOD_OS(int COD_OS) {
        this.COD_OS = COD_OS;
    }
    
    
}
