package ar.com.codoacodo.idiomas;

public class Persona implements IHablar{
	private String nombre;
	private String idioma;
	
	private String[] otrosIdiomas;
	public Persona(String nombre, String idioma) {
		this.nombre = nombre;
		this.idioma = idioma;
		this.otrosIdiomas = new String[0];
	}

	//ctrl+space
	public void hablar() {
		System.out.println(this.nombre  + "sabe hablar: ");
		System.out.println(this.idioma);
		for(String idioma : this.otrosIdiomas) {
			System.out.println(idioma);
		}
	}
	
	public void decir(String palabra, String idioma) {

		if (this.idioma == idioma) {
			System.out.println(this.nombre + " dice: " + palabra);
		} else {
			System.out.println(this.nombre + " no sabe decir " +palabra + " en " + idioma);
		}

	}
	
	public void aprender(String idioma) {
		
  		if(!this.idioma.equals(idioma)) {//f6 f7
			//ver si existe en el array de otrosIdiomas
			if(hablaEsteIdioma(idioma)) {//f6
				System.out.println(this.nombre + " ya habla " + idioma.toUpperCase());
			}else {
				System.out.println(this.nombre + " aprede "+ idioma);
				this.otrosIdiomas = copiarIdiomas(idioma);
			}
		}else {
			System.out.println(this.nombre + " ya habla " + idioma.toUpperCase());
		}
	}

	private String[] copiarIdiomas(String idioma) {
		//agregarlo a la lista!!!!
		String [] aux = new String[this.otrosIdiomas.length + 1];//[ ,]
		for(int i=0;i < this.otrosIdiomas.length;i++) {
			aux[i] = this.otrosIdiomas[i];
		}
		//al final de nuevo array aux, agrego  el idioma que aprende
		aux[aux.length - 1] = idioma;
		return aux;
	}

	private boolean hablaEsteIdioma(String idioma) {	
		boolean existe = false;
		for(int i=0;!existe && i<this.otrosIdiomas.length;i++) {
			existe = this.otrosIdiomas[i].equals(idioma);//true|false				
		}
		return existe;
	}
	
}// ctrl+sfhit+f