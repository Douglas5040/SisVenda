/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import java.text.DecimalFormat;

/**
 *
 * @author Douglas
 */
public class DoubleCtrl {

    public DoubleCtrl() {
    }
    
    public String convertDoubleToString(Double valor){
       /*trsnsformando um Double em 2 dasas decimais */
       DecimalFormat fmt = new DecimalFormat("0.00");
       String string = fmt.format(valor);
       String[] part = string.split("[,]");
       String preco = part[0]+","+part[1];
       
       int part1 = Integer.parseInt(part[0]);
        int deci1 = Integer.parseInt(part[0].substring(part[0].length()-1));
        int deci2 = Integer.parseInt(part[1].substring(1));
        int deci2part1 = Integer.parseInt(part[1].substring(0,1));
        
       if(deci2>6){
           if(deci2part1==9){
                preco = String.valueOf(Integer.parseInt(part[0])+1)+".00";
           }else{
               preco = part[0]+"."+(deci2part1+1)+"0";
           }
           
       }else if(deci2>2 && deci2<7){
           deci2=5;
           preco = part[0]+"."+part[1].substring(0,1)+deci2;
       }else{
           deci2=0;
           preco = part[0]+"."+part[1].substring(0,1)+deci2;
       }
       
       return preco;
    }
    public double convertDouble2casas(Double valor){
        DecimalFormat fmt = new DecimalFormat("0.00");
        String string = fmt.format(valor);
        String string2 = "0.00";
        String[] part = string.split("[,]");
        int part1 = Integer.parseInt(part[0]);
        int deci1 = Integer.parseInt(part[0].substring(part[0].length()-1));
        int deci2 = Integer.parseInt(part[1].substring(1));
        int deci2part1 = Integer.parseInt(part[1].substring(0,1));
        
       if(deci2>6){
           if(deci2part1==9){
                string2 = String.valueOf(Integer.parseInt(part[0])+1)+".00";
           }else{
               string2 = part[0]+"."+(deci2part1+1)+"0";
           }
           
       }else if(deci2>2 && deci2<7){
           deci2=5;
           string2 = part[0]+"."+part[1].substring(0,1)+deci2;
       }else{
           deci2=0;
           string2 = part[0]+"."+part[1].substring(0,1)+deci2;
       }
       Double preco = Double.parseDouble(string2);
       
       return preco;
    }

}
