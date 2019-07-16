package uiForms;

import lombok.Getter;

import javax.swing.*;
import java.io.File;

@Getter
public class menu {
    private JPanel panel1;
    private JTextArea heroDisplay;
    private JComboBox heroSelectCombo;
    private JButton viewHeroBtn;
    private JButton submitBtn;

    public menu(File[] listFiles){
        for (int i=0; i < listFiles.length; i++){
            String str = listFiles[i].getName();
            heroSelectCombo.add(new ComboItem(str,str));
        }
    }
}



class ComboItem
{
    private String key;
    private String value;

    public ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}