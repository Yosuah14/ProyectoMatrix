/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tarea_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author jose1
 */
public class Tarea_1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String f = "texto.txt";
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(f, StandardCharsets.UTF_8)); BufferedReader fbr = new BufferedReader(new InputStreamReader(System.in));) {

            int cont = 0;
            String texto;
            System.out.println("Dime el texto que desas introducir");
           
            do {
                if ((texto = fbr.readLine()).equalsIgnoreCase("")) {
                    cont++;
                } else {
                    cont = 0;
                }
                fw.write(texto);
                fw.newLine();

            } while (cont != 2);
            fw.flush();
            fw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }

    }
}
