package generadores;

import java.util.ArrayList;
import java.util.List;

public class GeneradorMultiplicativo  extends Generador{
	
	private int xinicial;	
	private int a;
	private int m;
	
	public GeneradorMultiplicativo(int xinicial, int a, int m){
		super(xinicial);
		this.xinicial=xinicial;
		this.a=a;
		this.m=m;
	}
	
	public List<NumeroAleatorio> generador(int iteraciones){
		System.out.println("GENERADOR MULTIPLICATIVO: x="+xinicial+" a="+a+" m="+m);
		int x=(a*xinicial)%m;
		
		List<NumeroAleatorio> listaNums=new ArrayList<NumeroAleatorio>();
		
		listaNums.add(new NumeroAleatorio(x,(double)(x)/(double)(m)));
		
		for(int i=0;i<iteraciones-1;i++){						
			xinicial=x;
			x=(a*xinicial)%m;
			listaNums.add(new NumeroAleatorio(x,(double)(x)/(double)(m)));
		}
		return listaNums;
	}
}

