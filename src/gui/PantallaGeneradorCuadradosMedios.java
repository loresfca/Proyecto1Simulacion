package gui;
import validador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;
import generadores.*;

public class PantallaGeneradorCuadradosMedios extends JFrame {
	private static final int WIDTH = 550;
	private static final int HEIGHT = 500;
	JTextField tx = new JTextField(6);
	JTextArea res= new JTextArea(2,10);
	Choice numAleatorios= new Choice();
	public  PantallaGeneradorCuadradosMedios(){
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
		JPanel panel1;
		JPanel panel2;
		JPanel panel3;
		JPanel panel4;
		JButton calc;
		JLabel num;
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
		/////////////////////////
		num=new JLabel(" #");
		panel3.add(num);		
		int maxNum=20;
		for(int i=0;i<maxNum;i++){
			numAleatorios.add((i+1)+"");
		}
		panel3.add(numAleatorios);
		///////////////////////

		calc=new JButton("Generar");
		encabezado=new JLabel("<html><br<<P ALIGN=center>Generador de cuadrados medios</p> <p>&nbsp;</html>");
		encabezado.setBackground(Color.white);
		encabezado.setFont(new Font("Arial", Font.BOLD,20));
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
			String[] vals=new String[1];
			vals[0]=tx.getText();
			List<String> listaErrores=Validador.hacerValidaciones(vals);	
			if(listaErrores.size()==0){
				int x=Integer.parseInt(vals[0]);
				if(x>=10000){
					JOptionPane.showMessageDialog(null,
							"No se aceptan valores mayores a 9999.",
							"ERRORES",
							JOptionPane.WARNING_MESSAGE);
				}else{
					BeanMensajeConstructorGenerador bean= new BeanMensajeConstructorGenerador(x,-1,-1,-1,false);
	
					FactoryGeneradores fg= new FactoryGeneradores();
	
					Generador gcm=fg.construirGenerador(bean);		
					int num=Integer.parseInt(numAleatorios.getSelectedItem());
					List<NumeroAleatorio> lna=gcm.generador(num);				
	
					/////				
					int i=0;
					for(NumeroAleatorio n: lna){
						String ri=new DecimalFormat("#.####").format(n.getRi());
						String valores=String.format("| %15s | %15s | %15s |\n",n.getOperacion1(), "X"+i+":"+n.getXi(), "R"+i+":"+ri);
						res.append(valores);
						i++;
					}		
					//////
				}

			}else{
				String errores="Por favor corrija los siguientes errores: \n";
				int i=1;
				for(String a: listaErrores){
					errores+=a+"\n";
				}
				JOptionPane.showMessageDialog(null,
						errores,
						"ERRORES",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private class back implements ActionListener{
		public void actionPerformed(ActionEvent e){
			MenuPrincipal p=new MenuPrincipal();
			dispose();
		}
	}
}