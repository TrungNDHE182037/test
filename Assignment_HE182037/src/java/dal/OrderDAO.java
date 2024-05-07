/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {
    
    
    
    public void addOrderLine(String[] a, int order_id){
        String sql = "INSERT INTO [dbo].[order_line] ([order_id] ,[book_id]) VALUES ("+order_id+","+a[0]+")";
        if(a.length>=2){
            for(int i=1; i<a.length; i++){
                sql = sql +",("+order_id+","+a[i]+")";
            }
        }
        for(int i = 0; i<a.length; i++){
            String sql2 = "UPDATE book\n" +
"SET quantity = quantity-1\n" +
"WHERE book_id = " + a[i];
            try {
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        }
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int addOrder(int userID) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        String sql = "INSERT INTO [dbo].[cust_order]\n" +
"           ([order_date]\n" +
"           ,[customer_id])\n" +
"     VALUES\n" +
"           ('"+dtf.format(now)+"'\n" +
"           ,"+userID+")";
        
        String sql2 = "Select top 1* from cust_order\n" +
"order by order_date desc";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        int orderID = 0;
        try {
            PreparedStatement st2 = connection.prepareStatement(sql2);
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                orderID = rs.getInt("order_id");
                return orderID;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }     
        return orderID;
    }

    public List<Order> getOrder(int cid) {
        List<Order> list = new ArrayList<>();
        String sql = "select * from cust_order where customer_id =" + cid;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String odate = rs.getString("order_date").substring(0, 10);
                Order s = new Order(rs.getInt("order_id"), rs.getInt("customer_id"), odate);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    
    
    public static void main(String[] args) {
        OrderDAO dbo = new OrderDAO();
        List<Order> list = dbo.getOrder(1);
        for(Order o: list){
            System.out.println(o);
        }
        
    }
}
