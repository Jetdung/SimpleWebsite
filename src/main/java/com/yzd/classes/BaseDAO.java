package com.yzd.classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDAO {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    int count;
    public static Connection getConn(){                             //连接数据库
        Connection conn=null;
        Properties p=new Properties();
        try {
            InputStream inputStream = BaseDAO.class.getResourceAsStream("/jdbc.properties");
            p.load(inputStream);
            Class.forName(p.getProperty("classname"));
            String url=p.getProperty("url");
            String username=p.getProperty("username");
            String password=p.getProperty("password");
            conn= DriverManager.getConnection(url,username,password);
        }catch(IOException e){
           e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet exeQuery(String sql,Object[] values){                    //查询数据库
        try{
            con=getConn();
            ps=con.prepareStatement(sql);
            for(int i=0;i<values.length;i++){
                ps.setObject(i+1, values[i]);
            }
            rs=ps.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    public int exeUpdate(String sql,Object[] values){                         //更新数据库
        try{
            con=getConn();
            ps=con.prepareStatement(sql);
            for(int i=0;i<values.length;i++){
                ps.setObject(i+1, values[i]);
            }
            count=ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public void closeAll(){
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
