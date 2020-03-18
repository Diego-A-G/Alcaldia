package Controlador;

import Modelo.ConsultasInstitucion;
import Modelo.Institucion;
import Vista.FormularioInstitucion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorInstitucion implements ActionListener {
    
    private Institucion modelo;
    private ConsultasInstitucion modeloConsultas;
    private FormularioInstitucion formulario;

    public ControladorInstitucion(Institucion modelo, ConsultasInstitucion modeloConsultas, FormularioInstitucion formulario) {
        this.modelo = modelo;
        this.modeloConsultas = modeloConsultas;
        this.formulario = formulario;
        this.formulario.btnGuardar.addActionListener(this);
        this.formulario.btnModificar.addActionListener(this);
        this.formulario.btnEliminar.addActionListener(this);
        this.formulario.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        formulario.setTitle("Instituciones");
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
                modelo.setRazonSocial(formulario.txtRazonSocial.getText());
                modelo.setActividadEconomica(formulario.txtActividadEconomica.getText());
            
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
                modelo.setRazonSocial(formulario.txtRazonSocial.getText());
                modelo.setActividadEconomica(formulario.txtActividadEconomica.getText());
                
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
                    formulario.txtRazonSocial.setText(modelo.getRazonSocial());
                    formulario.txtActividadEconomica.setText(modelo.getActividadEconomica());
                }
                else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                }
                
                break;
            case "Limpiar":
                formulario.txtId.setText(null);
                formulario.txtRazonSocial.setText(null);
                formulario.txtActividadEconomica.setText(null);
                break;
            default:
                System.err.println("Comando no definido");
               break;
        }

        
}
}