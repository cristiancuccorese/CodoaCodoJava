package ar.com.codoacodo.buscador;

import javax.naming.PartialResultException;

public class MainBuscador {

	public static void main(String[] args) {
	
		//quiero crear un objeto de tipo Buscador
		//crear una instancia de Buscador
		
		//creo mi primer objeto
		Buscador miBuscador = new Buscador();
		
		//"pongo" la clave que quiero buscar
		miBuscador.setClaveBusqueda("iron man");
		
		//ejecutar la busqueda????
		miBuscador.buscar();
		
		// res no es un atributo, sino una variable 
		//que guarda el resultado de invocar al metodo
		//buscar del objeto miBuscador (es una instancia
		//de la clase buscador)
		Articulo[] res = miBuscador.getResultados();
	
		//como recorro un array?
		for(Articulo unArticulo : res) {
			unArticulo.detalle();
		}
	}

}
