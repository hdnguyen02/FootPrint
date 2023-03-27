package footprint.bean;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {
	private String basePath;

	public String getbasePath() {
		return basePath;
	}

	public void setbasePath(String basePath) {
		this.basePath = basePath;
	}

	public UploadFile(String basePath) {
		this.basePath = basePath;
	}

	public UploadFile() {
	}

	public String handleUploadFile(MultipartFile file) {
	
		if (file.isEmpty()) { 
			 return null;
		}

		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddmmHH");
			String formattedDateTime = now.format(formatter);
			String fileName = formattedDateTime + file.getOriginalFilename();
			String photoPath = this.getbasePath() + File.separator + fileName;
			file.transferTo(new File(photoPath));
			return fileName; 
		} catch (Exception e) {
			return null;
		}
	}
	
	// khởi tạo 1 hàm sử lý thumbnail 
	// trả về 1 array tên của các hình ảnh 
	public String [] handleUploadFiles(MultipartFile [] files) {
		int lenghtFiles = files.length; 
		String [] nameFiles = new String[lenghtFiles]; 
		int indexHandle = 0;
		for (MultipartFile file : files) {
			// sử lý tại đây.  
			
			String fileName = this.handleUploadFile(file); 
			if ( fileName != null) {
				nameFiles[indexHandle] = fileName;
			}
			else { // trường hợp có 1 file sử lý thất bại
				return null;
			}
			
			indexHandle++; // thay cho biến index 
		}
		// 
		
		return nameFiles; 
	}
	
}
