package uo.mp.lab04.post.model;

import java.util.ArrayList;
import java.util.Collections;

import uo.mp.lab.util.check.ArgumentChecks;

public abstract class Post {

	private String user;
	protected int likes;
	private ArrayList<String> comments;
	
	/**
	 * Constructor por defecto de la clase Post
	 * @param user usuario
	 * @param likes likes de la publicación
	 */
	public Post(String user, int likes) {
		setUser(user);
		setLikes(likes);
		comments = new ArrayList<>();
	}
	
	/**
	 * Método que añade comentarios al objeto Post
	 * @param comment comentario a añadir 
	 */
	public void addComments(String comment) {
		ArgumentChecks.isTrue(comment != null && !comment.isBlank(), "Invalid comment");
		comments.add(comment);
	}
	
	
	/**
	 * Devuelve el usuario de la publicación
	 * @return usuario
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Establece el usuario de la publicación
	 * @param user
	 */
	private void setUser(String user) {
		ArgumentChecks.isTrue(user != null && !user.isBlank(), "Invalid user");
		this.user = user;
	}

	/**
	 * Devuelve el número de likes de la publicación
	 * @return valor de likes
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * PUBLIC? Establece el número de likes de la publicación
	 * @param likes el número de likes
	 */
	public void setLikes(int likes) {       
		ArgumentChecks.isTrue(likes >= 0, "Invalid number of likes");
		this.likes = likes;
	}

	/**
	 * Devuelve copia del arrayList de comentarios de una publicación
	 * @return commenstCopy arraylist copia de los comentarios de la publicación
	 */
	public ArrayList<String> getComments() {
		//¿copia arrayList?
		
		ArrayList<String> commentsCopy = new ArrayList<String>();
		Collections.copy(commentsCopy, comments);
		//for (int i = 0; i < comments.size(); i++) {
			//commentsCopy.add(comments.get(i));
		//}
		return commentsCopy;
	}

	/**
	 * Método que devuelve el formato HTML de cada Post:
	 */
	public abstract String toHtmlFormat();
	
	
//	/**
//	 * Establece array de comentarios en una publicación
//	 * @param comments arrayList de comentarios
//	 */
//	private void setComments(ArrayList<String> comments) {
//		ArgumentChecks.isTrue(comments != null, "Invalid arrayList of comments");
//		this.comments = comments;
//	}
	
	

}
