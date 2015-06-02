package com.valik.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ����� on 02.06.2015.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="descriprion")
    private String descrition;

    @Column(name="pageCount")
    private int pageCount;

    @Column(name="autor")
    private String autor;

    @Column(name="date")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Book(int id, String name, String descrition, int pageCount, String autor, Date date) {
        this.id = id;
        this.name = name;
        this.descrition = descrition;
        this.pageCount = pageCount;
        this.autor = autor;
        this.date = date;
    }

    public Book(String name, String descrition, int pageCount, String autor, Date date) {
        this.name = name;
        this.descrition = descrition;
        this.pageCount = pageCount;
        this.autor = autor;
        this.date = date;
    }

    public Book() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pageCount != book.pageCount) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (descrition != null ? !descrition.equals(book.descrition) : book.descrition != null) return false;
        if (autor != null ? !autor.equals(book.autor) : book.autor != null) return false;
        return !(date != null ? !date.equals(book.date) : book.date != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descrition != null ? descrition.hashCode() : 0);
        result = 31 * result + pageCount;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descrition='" + descrition + '\'' +
                ", pageCount=" + pageCount +
                ", autor='" + autor + '\'' +
                ", date='" + date + '\'' +
                "}\n";
    }
}
