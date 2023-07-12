package com.sist.vo;

import java.util.*;

/*
	 * rdno      number        NOT NULL,
	  title     varchar2(200) NOT NULL,
	  poster     VARCHAR2(260) NOT NULL,
	  chef      varchar2(100) NOT NULL,
	  chef_pos  varchar2(260) ,
	  content   clob, --content
	  info_1    varchar2(50)  , --
	  info_2    varchar2(50)  , --
	  info_3    varchar2(50)  , --
	  chef_info varchar2(500),
	  step_pos clob ,
	  step_text clob ,
 */
public class RecipeVO {
 private int rdno;
 private String title,poster,chef,chef_pos,content,info_1,info_2,info_3,chef_info;
 private String step_pos,step_text;
 


public String getStep_pos() {
	return step_pos;
}
public void setStep_pos(String step_pos) {
	this.step_pos = step_pos;
}
public String getStep_text() {
	return step_text;
}
public void setStep_text(String step_text) {
	this.step_text = step_text;
}
public int getRdno() {
	return rdno;
}
public void setRdno(int rdno) {
	this.rdno = rdno;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public String getChef() {
	return chef;
}
public void setChef(String chef) {
	this.chef = chef;
}
public String getChef_pos() {
	return chef_pos;
}
public void setChef_pos(String chef_pos) {
	this.chef_pos = chef_pos;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getInfo_1() {
	return info_1;
}
public void setInfo_1(String info_1) {
	this.info_1 = info_1;
}
public String getInfo_2() {
	return info_2;
}
public void setInfo_2(String info_2) {
	this.info_2 = info_2;
}
public String getInfo_3() {
	return info_3;
}
public void setInfo_3(String info_3) {
	this.info_3 = info_3;
}
public String getChef_info() {
	return chef_info;
}
public void setChef_info(String chef_info) {
	this.chef_info = chef_info;
}

 
}
