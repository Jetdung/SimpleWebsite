package com.yzd.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserOperate extends BaseDAO {
    public boolean insertUser(String name,String pwd){
        String sql="insert users(username,userpwd,usertype) values(?,?,?)";
        Object[] values={name,pwd,"0"};
        int count=super.exeUpdate(sql,values);
        return count>=1;
    }
    public boolean delUserByName(String name){                        //通过名字删除用户
        String sql="delete from users where username=?";
        Object[] values={name};
        int count=super.exeUpdate(sql,values);
        return count>=1;
    }
    public boolean isExist(String name) {                             //查询用户是否存在
        String sql="select * from users where username=?";
        Object[] values={name};
        ResultSet rs=super.exeQuery(sql,values);
        boolean flag=false;
        try{
            while(rs.next()) {
                flag = true;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            super.closeAll();
        }
        return flag;
    }
    public int isValid(String name,String pwd) {                            //验证用户密码
        String sql="select * from users where username=? and userpwd=?";
        Object[] values={name,pwd};
        ResultSet rs=super.exeQuery(sql,values);
        int flag = -1;
        try{
            while(rs.next()) {
                if(rs.getInt("usertype")==1){
                    flag = 1;
                }else{
                    flag = 0;
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            super.closeAll();
        }
        return flag;
    }
    public List<User> getAllUser(){
        String sql="select * from users";
        Object[] values={};
        ResultSet rs=super.exeQuery(sql,values);
        List<User> list=new ArrayList<User>();
        try {
            while(rs.next()) {
                User user=new User();
                user.setName(rs.getString("username"));
                user.setPwd(rs.getString("userpwd"));
                user.setType(rs.getInt("usertype"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
