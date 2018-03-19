package com.yzd.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemOperate extends BaseDAO {

    public List<Item> getAllItem(){
        String sql="select * from items";
        Object[] values={};
        ResultSet rs=super.exeQuery(sql,values);
        List<Item> list=new ArrayList<Item>();
        try {
            while(rs.next()) {
                Item item=new Item();
                item.setItemid(rs.getInt("iid"));
                item.setSight(rs.getString("sight"));
                item.setPrice(rs.getDouble("price"));
                item.setDetail(rs.getString("detail"));
                item.setType(rs.getInt("type"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
