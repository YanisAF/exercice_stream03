package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        String fileCsv = "src/main/resources/books_dataset.csv";
        List<Livre> books;

        try(BufferedReader br = new BufferedReader(new FileReader(fileCsv))){
            books = br.lines().skip(1)
                    /* Transformer des éléments d'un flux de données en objets Livre, après avoir d'abord séparé des chaînes de caractères à l'aide de split(). */
                    .map(line -> line.split(","))
                    /* Deuxième map() - Création d'un objet Livre */
                    .map(value -> new Livre(value[0], value[1],value[2], LocalDate.parse(value[3]),Integer.parseInt(value[4]),Boolean.parseBoolean(value[5]),Double.parseDouble(value[6])))
                    .toList();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        // 1.
        System.out.println("Tâche 1 : \n");
        books.stream()
                .filter(Livre::isEstDisponible)
                .forEach(System.out::println);

        // 2. Poursuivre l'exercice :


    }
}