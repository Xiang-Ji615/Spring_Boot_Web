package main.java.sharon.movieuploader.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import main.java.sharon.movieuploader.bo.IMovieUploaderBo;

@RestController
@RequestMapping(value = "Rest")
public class RestfulController {

	@Autowired
	IMovieUploaderBo movieUploadBo;

	@RequestMapping(value = "HelloWorld", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	public ResponseEntity<?> helloWorld() {
		return ResponseEntity.ok().body("Hello world");
	}

	@RequestMapping(value = "HelloWorld", method = RequestMethod.GET)
	public Object helloWorld2() {
		return "Hello world";
	}

	@RequestMapping(value = "UploadMovies", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

		if (uploadfile.isEmpty()) {
			return ResponseEntity.ok().body("please select a file!");
		}
		try {
			movieUploadBo.uploadFile(uploadfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body("Successfully uploaded - " + uploadfile.getOriginalFilename());
	}

}
