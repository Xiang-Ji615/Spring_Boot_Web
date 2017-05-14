package main.java.sharon.movieuploader.bo;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IMovieUploaderBo {

	Boolean uploadFile(MultipartFile uploadfile) throws IOException;
}
