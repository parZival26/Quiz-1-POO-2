package UML;

public class Propietario extends Persona {
    int id_Propietario;

    public Propietario(int documento, String nombres, String apellidos, int edad, int id_Propietario) {
        super(documento, nombres, apellidos, edad);
        this.id_Propietario = id_Propietario;
    }

    public String toCSV() {
        return documento + "," + nombres + "," + apellidos + "," + edad + "," + id_Propietario;
    }

}
