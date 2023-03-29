package com.hotel;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Login_menu {
    public void  menu() throws SQLException, ClassNotFoundException, InterruptedException {
        boolean permission = false;
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------------------------------------------LOGIN MENU---------------------------------------------------------------------------");
            System.out.print("USERNAME:");
            String id = sc.nextLine();
            System.out.print("PASSWORD:");
            String password = sc.nextLine();
            if (Objects.equals(id, "server")&&Objects.equals(password, "server123")) {
                {
                    permission = true;
                    break;
                }
            } else if (Objects.equals(id, "afreen")&&Objects.equals(password, "afreen123")) {
                {
                    permission = true;
                    break;

                }

            } else if (Objects.equals(id, "madhu")&&Objects.equals(password, "madhu123")) {
                {
                    permission = true;
                    break;

                }

            } else if (Objects.equals(id, "vaishnavi")&&Objects.equals(password, "vaishnavi123")) {
                {
                    permission = true;
                    break;
                }

            }
            else {
                System.out.println("Enter the correct Password and Username!");
            }

        }
        Menu n = new Menu();
        n.meu_Screen();


    }




}

