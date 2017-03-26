package validador;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Validador {
	private Validador(){}	

	public static List<String> esVacio(String[] s){
		List<String> errores= new ArrayList<String>();
		for(String x:s){
			if(x.length()==0){
				errores.add("No se aceptan valores vacíos en los campos");
				break;
			}
		}
		return errores;
	}

	public static List<String> esPositivo(String[] s){	
		List<String> errores= new ArrayList<String>();		
		for(String x:s){
			if(Integer.parseInt(x)<0){
				errores.add("El valor '"+x+"' no puede ser negativo.");
			}
		}
		return errores;
	}

	public static List<String> esNumero(String[] s){
		List<String> errores= new ArrayList<String>();
		for(String x:s){
			char[] arr=x.toCharArray();
			for (char c:arr){
				if(c!='-'){
					if(!Character.isDigit(c) ){
						errores.add("¡El texto '"+x+"' no es un número entero no negativo!.");
						break;
					}
				}				
			}						
		}
		return errores;		
	}

	public static List<String> hayOverflow(String[] s){
		List<String> errores= new ArrayList<String>();
		BigInteger a1=null;
		BigInteger b1=new BigInteger(Integer.MAX_VALUE+"");
		for(String x:s){		
			a1=new BigInteger(x);					
			int res=a1.compareTo(b1);
			if(res>0){
				errores.add("El valor "+x+" excede el máximo permitido (2^31-1)");
			}
		}
		return errores;
	}

	public static List<String> hacerValidaciones(String[] s){
		List<String> errores= new ArrayList<String>();
		errores=esVacio(s);
		if(errores.size()==0){			
			errores=esNumero(s);
			if(errores.size()==0){
				errores=hayOverflow(s);				
				if(errores.size()==0){
					errores=esPositivo(s);
					if(errores.size()==0){
						return errores;
					}
				}
			}
		}		
		return errores;
	}

}
