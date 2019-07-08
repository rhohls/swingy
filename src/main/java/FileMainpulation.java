import Characters.Hero;
import Items.Weapon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
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
        Hero newHero = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

//            String line = reader.readLine();
//
//            while (line != null) {
//                json += line;
//               line = reader.readLine();
//            }

             newHero = gson.fromJson(reader,  Hero.class);
        } catch (Exception e) {
            System.out.println("Error reading file: " + fileName);
            return (null);
        }

        return (newHero);
    }


    public File[] getFiles(){
        File dir = new File("Heros");

        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
//                System.out.println("Found " + name);
                if (name.endsWith(".json")){
                    return true;
                }
                return false;
            }
        });
        return files;
    }

}
