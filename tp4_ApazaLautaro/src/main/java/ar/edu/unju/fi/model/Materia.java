package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	private long codigo;
	private String nombre;
	private String curso;
	private String cantidadHoras;
	private boolean modalidad;
	@Autowired
	private Docente docente;
	@Autowired
	private Carrera carrera;

	public Materia() {
	}

	public Materia(long codigo, String nombre, String curso, String cantidadHoras, boolean modalidad, Docente docente,
			Carrera carrera) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(String cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public boolean isModalidad() {
		return modalidad;
	}

	public void setModalidad(boolean modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", cantidadHoras="
				+ cantidadHoras + ", modalidad=" + modalidad + ", docente=" + docente + ", carrera=" + carrera + "]";
	}

}
