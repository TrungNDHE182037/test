/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Book {
    private int  numPage, quantity, id;
    private double price;
    private String title, author, isbn, lang,pubDate, pubName, img, des, category;

    public Book() {
    }

    public Book( int numPage, int quantity,int id, double price, String title, String author, String isbn, String lang, String pubDate, String pubName, String img, String category, String des) {
        this.numPage = numPage;
        this.quantity = quantity;
        this.id = id;
        this.price = price;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.lang = lang;
        this.pubDate = pubDate;
        this.pubName = pubName;
        this.img = img;
        this.category = category;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" + "numPage=" + numPage + ", quantity=" + quantity + ", price=" + price + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", lang=" + lang + ", pubDate=" + pubDate + ", pubName=" + pubName + ", img=" + img + ", des=" + des + ", category=" + category + '}';
    }

    
    
}
