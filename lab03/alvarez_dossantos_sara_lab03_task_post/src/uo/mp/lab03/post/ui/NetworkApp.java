package uo.mp.lab03.post.ui;

import java.util.ArrayList;

import uo.mp.lab03.post.model.Image;
import uo.mp.lab03.post.model.Post;
import uo.mp.lab03.post.model.TextMessage;
import uo.mp.lab03.post.service.SocialNetwork;

public class NetworkApp {
	
	/**
	 * Método que instancia SocialNetwork, añade varias fotos y mensajes de dos usuarios diferentes,
	 * imprime todos los post y finalmente busca e imprime los asociados a un usuario
	 */
	public void simulateClient() {
		SocialNetwork sn = new SocialNetwork();   //se instancia SocialNetwork
		Post text1 = new TextMessage("sarandonga", 900, "Me mato");
		Post text2 = new TextMessage("margarito", 100, "quiero un chai");
		Post image1 = new Image("sarandonga", 400, "image1.jpg", "Foto de kati");
		Post image2 = new Image("margarito", 500, "image2.jpg", "Foto de tete");
		sn.addPost(text1);  //se añaden dos Post de cada subclase, 1 por usuario
		sn.addPost(text2);
		sn.addPost(image1);
		sn.addPost(image2);
		sn.listAllPosts(System.out);   //se imprime la lista de todos los posts de la SocialNetwork
		ArrayList<Post> postsBySarandonga = sn.findPostsByUser("sarandonga");  //se busca los post de un usuario
		postsBySarandonga.forEach(p -> System.out.println(p.toString()));  //se imprimen los posts de ese usuario

		
	}
}
