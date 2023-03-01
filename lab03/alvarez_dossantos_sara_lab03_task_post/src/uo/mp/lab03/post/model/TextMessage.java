package uo.mp.lab03.post.model;

import uo.mp.lab.util.check.ArgumentChecks;

public class TextMessage extends Post {
	
	private String message;
	
	/**
	 * Constructor de la clase TexteMessage.
	 * @param user usuario que publica el TextMessage
	 * @param likes número de likes
	 * @param message mensaje 
	 */
	public TextMessage(String user, int likes, String message) {
		super(user, likes);
		setMessage(message);
	}

	/**
	 * 
	 * @return el mensaje
	 */
	private String getMessage() {
		return message;
	}

	/**
	 * Establede el mensaje
	 * @param message
	 */
	private void setMessage(String message) {
		ArgumentChecks.isTrue(message != null, "Invalid message");  //se valida el parámetro
		this.message = message;
	}
	
	/**
	 * Convierte a String los atributos del objeto TextMessage con el formato:
	 * TEXT MESSAGE Posted by: Descartes Content: Pienso, luego existo.
	 */
	@Override
	public String toString() {
		String str = "TEXT MESSAGE posted by: " + this.getUser() + " Content: " + this.getMessage();
		return str;
	}
	
	
}
