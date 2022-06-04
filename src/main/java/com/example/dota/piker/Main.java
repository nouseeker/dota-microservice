/*
package com.example.dota.Piker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr[][] = new String[6][10];
        Parse parse = new Parse();
        Hero hero = new Hero();
        Double wrRadiant=0.0;
        Double wrDire=0.0;
        arr[0][0] = "WinRate%";
        arr[0][1] = "Radiant Team";
        arr[0][2] = "Dire Team";
        arr[0][3] = "WinRate%";
        arr[0][4] = "COUNTER";
        //нахождение героя по id и присваивание в массив
        for (int i = 1; i <=2 ; i++) {
            for (int j = 1; j <=5 ; j++) {
                arr[j][i] = hero.getHeroById(sc.nextInt());
                parse.parseByName(arr[j][i]);
                if (i == 1) {
                    arr[j][0] = parse.getWr();
                    arr[j][4] = arr[j][i];
                    wrRadiant = wrRadiant + Double.parseDouble(arr[j][0].substring(0,5));
                } else {
                    arr[j][3] = parse.getWr();
                    arr[0][j+4] = arr[j][i];
                    wrDire = wrDire + Double.parseDouble(arr[j][3].substring(0,5));

                }
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j]!=null&&arr[i][j].length()<20){
                    arr[i][j]=arr[i][j]+ stringMultiply(20 - arr[i][j].length());
                }
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println(wrRadiant);
        System.out.println(wrDire);
    }
    public static String stringMultiply(int x) {
        String text = "";
        for (int i = 0; i < x; i++) {
            text = text + " ";
        }
        return text;
    }
}


*/
