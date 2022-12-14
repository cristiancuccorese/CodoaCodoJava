package ar.com.codoacodo.herencia;

public class PlayStation extends Consola {
	
	private int version;
	
	public PlayStation(int version) {
		//invocar al constructor del padre		
		super(1024,"Playstation");
		this.version = version;
	}
	public int getversion() {
		return this.version;
	}
	
}
