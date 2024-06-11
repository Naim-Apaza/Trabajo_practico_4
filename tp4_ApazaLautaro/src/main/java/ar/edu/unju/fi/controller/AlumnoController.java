package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private Alumno alumno;

	@GetMapping("/lista")
	public String getListaPage(Model model) {
		model.addAttribute("alumnos", CollectionAlumno.getAlumnos());
		model.addAttribute("titulo", "Alumnos");

		return "alumnos";
	}

	@GetMapping("/nuevo")
	public String getNuevoAlumno(Model model) {
		boolean edicion = false;
		model.addAttribute("titulo", "Nuevo alumno");
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumno);

		return "alumnoFormulario";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(Model model, @ModelAttribute(value = "alumno") Alumno alumno) {
		model.addAttribute("titulo", "Alumnos");
		CollectionAlumno.agregarAlumno(alumno);
		ModelAndView modelAndView = new ModelAndView("alumnos");
		modelAndView.addObject("alumnos", CollectionAlumno.getAlumnos());

		return modelAndView;
	}

	@GetMapping("/editar/{dni}")
	public String modificarAlumnoPage(@PathVariable(value = "dni") String dni, Model model) {
		boolean edicion = true;
		Alumno alumno = CollectionAlumno.buscarAlumno(dni);
		model.addAttribute("titulo", "Editar alumno");
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumno);

		return "alumnoFormulario";
	}

	@PostMapping("/editar")
	public String ModificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		CollectionAlumno.agregarAlumno(alumno);

		return "redirect:/alumno/lista";
	}

	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable(value = "dni") String dni) {
		CollectionAlumno.eliminarAlumno(dni);

		return "redirect:/alumno/lista";
	}

}
