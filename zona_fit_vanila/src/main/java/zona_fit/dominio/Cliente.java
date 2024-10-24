package zona_fit.dominio;

import java.util.Objects;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private  String apellidoCliente;

    private  int membresia_id;

    //vacio

    public Cliente() {
    }

    //delete / select by id

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    //insert
    public Cliente( String nombreCliente, String apellidoCliente, int membresia_id) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.membresia_id = membresia_id;
    }

    //select
    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, int membresia_id) {
        this(nombreCliente,apellidoCliente,membresia_id);
        this.idCliente = idCliente;

    }


    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", membresia_id=" + membresia_id +
                '}'+"\n";
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public int getMembresia_id() {
        return membresia_id;
    }

    public void setMembresia_id(int membresia_id) {
        this.membresia_id = membresia_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente && membresia_id == cliente.membresia_id && Objects.equals(nombreCliente, cliente.nombreCliente) && Objects.equals(apellidoCliente, cliente.apellidoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nombreCliente, apellidoCliente, membresia_id);
    }
}
