package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {
	JButton clineal;
	JButton cuadrados;
	JButton mixto;
	JButton multiplicativo;
	private static final int WIDTH = 500;
    private static final int HEIGHT = 350;
	public MenuPrincipal(){
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
		JPanel panel1;
		JPanel panel2;
		JPanel panel3;
		panel1=new JPanel(new FlowLayout());
		panel2=new JPanel(new FlowLayout());
		panel3=new JPanel(new GridLayout(4,1,0,0));
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.WHITE);
		//objects creation
		clineal=new JButton("Congruencia lineal");
		cuadrados=new JButton("Cuadrados medios");
		mixto=new JButton("Mixto");
		multiplicativo=new JButton("Multiplicativo");
		encabezado=new JLabel("<html><br<<P ALIGN=center>Seleccione un generador: </p> <p>&nbsp;</html>");
		encabezado.setBorder(BorderFactory.createMatteBorder(0, 0, 1 ,0, Color.GRAY));
		encabezado.setBackground(Color.white);
		encabezado.setFont(new Font("Arial", Font.BOLD,20));
		//encabezado
		panel1.add(encabezado);
		panel1.setBackground(Color.WHITE);
		add(panel1,BorderLayout.NORTH);
		panel3.add(clineal);
		panel3.add(cuadrados);
		panel3.add(mixto);
		panel3.add(multiplicativo);
		panel2.add(panel3);
		add(panel2,BorderLayout.CENTER);
		//buttons
		clineal.addActionListener(new next());
		cuadrados.addActionListener(new next());
		mixto.addActionListener(new next());
		multiplicativo.addActionListener(new next());
	}
	private class next implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==clineal){
				PantallaGeneradorCongruenciaLineal p=new PantallaGeneradorCongruenciaLineal();
				dispose();
			}
			if(e.getSource()==cuadrados){
				PantallaGeneradorCuadradosMedios p = new PantallaGeneradorCuadradosMedios();
				dispose();
			}
			if(e.getSource()==mixto){
				PantallaGeneradorMixto p = new PantallaGeneradorMixto();
				dispose();
			}
			if(e.getSource()==multiplicativo){
				PantallaGeneradorMultiplicativo p = new PantallaGeneradorMultiplicativo();
				dispose();
			}
		}
	}
}
