package board.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	public abstract String restore(MultipartFile multipartFile);
	
	public abstract boolean writeFile(MultipartFile multipartFile, String saveFileName) throws IOException;
}
