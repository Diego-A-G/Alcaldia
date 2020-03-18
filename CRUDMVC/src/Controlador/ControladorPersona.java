package Controlador;

import Modelo.ConsultasPersona;
import Modelo.Persona;
import Vista.FormularioPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorPersona implements ActionListener {
    
    private Persona modelo;
    private ConsultasPersona modeloConsultas;
    private FormularioPersona formulario;

    public ControladorPersona(Persona modelo, ConsultasPersona modeloConsulta, FormularioPersona formulario) {
        this.modelo = modelo;
        this.modeloConsultas = modeloConsulta;
        this.formulario = formulario;
        this.formulario.btnGuardar.addActionListener(this);
        this.formulario.btnModificar.addActionListener(this);
        this.formulario.btnEliminar.addActionListener(this);
        this.formulario.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        formulario.setTitle("Personas");
        formulario.setLocationRelativeTo(null);
        formulario.txtId.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        System.out.println(comando);
        switch(comando){
            case "Guardar":
                
                modelo.setId(Integer.parseInt(formulario.txtId.getText()));
                modelo.setNombre(formulario.txtNombre.getText());
                modelo.setApellido(formulario.txtApellido.getText());
                modelo.setCiudad(formulario.txtCiudad.getText());
                modelo.setDocumento(formulario.txtDocumento.getText());
                modelo.setEdad(Integer.parseInt(formulario.txtEdad.getText()));
            
                if(modeloConsultas.registrar(modelo))
                {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }       
        
                break;
            case "Eliminar":
                 modelo.setId(Integer.parseInt(formulario.txtId.getText()));
            
                if(modeloConsultas.eliminar(modelo))
                {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar");
                }
                break;
            case "Modificar":
                modelo.setId(Integer.parseInt(formulario.txtId.getText()));
                modelo.setNombre(formulario.txtNombre.getText());
                modelo.setApellido(formulario.txtApellido.getText());
                modelo.setCiudad(formulario.txtCiudad.getText());
                modelo.setDocumento(formulario.txtDocumento.getText());
                modelo.setEdad(Integer.parseInt(formulario.txtEdad.getText()));
            
                if(modeloConsultas.modificar(modelo))
                {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                }
                break;
            case "Buscar":
                modelo.setId(Integer.parseInt(formulario.txtId.getText()));
            
                if(modeloConsultas.buscar(modelo))
                {
                    formulario.txtId.setText(String.valueOf(modelo.getId()));
                    formulario.txtNombre.setText(modelo.getNombre());
                    formulario.txtApellido.setText(modelo.getApellido());
                    formulario.txtCiudad.setText(modelo.getCiudad());
                    formulario.txtDocumento.setText(modelo.getDocumento());
                    formulario.txtEdad.setText(String.valueOf(modelo.getEdad()));
                }
                else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                }
                
                break;
            case "Limpiar":
                formulario.txtId.setText(null);
                formulario.txtNombre.setText(null);
                formulario.txtApellido.setText(null);
                formulario.txtCiudad.setText(null);
                formulario.txtDocumento.setText(null);
                formulario.txtEdad.setText(null);
                break;
            default:
                System.err.println("Comando no definido");
               break;
        }

        
}
}