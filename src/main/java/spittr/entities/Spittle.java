package spittr.entities;

import java.util.Date;

public class Spittle {
	private long id;
	private String message;
	private Date time;
	private double latitude;
	private double longtitude;
	public Spittle(String message, Date time, double latitude, double longtitude) {
		super();
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	public Spittle(String message, Date time) {
		super();
		this.message = message;
		this.time = time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	
}
