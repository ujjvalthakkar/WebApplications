package com.neu.ujjval.pojo;

public class Book {
	private long id;
	private String isbn;
	private String title;
	private String authors;
	private float price;

	public Book() {
	}
	public Book(String isbn,String title,String authors,float price) {
		this.isbn=isbn;
		this.title=title;
		this.authors=authors;
		this.price=price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
