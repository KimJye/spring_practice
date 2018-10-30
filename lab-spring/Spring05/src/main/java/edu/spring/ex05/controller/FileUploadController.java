package edu.spring.ex05.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	private static final String UPLOAD_PATH =
			"C:\\Study\\FileUpload";
	
	private static final Logger logger =
			LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value = "/fileupload",
			method = RequestMethod.GET)
	public void upload() {
		logger.info("upload() GET 호출");
	} // end upload()
	
	@RequestMapping(value = "/fileupload",
			method = RequestMethod.POST)
	public void upload(MultipartFile uploadFile, Model model) {
		logger.info("upload() POST 호출");
		logger.info("파일 이름: {}", 
				uploadFile.getOriginalFilename());
		logger.info("파일 크기: {}", uploadFile.getSize());
		
		String result = saveFile(uploadFile);
		if (result != null) { // 파일 저장 성공
			model.addAttribute("result", result);
		} else { // 파일 저장 실패
//			model.addAttribute("result", "fail");
		}
		
	} // end upload(MultipartFile)

	private String saveFile(MultipartFile file) {
		// 파일 이름 변경
		UUID uuid = UUID.randomUUID();
		String saveName = uuid + "_" + file.getOriginalFilename();
		logger.info("saveName: {}", saveName);
		
		// 저장할 File 객체를 생성
		File saveFile = new File(UPLOAD_PATH, saveName);
		
		// 생성된 파일 객체를 저장
		try {
//			file.transferTo(saveFile);
			FileCopyUtils.copy(file.getBytes(), saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return saveName;
	} // end saveFile()
	
	@RequestMapping(value = "/fileupload2",
			method = RequestMethod.POST)
	public String upload(MultipartFile[] uploadFiles, Model model) {
		
		String result = "";
		for (MultipartFile f : uploadFiles) {
			result += saveFile(f);
		}
		model.addAttribute("result", result);
		
		return "fileupload";
	}
	
} // end class FileUploadController




















