package digitaldairy;

public class Event implements Comparable<Event>
{
	
	private Integer month, day, year, hour, min;
	private String pmam, title, info;
	
	
	public Event(Integer month, Integer day, Integer year, Integer hour, Integer min, String pmam, String title, String memo)
	{
		this.month = month;
		this.day = day;
		this.year = year;
		this.hour = hour;
		this.min = min;
		this.pmam = pmam;
		this.title = title;
		this.info = memo;
	}

	public Integer getMonth() 
	{
		return month;
	}
	
	public String getMonthS()
	{
		switch(month)
		{
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8: 
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
			default:
				return "October";
		}
	}

	public void setMonth(Integer month) 
	{
		this.month = month;
	}

	public Integer getDay()
	{
		return day;
	}

	public void setDay(Integer day)
	{
		this.day = day;
	}

	public Integer getYear() 
	{
		return year;
	}

	public void setYear(Integer year) 
	{
		this.year = year;
	}

	public Integer getHour() 
	{
		return hour;
	}

	public void setHour(Integer hour)
	{
		this.hour = hour;
	}

	public Integer getMin() 
	{
		return min;
	}

	public void setMin(Integer min) 
	{
		this.min = min;
	}

	public String getPmam()
	{
		return pmam;
	}

	public void setPmam(String pmam)
	{
		this.pmam = pmam;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int compareTo(Event e) 
	{
		if (getYear().compareTo(e.getYear()) != 0)
	        return getYear().compareTo(e.getYear());
	    if (getMonth().compareTo(e.getMonth()) != 0)
	        return getMonth().compareTo(e.getMonth());
	    if (getDay().compareTo(e.getDay()) != 0)
	        return getDay().compareTo(e.getDay());
	    if (getPmam().compareTo(e.getPmam()) != 0)
	        return getPmam().compareTo(e.getPmam());
	    if (getHour().compareTo(e.getHour()) != 0)
	        return getHour().compareTo(e.getHour());
	    return getMin().compareTo(e.getMin());
	}
	
	public String toString()
	{
		String h = "", m = "";
		if(hour < 10)
			h = "0" + hour;
		else
			h = "" + hour;
		if(min < 10)
			m = "0" + min;
		else
			m = "" + min;
		return month + "/" + day + "  " + h + ":" + m + " " + pmam + "    " + title;
	} 
	
}
