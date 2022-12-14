package ar.com.codoacodomensajeria;

public class Mail implements IMensaje {
	public void enviar(String msj) {
		System.out.println("Enviando mail a 666@gmail.com:" + msj);
	}
}
