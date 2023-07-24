/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trackacc2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elazizbellah
 */
public class FileWriterHelper {
    public static void writeToFile(String fileName, String line){
        try {
            fileName = fileName.replaceAll(".txt", "");
            File file = new File(fileName + ".txt");
            file.createNewFile();
            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(line+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileWriterHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
