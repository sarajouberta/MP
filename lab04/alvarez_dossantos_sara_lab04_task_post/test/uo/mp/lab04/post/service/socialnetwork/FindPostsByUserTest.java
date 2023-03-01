package uo.mp.lab04.post.service.socialnetwork;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uo.mp.lab04.post.model.Image;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;
import uo.mp.lab04.post.service.SocialNetwork;



public class FindPostsByUserTest {
	
	SocialNetwork sn;   
	
	/**
	 * Se establece al inicio de los tests un SocialNetwork con elementos para no tener que añadirlos en
	 * cada test, de tipo Image y TextMessage
	 */
	@Before
	public void setUp() {
		sn = new SocialNetwork();
		Post text1 = new TextMessage("sarandonga", 900, "Me mato");
		Post text2 = new TextMessage("margarito", 100, "quiero un chai");
		Post image1 = new Image("sarandonga", 400, "image1.jpg", "Foto de kati");
		Post image2 = new Image("margarito", 500, "image2.jpg", "Foto de tete");
		sn.addPost(text1);
		sn.addPost(text2);
		sn.addPost(image1);
		sn.addPost(image2);
	}
	
	/**
	 * Casos de uso:
	 * 1- se intenta buscar un usuario null: salta una excepción
	 * 2- se busca un usuario válido que tiene posts: devuelve correctamente la lista con sus posts
	 * 3- se busca un usuario válido que no tiene posts: devuelve un array vacío
	 * 
	 */
	
	
	/**
	 * 1: se intenta buscar un usuario null
	 */
	@Test
	public void findInvalidUser() {
		try {
			sn.findPostsByUser(null);
			fail("Debería saltar una excepción");
		}catch(Exception e) {
			assertEquals("Invalid user", e.getMessage());
		}
		
	}
	
	/**
	 * 2: se intenta buscar un usuario válido que tiene posts
	 */
	@Test
	public void findValidUserWithPosts() {
		ArrayList<Post> posts = sn.findPostsByUser("margarito");
		assertEquals(2, posts.size());
	}

	/**
	 * 3: se busca un usuario válido que no tiene posts
	 */
	@Test
	public void findValidUserWithoutPosts() {
		ArrayList<Post> posts = sn.findPostsByUser("juan");
		assertEquals(0, posts.size());
	}




}
