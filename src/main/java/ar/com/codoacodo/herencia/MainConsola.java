package ar.com.codoacodo.herencia;

public class MainConsola {

	public static void main(String[] args) {

		// invocar un metodo estatico
		Consola[] listado = Vendedor.listado();

		//recorro el listado
		for(Consola c : listado) {
			System.out.println(c.getClass().getName());
			c.getDatos();
			//todos los hijos tienen metodo getdatos
		
		}
	}

}
