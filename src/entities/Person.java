package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person {

	private String name;
	private String mac;
	private Date dateBegin;
	private Integer days;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Date date = new Date();
	
	public Person(String name, String mac, String dateBegin, String days){
		this.name = name;
		this.mac = mac;
		try {
		this.dateBegin = sdf.parse(dateBegin);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		this.days = Integer.parseInt(days);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Date getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@SuppressWarnings("unused")
	private Date dateFinal() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateBegin);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}
	
	public String defeated() {
		Date date2 = dateFinal();
		if (date.compareTo(date2) > 0) {
			return "Vencido";
		}
		return "OK";
	}
	
	@Override
	public String toString() {
		return name + "," + mac + "," + defeated();
	}
	
	
}
