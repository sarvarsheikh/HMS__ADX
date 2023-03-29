package com.hotel;

import java.sql.SQLException;
import java.util.Scanner;

    class Menu {

        public void meu_Screen() throws SQLException, ClassNotFoundException, InterruptedException {
        Room r = new Room();
        boolean event_loop  = true;

        Scanner sc = new Scanner(System.in);

        while (event_loop){
            int choice ;
            System.out.println("     +-----------------------------------------------------------------------MAIN MENU---------------------------------------------------------------------------+");
            System.out.println("     | 1.Booking                                                                                                                                                 |");
            System.out.println("     | 2.Cancel Booking                                                                                                                                          |");
            System.out.println("     | 3.Check out                                                                                                                                               |");
            System.out.println("     | 4.Search                                                                                                                                                  |");
            System.out.println("     | 5.EXIT                                                                                                                                                    |");
            System.out.println("     +-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("Enter the choice!");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> r.booking();
                case 2 -> r.remove_Detail();
                case 3 -> r.check__out();
                case 4 -> r.give__detail();
                case 5 -> {
                    System.out.println("Thanks for using software! \uD83D\uDE09");
                    event_loop = false;
                }
                default ->System.out.println("Enter the Proper option!");
            }  
        }
    }

}