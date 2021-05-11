package modulos;

import excepciones.PacienteMismoDniExcepcion;
import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Paciente;

public class Recepcion {
    
    public Recepcion() {
        super();
    }
    public  void peticionAlta(Datos d,Paciente p){
        try {
            d.AltaPaciente(p);
        } catch (PacienteMismoDniExcepcion e) {
            System.out.println("Dni = "+e.getDni()+" ya está registrado como paciente");
        }
    }
    public void peticionModTel(Datos d,String dni, String tel){
        try {
            d.modPacienteTel(dni, tel);
        } catch (PacienteNoEncontradoExcepcion e) {
            System.out.println("Dni = "+e.getDato()+" no arrojó coincidencias");
            
        }
    }
    public void peticionModDom(Datos d,String dni, String dom){
        try {
            d.modPacienteDom(dni, dom);
        } catch (PacienteNoEncontradoExcepcion e) {
            System.out.println("Dni = "+e.getDato()+" no arrojó coincidencias");
            
        }
    }
    public void peticionModNyA(Datos d,String dni, String nom,String ape){
        try {
            d.modPacienteNomyApe(dni, nom, ape);
        } catch (PacienteNoEncontradoExcepcion e) {
            System.out.println("Dni = "+e.getDato()+" no arrojó coincidencias");
        }
    }
    
    public void peticionBaja(Datos d,String dni){
        try {
            d.removerPaciente(dni);
        } catch (PacienteNoEncontradoExcepcion e) {
            System.out.println("Dni = "+e.getDato()+" no arrojó coincidencias");
        }
    }

   public Paciente peticionConsulta(Datos d,String dni){
        Paciente p=null;
        try {
             p=(Paciente)d.consultarPaciente(dni);
        } catch (PacienteNoEncontradoExcepcion e) {
            System.out.println("Dni = "+e.getDato()+" no arrojó coincidencias");
        }
        return p;
    }
   public void ingresarPaciente(Paciente p,Ingreso in){
            in.ingresaPaciente(p);
   }
}
