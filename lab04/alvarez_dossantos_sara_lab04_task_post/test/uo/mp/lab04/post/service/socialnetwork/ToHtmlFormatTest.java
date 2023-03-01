package uo.mp.lab04.post.service.socialnetwork;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import uo.mp.lab04.post.model.Image;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;
import uo.mp.lab04.post.service.SocialNetwork;

public class ToHtmlFormatTest {
	
	/**
	 * Casos de uso:
	 * 1- SocialNetwork tiene publicaciones: se devuelve lista de sus posts en formato HTML
	 * 2- SocialNetwork no tiene publicaciones: se devuelve lista vacía
	 * 3- SocialNetwork solo tiene posts Image: se devuelve la lista de sus posts en formato HTML
	 * 4- SocialNetwork solo tiene posts TextMessage: se devuelve la lista de sus posts en formato HTML
	 */
	
	/**
	 * 1.
	 * GIVEN SocialNetWOrk tiene publicaciones
	 * WHEN toHtmlFormat()
	 * THEN devuelve una lista de cadenas (cada post en formato HTML)
	 */
	@Test
	public void toHtmlFormatWithPosts() {
		SocialNetwork sn = new SocialNetwork();
		Post text1 = new TextMessage("Tecnomaga", 900, "Me mato x2");
		Post image1 = new Image("Tecnomaga", 400, "image1.jpg", "Foto de Kati");
		sn.addPost(text1);
		sn.addPost(image1);
		List<String> aux = sn.toHtmlFormat();
		assertEquals(2, aux.size()); //se comprueba que la lista devuelta tiene los posts de sn
		assertEquals("<p> Me mato x2 </p>", aux.get(0));  //se comprueba que el contenido esperado es igual al real
		assertEquals("<img src =image1.jpg> Foto de Kati </img>", aux.get(1));  //se comprueba que el contenido esperado es igual al real
	}
	
	/**
	 * 2.
	 * GIVEN SocialNetWOrk no tiene publicaciones
	 * WHEN toHtmlFormat()
	 * THEN devuelve una lista vacía
	 */
	@Test
	public void toHtmlFormatWithoutPosts() {
		SocialNetwork sn = new SocialNetwork();
		assertEquals(0, sn.toHtmlFormat().size()); //se comprueba que el método devuelve una lista vacía
	}
	
	
	/**
	 * 3.
	 * GIVEN SocialNetWOrk solo tiene Image
	 * WHEN toHtmlFormat()
	 * THEN devuelve una lista de cadenas en formato HTML
	 */
	@Test
	public void toHtmlFormatWithImagePost() {
		SocialNetwork sn = new SocialNetwork();
		Post image1 = new Image("Tecnomaga", 400, "image1.jpg", "Foto de Kati");
		sn.addPost(image1);
		List<String> aux = sn.toHtmlFormat();
		assertEquals(1, aux.size()); //se comprueba que la lista devuelta tiene los posts de sn
		assertEquals("<img src =image1.jpg> Foto de Kati </img>", aux.get(0));  //se comprueba que el contenido esperado es igual al real
	}
	
	/**
	 * 4.
	 * GIVEN SocialNetWOrk tiene publicaciones TextMessage
	 * WHEN toHtmlFormat()
	 * THEN devuelve una lista de cadenas en formato HTML
	 */
	@Test
	public void toHtmlFormatWithTextMessagePost() {
		SocialNetwork sn = new SocialNetwork();
		Post text1 = new TextMessage("Tecnomaga", 900, "Me mato x2");
		sn.addPost(text1);
		List<String> aux = sn.toHtmlFormat();
		assertEquals(1, aux.size()); //se comprueba que la lista devuelta tiene los posts de sn
		assertEquals("<p> Me mato x2 </p>", aux.get(0));  //se comprueba que el contenido esperado es igual al real
	}
	
	
	
	
	
}
