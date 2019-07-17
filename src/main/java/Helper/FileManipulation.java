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

//        System.out.println(gson.toJson(hero));

//        try {
            String json = gson.toJson(hero);
            FileWriter writer = new FileWriter("Heros/" + fileOutputName + ".json");
            writer.write(json);
            writer.close();

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public Hero createFromFile(String fileName) throws Exception{
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().create();
        String json = "";
        Hero newHero;
        System.out.println("-----" + fileName);
//        try {
            BufferedReader reader = new BufferedReader(new FileReader("Heros/" + fileName));

//            String line = reader.readLine();
//
//            while (line != null) {
//                json += line;
//               line = reader.readLine();
//            }

             newHero = gson.fromJson(reader,  Hero.class);
//        } catch (Exception e) {
//            System.out.println("Error reading file: " + fileName);
//            return (null);
//        }
        if (newHero == null)
            throw new Exception("Hero could not be created. Error with file: " + fileName );

//        if (newHero.getName() == null)
//            throw new Exception("noname could not be created. Error with file: " + fileName );




//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//        Set<ConstraintViolation<Hero>> violations = validator.validate(newHero);
//
//        if(violations.size() < 0)
//            throw new Exception("Hero could not be created. Error with file: " + fileName );


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
