/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Lucas
 */

import java.io.*;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TestWriter {
    public static void main(String args[]){
       BufferedWriter bufferedWriter = null;
       String fileName = "piroquinhaDoIgor"+Instant.now().getEpochSecond()+".txt";    
       
       try{
           bufferedWriter = new BufferedWriter(new FileWriter(fileName));
           bufferedWriter.write("Igor tem uma piroquinha pequena");
           bufferedWriter.newLine();
           bufferedWriter.write("Na moral, é muito pequena mesmo");
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       } catch (IOException ex) {
            Logger.getLogger(TestWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
       finally{
           try{
               if(bufferedWriter != null){
                   bufferedWriter.flush();
                   bufferedWriter.close();
               }
           }
           catch(IOException ex){
               ex.printStackTrace();
           }
       }
    }
}
