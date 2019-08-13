package Helper;

import Characters.Hero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class FileManipulation {

    private static Validator validator;

    public FileManipulation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void writeHeroToFile(Hero hero, String fileOutputName) throws Exception{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(hero);
        FileWriter writer = new FileWriter("Heros/" + fileOutputName + ".json");
        writer.write(json);
        writer.close();
    }

    public Hero createFromFile(String fileName) throws Exception{
        Gson gson = new GsonBuilder().create();
        Hero newHero;

        BufferedReader reader = new BufferedReader(new FileReader("Heros/" + fileName));
        newHero = gson.fromJson(reader,  Hero.class);

        if (newHero == null ||
            !validateHero(newHero))
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

    public Hero newHero(String name) throws Exception{
        Hero newHero = new Hero(name, 10, 10, 10, 10, 1);

        if (!validateHero(newHero))
            throw new Exception("Hero could not be created.");

        return (newHero);
    }

    private boolean validateHero(Hero hero){
        Set<ConstraintViolation<Hero>> constraintViolations =
                validator.validate( hero );

        if (constraintViolations.size() > 0)
            return false;
        else
            return true;
    }
}
