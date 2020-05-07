package com.zj;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        RoomSet nowRoomset;
        nowRoomset=initRooms();
        //为了防止初始化房间过于冗杂，创建函数来初始化
        //现在我想看看里面会的房间会
        showRoomSet(nowRoomset);
        //不过我想让用户输入id，而不是我自己查询id,因为是用户用呀


        //而创建这个程序的目的就是为了，能够查询到我可以到达的房间
        //不能通过房间集合查找，应该从房间查找，通过输入字符id,可以获取到相应房间
//        Room room=nowRoomset.searchRoom("1");
        while (true){
            Scanner in=new Scanner(System.in);
            String input=in.nextLine();
            Room room=nowRoomset.searchRoom(input);
            System.out.println("下面就是可到达的房间!!!，看看喔，我把我得包包打开给你看");
            room.showAbleToRooms();
        }
        //现在已经找到那房间了，就需要打开它的包包看看里面有什么东西了

        //因为我得包包里装的是可到达房间id和可到到房间，获取到房间时，房间不知道怎么表达，只好返回hashcode所以就要
        //重写toString方法，让大家重新认识我啦

    }
    public static void showRoomSet(RoomSet roomSet){
        for (Room item:roomSet.getRooms()){
            System.out.println("id= "+item.getId()+", description= "+item.getDescription());
        }
    }

    public static RoomSet initRooms(){
        RoomSet roomset =new RoomSet();
        Room outside=new Room("1","城堡外");
        Room lobby=new Room("2","大堂");
        Room pub=new Room("3","酒吧");
        Room study=new Room("4","书房");
        Room bedroom=new Room("5","卧室");
        //创建房间完毕

        //把房间放起来
        roomset.addrooms(outside);
        roomset.addrooms(lobby);
        roomset.addrooms(pub);
        roomset.addrooms(study);
        roomset.addrooms(bedroom);

        //之后是吧房间可以到达的房间全部存放起来，放在hashmap之中，就像一个口袋放好
        outside.addReachableRoom("2",lobby);
        outside.addReachableRoom("3",pub);
        outside.addReachableRoom("4",study);

        lobby.addReachableRoom("1",outside);

        pub.addReachableRoom("1",outside);

        study.addReachableRoom("1",outside);
        study.addReachableRoom("5",bedroom);

        bedroom.addReachableRoom("4",study);

        return roomset;
    }

}
