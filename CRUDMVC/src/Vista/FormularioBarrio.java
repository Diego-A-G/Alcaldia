package Vista;
import Controlador.ControladorPersona;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FormularioBarrio extends JFrame{
    
    private JPanel contenedor;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEstrato;
    private JLabel lblArea;
    
    public JTextField txtId;
    public JTextField txtNombre;
    public JTextField txtEstrato;
    public JTextField txtArea;
    
    public JButton btnGuardar;
    public JButton btnBuscar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiar;
    
    public FormularioBarrio() {
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
        lblEstrato = new JLabel("Apellido:");
        contenedor.add(lblEstrato);
        sp.putConstraint(SpringLayout.NORTH, lblEstrato, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEstrato,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA CIUDAD
        lblArea = new JLabel("Ciudad:");
        contenedor.add(lblArea);
        sp.putConstraint(SpringLayout.NORTH, lblArea, 130, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblArea,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA DOCUMENTO
        
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
        txtEstrato = new JTextField();
        contenedor.add(txtEstrato);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtEstrato, 90, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEstrato, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEstrato, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LA CIUDAD
        txtArea = new JTextField();
        contenedor.add(txtArea);    //añadir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtArea, 130, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtArea, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtArea, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL DOCUMENTO
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
