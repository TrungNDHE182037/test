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
import model.Category;
/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext{
    public String getIDByname(String name){
        String sql = "Select category_id from category where category_name = '"+name+"'";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql); 
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s = rs.getString("category_id");
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Category> getAll(){
        List<Category> list = new ArrayList<>();
        String sql="Select * from category";
         try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category s = new Category(rs.getInt("category_id"), rs.getString("category_name"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
}
