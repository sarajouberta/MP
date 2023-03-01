package uo.mp.lab03.post.service.socialnetwork;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import uo.mp.lab03.post.model.Image;
import uo.mp.lab03.post.model.Post;
import uo.mp.lab03.post.model.TextMessage;
import uo.mp.lab03.post.service.SocialNetwork;

public class AddPostTest {

	/**
	 * Casos de uso:
	 * 1- Se intenta añadir un post null: salta una excepción
	 * 2- Se añade un post(Image): se añade correctamente
	 * 3- Se añade un post(TextMessage): se añade correctamente
	 * 
	 * 
	 */
	
	
	/**
	 * 1.
	 * GIVEN: Se intenta añadir un post null
	 * WHEN: sn.addPost()
	 * THEN: IlleaglArgumentExcepcion
	 */
	@Test
	public void addInvalidPost() {
		SocialNetwork sn = new SocialNetwork();
		try {
			sn.addPost(null);
			fail("Debería saltar una excepción");
		}catch(IllegalArgumentException e) {
			assertEquals("Invalid post", e.getMessage());
		}
	}
	
	/**
	 * 2.
	 * GIVEN: Se intenta añadir un post TextMessage
	 * WHEN: sn.addPost()
	 * THEN: se añade correctamente
	 */
	@Test
	public void addTextPost() {
		SocialNetwork sn = new SocialNetwork();
		Post text1 = new TextMessage("sarandonga", 900, "Me mato");
		Post text2 = new TextMessage("sarandonga", 100, "quiero un chai");
		sn.addPost(text1);
		sn.addPost(text2);
		ArrayList<Post> posts = sn.getPostsForTesting();
		assertEquals(2, posts.size());
		posts.forEach(p -> {
			assertEquals(p.getUser(), "sarandonga");
		});
	}
	
	/**
	 * 3.
	 * GIVEN: Se intenta añadir un post Image
	 * WHEN: sn.addPost()
	 * THEN: se añade correctamente
	 */
	@Test
	public void addImagePost() {
		SocialNetwork sn = new SocialNetwork();
		Post image1 = new Image("sarandonga", 400, "image1.jpg", "Foto de kati");
		Post image2 = new Image("sarandonga", 500, "image2.jpg", "Foto de tete");
		sn.addPost(image1);
		sn.addPost(image2);
		ArrayList<Post> posts = sn.getPostsForTesting();
		assertEquals(2, posts.size());
		//for each para cada elemento de posts:  obtiene el usuario y comprueba que es del usuario que lo añadió
		posts.forEach(p -> {                         
			assertEquals(p.getUser(), "sarandonga");
		});
	}
}
