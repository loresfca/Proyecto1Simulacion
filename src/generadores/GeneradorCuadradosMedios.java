package generadores;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCuadradosMedios extends Generador {
	private int semilla;
	
	public GeneradorCuadradosMedios(int semilla){		
		super(semilla);
		this.semilla=semilla;
	}
	
	public List<NumeroAleatorio> generador(int iteraciones){
		System.out.println("GENERADOR CUADRADOS MEDIOS");
		int num=this.semilla;
		int aux=0;
		int padding=8;
		String aux_num="";
		
		List<NumeroAleatorio> listaNums=new ArrayList<NumeroAleatorio>();
		
		for(int i=0;i<iteraciones;i++){
			aux_num=(int) Math.pow(num,2)+aux+"";
			while(aux_num.length()<padding){
				aux_num="0"+aux_num;
			}
			aux_num=aux_num.substring(2, aux_num.length()-2);
			num=Integer.parseInt(aux_num);
			listaNums.add(new NumeroAleatorio(num,(((double)(num))/10000.0)));
		}
		return listaNums;
	}
}
