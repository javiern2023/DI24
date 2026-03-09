package application;

public class Alumno {
	private String expediente;
    private String nombre;
    private String apellidos;

    protected Alumno(String expediente, String nombre, String apellidos) {
        this.expediente = expediente;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    protected String getExpediente() {
        return expediente;
    }

    protected void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getApellidos() {
        return apellidos;
    }

    protected void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
