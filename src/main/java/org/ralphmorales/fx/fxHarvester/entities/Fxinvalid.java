package org.ralphmorales.fx.fxHarvester.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Fxinvalid {

	private Long id;
	private String invalidRecord;
	private String fileName;	
	
	public Fxinvalid(){}
	
	public Fxinvalid(String invalidRecord, String fileName){
		this.invalidRecord = invalidRecord;
		this.fileName = fileName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="invalidRecord", nullable=false)
	public String getInvalidRecord() {
		return invalidRecord;
	}
	public void setInvalidRecord(String invalidRecord) {
		this.invalidRecord = invalidRecord;
	}
	
	@Column(name="fileName", nullable=false)
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
