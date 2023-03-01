package uo.mp.lab04.post.ui;

import java.util.ArrayList;
import java.util.List;

import uo.mp.lab04.post.model.Image;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;
import uo.mp.lab04.post.service.SocialNetwork;

public class NetworkApp {
	
	/**
	 * Método que instancia SocialNetwork, añade varias fotos y mensajes de dos usuarios diferentes,
	 * imprime todos los post y finalmente busca e imprime los asociados a un usuario.
	 * Se añade que imprima la lista de códigos HTML
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
		System.out.println("Todos los posts:");
		sn.listAllPosts(System.out);   //se imprime la lista de todos los posts de la SocialNetwork
		System.out.println("Posts en formato HTML:");
		List<String> listToHtml = sn.toHtmlFormat();
		for (int i = 0; i < listToHtml.size(); i++) {
			System.out.println(listToHtml.get(i)); 
		}
		System.out.println("Posts del usuario sarandonga:");
		ArrayList<Post> postsBySarandonga = sn.findPostsByUser("sarandonga");  //se busca los post de un usuario
		postsBySarandonga.forEach(p -> System.out.println(p.toString()));  //se imprimen los posts de ese usuario
		
	}
}
