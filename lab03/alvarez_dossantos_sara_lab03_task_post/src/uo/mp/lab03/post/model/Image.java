package uo.mp.lab03.post.model;

import uo.mp.lab.util.check.ArgumentChecks;

public class Image extends Post {
	
	private String filename;
	private String caption;
	
	/**
	 * Constructor de la clase Image
	 * @param user usuario que crea la imagen
	 * @param likes número de likes de la imagen
	 * @param filename nombre del archivo donde se encuentra
	 * @param caption pie de foto
	 */
	public Image(String user, int likes, String filename, String caption) {
		super(user, likes);
		setFilename(filename);
		setCaption(caption);
		
	}
	
	
	/**
	 * 
	 * @return el archivo de la imagen
	 */
	private String getFilename() {
		return filename;
	}
	
	/**
	 * 
	 * @param filename el archivo donde se encuentra la imagen
	 */
	private void setFilename(String filename) {
		ArgumentChecks.isTrue(filename != null && !filename.isBlank(), "Invalid filename");
		this.filename = filename;
	}
	
	/**
	 * 
	 * @return el pie de foto
	 */
	private String getCaption() {
		return caption;
	}
	
	/**
	 * Establece el pie de foto de una imagen
	 * @param caption el pie de foto a establecer
	 */
	private void setCaption(String caption) {
		ArgumentChecks.isTrue(filename != null, "Invalid caption");
		this.caption = caption;
	}


	/**
	 * Convierte a String los atributos del objeto Image con el formato:
	 * PHOTO posted by: maria1999, File: gatos.jpg, Caption: Gatos divertidos
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("PHOTO posted by: ");
		str.append(this.getUser());
		str.append(", File: ");
		str.append(this.getFilename());
		str.append(", Caption: ");
		str.append(this.getCaption());
		return str.toString();
	}
	

}
