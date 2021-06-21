package modelo;


import excepciones.PacienteNoEncontradoExcepcion;


/**
 *  *  Clase sala_privada uso de patron singleton ya que se usa una sola instancia contiene los pacientes ingrsados en la sala privada

 */
public class Sala_privada extends Sala{
        
    Paciente pac;
    private static Sala_privada _instance=null;
    
    private Sala_privada() {
        super();
    }

    public static Sala_privada getInstace(){
        if(_instance==null)
            _instance= new Sala_privada();
        return _instance;
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
            System.out.println(this.pac.getNombre()+" dni: " +this.pac.getDni()+ " nro orden: "+this.pac.getNroOrden());
        }
            
        else
            System.out.println("Sala vacia");  
    }

    @Override
    public void QuitaPaciente(String dni) throws PacienteNoEncontradoExcepcion{
        if(dni!=this.pac.getDni())
            throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.",dni);
        else
            this.pac=null;
    }
}