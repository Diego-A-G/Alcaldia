package Vista;
import Controlador.ControladorPersona;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FormularioPersona extends JFrame{
    
    private JPanel contenedor;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblCiudad;
    private JLabel lblDocumento;
    private JLabel lblEdad;
    
    public JTextField txtId;
    public JTextField txtNombre;
    public JTextField txtApellido;
    public JTextField txtCiudad;
    public JTextField txtDocumento;
    public JTextField txtEdad;
    
    public JButton btnGuardar;
    public JButton btnBuscar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiar;
    
    public FormularioPersona() {
        setBounds(100, 100, 500, 550);
        setTitle("Gestión Persona");   
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        contenedor = new JPanel();
        getContentPane().add(contenedor);
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        lblNombre = new JLabel("Nombre:");  //Crear el objeto
        contenedor.add(lblNombre);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblNombre, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNombre,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA APELLIDOS
        lblApellido = new JLabel("Apellido:");
        contenedor.add(lblApellido);
        sp.putConstraint(SpringLayout.NORTH, lblApellido, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblApellido,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA CIUDAD
        lblCiudad = new JLabel("Ciudad:");
        contenedor.add(lblCiudad);
        sp.putConstraint(SpringLayout.NORTH, lblCiudad, 130, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblCiudad,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA DOCUMENTO
        lblDocumento = new JLabel("Documento:");
        contenedor.add(lblDocumento);
        sp.putConstraint(SpringLayout.NORTH, lblDocumento, 170, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblDocumento,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA EDAD
        lblEdad = new JLabel("Edad:");
        contenedor.add(lblEdad);
        sp.putConstraint(SpringLayout.NORTH, lblEdad, 210, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEdad,  10, SpringLayout.WEST, contenedor);
        
        lblId = new JLabel("ID :");  //Crear el objeto
        contenedor.add(lblId);      //Añadirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblId, 240,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblId,  10,SpringLayout.WEST, contenedor);
        
        
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //CUADRO DE TEXTO PARA EL NOMBRE
        txtNombre       = new JTextField();
        contenedor.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 50, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNombre, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtNombre, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL APELLIDO
        txtApellido = new JTextField();
        contenedor.add(txtApellido);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtApellido, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtApellido, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtApellido, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LA CIUDAD
        txtCiudad = new JTextField();
        contenedor.add(txtCiudad);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtCiudad, 130, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtCiudad, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtCiudad, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL DOCUMENTO
        txtDocumento = new JTextField();
        contenedor.add(txtDocumento);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtDocumento, 170, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtDocumento, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtDocumento, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LA EDAD
        txtEdad      = new JTextField();
        contenedor.add(txtEdad);
        sp.putConstraint(SpringLayout.NORTH, txtEdad, 210, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEdad, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEdad, 300, SpringLayout.WEST, contenedor);
        
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
