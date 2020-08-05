package com.pocassgn.Person;


import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class Books {
	int id;
	String name;
	String author;
	
	Map<Integer,Books> book= new HashMap<>();
	
	public Books() {
		
	}
	
	public Books(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}

	

	public String getAuthor() {
		return author;
	}
	
	public  void  addBook(Books b){
		
				book.put(b.getId(),b);
				
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	
}
