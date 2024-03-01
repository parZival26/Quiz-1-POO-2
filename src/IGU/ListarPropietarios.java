package IGU;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import UML.Propietario;

public abstract class ListarPropietarios {
    public static void main(String[] args) {
       
    }

    private static ArrayList<String[]> readCSV() {
        ArrayList<String[]> propietarios = new ArrayList<>();
        try (Scanner scFile = new Scanner(new File("././src/IGU/Propietarios.csv"))) {
            while (scFile.hasNextLine()) {
                String[] linea = scFile.nextLine().split(",");
                propietarios.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propietarios;

    }
}
