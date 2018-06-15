package bean;

import java.util.Date;

public class forbidbean {
	private String name;
	private Date date;
	
	
	public forbidbean(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
