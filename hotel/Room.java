package com.hotel;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Room {
    public Connection con;
    public Room() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String uname = "root";
        String pass = "Sarvar123";
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection(url,uname,pass);

    }


    public void booking() throws SQLException, InterruptedException {
        RealTime r = new RealTime();
        Scanner sc = new Scanner(System.in);
        String name;
        String email;
        String phone_num;
        String address;
        String  booking_date;
        String room_type;
        int total_bedroom;
        boolean has_tv = true;
        boolean has_ac = true;
        boolean has_internet = true;
        int room_no;
        int num_adult;
        int num_child;
        double price;
        boolean inuse  = false;



        System.out.println("---------------------------------------------------------------------------------Booking-------------------------------------------------------------------");
        System.out.println("Enter the name:");
        name = sc.nextLine();

        System.out.println("Enter the email");
        email = sc.nextLine();

        System.out.println("Enter the phone number");
        phone_num = sc.nextLine();
        String ph = phone_num;

        System.out.println("Enter the Address");
        address = sc.nextLine();

        System.out.println("Enter the Room Type");
        room_type = sc.nextLine();

        System.out.println("Enter the No. Adult:");
        num_adult = sc.nextInt();
        System.out.println("Enter the No. Children");
        num_child = sc.nextInt();
        System.out.println("Enter the room no");
        room_no = sc.nextInt();
        String query1 = "select inuse from room where room_no ="+room_no+" ";
        Statement s_ = con.createStatement();
        ResultSet r_ = s_.executeQuery(query1);
        if(r_.next()){
            inuse = r_.getBoolean("inuse");}
        System.out.println(inuse);
        
            while (true) {
                boolean check = false;
                 query1 = "select inuse from room where room_no =" + room_no + " ";
                 s_= con.createStatement();
                 r_ = s_.executeQuery(query1);
                if (r_.next()) {
                    check = r_.getBoolean("inuse");
                }


                if (check) {
                    System.out.println("Room Already taken!");
                    System.out.println("Enter the room no");
                    room_no = sc.nextInt();
                }
                else if(!check){
                    break;
                }


            }
        
        

        System.out.println("Enter the No. Bedroom");
        total_bedroom = sc.nextInt();

        System.out.println("Enter the no of day you stay!");
        int day = sc.nextInt();
        System.out.println("Amount Paid: ");
        double paid = sc.nextDouble();
        price = (double)1000*day;
        price = price - paid;
        booking_date =  r.get_Real_Time_date();
        inuse = true;









        String query_For_customer = " insert into customer (name,email,phone_num,address)"
                + " values (?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query_For_customer);

        preparedStmt.setString (1,name);
        preparedStmt.setString (2,email);
        preparedStmt.setString(3,phone_num);
        preparedStmt.setString(4,address);


        preparedStmt.execute();

        String query_For_booking = " insert into booking (booking_date,num_adult,num_child)"
                + " values (?,?,?)";
        PreparedStatement p_S = con.prepareStatement(query_For_booking);

        p_S.setString (1,booking_date);
        p_S.setInt (2,num_adult);
        p_S.setInt(3,num_child);

        p_S.execute();

        String query_For_room = " insert into room (room_no,room_type,total_bedroom,has_tv,has_ac,has_internet,price,inuse)"
                + " values (?,?,?,?,?,?,?,?)";
        PreparedStatement p_s = con.prepareStatement(query_For_room);

        p_s.setInt (1,room_no);
        p_s.setString (2,room_type);
        p_s.setInt(3,total_bedroom);
        p_s.setBoolean (4,has_tv);
        p_s.setBoolean (5,has_ac);
        p_s.setBoolean(6,has_internet);
        p_s.setDouble(7,price);
        p_s.setBoolean(8,inuse);



        p_s.execute();
        String query = "select id from customer where phone_num ="+ph+" ";
        Statement s = con.createStatement();
        ResultSet r__ = s.executeQuery(query);
        int id__ = 0;
        if (r__.next()) {

           id__ = r__.getInt("id");



        }
        System.out.println("The customer ID is:"+id__);
        TimeUnit.SECONDS.sleep(5);





    }
    public void give__detail() throws SQLException, InterruptedException {
        boolean has__info = false;
        String name = null;
        String phone = null;
        String email  =null;
        String addr = null;
        String booking_date = null;
        int num_adult = 0;
        int num_child = 0;

        int id__;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID or Booking ID:");
        id__ = sc.nextInt();

         String query = "select * from customer where id = "+id__+" ";


        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        if (rs.next()) {

             name = rs.getString("name");
             email = rs.getString("email");
             addr = rs.getString("address");

             phone = rs.getString("phone_num");


        }
        query = "Select * from booking where customer_id ="+id__+" ";
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(query);
        if(r.next()){
            has__info = true;
            booking_date = r.getString("booking_date");
            num_adult  = r.getInt("num_adult");
            num_child = r.getInt("num_child");



        }
        else{
            System.out.println("Enter the valid Id!");

        }
        if(has__info){
        System.out.println("+----------------------------------------------------------------------Customer Detail!------------------------------------------------------------+");
        System.out.println("|   Name:"+name+"                                                                                                                                  ");
        System.out.println("|   Customer Phone no:"+phone+"                                                                                                                    ");
        System.out.println("|   Customer Address :"+addr+"                                                                                                                     ");
        System.out.println("|   Customer Email:"+email+"                                                                                                                       ");
        System.out.println("|   Booking Date"+booking_date+"                                                                                                                   ");
        System.out.println("|   Number of Adult:"+num_adult+"                                                                                                                  ");
        System.out.println("|   Number of Children:"+num_child+"                                                                                                               ");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------+");}

        r.close();
        s.close();
        rs.close();
        st.close();
        TimeUnit.SECONDS.sleep(5);

    }

    public void remove_Detail() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID:");
        int id;
        id = sc.nextInt();


        String query_for_Customer = "delete from customer where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query_for_Customer);
        preparedStmt.setInt(1, id);
        preparedStmt.execute();
        String query_for_booking = "delete from booking where customer_id = ?";
        PreparedStatement p_S = con.prepareStatement(query_for_booking);
        p_S.setInt(1, id);
        p_S.execute();
        String query_for_room = "delete from room where room_id = ?";
        PreparedStatement p_s = con.prepareStatement(query_for_room);
        p_s.setInt(1, id);
        p_s.execute();
        System.out.println("Successfully Detail Remove!");


    }
    public void check__out() throws SQLException, InterruptedException {
        double price__ = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID:");
        int id;
        id = sc.nextInt();
        String query = "select price from room where room_id = "+id+" ";
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            price__ = rs.getDouble("price");
        }
        System.out.println("Amount Remaining:"+price__);
        TimeUnit.SECONDS.sleep(8);


            String query_for_Customer = "delete from customer where id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query_for_Customer);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            String query_for_booking = "delete from booking where customer_id = ?";
            PreparedStatement p_S = con.prepareStatement(query_for_booking);
            p_S.setInt(1, id);
            p_S.execute();
            String query_for_room = "delete from room where room_id = ?";
            PreparedStatement p_s = con.prepareStatement(query_for_room);
            p_s.setInt(1, id);
            p_s.execute();
            System.out.println("Success!");








    }
}

