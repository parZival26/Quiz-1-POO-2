package IGU;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import UML.Propietario;

public abstract class ListarPropietarios {
    public static void main(String[] args) {
        ArrayList<Propietario> propietarios = readCSV();
        for (Propietario propietario : propietarios) {
            System.out.println(propietario.getInformacion());
        }
    }

    private static ArrayList<Propietario> readCSV() {
        ArrayList<Propietario> propietarios = new ArrayList<>();
        try (Scanner scFile = new Scanner(new File("././src/IGU/Propietarios.csv"))) {
            while (scFile.hasNextLine()) {
                String[] linea = scFile.nextLine().split(",");
                Propietario propietario = new Propietario(Integer.parseInt(linea[0]), linea[1], linea[2],
                        Integer.parseInt(linea[3]), Integer.parseInt(linea[4]));
                propietarios.add(propietario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propietarios;

    }
}
