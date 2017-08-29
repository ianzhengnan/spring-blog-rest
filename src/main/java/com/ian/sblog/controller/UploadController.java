package com.ian.sblog.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController extends BaseController {

	/**
	 * Content-type:application/octet-stream 的上传方式，如果是multipart方式与此不同，要简单许多
	 * 这里是为了适应xheditor
	 * @param request
	 * @return json object {err:"", msg:"/upload/filename.jpg"}
	 * @throws Exception
	 */
	@PostMapping("/upload")
	@ResponseBody
	public Object uploadFile(HttpServletRequest request) throws Exception {
		String fileName = "";
		try {
			InputStream inputStream = request.getInputStream();
			
			if (inputStream != null) {
				String disposition = request.getHeader("Content-Disposition");
				fileName = disposition.replaceFirst("(?i).*filename=\"([^\"]+)\".*$", "$1");
				String path = request.getServletContext().getRealPath("/upload/");
				path += fileName;
				FileOutputStream outputStream = new FileOutputStream(new File(path));
				
				byte[] buffer = new byte[1024];
				
				int bytesRead;
				
				while((bytesRead = inputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.flush();
				outputStream.close();
			}
		} catch (FileNotFoundException e) {
			log.error(e.toString(), e);
		} catch (IOException e) {
			log.error(e.toString(), e);
		} catch (Exception e) {
			log.error(e.toString(), e);
		} finally {
		}
		
		return new UploadMsg("/upload/" + fileName, "");
		
	}
	
	class UploadMsg {
		private String msg;
		private String err;
		public UploadMsg(String msg, String err) {
			this.msg = msg;
			this.err = err;
		}
		public String getMsg() {
			return this.msg;
		}
		public String getErr() {
			return this.err;
		}
	}
}
