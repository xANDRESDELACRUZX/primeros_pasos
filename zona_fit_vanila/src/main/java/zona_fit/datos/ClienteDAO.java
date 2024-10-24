package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{

    private PreparedStatement preparedStatement;
    private ResultSet resultSet = null;
    @Override
    public List<Cliente> listarClientes() {

        List<Cliente> clientes  = new ArrayList<>();
        Connection con = Conexion.getConnection(); //se llama a al coneccion
        var sql = "SELECT * FROM clientes order by id";
        try {
            preparedStatement  = con.prepareStatement(sql); // prepara el sql
            resultSet = preparedStatement.executeQuery(); //lo ejecuta y lo guardo en una variable

            //recupero los datos en la bd y los guardo en una variable
            while (resultSet.next()) {
                var cliente = new Cliente();
                cliente.setIdCliente( resultSet.getInt("id"));
                cliente.setNombreCliente( resultSet.getString("nombre"));
                cliente.setApellidoCliente( resultSet.getString("apellido"));
                cliente.setMembresia_id( resultSet.getInt("membresia_id"));
                clientes.add(cliente);
            }
        }catch (Exception e){
            System.out.println("error al listar clientes" +e.getMessage());
        }
        finally {
            try {
              con.close();
            }catch (Exception e){
                System.out.println("error al cerrar la conexion en listar clientes" +e.getMessage());
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClienteporID(Cliente cliente) {
        // funcionan ambas
        //var sql = "SELECT * FROM clientes WHERE id= "+cliente.getIdCliente() ;
        Connection con = Conexion.getConnection(); //se llama a al coneccion
        var sql = "SELECT * FROM clientes WHERE id = ?"; //esta es mas  elegante
        try {
            preparedStatement  = con.prepareStatement(sql); // prepara el sql
            preparedStatement.setInt(1,cliente.getIdCliente()); //se la pasa el id con este comando
            resultSet = preparedStatement.executeQuery(); //lo ejecuta y lo guardo en una variable

            if(resultSet.next()){
            //recupero los datos en la bd y los guardo en una variable
            cliente.setIdCliente( resultSet.getInt("id"));
            cliente.setNombreCliente( resultSet.getString("nombre"));
            cliente.setApellidoCliente( resultSet.getString("apellido"));
            cliente.setMembresia_id( resultSet.getInt("membresia_id"));

            return  true;
            }

        }catch (Exception e){
            System.out.println("error al mostrar cliente por id" +e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar la conexion en mostrar cliente por id" +e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        /*var sql = "INSERT INTO clientes (nombre, apellido, membresia_id)" +
                "VALUES ('"+ cliente.getNombreCliente()+"', '"+ cliente.getApellidoCliente()+"', "+ cliente.getMembresia_id()+");";*/
        Connection con = Conexion.getConnection(); //se llama a al coneccion
        var sql = "INSERT INTO clientes (nombre, apellido, membresia_id)" +
                  "VALUES (?, ?, ?)";

        try {
            preparedStatement  = con.prepareStatement(sql); // prepara el sql
            preparedStatement.setString(1, cliente.getNombreCliente());
            preparedStatement.setString(2, cliente.getApellidoCliente());
            preparedStatement.setInt(3, cliente.getMembresia_id());
            preparedStatement.execute(); //lo ejecuta y lo guardo en una variable

            return true;

        }catch (Exception e){
            System.out.println("error al crear cliente " +e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar crear cliente" +e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        /*var sql ="UPDATE clientes"+
                "SET nombre = '"+ cliente.getNombreCliente()+"', apellido = '"+ cliente.getNombreCliente()+"', membresia_id ='" + cliente.getMembresia_id()+"'"+
                " WHERE id = "+cliente.getIdCliente()+";";*/
        Connection con = Conexion.getConnection(); //se llama a al coneccion
        var sql ="UPDATE clientes SET nombre = ?, apellido = ?, membresia_id = ?"+
                " WHERE id = ?";
        try {
            preparedStatement  = con.prepareStatement(sql); // prepara el sql
            preparedStatement.setString(1, cliente.getNombreCliente());
            preparedStatement.setString(2, cliente.getApellidoCliente());
            preparedStatement.setInt(3, cliente.getMembresia_id());
            preparedStatement.setInt(4, cliente.getIdCliente());
            preparedStatement.execute(); //lo ejecuta y lo guardo en una variable

            return  true;
        }catch (Exception e) {
            System.out.println("error al modificar el cliente" +e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar la conexion en modificar usuario" +e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean elimarCliente(Cliente cliente) {

        /*var sql ="DELETE FROM clientes"+
                " WHERE id = "+cliente.getIdCliente()+";";*/
        Connection con = Conexion.getConnection(); //se llama a al coneccion

        var sql ="DELETE FROM clientes"+
                " WHERE id = ?";
        try {
            preparedStatement  = con.prepareStatement(sql); // prepara el sql
            preparedStatement.setInt(1, cliente.getIdCliente());
            preparedStatement.execute(); //lo ejecuta y
            return  true;

        }catch (Exception e) {
            System.out.println("error al delete el cliente" +e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("error al cerrar la conexion en eliminar usuario" +e.getMessage());
            }
        }
        return false;
    }

    /*public static void main(String[] args) {
        var clientedao = new ClienteDAO();

       /* //mostrar toda la lista
        var lista = clientedao.listarClientes();
        System.out.println(lista);

        //mostrar por id
        var cliente = new Cliente(1);
        var buscarPorid = clientedao.buscarClienteporID(cliente);
        if (buscarPorid)
            System.out.println(cliente);
        else
            System.out.println("no se encuentra cliente con ese id " + cliente.getIdCliente());*/

       /* //agregar
        var clienteAdd = new Cliente("andres felipe","delacruz vargas" , 2);
        var add = clientedao.agregarCliente(clienteAdd);
        if (add)
            System.out.println("se  agrego el usuario correctamente:" + clienteAdd);
        else
            System.out.println("no guardo el cliente");

        //modificar
        var clienteUpd = new Cliente(2,"sandra patrica","vargas arias" , 2);
        var updated = clientedao.modificarCliente(clienteUpd);
         if (updated)
            System.out.println("se  modifico  el usuario correctamente:" + clienteUpd);
        else
            System.out.println("no se modifico el cliente");

        //delete
        var clienteDel = new Cliente(3);
        var delete = clientedao.elimarCliente(clienteDel);
        if (delete)
            System.out.println("se elimino correctamente el cliente:" + clienteUpd);
        else
            System.out.println("no se elimino el cliente");


    }*/
}
