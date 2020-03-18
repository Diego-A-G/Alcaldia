package Controlador;

import Modelo.ConsultasBarrio;
import Modelo.Barrio;
import Vista.FormularioBarrio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorBarrio implements ActionListener {
    
    private Barrio modelo;
    private ConsultasBarrio modeloConsultas;
    private FormularioBarrio formulario;

    public ControladorBarrio(Barrio modelo, ConsultasBarrio modeloConsultas, FormularioBarrio formulario) {
        this.modelo = modelo;
        this.modeloConsultas = modeloConsultas;
        this.formulario = formulario;
        this.formulario.btnGuardar.addActionListener(this);
        this.formulario.btnModificar.addActionListener(this);
        this.formulario.btnEliminar.addActionListener(this);
        this.formulario.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        formulario.setTitle("Barrios");
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
                modelo.setEstrato(Integer.parseInt(formulario.txtEstrato.getText()));
                modelo.setArea(formulario.txtArea.getText());
            
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
                modelo.setEstrato(Integer.parseInt(formulario.txtEstrato.getText()));
                modelo.setArea(formulario.txtArea.getText());
                
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
                    formulario.txtEstrato.setText(String.valueOf(modelo.getEstrato()));
                    formulario.txtArea.setText(modelo.getArea());
                }
                else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                }
                
                break;
            case "Limpiar":
                formulario.txtId.setText(null);
                formulario.txtNombre.setText(null);
                formulario.txtEstrato.setText(null);
                formulario.txtArea.setText(null);
                break;
            default:
                System.err.println("Comando no definido");
               break;
        }

        
}
}