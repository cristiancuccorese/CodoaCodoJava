package ar.com.codoacodo.herencia;

//clase abstracta no se puede instanciar
public abstract class Consola {
	protected int bit;
	private String name;

	public Consola(int bit, String name) {
		this.bit = bit;
		this.name = name;
	}

	public int getBit() {
		return this.bit;
	}

	public String getName() {
		return name;
	}
	public String getDatos(){
       
        return this.getName() + " - " + String.valueOf(this.getBit());
        
    }



}

