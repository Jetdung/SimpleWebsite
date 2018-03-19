package com.yzd.classes;

import java.sql.*;

public class BaseDAO {
    Connection con=null;
    PreparedStatement ps;
    ResultSet rs;
    int count;
    public static Connection getConn() throws Exception {                   //连接数据库
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/system";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);
        return conn;
    }
    public ResultSet exeQuery(String sql,Object[] values){                    //查询数据库
        try{
            BaseDAO db=new BaseDAO();
            con=db.getConn();
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
            BaseDAO db=new BaseDAO();
            con=db.getConn();
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
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
