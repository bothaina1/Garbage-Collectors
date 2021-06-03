package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("heap.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next()+"/");  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}
