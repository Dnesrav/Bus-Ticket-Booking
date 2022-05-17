package Reg_Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * table details
 * 1. bus_user - user details
 * 2. bus_trip - bus details
 * 3. book_details - booking details of user
 */
import java.util.List;

public class BusDAO {
	/*
	 * This method is to check whether the entered user name is correct or not 
	 * if yes returns true else false
	 */
	public boolean check(String Number,String Passw) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps= con.prepareStatement("select * from bus_user where number=? and pass =?");
		ps.setString(1,Number);
		ps.setString(2,Passw);
		ResultSet res = ps.executeQuery();
		return res.next();
	}
	
	/*
	 * This is to get the name of the user who logs in 
	 */
	public String getUser(String Number,String Passw) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps= con.prepareStatement("select Name from bus_user where number=? and pass =?");
		ps.setString(1,Number);
		ps.setString(2,Passw);
		ResultSet res = ps.executeQuery();
		res.next();
		return res.getString(1);
	}
	
	/*
	 * this method will checks for the user is already registered or not if yes returns true
	 * for the forgot password page, if it returned yes only user can change password
	 */
	public boolean changePass(String Number) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select * from bus_user where Number ="+Number);
		return res.next();
	}
	
	/*
	 * once changePass() returned true, cahngePass method will be called to change the password
	 * check for the username in the db and update the password accordingly
	 */
	public void changeData(String Password, String number) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps = con.prepareStatement("update Bus_user set pass = ? where Number= ?");
		ps.setString(1,Password);
		ps.setString(2,number);
		ps.executeUpdate();
	}
	
	/*
	 * inseertData() is used to register user when he is new to application
	 */
	public void insertData(DetailsDTO dt) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps = con.prepareStatement("insert into Bus_user  values (?,?,?,?,?)");
		ps.setString(1,dt.getName());
		ps.setString(2,dt.getNumber());
		ps.setString(3,dt.getEmailId());
		ps.setString(4,dt.getPassword());
		ps.setString(5,dt.getGender());
		ps.executeUpdate();
	}
	/*
	 * this method is to get the seat count alloted for the bus
	 */
	public void seatCount(int seatNumber, String fromDest, String toDest) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps = con.prepareStatement("update bus_trip set seatCap =? where source=? and dest=? ");
		ps.setInt(1,seatNumber);
		ps.setString(2,fromDest);
		ps.setString(3,toDest);
		ps.executeUpdate();	
	}
/*
 * this method will insert data to book_details table once the booking confirmation was done 
 */
	//static int ctr=1;
	public void addbus(String Number, String fromDest, String toDest, String bDate, String busName, String startTime, String endTime, String ac_type, String sleep_type,String rate,int seater) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps = con.prepareStatement("insert into book_detail values (?,?,?,?,?,?,?,?,?,?,?,?)");
		int idcheck=checkId()+1;
		ps.setString(1,Number);
		ps.setString(2,fromDest);
		ps.setString(3,toDest);
		ps.setString(4,bDate);
		ps.setString(5,busName);
		ps.setString(6,startTime);
		ps.setString(7,endTime);
		ps.setString(8,ac_type);
		ps.setString(9,sleep_type);
		ps.setString(10,rate);
		ps.setInt(11,seater);
		ps.setInt(12, idcheck);
		ps.executeUpdate();	
	}
	/*
	 * this method is to check for latest id of the bus to sort in descending order of my bookings
	 */
	 
	public int checkId() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps = con.prepareStatement("Select max(id) from book_detail");
		ResultSet res = ps.executeQuery();
		res.next();
		return res.getInt(1);
		
	}
	/*
	 * this method is to get the booking list from the table .
	 */
	public void viewbooking(String number,List<BookDTO> bookList) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps= con.prepareStatement("select * from book_detail where number=? order by id desc");
		ps.setString(1,number);
		ResultSet res = ps.executeQuery();
		for(;res.next();) 
		{
			BookDTO boo=new BookDTO();
			boo.setFromDest(res.getString(2));
			boo.setToDest(res.getString(3));
			boo.setbDate(res.getString(4));
			boo.setBusName(res.getString(5));
			boo.setStartTime(res.getString(6));
			boo.setEndTime(res.getString(7));
			boo.setAc_type(res.getString(8));
			boo.setSleep_type(res.getString(9));
			boo.setRate(res.getString(10));
			boo.setSeatCap(res.getInt(11));
			bookList.add(boo);
		}
	}
	
	/*
	 * this method is called to delete a ticket from the db
	 */
	public void deleteRow(String fromDest, String toDest, String bDate, String busName, String num)throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps = con.prepareStatement("Delete from  book_detail where Number= ? and bpoint = ? and dpoint = ? and bDate = ? and busName = ?");
		ps.setString(1,num);
		ps.setString(2,fromDest);
		ps.setString(3,toDest);
		ps.setString(4,bDate);
		ps.setString(5,busName);
		ps.executeUpdate();
	}
	
	/*
	 * this method is to checck the availablle number of seats for the particular bus
	 */
	public int checkSeats(String fromDest, String toDest) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		PreparedStatement ps= con.prepareStatement("select seatCap from bus_trip where source=? and dest=? ");
		ps.setString(1,fromDest);
		ps.setString(2,toDest);
		ResultSet res = ps.executeQuery();
		res.next();
		int seatnum=res.getInt(1);
		return seatnum;
	}
	/*
	 * this method will check for source and dest for mentioned conditon and return the available busses
	 */
	public void fetchtrip(String fromDest,String toDest,BusDTO bus, List<BusDTO> busList) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new","root","Dhinesh@1");
		ResultSet res=null;
		if((fromDest=="")&&(toDest!=""))
		{
			PreparedStatement ps= con.prepareStatement("select * from bus_trip where Dest=? and seatcap>=1");
			ps.setString(1,toDest);
			res = ps.executeQuery();
		}
		else if((fromDest!="")&&(toDest==""))
		{
			PreparedStatement ps= con.prepareStatement("select * from bus_trip where source=? and seatcap>=1");
			ps.setString(1,fromDest);
			res = ps.executeQuery();
		}
		else if((fromDest=="")&&(toDest==""))
		{
			PreparedStatement ps= con.prepareStatement("select * from bus_trip where seatcap>=1");
			res = ps.executeQuery();
		}
		else if(checkSeats(fromDest,toDest)>=1)
		{
			PreparedStatement ps= con.prepareStatement("select * from bus_trip where source=? and Dest=?");
			ps.setString(1,fromDest);
			ps.setString(2,toDest);
			res = ps.executeQuery();
		}
		
		for(;res.next();) 
		{
			BusDTO bus1=new BusDTO();
			bus1.setBusName(res.getString(1));
			bus1.setStartTime(res.getString(2));
			bus1.setEndTime(res.getString(3));
			bus1.setAc_type(res.getString(4));
			bus1.setSleep_type(res.getString(5));
			bus1.setRate(res.getInt(6));
			bus1.setFromDest(res.getString(7));
			bus1.setToDest(res.getString(8));
			busList.add(bus1);
		}
	}	
}
