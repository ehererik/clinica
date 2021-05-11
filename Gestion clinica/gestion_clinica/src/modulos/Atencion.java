package modulos;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

import modelo.Paciente;

public class Atencion {
    HashMap<String,Paciente> pacientes=new HashMap<String,Paciente>();
    
    public Atencion() {
        super();
    }
    public void atenderPaciente(Paciente p){
        pacientes.put(p.getDni(), p);
    }
    public void removerPaciente(String dni){
        pacientes.remove(dni);
    }
    public void muestraPacientes(){
        Paciente p;
        p=null;
        Iterator<Paciente> it=this.pacientes.values().iterator();
        if(this.pacientes.isEmpty())
            System.out.println("Atencion vacia");
        else{
            System.out.println("Pacientes en atecion");
            while(it.hasNext()){
                try {
                    p = (Paciente) it.next().clone();
                } catch (CloneNotSupportedException e) {
                }
                System.out.println(p.getNombre()+" "+p.getDni());
            }
        }
    }
}
