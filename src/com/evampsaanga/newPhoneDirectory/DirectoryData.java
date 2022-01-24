package com.evampsaanga.newPhoneDirectory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

@ManagedBean
@RequestScoped
public class DirectoryData {

	private Part uploadedFile;
	private String text;
	
	
	public Part getUploadFile() {
		return uploadedFile;
	}
	public void setUploadFile(Part uploadFile) {
		this.uploadedFile = uploadFile;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	public void upload() {
		 if (null != uploadedFile) {
	            try {
	                InputStream is = uploadedFile.getInputStream();
	                text = new Scanner(is).useDelimiter("\\A").next();
	            } catch (IOException ex) {
	            }
	        }
	}
}
