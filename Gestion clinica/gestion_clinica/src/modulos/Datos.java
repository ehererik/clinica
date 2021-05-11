package modulos;

import java.util.HashMap;
import java.util.Iterator;

import excepciones.PacienteMismoDniExcepcion;
import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Paciente;

public class Datos {
    HashMap<String,Paciente> pacientes =new HashMap<String,Paciente>();
    
    public Datos() {
        super();
    }

    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public Paciente consultarPaciente(String dni)throws PacienteNoEncontradoExcepcion{
        Paciente p1;
        p1=null;
        try {
            if(!this.pacientes.isEmpty()){
                 p1=this.pacientes.get(dni);
                if(p1!=null)
                     p1 = (Paciente) p1.clone();
            }
        }
         catch (CloneNotSupportedException e) {  
        }
        if(p1==null)
            throw new PacienteNoEncontradoExcepcion(dni);
        else
            return p1;
    }
    public void modPacienteTel(String dni,String tel)throws PacienteNoEncontradoExcepcion{
        Paciente p1;
        p1=null;
        try {
            if(!this.pacientes.isEmpty())
                p1 = (Paciente) this.pacientes.get(dni).clone();
        } catch (CloneNotSupportedException e) {  
        }
        if(p1==null)
            throw new PacienteNoEncontradoExcepcion(dni);
        else{
            p1.setTelefono(tel);
            this.pacientes.remove(p1.getDni());
            this.pacientes.put(p1.getDni(), p1);
        }
    }
    public void modPacienteCiu(String dni,String ciu)throws PacienteNoEncontradoExcepcion{
        Paciente p1;
        p1=null;
        try {
            if(!this.pacientes.isEmpty())
                p1 = (Paciente) this.pacientes.get(dni).clone();
        } catch (CloneNotSupportedException e) {  
        }
        if(p1==null)
            throw new PacienteNoEncontradoExcepcion(dni);
        else{
            p1.setCiudad(ciu);
            this.pacientes.remove(p1.getDni());
            this.pacientes.put(p1.getDni(), p1);
        }
    }
    public void modPacienteNomyApe(String dni,String nom,String ape)throws PacienteNoEncontradoExcepcion{
        Paciente p1;
        p1=null;
        try {
            if(!this.pacientes.isEmpty())
            p1 = (Paciente) this.pacientes.get(dni).clone();
        } catch (CloneNotSupportedException e) {  
        }
        if(p1==null)
            throw new PacienteNoEncontradoExcepcion(dni);
        else{
            p1.setNombre(nom);
            p1.setApellido(ape);
            this.pacientes.remove(p1.getDni());
            this.pacientes.put(p1.getDni(), p1);
        }
    }
    public void modPacienteDom(String dni,String dom)throws PacienteNoEncontradoExcepcion{
        Paciente p1;
        p1=null;
        try {
            if(!this.pacientes.isEmpty())
                p1 = (Paciente) this.pacientes.get(dni).clone();
        } catch (CloneNotSupportedException e) {  
        }
        if(p1==null)
            throw new PacienteNoEncontradoExcepcion(dni);
        else{
            p1.setDomicilio(dom);
            this.pacientes.remove(p1.getDni());
            this.pacientes.put(p1.getDni(), p1);
        }
    }
    
    
    public HashMap<String,Paciente> listaPacientes(){
        Paciente p;
        HashMap<String,Paciente> copia =new HashMap<String,Paciente>();
       Iterator<Paciente> it=this.pacientes.values().iterator();
       while(it.hasNext()){
            try {
                p = (Paciente) it.next().clone();
                copia.put(p.getDni(),p);
            } catch (CloneNotSupportedException e) {
            }
        }
       return copia;
    }
    public void removerPaciente(String dni)throws PacienteNoEncontradoExcepcion{
        if (this.pacientes.remove(dni)==null)
            throw new PacienteNoEncontradoExcepcion(dni);
    }
    public void AltaPaciente(Paciente p)throws PacienteMismoDniExcepcion{
        if(this.pacientes.get(p.getDni())!=null)
            throw new PacienteMismoDniExcepcion(p.getDni());
        else
            this.pacientes.put(p.getDni(), p);
    }
}
