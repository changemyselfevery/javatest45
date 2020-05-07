package com.zj;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/4/22 14:33
 * @version: 1.0
 * @modified By:
 */
public class Room {
    private String id;
    private String description;
    private HashMap<String,Room> ableTorooms=new HashMap<>();//这是创建的放可到达房间的hashmap散列表
    public void showAbleToRooms(){
        for(Map.Entry<String,Room> item:ableTorooms.entrySet()){
            System.out.println(item.getKey()+":"+item.getValue());
        }
    }
    @Override
    public String toString(){
        return description;
    }
    public Room(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public void addReachableRoom(String id, Room room){
        ableTorooms.put(id,room);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
