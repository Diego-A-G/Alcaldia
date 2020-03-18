package Vista;
import Controlador.ControladorPersona;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FormularioInstitucion extends JFrame{
    
    private JPanel contenedor;
    private JLabel lblId;
    private JLabel lblRazonSocial;
    private JLabel lblActividadEconomica;
    
    public JTextField txtId;
    public JTextField txtRazonSocial;
    public JTextField txtActividadEconomica;
    
    public JButton btnGuardar;
    public JButton btnBuscar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiar;
    
    public FormularioInstitucion() {
        setBounds(100, 100, 500, 550);
        setTitle("Gestión Persona");   
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        contenedor = new JPanel();
        getContentPane().add(contenedor);
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        lblRazonSocial = new JLabel("Nombre:");  //Crear el objeto
        contenedor.add(lblRazonSocial);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblRazonSocial, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblRazonSocial,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA APELLIDOS
        lblActividadEconomica = new JLabel("Apellido:");
        contenedor.add(lblActividadEconomica);
        sp.putConstraint(SpringLayout.NORTH, lblActividadEconomica, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblActividadEconomica,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA CIUDAD
        
        lblId = new JLabel("ID :");  //Crear el objeto
        contenedor.add(lblId);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblId, 240,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblId,  10,SpringLayout.WEST, contenedor);
        
        
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //CUADRO DE TEXTO PARA EL NOMBRE
        txtRazonSocial       = new JTextField();
        contenedor.add(txtRazonSocial);
        sp.putConstraint(SpringLayout.NORTH, txtRazonSocial, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtRazonSocial, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtRazonSocial, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL APELLIDO
        txtActividadEconomica = new JTextField();
        contenedor.add(txtActividadEconomica);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtActividadEconomica, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtActividadEconomica, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtActividadEconomica, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LA CIUDAD
        
        txtId      = new JTextField();
        contenedor.add(txtId);
        sp.putConstraint(SpringLayout.NORTH, txtId, 240, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtId, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtId, 300, SpringLayout.WEST, contenedor);
        
        /**************** BOF BOTONES vvvvvvvvvvvvvvvvvv **/
        //BOTÓN AÑADIR
        btnGuardar          = new JButton("Guardar");
        contenedor.add(btnGuardar);
        sp.putConstraint(SpringLayout.SOUTH, btnGuardar, -10, SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnGuardar,   50, SpringLayout.WEST, contenedor);
        //BOTÓN BORRAR
        btnEliminar          = new JButton("Eliminar");
        contenedor.add(btnEliminar);
        sp.putConstraint(SpringLayout.SOUTH, btnEliminar, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnEliminar,  150, SpringLayout.WEST, contenedor);
        //BOTÓN MODIFICAR
        btnModificar          = new JButton("Modificar");
        contenedor.add(btnModificar);
        sp.putConstraint(SpringLayout.SOUTH, btnModificar, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnModificar,  250, SpringLayout.WEST, contenedor);
        
        btnBuscar          = new JButton("Buscar");
        contenedor.add(btnBuscar);
        sp.putConstraint(SpringLayout.SOUTH, btnBuscar, -10, SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnBuscar,   350, SpringLayout.WEST, contenedor);
        
        btnLimpiar          = new JButton("Limpiar");
        contenedor.add(btnLimpiar);
        sp.putConstraint(SpringLayout.SOUTH, btnLimpiar, -50, SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnLimpiar,   160, SpringLayout.WEST, contenedor);
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
        setVisible(true);
 
    }
    
     public void conectaControlador(  ControladorPersona c  ){
 
        btnGuardar.addActionListener(c);
        btnGuardar.setActionCommand("GUARDAR");
 
        btnEliminar.addActionListener(c);
        btnEliminar.setActionCommand("ELIMINAR");
 
        btnModificar.addActionListener(c);
        btnModificar.setActionCommand("MODIFICAR");
        
        btnBuscar.addActionListener(c);
        btnBuscar.setActionCommand("BUSCAR");
        
        btnLimpiar.addActionListener(c);
        btnLimpiar.setActionCommand("LIMPIAR");
    }
}
