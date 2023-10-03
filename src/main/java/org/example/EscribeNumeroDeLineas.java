/*Mmuestra los contenidos de un fichero de texto línea a línea, numerando las líneas.
Para leer líneas de texto se usa el método readLine( ) de la clase BufferedReader.
*/

package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EscribeNumeroDeLineas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nobre del fichero: ");
        String nomFich = scanner.next();

        // Lectura con buffer.
        // Se asume que el fichero usa codificación UTF8.
        // ¿Y si no usa UTF8 como lo leemos?
            //BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(nomFich),StandardCharsets.ISO_8859_1));
        try (BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {  // bloque de recurso
            String linea = fbr.readLine();
            int i = 0;
            while (linea != null) {
                System.out.printf("[%5d] %s\n", i++, linea);
                linea = fbr.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe fichero" + nomFich);
        } catch (IOException e) {
            System.out.println("Error de E/ S:" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}