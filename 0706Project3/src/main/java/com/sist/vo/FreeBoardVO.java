package com.sist.vo;
import java.util.*;

/*
 	bno 	NUMBER,
	name VARCHAR2(51) CONSTRAINT yf_name_nn NOT NULL,
	subject VARCHAR2(2000) CONSTRAINT yf_sub_nn NOT NULL,
	content CLOB CONSTRAINT yf_cont_nn NOT NULL,
	filename VARCHAR2(400),
	filesize NUMBER,
	pwd VARCHAR2(10) CONSTRAINT yf_pwd_nn NOT NULL,
	regdate DATE DEFAULT SYSDATE,
	hit NUMBER DEFAULT 0,
	suggest NUMBER DEFAULT 0,
	CONSTRAINT yf_bno_pk PRIMARY KEY(bno)
);
 */
public class FreeBoardVO {
	private int bno,filesize,hit,suggest,rownum;
	private String name,subject,content,filename,pwd,dbday;
	private Date regdate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getSuggest() {
		return suggest;
	}
	public void setSuggest(int suggest) {
		this.suggest = suggest;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
