package modelo;


import excepciones.PacienteNoEncontradoExcepcion;

public class Sala_privada extends Sala{
        
    Paciente pac;
    
    public Sala_privada() {
        super();
    }

    
    
    public void AgregaPaciente(Paciente p) {
        this.pac=p;
    }

 
    public Paciente devuelvePaciente(){
        Paciente p1;
        p1 = null;
        try {
            if(this.pac!=null)
             p1 = (Paciente) this.pac.clone();
        } catch (CloneNotSupportedException e) {
        }
        return p1;
    }
    public void muestraPaciente(){
        if(this.pac!=null){
            System.out.println("Paciente de la sala privada");
            System.out.println(this.pac.getNombre()+" " +this.pac.getDni()+ " nro orden: "+this.pac.getNroOrden());
        }
            
        else
            System.out.println("Sala vacia");  
    }

    @Override
    public void QuitaPaciente(String dni) throws PacienteNoEncontradoExcepcion{
        if(dni!=this.pac.getDni())
            throw new PacienteNoEncontradoExcepcion(dni);
        else
            this.pac=null;
    }
}