package crudmvc;

import Controlador.ControladorPersona;
import Modelo.ConsultasPersona;
import Modelo.Persona;
import Vista.FormularioPersona;

public class CRUDMVC {

    public static void main(String[] args) {
      
        Persona modelo = new Persona();
        ConsultasPersona modeloConsulta = new ConsultasPersona();
        FormularioPersona formulario = new FormularioPersona();
        
        ControladorPersona controlador = new ControladorPersona(modelo, modeloConsulta, formulario);
        controlador.iniciar();
        formulario.setVisible(true);
        
    }
    
}
