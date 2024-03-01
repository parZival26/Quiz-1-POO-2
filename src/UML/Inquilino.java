package UML;
public class Inquilino extends Persona {
    int id_Inquilino;

    public Inquilino(int documento, String nombres, String apellidos, int edad, int id_Inquilino) {
        super(documento, nombres, apellidos, edad);
        this.id_Inquilino = id_Inquilino;
    }

}
