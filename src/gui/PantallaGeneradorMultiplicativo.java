package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import generadores.*;

public class PantallaGeneradorMultiplicativo extends JFrame{
	private static final int WIDTH = 550;
    private static final int HEIGHT = 500;
    JTextField tx = new JTextField(2);
	JTextField ta = new JTextField(2);
	JTextField tc = new JTextField(2);
	JTextField tm = new JTextField(2);
	JTextArea res= new JTextArea(2,10);
	public PantallaGeneradorMultiplicativo(){
		Container contentPane=getContentPane();
		contentPane.setBackground(new Color(255,255,255));
		setTitle("");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearContenidos();
		setVisible(true);
		//window creation
	}
	private void crearContenidos() {
		JLabel encabezado;
		JLabel x;
		JLabel a;
		JLabel c;
		JLabel m;
		JPanel panel1;
		JPanel panel2;
		JPanel panel3;
		JPanel panel4;
		JButton calc;
		panel1=new JPanel(new FlowLayout());
		panel2=new JPanel(new BorderLayout());
		panel3=new JPanel(new GridBagLayout());
		panel4=new JPanel(new FlowLayout());;
		panel2.setBackground(Color.WHITE);
		panel3.add(new JLabel(" "));
		x=new JLabel("x:");
		x.setBackground(Color.white);
		x.setFont(new Font("Arial", Font.BOLD,12));
		panel3.add(x);
		panel3.add(tx);
		
		a=new JLabel("a:");
		a.setBackground(Color.white);
		a.setFont(new Font("Arial", Font.BOLD,12));
		panel3.add(a);
		panel3.add(ta);
		
		m=new JLabel("m:");
		m.setBackground(Color.white);
		m.setFont(new Font("Arial", Font.BOLD,12));
		panel3.add(m);
		calc=new JButton("Generar números");
		panel3.add(tm);
		
		encabezado=new JLabel("<html><br<<P ALIGN=center>Generador congruencial mixto </p> <p>&nbsp;</html>");
		encabezado.setBackground(Color.white);
		encabezado.setFont(new Font("Arial", Font.BOLD,20));
		res.setLocation(20,20);
		panel4.add(panel3);
		panel4.add(calc,BorderLayout.SOUTH);
		panel2.add(panel4,BorderLayout.NORTH);
		panel2.add(res,BorderLayout.CENTER);
		panel1.add(encabezado);
		panel1.setBackground(Color.WHITE);
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		JButton back = new JButton("Regresar");
		add(back,BorderLayout.SOUTH);
		calc.addActionListener(new next());
		back.addActionListener(new back());
	}
	private class next implements ActionListener{
		public void actionPerformed(ActionEvent e){
			res.setText("");
			int x=Integer.parseInt(tx.getText());
			int a=Integer.parseInt(ta.getText());
			int m=Integer.parseInt(tm.getText());
			BeanMensajeConstructorGenerador bean= new BeanMensajeConstructorGenerador(x,a,-1,m,false);
			
			FactoryGeneradores fg= new FactoryGeneradores();
			
			Generador gcm=fg.construirGenerador(bean);		
			List<NumeroAleatorio> lna=gcm.generador(10);		
			
			for(NumeroAleatorio n: lna){
				res.append("Xi: "+n.getXi()+" || Ri: "+new DecimalFormat("#.####").format(n.getRi())+"\n");
			}	
			//Stream.of(((GeneradorCongruencialMixto) gcm).getMensajes()).forEach(this.toString());;
		}
	}
	private class back implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MenuPrincipal p=new MenuPrincipal();
			dispose();
		}
	}
}