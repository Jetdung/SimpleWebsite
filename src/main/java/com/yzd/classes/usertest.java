package com.yzd.classes;

import java.sql.SQLException;
import java.util.List;

public class usertest {
    public static void main(String[] args) throws SQLException {
        //UserOperate uo=new UserOperate();
        //List<User> list=uo.getAllUser();
        //System.out.println(uo.insertUser("zc","123456"));
        //System.out.println(uo.delUserByName("zzz"));
        //System.out.println(uo.isExist("123"));
        //System.out.println(uo.isValid("zzz","12345"));
        //for(User user:list){
        //    System.out.println(user.getName()+" "+user.getPwd()+" "+user.getType());
        //}
        ItemOperate io=new ItemOperate();
        List<Item> list=io.getAllItem();
        for(Item item:list){
            System.out.println(item.getItemid()+" "+item.getSight()+" "+item.getPrice()+" "+item.getDetail()+" "+item.getType());
        }
    }
}
