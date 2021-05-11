package modulos;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import excepciones.PacienteNoEncontradoExcepcion;
import modelo.Paciente;
import modelo.Patio;
import modelo.Sala_privada;

public class Ingreso {
    private Sala_privada salaPriv=new Sala_privada();
    private Patio pat=new Patio();
    private  int Capacidad ;
    private int cantPac=0;
    private static int nroORden=0;
    private Queue<Paciente> colaDeEspera = new LinkedList<>();

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCantPac(int cantPac) {
        this.cantPac = cantPac;
    }

    public int getCantPac() {
        return cantPac;
    }

    public static int getNroORden() {
        return nroORden;
    }

    public Ingreso() {
        super();
    }
   
    public void ingresaPaciente(Paciente p){
        Paciente pSalaPriv;
        pSalaPriv=null;
        colaDeEspera.add(p);
        p.setNroOrden(this.nroORden++);
        pSalaPriv=salaPriv.devuelvePaciente();
        if(p.establecerPriotodad(pSalaPriv)){
            salaPriv.AgregaPaciente(p);
            if(pSalaPriv!=null)
                pat.AgregaPaciente(pSalaPriv);
            }
            else
                pat.AgregaPaciente(p);    
    }
    public void atenderPaciente(Atencion a) {
        Paciente p;
        try{
            p=colaDeEspera.remove();
            a.atenderPaciente(p);
            try {
                this.pat.QuitaPaciente(p.getDni());
            } catch (PacienteNoEncontradoExcepcion e) {
                try {
                    this.salaPriv.QuitaPaciente(e.getDato());
                } catch (PacienteNoEncontradoExcepcion f) {
                    System.out.println("Paciente no encontrado en Ingreso");
                }
            }
        }
        catch(NoSuchElementException e){
            System.out.println("No hay pacientes en espera de atencion");
        }

    }
    public void muestraPacSalaPriv(){
        this.salaPriv.muestraPaciente();
    }
    public void muestraPacPatio(){
        this.pat.muestraPacientes();
    }
}
