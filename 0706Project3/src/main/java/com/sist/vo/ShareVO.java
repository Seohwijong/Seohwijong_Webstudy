package com.sist.vo;
/*
	 * skdno  number  NOT NULL,
	
	title  varchar2(500)  NOT NULL,
	
	sub_title  varchar2(400)  NOT NULL,
	
	intro  clob  NOT NULL,
	
	run  varchar2(1000) NOT NULL,
	
	holi  varchar2(200) ,
	
	info  clob  NOT NULL,
	
	caution  clob  NOT NULL,
	
	address  varchar2(1000)  NOT NULL,
	
	hs_tag  varchar2(800)  NOT NULL,
	
	max_mem  varchar2(300),
	
	poster  varchar2(400),
	
	price  varchar2(100),
	
	refund  clob  NOT NULL,
 */
public class ShareVO {
 private int skdno;
 private String title,sub_title,intro,run,holi,info,caution,address,hs_tag,max_mem,poster,price,refund;
public int getSkdno() {
	return skdno;
}
public void setSkdno(int skdno) {
	this.skdno = skdno;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSub_title() {
	return sub_title;
}
public void setSub_title(String sub_title) {
	this.sub_title = sub_title;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public String getRun() {
	return run;
}
public void setRun(String run) {
	this.run = run;
}
public String getHoli() {
	return holi;
}
public void setHoli(String holi) {
	this.holi = holi;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String getCaution() {
	return caution;
}
public void setCaution(String caution) {
	this.caution = caution;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getHs_tag() {
	return hs_tag;
}
public void setHs_tag(String hs_tag) {
	this.hs_tag = hs_tag;
}
public String getMax_mem() {
	return max_mem;
}
public void setMax_mem(String max_mem) {
	this.max_mem = max_mem;
}
public String getPoster() {
	return poster;
}
public void setPoster(String poster) {
	this.poster = poster;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getRefund() {
	return refund;
}
public void setRefund(String refund) {
	this.refund = refund;
}
 
}
