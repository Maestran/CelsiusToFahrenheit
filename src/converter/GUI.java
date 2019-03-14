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
        content.setLayout(new BoxLayout(content,BoxLayout.PAGE_AXIS)); 
        
        JPanel line1 = new JPanel();
        line1.setLayout(new BorderLayout());
        line1.setPreferredSize(new Dimension(400,50));
        
        
        JTextField value = new JTextField();
        value.setPreferredSize(new Dimension(200,50));
        
        JLabel valueInCelsius = new JLabel(" Celsius");
        
        line1.add(value,BorderLayout.WEST);
        line1.add(valueInCelsius);
        
        
        
        JPanel line2 = new JPanel();
        line2.setLayout(new BorderLayout());
        line2.setPreferredSize(new Dimension(400,50));
        
        
        
        JButton convert = new JButton("Convert");
        convert.setVisible(true);
        convert.setPreferredSize(new Dimension(200,50));
        
        
        JLabel valueInFahrenhein = new JLabel(" ");
        
        convert.addActionListener(new ActionListener()
                {
            @Override
            public void actionPerformed(ActionEvent e) {
                double cel = Double.parseDouble(value.getText());
                double far = conversion(cel);
                valueInFahrenhein.setText(" " + far + " Fahrenheit");
                
            }
                    
                });
        line2.add(convert,BorderLayout.WEST);
        line2.add(valueInFahrenhein);
                
        content.add(line1);
        content.add(line2);
        
        this.getContentPane().add(content);
        setVisible(true);
        
    }
    
    double conversion(double celsius)
    {
       double value; 
       value = (celsius * 9.0) / 5.0;
       return value + 32.0;
    }
}
