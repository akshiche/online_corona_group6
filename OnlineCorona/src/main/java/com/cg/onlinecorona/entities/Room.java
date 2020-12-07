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
@Table(name="rooms")
public class Room implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
private String roomId;
private String roomtype;
private int roomPrice;
/**
 * to get roomId
 * @return roomId
 */
public String getRoomId() {
	return roomId;
}
/**
 * to get roomType
 * @return roomType
 */
public String getRoomType() {
	return roomtype;
}
/**
 * to set roomType
 * @param roomType
 */
public void setRoomType(String roomtype) {
	this.roomtype = roomtype;
}
/**
 * to set roomId
 * @param roomId
 */
public void setRoomId(String roomId) {
	this.roomId = roomId;
}
/**
 * to get roomPrice
 * @return roomPrice
 */
public int getRoomPrice() {
	return roomPrice;
}
/**
 * to set roomPrice
 * @param roomPrice
 */
public void setRoomPrice(int roomPrice) {
	this.roomPrice = roomPrice;
}

@Override
public String toString() {
	return "Room [roomId=" + roomId + ", roomtype=" + roomtype + ", roomPrice=" + roomPrice + "]";
}

public Room() {
	super();

}

}
