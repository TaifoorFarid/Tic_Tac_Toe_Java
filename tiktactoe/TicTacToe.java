package tiktactoe;

import javax.swing.*;
import java.util.Scanner;

public class TicTacToe {
    static String plyr1;
    static String plyr2;
    public static void player1(String[] arr){
        while(true) {
            System.out.print(plyr1 + "'s Turn ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if(choice == (int)'e')
                System.exit(0);
            if(arr[choice].equals(" X ") || arr[choice].equals(" O "))
                System.out.println("Entry already occupied");
            else if (choice < 1 || choice > 9) {
                System.out.println("Wrong choice ");
            } else {
                arr[choice] = " O ";
                break;
            }
        }
    }

    public static void player2(String[] arr){
        while(true) {
            System.out.print(plyr2 + "'s Turn ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if(choice == (int)'e')
                System.exit(0);
            if(arr[choice].equals(" X ") || arr[choice].equals(" O "))
                System.out.println("Entry already occupied");
            else if (choice < 1 || choice > 9) {
                System.out.println("Wrong choice ");
            } else {
                arr[choice] = " X ";
                break;
            }
        }
    }

    public static void print(String[] ttt){
        int count = 0;
        System.out.println();
        for(int i = 1 ; i < ttt.length ; i++){
            if(ttt[i].equals(" X ") || ttt[i].equals(" O ")) {
                System.out.print("|" + ttt[i]);
                count++;
            }else
                System.out.print("| _ ");

            if(i % 3 == 0){
                System.out.print("|");
                System.out.println();
            }
        }
        if(count == 9) {
            System.out.println("Game Over!!");
            System.exit(0);
        }
    }

    public static String[] store(){// to first creat and initilaze the array with " _ "
        String[] ttt = new String[10];
        String store = "A";
        for(int i = 1 ; i < ttt.length ; i++){
                ttt[i] = store;
                store = "A"+i;
        }
        return ttt;
    }

    public static void checkWin(String[] arr, int plr){
        boolean check;
        if(arr[1].equals(arr[2]) && arr[1].equals(arr[3]))
        check = true;
        else if (arr[4].equals(arr[5]) && arr[4].equals(arr[6]))
            check = true;
        else if (arr[7].equals(arr[8]) && arr[7].equals(arr[9]))
            check = true;
        else if (arr[1].equals(arr[4]) && arr[1].equals(arr[7]))
            check = true;
        else if (arr[2].equals(arr[5]) && arr[2].equals(arr[8]))
            check = true;
        else if (arr[3].equals(arr[6]) && arr[3].equals(arr[9]))
            check = true;
        else if (arr[1].equals(arr[5]) && arr[1].equals(arr[9]))
            check = true;
        else if (arr[3].equals(arr[5]) && arr[3].equals(arr[7]))
            check = true;
        else
            check = false;

        if(check){
            if(plr == 1){
                print(arr);
                System.out.println("Congratulations "+plyr1+" you won!");
                System.exit(0);
            }
            else{
                print(arr);
                System.out.println("Congratulations "+plyr2+" you won!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter player 1 name(O)) : ");
        plyr1 = in.nextLine();
        System.out.print("Enter player 2 name(X) : ");
        plyr2 = in.nextLine();
        String[] ttt = store();
        System.out.println("Press Enter any key to start and 'e' to exit ");
        if(in.next().equals("e"))
            System.exit(0);

        while(true) {
            print(ttt);
            player1(ttt);
            checkWin(ttt, 1);
            print(ttt);
            player2(ttt);
            checkWin(ttt, 2);
        }
    }
}