package ar.com.codoacodomensajeria;

public class Discoduro implements IMensaje {
	public void enviar(String msj) {
		System.out.println("Grabando en HD /temp > :" + msj);
	}
}
