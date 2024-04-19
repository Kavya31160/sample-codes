package com.stackroute.consumer.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recommend {
	
	@Id
	String bookid;
	String bookname;
	String author;
	Date dofpurchase;
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + "]";
	}
	public Date getDofpurchase() {
		return dofpurchase;
	}
	public void setDofpurchase(Date dofpurchase) {
		this.dofpurchase = new Date();
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
