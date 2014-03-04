package me.alert.dto;

import java.security.InvalidParameterException;

public class AlertDataDto {
	public static enum Direction {
		UP,DOWN
	}
	
	private String phone;		
	private Integer price;
	private Direction direction;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		switch(direction) {
		case "gt":
			this.direction = Direction.UP;
			break;
		case "lt":
			this.direction = Direction.DOWN;
			break;
		default:
			throw new InvalidParameterException("invalid direction received: " + direction);
		}
	}
}
