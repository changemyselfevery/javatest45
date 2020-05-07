package com.zj;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author: zj
 * @date: Created in 2020/4/22 14:40
 * @version: 1.0
 * @modified By:
 */
public class RoomSet {
    private ArrayList<Room> rooms=new ArrayList<>();
    public void addrooms(Room room){
        rooms.add(room);
        //Hashmap是put,而ArrayList是add来添加
    }
    //现在是用户输入时间
//    public Room play(){
//        Scanner in =new Scanner(System.in);
//        while (true){
//            Room room=null;
//            String input=in.nextLine();
//           for(Room item:rooms){
//               if(item.getId().equals(input)){
//                   room=item;
//               }
//           }
//        }
//        return room;
//    }
  //  我的想法是通过包包房间的id，并不是我想要的id,和要的room
    public Room searchRoom(String roomId){
        Room room=null;
       for(Room item:rooms){
           if(item.getId().equals(roomId)){
               room=item;
    break;
           }
        }
        return room;
    }
    public RoomSet(){}

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
