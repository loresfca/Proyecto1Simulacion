package generadores;

public class FactoryGeneradores {

	public FactoryGeneradores(){}

	public Generador construirGenerador(BeanMensajeConstructorGenerador bean){
		if(bean== null){
			return null;
		}		
		if(bean.getA()>0 && bean.getC()>0 && bean.getEsMixto()==false){
			System.out.println("Generador cong. lineal");
			return new GeneradorCongruenciaLineal(bean.getXinicial(),bean.getA(),bean.getC(),bean.getM());

		} else if(bean.getXinicial()>0 && bean.getM()<0){
			System.out.println("Generador cuadrados");
			return new GeneradorCuadradosMedios(bean.getXinicial());

		} else if(bean.getC()<0){
			System.out.println("Generador multip");
			return new GeneradorMultiplicativo(bean.getXinicial(),bean.getA(),bean.getM());

		} else if(bean.getA()>0 && bean.getM()>0 && bean.getEsMixto()==true){
			System.out.println("Generador mixto");
			return new GeneradorCongruencialMixto(bean.getXinicial(),bean.getA(),bean.getC(),bean.getM());
		}

		return null;
	}

}
