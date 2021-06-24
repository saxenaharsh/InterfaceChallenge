package com.HarshSaxena;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player tom = new Player("Tom", 10, 15);
        System.out.println(tom.toString());
        saveObject(tom);

        tom.setHitPoints(9);
        tom.setStrength(30);
        saveObject(tom);
       // loadObject(tom);
        System.out.println(tom);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        saveObject(werewolf);
    }
    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 - Enter a String value\n" +
                "0 - To quit");
        while(!quit){
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0 :
                    quit = true;
                    break;
                case 1 :
                    System.out.println("Enter a string value");
                    String inputString = scanner.nextLine();
                    values.add(index, inputString);
                    index++;
                    break;
            }
        }
        return values;
    }
    public static void saveObject(ISaveable objectToSave){
        for(int i = 0; i < objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }

    }
    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


}
