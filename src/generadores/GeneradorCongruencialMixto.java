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
			String op1= "("+a+"⋅"+xinicial+" + "+c+")mod"+m;
			String op2= ((a*xinicial)+c)+"mod"+m;					
			listaNums.add(new NumeroAleatorio(x,(double)(x)/(double)(m),op1,op2));
			xinicial=x;
			x=(a*xinicial+c)%m;			
		}


		return listaNums;
	}

	public void checarCondiciones(){
		System.out.println(this.a);
		System.out.println(checarPrimosRelativos(this.c,this.m)==1);
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
			if(!flagsCondiciones.get(0)){
				mensajes.add("Los números c="+this.c+" y m="+this.m+" no son primos relativos.");
			}
			if(!flagsCondiciones.get(1)){
				mensajes.add("No hay un factor 'q' que divida tanto a 'a-1'="+(this.a-1)+" como a 'm'="+this.m+".");
			}
			if(!flagsCondiciones.get(2)){
				mensajes.add("El número 4 no divide tanto a 'a-1'="+(this.a-1)+" como a 'm'="+this.m+".");
			}
		}
	}

	public String generarRecomendaciones(){
		int x=this.a;
		int y=this.m;
		int z=this.c;
		if(y<4){
			y=4;
		}
		if(x<4){
			x=4;
		}
		while(y%4!=0){
			y++;
		}
		while((x-1)%4!=0){
			x++;
		}		
		if(x>y){
			y+=10;
		}
		int dif=0;
		while(checarPrimosRelativos(z,y)!=1 || !hayFactorQueDivideAmbos2(x,y) || !cuartroDivideAmbos2(x,y)){
			z++;			
			y++;
			dif++;
			if(dif>2000){
				break;
			}
		}		
		return x+" "+y+" "+z;
	}

	//Checar primera condicion de Hull-Dobell
	public int checarPrimosRelativos(int a, int b){    
		if(a==0||b==0){
			return 0;
		}
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
	
	public boolean hayFactorQueDivideAmbos2(int x, int y){
		int aux=2;
		while(aux<=y){
			if(y%aux==0 && (x-1)%aux==0){
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
	
	public boolean cuartroDivideAmbos2(int x, int y){
		int aux=4;
		if(y%aux==0 && (x-1)%aux==0){
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
