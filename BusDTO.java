package Reg_Controllers;

import java.util.List;
/*
 * This class is an encapsulated class having only details for the buses available 
 * only setters and getter methods used to access data members
 */
public class BusDTO {
	private String fromDest;
	private String toDest;
	private String busName;
	private String startTime;
	public String getFromDest() {
		return fromDest;
	}
	public void setFromDest(String fromDest) {
		this.fromDest = fromDest;
	}
	public String getToDest() {
		return toDest;
	}
	public void setToDest(String toDest) {
		this.toDest = toDest;
	}
	private String endTime;
	private String ac_type;
	private String sleep_type;
	private int rate;
	private List<BusDTO> bus;
	
	
	
	
	public List<BusDTO> getBus() {
		return bus;
	}
	public void setBus(List<BusDTO> bus) {
		this.bus = bus;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAc_type() {
		return ac_type;
	}
	public void setAc_type(String ac_type) {
		this.ac_type = ac_type;
	}
	public String getSleep_type() {
		return sleep_type;
	}
	public void setSleep_type(String sleep_type) {
		this.sleep_type = sleep_type;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
