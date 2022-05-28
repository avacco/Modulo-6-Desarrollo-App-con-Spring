package cl.andres.java.upload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.andres.java.upload.model.Archivo;
import cl.andres.java.upload.repository.ArchivoRepository;

@Controller
public class AppController {

	@Autowired
	ArchivoRepository archivoRepository;
	
	@GetMapping("/")
	public String form() {
		return "form";
	}
	
	@GetMapping("/exito")
	public String exito() {
		return "exito";
	}
	
	// recibe el parametro de name "archivo" del html, lo convierte en un objeto MultipartFile
	@PostMapping("/")
	public String procesar(@RequestParam(name = "archivo") MultipartFile archivo) {
		try {
			// setea el string nombreArchivo con el nombre original del archivo
			String nombreArchivo = archivo.getOriginalFilename();
			
			// setea el string tipoArchivo con la extension y tipo del archivo
			String tipoArchivo = archivo.getContentType();
			
			// guarda en un byte[] el archivo proper
			byte[] contenidoArchivo = archivo.getBytes();
			
			Archivo archivoDB = Archivo.builder()
											.datos(contenidoArchivo)
											.nombre(nombreArchivo)
											.tipo(tipoArchivo)
											.build()
									;
			archivoRepository.saveAndFlush(archivoDB);

			return "redirect:/exito";
		} catch (IOException e) {
			e.printStackTrace();
			return "formulario";
		}
	}
	
	//								donde 1 = id
	//http://localhost:8080/archivo/a/1 = descarga el archivo
	//http://localhost:8080/archivo/i/1 = muestra el archivo
	@GetMapping("/archivo/{disposicion}/{id}")
	public ResponseEntity<byte[]> mostrarDescargarArchivo(
			@PathVariable("disposicion") String disposicion,
			@PathVariable("id") 		 Archivo archivo
		){
		String disposition = null;
		if("a".equalsIgnoreCase(disposicion)) {
			disposition = "attachment";
		}else {
			disposition = "inline";
		}
			return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, disposition)
				.contentType(MediaType.valueOf(archivo.getTipo()))
				.body(archivo.getDatos());
		}
}
