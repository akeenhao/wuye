package com.serve.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;


import com.serve.pojo.common.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	//上传
	public static String upload(MultipartFile file) throws IOException {

		String uuid = UUID.randomUUID().toString();
		File path = new File(Const.FILE_PATH);
		if(!path.exists()){//如果文件夹不存在
			path.mkdir();//创建文件夹
		}
		String filePath = Const.FILE_PATH +uuid+"_"+file.getOriginalFilename();
		logger.info("file上传:"+filePath);
		
		File covertFile = new File(filePath);
		covertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(covertFile);
		fout.write(file.getBytes());
		fout.close();
		return filePath;
	}
	
	//下载
	public static ResponseEntity<Object> download(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
		File file = new File(filePath);
		InputStreamResource resource = new InputStreamResource(new FileInputStream((file)));
		String fileName = URLEncoder.encode(file.getName(),"UTF-8");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", fileName));
		headers.add("Cache-Control", "no-cache,no-store,must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/text")).body(resource);
		return responseEntity;
		
	}
	
	
}
