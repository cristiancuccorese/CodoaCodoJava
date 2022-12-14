package ar.com.codoacodomensajeria;

public class SMS implements IMensaje {
	public void enviar(String msj) {
		System.out.println("Enviando sms a 11222333445566:" + msj);
	}
}
