package com.cg.onlinecorona.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author AKSHITHA
 *
 */
@Entity
@Table(name="wards")
public class Ward implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
private String wardId;
private String wardtype;
private int wardPrice;
/**
 * to get wardId
 * @return wardId
 */
public String getWardId() {
	return wardId;
}
/** 
 *  to set wardId
 * @param wardId
 */
public void setWardId(String wardId) {
	this.wardId = wardId;
}
/**
 * to get wardType
 * @return wardType
 */
public String getWardtype() {
	return wardtype;
}
/**
 * to set wardType
 * @param wardtype
 */
public void setWardtype(String wardtype) {
	this.wardtype = wardtype;
}
/**
 * to get wardPrice
 * @return wardPrice
 */
public int getWardPrice() {
	return wardPrice;
}
/**
 * to set wardPrice
 * @param wardPrice
 */
public void setWardPrice(int wardPrice) {
	this.wardPrice = wardPrice;
}
@Override
public String toString() {
	return "Ward [wardId=" + wardId + ", wardtype=" + wardtype + ", wardPrice=" + wardPrice + "]";
}

public Ward() {
	super();
}
}