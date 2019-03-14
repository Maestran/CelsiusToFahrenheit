/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tristan
 */
public class GUI extends JFrame {
 
    GUI()
    {
        setTitle("Convert Celsius to Fahrenheit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setBounds(0, 0, 400, 100);
        setLocationRelativeTo(null);
        
        
        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(400,100));
        content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS));  // On se met en boxLayout pour gerer les lignes
        
        JPanel line1 = new JPanel();  // 1er panel, celui de la 1ere ligne comprenant le champ de saisie et le mot "Celsius"
        line1.setLayout(new BorderLayout());
        line1.setPreferredSize(new Dimension(400,50));
        
        
        JTextField value = new JTextField();
        value.setPreferredSize(new Dimension(200,50));
        
        JLabel valueInCelsius = new JLabel(" Celsius");
        
        line1.add(value,BorderLayout.WEST);
        line1.add(valueInCelsius);
        
        
        
        JPanel line2 = new JPanel();  // 2nd panel, comprenant le bouton et le resultat
        line2.setLayout(new BorderLayout());
        line2.setPreferredSize(new Dimension(400,50));
        
        
        
        JButton convert = new JButton("Convert");
        convert.setVisible(true);
        convert.setPreferredSize(new Dimension(200,50));
        
        
        JLabel valueInFahrenhein = new JLabel(" ");
        
        convert.addActionListener(new ActionListener()  // Notre bouton 
                {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cel = Double.parseDouble(value.getText()); // On recupere la valeur du champ
                double far = conversion(cel);
                valueInFahrenhein.setText(" " + far + " Fahrenheit"); // On update la ligne du resultat
                
            }
                    
                });
        
        line2.add(convert,BorderLayout.WEST);
        line2.add(valueInFahrenhein);
                
        content.add(line1); // On ajout nos deux lignes a la fenetre principale
        content.add(line2);
        
        this.getContentPane().add(content);
        setVisible(true);
        
    }
    
    /*
    Methode qui calcule la valeur en fahrenheit en fonction d'une valeur en celsius
    */
    double conversion(double celsius)
    {
       double value; 
       value = (celsius * 9.0) / 5.0;
       return value + 32.0;
    }
}
