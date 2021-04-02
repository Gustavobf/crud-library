package com.batista.library.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBook;

	private String name;
	private Integer releaseYear;
	private Double price;

	public Book() {
	}

	public Book(Integer idBook, String name, Integer releaseYear, Double price) {
		super();
		this.idBook = idBook;
		this.name = name;
		this.releaseYear = releaseYear;
		this.price = price;
	}

	public Integer getIdBook() {
		return idBook;
	}

	public void setIdBook(Integer idBook) {
		this.idBook = idBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
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
		Book other = (Book) obj;
		if (idBook == null) {
			if (other.idBook != null)
				return false;
		} else if (!idBook.equals(other.idBook))
			return false;
		return true;
	}

}
