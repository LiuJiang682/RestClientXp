package demo;

import java.io.Serializable;
import java.util.Calendar;

public class MyCalander implements Serializable {

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 6903812246910957608L;
	
	private Calendar calender;

	public Calendar getCalender() {
		return calender;
	}

	public void setCalender(Calendar calender) {
		this.calender = calender;
	}
	
}
