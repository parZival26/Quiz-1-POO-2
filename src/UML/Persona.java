package UML;

public class Persona {
    int documento;
    String nombres;
    String apellidos;
    int edad;

    public Persona(int documento, String nombres, String apellidos, int edad) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Propiedad propiedad() {
        return new Propiedad();
    }

    public String getInformacion() {
        return "Documento: " + this.documento + " Nombre: " + this.nombres + " Apellido: " + this.apellidos + " Edad: "
                + this.edad;
    }

}
