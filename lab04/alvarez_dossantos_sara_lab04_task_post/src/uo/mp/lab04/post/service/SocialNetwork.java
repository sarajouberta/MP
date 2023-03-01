package uo.mp.lab04.post.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab04.post.model.Image;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;

public class SocialNetwork {
	
	private ArrayList<Post> posts = new ArrayList<Post>();  //para no tener que crear un constructor que solo inicialice la lista de posts
	
	
	/**
	 * Método que añade una publicación a la lista de SocialNetwork
	 * @param post publicación a añadir 
	 */
	public void addPost(Post post) {
		ArgumentChecks.isTrue(post != null, "Invalid post");
		this.posts.add(post);
	}
	
	/**
	 * Devuelve lista de publicaciones de un usuario. Si no tiene, se devuelve vacío.
	 * @param user usuario del que se mostrarán las publicaciones
	 * @return lista con las publicaciones del usuario
	 */
	public ArrayList<Post> findPostsByUser(String user){
		ArgumentChecks.isTrue(user != null && !user.isBlank(), "Invalid user");
		//posts.stream().filter(p -> p.getUser().equals(user))
		ArrayList<Post> postsUser = new ArrayList<Post>();   //araylist auxuliar para devolver las pblicaciones del usuario
		for (int i = 0; i < posts.size(); i++) {
			if(posts.get(i).getUser().equals(user)) {   //si el post tiene el usuario buscado
				postsUser.add(posts.get(i));
			}
		}
		return postsUser;
	}
	
	/**
	 * Imprime todas las publicaciones de la red social, según el parámetro PrintStream
	 * @param out muestra por consola el contenido de posts
	 */
	public void listAllPosts(PrintStream out) {
		//for-each del arrayList: para cada elemento de posts, imprime su contenido
		posts.forEach(p -> out.println(p.toString()));
	}
	

	/*
	 * Como es un método para debug, no hago copia de los post, sino que devuelvo el original.
	 */
	public ArrayList<Post> getPostsForTesting() {
		return posts;
	}
	
	/**
	 * Método que devuelve una lista con cadenas de publicaciones en formato HTML.
	 *
	 * @return lista de cadenas
	 */
	public List<String> toHtmlFormat() {
		List<String> listHtml = new ArrayList<String>(); //lista auxiliar para devolver las cadenas HTML
			for(Post post : posts) {
				listHtml.add(post.toHtmlFormat());
			}
		return listHtml;
	}
}
