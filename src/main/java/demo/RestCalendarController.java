package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCalendarController {

	@RequestMapping(value = "/cld", method={RequestMethod.GET, RequestMethod.POST},
            produces=MediaType.APPLICATION_JSON_VALUE) 
	public String getDateString(@RequestParam("date") Calendar calender) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(calender.getTime());
	}
	
	@RequestMapping(value = "/co", method={RequestMethod.GET, RequestMethod.POST},
            produces=MediaType.APPLICATION_JSON_VALUE) 
	public String getDateObject(@RequestParam("date") MyCalander calender) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(calender.getCalender().getTime());
	}
	
	@RequestMapping(value = "/cl", method={RequestMethod.GET, RequestMethod.POST}) 
	public String getDateObject(@RequestParam("date") long calender) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(calender);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(c.getTime());
	}
}
