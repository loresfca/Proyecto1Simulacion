package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PantallaGeneradorCongruenciaLineal{
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public PantallaGeneradorCongruenciaLineal(){
      prepareGUI();
   }
   public static void main(String[] args){
	   PantallaGeneradorCongruenciaLineal swingControlDemo = new PantallaGeneradorCongruenciaLineal();  
//      swingControlDemo.showEventDemo();       
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
      mainFrame.setSize(650,500);
//      mainFrame.setLayout(new GridLayout(1,3));
//
//      headerLabel = new JLabel("",JLabel.CENTER );
//      statusLabel = new JLabel("",JLabel.CENTER);        
//      statusLabel.setSize(350,100);
//      
//      mainFrame.addWindowListener(new WindowAdapter() {
//         public void windowClosing(WindowEvent windowEvent){
//            System.exit(0);
//         }        
//      });    
//      controlPanel = new JPanel();
//      controlPanel.setLayout(new FlowLayout());
//
//      mainFrame.add(headerLabel);
//      mainFrame.add(controlPanel);
//      mainFrame.add(statusLabel);
      int i = 3;
      int j = 4;
      JPanel[][] panelHolder = new JPanel[i][j];    
      mainFrame.setLayout(new GridLayout(i,j));

      for(int m = 0; m < i; m++) {
         for(int n = 0; n < j; n++) {
            panelHolder[m][n] = new JPanel();
            mainFrame.add(panelHolder[m][n]);
         }
      }
      
      panelHolder[2][3].add(new JButton("Foo"));
      
      mainFrame.setVisible(true);  
   }
   
//   private void showEventDemo(){
//      headerLabel.setText("Control in action: Button"); 
//
//      JTextField s = new JTextField();
//      s.setVisible(false);
//      s.setPreferredSize( new Dimension( 200, 24 ) );
//      
//      JTextField texto_xinicial = new JTextField();
//      texto_xinicial.setPreferredSize( new Dimension( 200, 24 ) );
//      
//      JTextField texto_a  = new JTextField();
//      texto_a.setPreferredSize( new Dimension( 200, 24 ) );
//      
//      JTextField texto_c = new JTextField();
//      texto_c.setPreferredSize( new Dimension( 200, 24 ) );
//      
//      JTextField texto_m= new JTextField();
//      texto_m.setPreferredSize( new Dimension( 200, 24 ) );
//
////      okButton.setActionCommand("OK");
////      submitButton.setActionCommand("Submit");
////      cancelButton.setActionCommand("Cancel");
////
////      okButton.addActionListener(new ButtonClickListener()); 
////      submitButton.addActionListener(new ButtonClickListener()); 
////      cancelButton.addActionListener(new ButtonClickListener()); 
//
//      controlPanel.add(texto_xinicial);
//      controlPanel.add(texto_a);
//      controlPanel.add(texto_c);      
//      controlPanel.add(texto_m);     
//      controlPanel.add(s);          
//
//      mainFrame.setVisible(true);  
//   }
   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         
         if( command.equals( "OK" ))  {
            statusLabel.setText("Ok Button clicked.");
         } else if( command.equals( "Submit" ) )  {
            statusLabel.setText("Submit Button clicked."); 
         } else {
            statusLabel.setText("Cancel Button clicked.");
         }  	
      }		
   }
}