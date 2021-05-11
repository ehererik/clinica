package modelo;

import java.util.HashMap;
import java.util.Iterator;

import excepciones.PacienteNoEncontradoExcepcion;

public class Patio extends Sala {
    HashMap<String,Paciente> pacientes=new HashMap<String,Paciente>();
    public Patio() {
        super();
    }

    @Override
    public void AgregaPaciente(Paciente p) {
        this.pacientes.put(p.getDni(), p);
    }

    @Override
    public void QuitaPaciente(String dni)throws PacienteNoEncontradoExcepcion {
        if(this.pacientes.get(dni)!=null)
             this.pacientes.remove(dni);
        else
            throw new PacienteNoEncontradoExcepcion(dni);
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
    public void muestraPacientes(){
        Paciente p;
        p=null;
        Iterator<Paciente> it=this.pacientes.values().iterator();
        if(this.pacientes.isEmpty())
            System.out.println("Patio vacio");
        else{
            System.out.println("Pacientes patio");
            while(it.hasNext()){
                try {
                    p = (Paciente) it.next().clone();
                } catch (CloneNotSupportedException e) {
                }
                System.out.println(p.getNombre()+" "+p.getDni()+" nro orden."+p.getNroOrden());
            }
        }
    }
}
