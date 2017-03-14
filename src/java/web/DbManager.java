package web;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aditya
 */
public class DbManager implements IRepo{
   
    Connection con ;
    
    public DbManager(){
       
        
    
    }

    public List<Post> GetAllPosts() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
             con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblog","root","root");
             
             Post post;
             List<Post>  posts = new ArrayList<Post>();
            PreparedStatement sql = con.prepareStatement("SELECT * FROM blog");
            
            ResultSet res = sql.executeQuery();
           while( res.next()){
            post = new Post();
            post.ID = res.getInt(1);
            post.PostTitle = res.getString(2);
            post.PostContent = res.getString(3);
            
           posts.add(post);
           }
              return posts;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, "ex happened !!!", ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch(Exception ex){
           Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
           return null;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int Login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> SearchPosts(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public Post GetPost(int ID) {
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
             con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblog","root","root");

             Post post = new Post();
             
            PreparedStatement sql = con.prepareStatement("SELECT * FROM blog WHERE post_id=?");
            sql.setInt(1, ID);

            ResultSet res = sql.executeQuery();
            res.next();
            
            post.ID = res.getInt(1);
            post.PostTitle = res.getString(2);
            post.PostContent = res.getString(3);
            post.PostCategory = res.getString(4);
           
            
              return post;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, "ex happened !!!", ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch(Exception ex){
           Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
           return null;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public int InsertPost(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UpdatePost(int ID, Post newPost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int DeletePost(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
