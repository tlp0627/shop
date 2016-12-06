package com.shop.category.vo;

import java.util.Set;

import com.shop.categorysecond.vo.CategorySecond;

/*
 * CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) 

 */
public class Category {
	private Integer cid;
	private String cname;
	Set <CategorySecond> CategroySeconds;
	public Set<CategorySecond> getCategroySeconds() {
		return CategroySeconds;
	}
	public void setCategroySeconds(Set<CategorySecond> categroySeconds) {
		CategroySeconds = categroySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
}
