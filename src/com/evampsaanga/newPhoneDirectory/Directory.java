package com.evampsaanga.newPhoneDirectory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
@RequestScoped
public class Directory {

	public int id;
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public String emailAddress;
	public String address;
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
	
	

		
	public ArrayList<Directory> userDirectory ;
	
	public Directory() {
		
	}
	@PostConstruct
	public void init() {
		userDirectory = new ArrayList<Directory>(Arrays.asList(

				new Directory(1, "Talha", "Shah", "03415492830", "talhawaleed015@gmail.com", "Nilore"),
				new Directory(2, "Ali", "Hassan", "03442141288", "mr.ali015@gmail.com", "Islamabad"),
				new Directory(3, "Ali", "Hassan", "03442141288", "mr.ali015@gmail.com", "Islamabad")
				

		));
	}
	

	

	public Directory(int id, String firstName, String lastName, String phoneNumber, String emailAddress, String address
			) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		
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

	public ArrayList<Directory> getDirectory() {
		return userDirectory;
	}

	public void deleteAction(Directory phone) {
		userDirectory.remove(phone);
	}

	public void addAction() {

		Directory phone = new Directory(this.id, this.firstName, this.lastName, this.phoneNumber, this.emailAddress,
				this.address);

		userDirectory.add(phone);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public ArrayList<Directory> getUserdirectory() {
		return userDirectory;
	}

	

}
