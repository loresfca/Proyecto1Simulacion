package generadores;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCongruencialMixto extends Generador {

	private int xinicial;

	private int a;
	private int c;
	private int m;
	private List<String> mensajes= new ArrayList<String>();
	private List<Boolean> flagsCondiciones= new ArrayList<Boolean>();

	public GeneradorCongruencialMixto(int xinicial, int a, int c, int m){
		super(xinicial);
		this.xinicial=xinicial;
		this.a=a;
		this.c=c;
		this.m=m;
	}

	public List<NumeroAleatorio> generador(int iteraciones){
		System.out.println("GENERADOR CONGRUENCIA MIXTO: x="+xinicial+" a="+a+" c="+c+" m="+m);
		int x=(a*xinicial+c)%m;
		
		generarMensajes();

		List<NumeroAleatorio> listaNums=new ArrayList<NumeroAleatorio>();

		for(int i=0;i<iteraciones-1;i++){			
			listaNums.add(new NumeroAleatorio(x,(double)(x)/(double)(m)));
			xinicial=x;
			x=(a*xinicial+c)%m;			
		}

		return listaNums;
	}

	public void checarCondiciones(){
		System.out.println(this.a);
		System.out.println(checarPrimosRelativos(this.a,this.m)==1);
		this.flagsCondiciones.add(checarPrimosRelativos(this.a,this.m)==1);
		this.flagsCondiciones.add(hayFactorQueDivideAmbos());
		this.flagsCondiciones.add(cuartroDivideAmbos());		
	}

	public void generarMensajes(){
		checarCondiciones();
		boolean flagHayFalsos=false;
		for(Boolean v: flagsCondiciones){
			if(!v){
				flagHayFalsos=true;
				break;
			}
		}
		
		if(flagHayFalsos){
			mensajes.add("El generador congruencial mixto no tendrá un período completo debido a las siguientes razones:");			
			if(!flagsCondiciones.get(0)){
				mensajes.add("Los números a="+this.a+" y m"+this.m+"no son primos relativos.");
			}
			if(!flagsCondiciones.get(1)){
				mensajes.add("No hay un factor 'q' que divida tanto a 'a'="+this.a+" como a 'm'="+this.m+".");
			}
			if(!flagsCondiciones.get(2)){
				mensajes.add("El número 4 no divide tanto a 'a'="+this.a+" como a 'm'="+this.m+".");
			}
		}
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

	public List<String> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}

	public List<Boolean> getFlagsCondiciones() {
		return flagsCondiciones;
	}

	public void setFlagsCondiciones(List<Boolean> flagsCondiciones) {
		this.flagsCondiciones = flagsCondiciones;
	}

	


}
