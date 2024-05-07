/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.BookDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {
    public List<Book> getCart(String txt){
        List<Book> list = new ArrayList<>();
        BookDAO dbb = new BookDAO();
        try{
            if(txt!=null && txt.length()!=0){
                String[] s = txt.split("/");
                for(String i: s){
                    Book a = dbb.getBookByID(i);
                    //String title=a.getTitle();
                    //int quantity = 1;
                    //double price = a.getPrice();
                    //String img = a.getImg();
                    //Book b = new Book(0, quantity,0, price, title, null, null, null, null, null, img, null, null);
                    list.add(a);
                }
                
            }
        }catch(NumberFormatException e){
            System.err.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        Cart c = new Cart();
        List<Book> list = c.getCart("2/2");
       for(Book b : list){
           System.out.println(b.toString());
       } 
       
    }
}
