package modelo;

public interface PrioridadAsignacion {
    abstract boolean establecerPriotodad(Paciente p);
    abstract boolean ninioPregunta();
    abstract boolean jovenPregunta();
    abstract boolean mayorPregunta();
}
