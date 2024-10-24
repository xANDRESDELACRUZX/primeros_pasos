import com.formdev.flatlaf.FlatDarculaLaf;
import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class forma extends JFrame {


    private IClienteDAO clienteDAO;
    private JPanel panelPrincipal;
    private JLabel prueba;
    private JTable clientesTabla;
    private JScrollPane scrollPane1;
    private JLabel Nombre;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel apellido;
    private JLabel membresia;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    private DefaultTableModel tableModelClientes;
    private Integer idCliente;

    public forma(){
        inicializarForma();
        guardarButton.addActionListener(e -> guardarCliente());
        limpiarButton.addActionListener(e -> limpiarFormulario());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarButton.addActionListener(e ->eliminarCliente());
    }
    //iniciar la configuracion de la app
    private void  inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);//centrar la ventana
    }


    // editar la tabla
    private void createUIComponents() {
        this.tableModelClientes = new DefaultTableModel(0,4);
        String[] cabeceros = {"Id","Nombres","Apellidos","mebresia" };
        this.tableModelClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tableModelClientes);
        listarClientes();
    }
    private void listarClientes(){
        this.tableModelClientes.setRowCount(0);
        this.clienteDAO = new ClienteDAO();
        var clientes =  this.clienteDAO.listarClientes();
        clientes.forEach(cliente -> {
            Object[] renglonCliente = {
                    cliente.getIdCliente(),
                    cliente.getNombreCliente(),
                    cliente.getApellidoCliente(),
                    cliente.getMembresia_id()
            };
            this.tableModelClientes.addRow(renglonCliente);
        });
    }
    private void guardarCliente(){

        if(textField1.getText().equals("")){
            mostrarMensaje("el nombre es requerido");
            textField1.requestFocusInWindow();
            return;
        }

        if(textField3.getText().equals("")){
            mostrarMensaje("la membresia es requerido");
            textField3.requestFocusInWindow();
            return;
        }
        // recuperar los texto
        var nombre = textField1.getText();
        var apellido = textField2.getText();
        var membresia = Integer.parseInt(textField3.getText());

        //inicializar  la innterfarse
        this.clienteDAO = new ClienteDAO();

        //validar si es crear o modificar
        if(this.idCliente != null){
            //modificar
            var cliente = new Cliente(this.idCliente,nombre, apellido, membresia);
            var upd =this.clienteDAO.modificarCliente(cliente);
            if (upd) {
                mostrarMensaje("se modifico el cliente");
                limpiarFormulario();
                listarClientes();
            } else
                mostrarMensaje("no se modifico el cliente");

        }else {
            //crear
            //llenar el modelo
            var cliente = new Cliente(nombre, apellido, membresia);
            //llamar el metodo de add
            var add = this.clienteDAO.agregarCliente(cliente);
            if (add) {
                mostrarMensaje("se agrego el cliente");
                limpiarFormulario();
                listarClientes();
            } else
                mostrarMensaje("no se agrego el cliente");
        }

    }
    private void cargarClienteSeleccionado(){
        var renglon = clientesTabla.getSelectedRow();
        if (renglon != 1){
            var idCliente = clientesTabla.getModel().getValueAt(renglon,0).toString();
            var nombreCliente = clientesTabla.getModel().getValueAt(renglon,1).toString();
            var apellidoCliente = clientesTabla.getModel().getValueAt(renglon,2).toString();
            var membresiaCliente = clientesTabla.getModel().getValueAt(renglon,3).toString();

            //cargar en el formulario
            this.idCliente = Integer.parseInt(idCliente);
            this.textField1.setText(nombreCliente);
            this.textField2.setText(apellidoCliente);
            this.textField3.setText(membresiaCliente);

        }
    }

    private void eliminarCliente(){
        if (this.idCliente == null){
            mostrarMensaje("seleccione un cliente de al tabla");
            return;
        }
        if(textField1.getText().equals("")){
            mostrarMensaje("el nombre es requerido");
            textField1.requestFocusInWindow();
            return;
        }

        if(textField3.getText().equals("")){
            mostrarMensaje("la membresia es requerido");
            textField3.requestFocusInWindow();
            return;
        }

        //inicializar  la innterfarse
        this.clienteDAO = new ClienteDAO();
        var cliente = new Cliente(this.idCliente);
        var delete = this.clienteDAO.elimarCliente(cliente);
        if (delete) {
            mostrarMensaje("se elimino el cliente");
            limpiarFormulario();
            listarClientes();
        } else
            mostrarMensaje("no se elimino el cliente");


    }

    private void mostrarMensaje (String mesaje){
        JOptionPane.showMessageDialog(this,mesaje);
    }
    private void limpiarFormulario(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        this.idCliente = null;
    }


    public static void main(String[] args) {
        FlatDarculaLaf.setup();// look and fell a oscuro
        forma prueba = new forma();
        prueba.setVisible(true);
    }
}
