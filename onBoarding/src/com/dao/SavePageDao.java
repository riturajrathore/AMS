package com.dao;

import java.sql.*;
import java.io.*;

import com.beans.GetPagesBean;
 
public class SavePageDao
{
        /*public static void main(String[] args) 
        {
                DB db = new DB();
                Connection conn=db.dbConnect(
                  "jdbc:mysql://localhost:3306/rapidnsr","root","shriganesh-01");
                db.insertImage(conn,("D://office work//garagefest//data//"+imageName));
                db.getImageData(conn);
        }*/
 
/*}
 
class DB
{
        public DB() {}
*/
 
        /*public Connection dbConnect(String db_connect_string,
           String db_userid, String db_password)
        {
                try
                {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(
                          db_connect_string, db_userid, db_password);
 
                        System.out.println("connected");
                        return conn;
                         
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        return null;
                }
        }*/
        public void insertImage(String img, GetPagesBean pageBean)
        {
                int len;
                String query;                 
                try
                {
                        File file = new File(img);
                        FileInputStream fis = new FileInputStream(file);
                        len = (int)file.length();
                        query = ("insert into imagetable VALUES(?,?,?)");
                        System.out.println("-------------------file.getName-----------"+file.getName());
                		PreparedStatement pstmt =  this.runQuery(query);
                        pstmt.setString(1,pageBean.getSiteName());
                        // Method used to insert a stream of bytes
                        pstmt.setBinaryStream(2, fis, len); 
                        pstmt.setInt(3, len);
                        pstmt.executeUpdate();
 
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }
        public void insertHtml(String htmlfile, GetPagesBean pageBean) {

            int len;
            String query;                 
            try
            {
                    File file = new File(htmlfile);
                    FileInputStream fis = new FileInputStream(file);
                    len = (int)file.length();
                    query = ("insert into html_page VALUES(?,?,?)");
                    System.out.println("-------------------file.getName-----------"+file.getName());
            		PreparedStatement pstmt =  this.runQuery(query);
                    pstmt.setString(1,pageBean.getSiteName());
                    // Method used to insert a stream of bytes
                    pstmt.setBinaryStream(2, fis, len); 
                    pstmt.setInt(3, len);
                    pstmt.executeUpdate();

            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
			
		}
        
        public PreparedStatement runQuery(String queryStatement) {
    		PreparedStatement preparedState=null;
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rapidnsr", "root","shriganesh-01");
    			preparedState = con.prepareStatement(queryStatement);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return preparedState;

    	}
 
        public void getImageData(Connection conn)
        {/*
                 
                 byte[] fileBytes;
                 String query;
                 try
                 {
                         query = "select data from tableimage";
                         Statement state = conn.createStatement();
                         ResultSet rs = state.executeQuery(query);
                         if (rs.next())
                        {
                                  fileBytes = rs.getBytes(1);
                                  OutputStream targetFile=  
                                  new FileOutputStream(
                                       "d://filepath//new.JPG");
 
                                  targetFile.write(fileBytes);
                                  targetFile.close();
                        }        
                         
                 }
                 catch (Exception e)
                 {
                         e.printStackTrace();
                 }
        */}
		public void insertUrl(String pageURL, GetPagesBean pageBeam) {
			// TODO Auto-generated method stub
            String query="";                 
            try
            {
                    query = ("insert into navigation_urls VALUES(?,?)");
                    System.out.println("-------------------file.getName-----------"+pageBeam.getSiteName());
            		PreparedStatement pstmt =  this.runQuery(query);
                    pstmt.setString(1,pageBeam.getSiteName());
                    pstmt.setString(2, pageURL);
                    // Method used to insert a stream of bytes
                    pstmt.executeUpdate();

            }
            catch (Exception e)
            {
                    e.printStackTrace();
            }
			
		
		}
}