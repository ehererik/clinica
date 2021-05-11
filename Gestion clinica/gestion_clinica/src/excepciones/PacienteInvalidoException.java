package excepciones;

import modelo.Paciente;

public class PacienteInvalidoException extends Exception {

	private Paciente paciente;

	public PacienteInvalidoException(String message, Paciente paciente) {
		super(message);
		this.paciente = paciente;
	}
	
	public Paciente getPaciente() {
		return this.paciente;
	}
	
}
