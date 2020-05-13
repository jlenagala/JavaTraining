package com.javatraining.designpattern.prototypexample;

import java.util.ArrayList;
import java.util.List;

public class Library implements Cloneable {
	private String name;
	List<Book> books = new ArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books + "]";
	}

	public void loadData() {
		for (int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setBid(i);
			book.setBname("book" + i);
			getBooks().add(book);

		}

	}

	/*
	 * @Override protected Object clone() throws CloneNotSupportedException { return
	 * super.clone(); }
	 */
	@Override
	protected Library clone() throws CloneNotSupportedException {
		Library lib = new Library();
		for (Book book : this.getBooks()) {
			lib.getBooks().add(book);

		}
		return lib;
	}

}
