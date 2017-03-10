package generadores;

public class BeanMensajeConstructorGenerador {
	private int xinicial;
	private int a;
	private int c;
	private int m;
	private boolean esMixto;
	
	public BeanMensajeConstructorGenerador(int xinicial, int a, int c, int m, boolean esMixto) {
		this.xinicial = xinicial;
		this.a = a;
		this.c = c;
		this.m = m;
		this.esMixto = esMixto;
	}
	
	public int getXinicial() {
		return xinicial;
	}
	public void setXinicial(int xinicial) {
		this.xinicial = xinicial;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public boolean getEsMixto() {
		return esMixto;
	}
	public void setEsMixto(boolean esMixto) {
		this.esMixto = esMixto;
	}
	
	
}
