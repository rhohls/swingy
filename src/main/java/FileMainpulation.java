import Characters.Hero;
import Items.Weapon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileMainpulation {
    public void writeHeroToFile(Hero hero, String fileOutputName){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        System.out.println(gson.toJson(hero));


        try {
            String json = gson.toJson(hero);
            FileWriter writer = new FileWriter(fileOutputName);
            writer.write(json);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Hero createFromFile(String fileName){
        Gson gson = new Gson();
        String json = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line = reader.readLine();

            while (line != null) {
                json += line;
               line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + fileName);
            return (null);
        }

        Hero newHero = gson.fromJson(json,  Hero.class);
        return (newHero);
    }


}
