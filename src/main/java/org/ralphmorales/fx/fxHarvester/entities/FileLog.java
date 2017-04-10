package org.ralphmorales.fx.fxHarvester.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FileLog {

	private String fileName;
	private Date dateImported;
	
	public FileLog(){}
	
	public FileLog(String fileName, Date dateImported){
		this.fileName = fileName;
		this.dateImported = dateImported;
	}

	@Id
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(nullable=false, unique=true)
	public Date getDateImported() {
		return dateImported;
	}

	public void setDateImported(Date dateImported) {
		this.dateImported = dateImported;
	}
	
	
	
}
