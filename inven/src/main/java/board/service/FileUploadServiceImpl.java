package board.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String restore(MultipartFile multipartFile) {
		String url = null;
		
		if (multipartFile.getOriginalFilename().equals("")) {
			return "";
		}
		
		try {
			// 파일 정보
			String saveFileName = multipartFile.getOriginalFilename();
			writeFile(multipartFile, saveFileName);
			url =  "C:/Users/Choi/Desktop/Java_Developer/spring_workspace/inven/src/main/webapp/webresources/upload/" + saveFileName;
		}
		catch (IOException e) {
			throw new RuntimeException(e);
			// Exception 직접 만들어서 던져도 됨
		}
		return url;
	}

	@Override
	public boolean writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		boolean result = false;

		byte[] data = multipartFile.getBytes();
		
		File file = new File( "C:/Users/Choi/Desktop/Java_Developer/spring_workspace/inven/src/main/webapp/webresources/upload/" + saveFileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(data);
		fos.flush();
		fos.close();
		
		result = !result;
		return result;
	}

}
