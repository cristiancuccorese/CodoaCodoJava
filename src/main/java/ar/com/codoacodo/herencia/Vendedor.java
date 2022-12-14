package ar.com.codoacodo.herencia;

public class Vendedor {

	public static Consola[] listado() {
		//Consola c = new Consola();

		PlayStation p1 = new PlayStation(1);
		var nw = new NintendoSwitch();
		var sg = new SegaGenesis();
		var xbox360 = new Xbox360();
	
		
		Consola[] listado = new Consola[] {p1,nw,sg,xbox360};
		
		//listado[0] = c;
		listado[0] = p1;
		listado[1] = nw;
		listado[2] = sg;
		listado[3] = xbox360;
		
		return listado;
	}
}
