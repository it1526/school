/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author student
 */
public class Soubor {
    private String data;
    Soubor(){
        
    }

    public String getData() {
        return data;
    }
    public Boolean nactiZeSouboru(File soubor,String charset) throws FileNotFoundException{
        data = "";
        try{
            InputStream inputStream = new FileInputStream(soubor);
            Reader reader = new InputStreamReader(inputStream,charset);
            int znak;
            do{
                znak = reader.read();
                if(znak != -1) data += (char)znak;
            }while(znak != -1);
        }catch(IOException e){
            return false;
        }
        return true;
    }
    
    public Boolean ulozDoSouboru(File soubor,String charset,String text) throws FileNotFoundException{
        try{
            OutputStream outputStream = new FileOutputStream(soubor);
            try(Writer writer = new OutputStreamWriter(outputStream,charset)){
                writer.write(text);
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }
}
