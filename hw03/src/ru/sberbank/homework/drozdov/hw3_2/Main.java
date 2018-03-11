package ru.sberbank.homework.drozdov.hw3_2;

import java.util.Scanner;

/**
 * Created by Gleb on 15.02.2018
 */
public class Main {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            String urlAddress = in.nextLine();
            URLReader urlReader = new URLReader();
            while (!urlReader.readPage(urlAddress)) {
                urlAddress = in.nextLine();
            }
        }
    }
}
