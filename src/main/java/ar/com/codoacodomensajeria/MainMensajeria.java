package ar.com.codoacodomensajeria;

public class MainMensajeria {

	public static void main(String[] args) {

		String mensajeAEnviar = "aprendiendo interfaces";

		String destino = "B";
						
		IMensaje msj = MensajeBuilder.buildMensaje(destino);

		
		if (msj != null) {
			msj.enviar(mensajeAEnviar);
		}else {
			System.out.println("Error enviando msj");
		}
	}
}
