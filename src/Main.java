import java.util.List;
import java.util.stream.Stream;

import generadores.*;

public class Main {

	public static void main(String[] args) {
		int xinicial=37;
		int a=16;
		int c=29;
		int m=100;
		boolean esMixto=true;
				
		//bean=x,a,c,m,esmixto
		BeanMensajeConstructorGenerador x= new BeanMensajeConstructorGenerador(xinicial,a,c,m,esMixto);
		
		FactoryGeneradores fg= new FactoryGeneradores();
		
		Generador gcm=fg.construirGenerador(x);		
		List<NumeroAleatorio> lna=gcm.generador(10);		
		
		for(NumeroAleatorio n: lna){
			System.out.println("Xi: "+n.getXi()+" || Ri: "+n.getRi());
		}				
				
		Stream.of(((GeneradorCongruencialMixto) gcm).getMensajes()).forEach(System.out::println);		
	}

}
