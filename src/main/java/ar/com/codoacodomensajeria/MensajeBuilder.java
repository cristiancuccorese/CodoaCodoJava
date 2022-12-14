package ar.com.codoacodomensajeria;

public  class MensajeBuilder {
	//metodo de clase, no de intancia
	//no necesito crear un objeto de la clase para usar el metodo
	public static IMensaje buildMensaje(String destino) {
		
		IMensaje msj;
		
		switch (destino) {
		case "A":
			msj = new SMS();
			break;
		case "B":
			msj = new Db();
			break;
		case "C":
			msj = new Mail();
			break;
		case "D":
			msj = new Discoduro();
			break;

		default:
			msj = null;
			System.out.println("No esxite implementacion para " + destino);
		}
		return msj;
	}

}
