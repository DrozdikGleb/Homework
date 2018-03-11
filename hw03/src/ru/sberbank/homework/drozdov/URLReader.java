package ru.sberbank.homework.drozdov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gleb on 15.02.2018
 */
public class URLReader {
     boolean readPage(String url){
         try {
             URL urlAddress = new URL(url);
             try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlAddress.openStream()))) {
                 String line;
                 while ((line=bufferedReader.readLine())!=null){
                     System.out.println(line);
                 }
                 return true;
             }  catch (IOException e) {
                 System.err.println("Problems with reading current page");
                 return false;
             }
         } catch (MalformedURLException e) {
             System.err.println("Not valid url");
             return false;
         }

     }
}
