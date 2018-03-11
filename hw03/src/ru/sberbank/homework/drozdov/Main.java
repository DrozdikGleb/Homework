package ru.sberbank.homework.drozdov;

import java.util.Scanner;

/**
 * Created by Gleb on 15.02.2018
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String urlAddress = in.nextLine();
        URLReader urlReader = new URLReader();
        while (!urlReader.readPage(urlAddress)){
            urlAddress = in.nextLine();
        }
    }
}
