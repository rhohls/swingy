package Helper;

import Characters.Hero;
import Items.Weapon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class FileManipulation {
    public void writeHeroToFile(Hero hero, String fileOutputName) throws Exception{

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(hero);
        FileWriter writer = new FileWriter("Heros/" + fileOutputName + ".json");
        writer.write(json);
        writer.close();
    }

    public Hero createFromFile(String fileName) throws Exception{
        Gson gson = new GsonBuilder().create();
        String json = "";
        Hero newHero;

        BufferedReader reader = new BufferedReader(new FileReader("Heros/" + fileName));
        newHero = gson.fromJson(reader,  Hero.class);

        if (newHero == null)
            throw new Exception("Hero could not be created. Error with file: " + fileName );

        return (newHero);
    }

    public File[] getFiles(){
        File dir = new File("Heros");

        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".json")){
                    return true;
                }
                return false;
            }
        });
        return files;
    }
}
