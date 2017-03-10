package generadores;

import java.util.List;

public class Generador implements MetodosGeneradores{
	private int semilla;
	
	public Generador(int semilla){
		this.semilla=semilla;
	}

	public int getSemilla() {
		return semilla;
	}

	public void setSemilla(int semilla) {
		this.semilla = semilla;
	}

	@Override
	public List<NumeroAleatorio> generador(int iteraciones) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
