package generadores;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCongruenciaLineal extends Generador{
	
	private int xinicial;
	
	private int a;
	private int c;
	private int m;
	
	public GeneradorCongruenciaLineal(int xinicial, int a, int c, int m){
		super(xinicial);
		this.xinicial=xinicial;
		this.a=a;
		this.c=c;
		this.m=m;
	}
	
	public List<NumeroAleatorio> generador(int iteraciones){
		System.out.println("GENERADOR CONGRUENCIA LINEAL: x="+xinicial+" a="+a+" c="+c+" m="+m);
		int x=(a*xinicial+c)%m;
		
		List<NumeroAleatorio> listaNums=new ArrayList<NumeroAleatorio>();
		
		for(int i=0;i<iteraciones-1;i++){			
			listaNums.add(new NumeroAleatorio(x,(double)(x)/(double)(m)));
			xinicial=x;
			x=(a*xinicial+c)%m;			
		}
		
		return listaNums;
	}
}
