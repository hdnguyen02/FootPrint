package footprint.helper.impl;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import footprint.helper.ConverterUploadHandler;

public class ConvertUploadHandlerBehaviour implements ConverterUploadHandler {

	@Override
	public boolean MoveMultipartToDirectory(MultipartFile fileUpload, String path) {
		String imageName = fileUpload.getOriginalFilename();
		String pathDir = String.format("%s%s", path, imageName);
		if (!fileUpload.isEmpty()) {
			try {
				File file = new File(pathDir);
				if(file.exists())
				{
					file.delete();
				}
				fileUpload.transferTo(file);
				Thread.sleep(3000);
				return true;
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		return false;
	}

	@Override
	public String SetImageNameViaMultipartFile(MultipartFile fileUpload) {
		return fileUpload.getOriginalFilename();
	}

}
