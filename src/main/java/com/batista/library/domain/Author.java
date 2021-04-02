package com.batista.library.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAuthor;

	private String name;
	private Integer age;

	@JsonIgnore
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book> books = new ArrayList<>();

	public Author() {
	}

	public Author(Integer idAuthor, String name, Integer age) {
		super();
		this.idAuthor = idAuthor;
		this.name = name;
		this.age = age;
	}

	public Integer getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Integer idAuthor) {
		this.idAuthor = idAuthor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAuthor == null) ? 0 : idAuthor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (idAuthor == null) {
			if (other.idAuthor != null)
				return false;
		} else if (!idAuthor.equals(other.idAuthor))
			return false;
		return true;
	}

}
