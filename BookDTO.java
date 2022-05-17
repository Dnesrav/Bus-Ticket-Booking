package Reg_Controllers;
/*
 * This class is an encapsulated class having only detai;s for the bookings done by user 
 * only setters and getter methods used to access data members
 */
public class BookDTO {
	private String fromDest;
	private String toDest;
	private String bDate;
	
	private String busName;
	private String startTime;
	private String endTime;
	private String ac_type;
	private String sleep_type;
	private String rate;
	private int seatCap;
	public int getSeatCap() {
		return seatCap;
	}
	public void setSeatCap(int seatCap) {
		this.seatCap = seatCap;
	}
	/*@Override
	public String toString() {
		return "[fromDest=" + fromDest + ", toDest=" + toDest + ", bDate=" + bDate + ", busName=" + busName
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", ac_type=" + ac_type + ", sleep_type="
				+ sleep_type + ", rate=" + rate + "]";
	}*/
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
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
}
