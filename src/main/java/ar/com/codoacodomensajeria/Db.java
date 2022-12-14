package ar.com.codoacodomensajeria;

public class Db implements IMensaje {
	public void enviar(String msj) {
		System.out.println("Guardando en DB: tabla XYZ:" + msj);
	}
}
