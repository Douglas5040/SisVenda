package formularios;

import java.awt.Color;
import java.awt.Container;  
import java.awt.Font;
import java.awt.GridLayout;  

import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JPasswordField;  
import javax.swing.JTextField;
/**
 *
 * @author Douglas
 */
public class Alertas extends JFrame{ 
    
    public Alertas(String title, String txt, int width, int height){
        super(title);  

        Container c = getContentPane();  

        JLabel label = new JLabel(txt);
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        label.setFont(font);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setAlignmentY(CENTER_ALIGNMENT);
        label.setAlignmentX(CENTER_ALIGNMENT);
        //label.setSize(300, 150);
        label.setForeground(Color.BLACK);
        
        c.setLayout(new GridLayout(1,1));  
        c.add(label);  




        setBounds((width/2)-175,(height/2)-80, 350, 150);
        //setSize(220,80);
        setResizable(false);
        setVisible(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    public static void main(String[] args) {

        //new Alertas("Aguarde","CARREGANDO...", 1000, 800);
    }
    public void parecer(){
        this.setVisible(true);
    }
    public void sumir(){
        this.setVisible(false);
    }
}
