package com.yzd.classes;

public class OrderOperate extends BaseDAO {
    public boolean inserOrder(String name,int num,int itemid,double price){
        String sql="insert orders(oname,num,itemid,price) values(?,?,?,?)";
        Object[] values={name,num,itemid,price};
        int count=super.exeUpdate(sql,values);
        return count>=1;
    }
}
