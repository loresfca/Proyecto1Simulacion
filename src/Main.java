import java.util.List;

import generadores.*;

public class Main {

	public static void main(String[] args) {
		int xinicial=117;
		int a=43;
		int c=-1;
		int m=1000;
		boolean esMixto=false;
				
		//bean=x,a,c,m,esmixto
		BeanMensajeConstructorGenerador x= new BeanMensajeConstructorGenerador(xinicial,a,c,m,esMixto);
		
		FactoryGeneradores fg= new FactoryGeneradores();
		
		Generador gcm=fg.construirGenerador(x);
		
		List<NumeroAleatorio> lna=gcm.generador(10);
		
		for(NumeroAleatorio n: lna){
			System.out.println("Xi: "+n.getXi()+" || Ri: "+n.getRi());
		}
		
	}

}
