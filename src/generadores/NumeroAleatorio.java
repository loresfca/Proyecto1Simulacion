package generadores;

public class NumeroAleatorio {
	private int xi;
	private double ri;
	private String operacion1;
	private String operacion2;
	
	public NumeroAleatorio(int xi, double ri, String op1, String op2){
		this.xi=xi;
		this.ri=ri;		
		this.operacion1=op1;
		this.operacion2=op2;
	}
	
	public String getOperacion1() {
		return operacion1;
	}

	public void setOperacion1(String operacion1) {
		this.operacion1 = operacion1;
	}

	public String getOperacion2() {
		return operacion2;
	}

	public void setOperacion2(String operacion2) {
		this.operacion2 = operacion2;
	}

	public int getXi() {
		return xi;
	}

	public void setXi(int xi) {
		this.xi = xi;
	}

	public double getRi() {
		return ri;
	}

	public void setRi(double ri) {
		this.ri = ri;
	}
}
