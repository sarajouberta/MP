package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public class Book extends Item implements Borrowable {

    private String author;
    private String publisher;
    private String isbn;
    private boolean isAvailable;

    /**
     * Book constructor
     * 
     * @param title
     * @param author
     * @param publisher
     * @param isbn
     * @param basePrice
     */
    public Book(String title, String author, String publisher, String isbn, double basePrice) {
	super(title, basePrice);
	setAuthor(author);
	setPublisher(publisher);
	setIsbn(isbn);
	isAvailable = false; // por defecto prestable (por defecto ownIt = false)
    }

    /**
     * 
     * @param out
     */
    public void print(PrintStream out) {
	out.println("Book: " + getTitle());
	out.println("Author: " + getAuthor());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
	out.println("ISBN: " + getIsbn());
    }

    @Override
    public void print() {
	print(System.out);

    }

    @Override
    public String getResponsable() {
	return this.author;
    }

    @Override
    public boolean isLike(Item item) {
	if (item instanceof Book) {
	    Book book = (Book) item;
	    if (this.getTitle()
		.equals(book.getTitle())
		    && this.getAuthor()
			.equals(book.getAuthor())) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Dos libros son iguales cuando tienen el mismo título e ISBN
     * 
     * @param item a comparar
     */
    @Override
    public boolean equals(Object item) {
	if (!(item instanceof Book)) { // caso en el que sí se puede utilizar instanceof: cast-down
	    return false;
	} else {
	    if (this.getTitle()
		.equals(((Book) item).getTitle())
		    && this.getIsbn()
			.equals(((Book) item).getIsbn())) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("Book: ");
	str.append(this.getTitle());
	str.append(" Author: ");
	str.append(this.getAuthor());
	str.append(" ISBN: ");
	str.append(this.getIsbn());
	str.append(" Publisher: ");
	str.append(this.getPublisher());

	return str.toString();
    }

    @Override
    public double getFinalPrice() {
	double finalPrice = this.getBasePrice() + (this.getBasePrice() * 0.04); // se suma el 4% al precio base
	return finalPrice;
    }

    /**
     * @return the author
     */
    private String getAuthor() {
	return author;
    }

    /**
     * @param author the author to set
     */
    private void setAuthor(String author) {
	ArgumentChecks.isTrue(author != null && !author.isBlank(), "Invalid author");
	this.author = author;
    }

    /**
     * @return the editorial
     */
    private String getPublisher() {
	return publisher;
    }

    /**
     * @param editorial the editorial to set
     */
    private void setPublisher(String publisher) {
	ArgumentChecks.isTrue(publisher != null && !author.isBlank(), "Invalid publisher");
	this.publisher = publisher;
    }

    /**
     * @return the isbn
     */
    private String getIsbn() {
	return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    private void setIsbn(String isbn) {
	ArgumentChecks.isTrue(publisher != null && !author.isBlank(), "Invalid ISBN");
	this.isbn = isbn;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
    }

    /**
     * Un libro está disponible si lo tienes y está disponible
     * 
     * @return isAvailable
     */
    @Override
    public boolean isAvailable() {
	return isAvailable && this.getOwn();
    }

    @Override
    public void borrow() {
	isAvailable = false;
    }

    @Override
    public void giveBack() {
	isAvailable = true;
    }

}
