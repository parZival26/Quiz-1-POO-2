package IGU;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class CSVUtils {
    public static ArrayList<String[]> readCSV() {
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

    public static ArrayList<String[]> buscarPorNombre(String nombre) {
        ArrayList<String[]> propietarios = readCSV();
        ArrayList<String[]> propietariosFiltrados = new ArrayList<>();
        for (String[] propietario : propietarios) {
            if (propietario[1].toLowerCase().contains(nombre.toLowerCase())) {
                propietariosFiltrados.add(propietario);
            }
        }
        return propietariosFiltrados;
    }
}
