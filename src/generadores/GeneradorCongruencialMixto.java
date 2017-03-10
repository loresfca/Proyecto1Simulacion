package generadores;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCongruencialMixto extends Generador {

	private int xinicial;

	private int a;
	private int c;
	private int m;

	private List<Boolean> flagsCondiciones;

	public GeneradorCongruencialMixto(int xinicial, int a, int c, int m){
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

	public void checarCondiciones(){
		this.flagsCondiciones.add(checarPrimosRelativos(this.a,this.m)==1);
		this.flagsCondiciones.add(hayFactorQueDivideAmbos());
		this.flagsCondiciones.add(cuartroDivideAmbos());
	}

	//Checar primera condicion de Hull-Dobell
	public int checarPrimosRelativos(int a, int b){    
		int aux=0;
		while(b != 0){
			aux = a;
			a = b;
			b = aux%b;
		}
		return a;
	}

	//Checar segunda condicion de Hull-Dobell
	public boolean hayFactorQueDivideAmbos(){
		int aux=2;
		while(aux<=this.m){
			if(this.m%aux==0 && (this.a-1)%aux==0){
				return true;
			}
			aux++;
		}
		return false;
	}

	//Checar tercera condicion de Hull-Dobell
	public boolean cuartroDivideAmbos(){
		int aux=4;
		if(this.m%aux==0 && (this.a-1)%aux==0){
			return true;
		}
		return false;
	}



}
