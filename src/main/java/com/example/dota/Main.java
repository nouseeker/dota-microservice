package com.example.dota;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f=0;
        if (n<=1){
            System.out.println(n);
        }
        else {
            for (int i = 2; i <= n; i++) {
                f = f1+f2;
                f1=f2;
                f2=f;
            }
            System.out.println(f%m);
        }

    }
}