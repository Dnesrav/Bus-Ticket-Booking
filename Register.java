package Reg_Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Register {
	public static String Dbnumber;
	public static String Dbpass;
	public static String Dbuser;
	BusDAO dao=new BusDAO();
	/*
	 * to display login page
	 */
	@RequestMapping("/login")
	public String toLogin()
	{
		return "login-page";
	}
	
	/*
	 * this method will call check method from dao class to check whether the entered username is correct or not 
	 * if yes it will return next booking page else it will return login page itself
	 * while login itself usern number and password stored in DBnumber and Db password variable to redirect to otherpage with same login credentials
	 * dbuser storeing name of the user
	 */
	@RequestMapping("/last")
	public String message(Model model,@RequestParam("Number") String Number,@RequestParam("Password") String Password,DetailsDTO dt1) throws ClassNotFoundException, SQLException
	{
		if(dao.check(Number,Password)==false)
		{	
			model.addAttribute("message", "Username and password not exist");
			return "login-page";
		}
		else
		{ 
			Dbnumber=Number;
			Dbpass=Password;
			Dbuser=dao.getUser(Number,Password);
			model.addAttribute("Dbuser", Dbuser);
			return "message";
		}
	}
	
	/*
	 * from bus details to back to booking sorce dest page
	 */
	
	@RequestMapping("/back")
	public String back(Model model)
	{
		model.addAttribute("Dbuser", Dbuser);
		return "message";
	}
	
	/*
	 * logout page
	 */
	@RequestMapping("/logout")
	public String toLogout()
	{
		return "logout";
	}
	
	/*
	 *on clicking forgot password it will return this forgot password form  
	 */
	@RequestMapping("/forgot")
	public String toReset() 
	{
			return "Forgot";
	}
	
	/*
	 * on landing to forgot passwoprd page , it ask for username to check for already registered or not by calling changepass() method
	 * if yes , it will call changedate() to change password elsse it will display error mesage
	 * saying not registered and return forgot pae itself
	 */
	@RequestMapping("/change")
	public String toChange(Model model,@RequestParam("Number") String Number,@RequestParam("Password") String Password) throws Exception 
	{
		if(dao.changePass(Number)==true)
		{
			dao.changeData(Password,Number);
			model.addAttribute("smessage","Password changed !!!");
			//return "login-page";
		}
		else
		{
			model.addAttribute("message","This number is not registered");
			
		}
		return "Forgot";
	}
	
	/*
	 * If the user is new to application , the user is requested to register using this page.
	 */
	@RequestMapping("/register")
	public String newEntry() throws Exception 
	{
			return "register";
	}
	
	/*
	 * this method will call the insertdata() method to insert new user data into the db
	 */
	@RequestMapping("/confirm")
	public String confirmData(Model model, DetailsDTO dt, @RequestParam("Number") String Number) throws Exception
	{
		if(dao.changePass(Number)==true)
		{
			model.addAttribute("emessage", "Sorry user is already Registered ");
			return "register";
		}
		//model.addAttribute("Detail",dt);
		else {
			dao.insertData(dt);
			model.addAttribute("smessage", "Registered Successfully");
			return "register";
		}
		
	}
	
	/*
	 * this method calls viewbooking() to display my bookings page from the booking page .
	 * booklist gets the list of bookings done by the user
	 */
	@RequestMapping("/viewbook")
	public String viewbook(Model model) throws ClassNotFoundException, SQLException 
	{
		String number=Dbnumber;
		List<BookDTO> bookList=new ArrayList<>();
		dao.viewbooking(number,bookList);      
		model.addAttribute("bookList",bookList);
		model.addAttribute("Number", Dbnumber);
		model.addAttribute("Password", Dbpass);
			return "mybooking";	
	}
	/*
	 * this method will return the mybooking page once after the confirmation of booking ticket
	 */
	@RequestMapping("/mybooking")
	public String mybooking(Model model,@RequestParam("fromDest") String fromDest,@RequestParam("toDest") String toDest,@RequestParam("bDate") String bDate,
			@RequestParam("busName") String busName,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
			@RequestParam("ac_type") String ac_type,@RequestParam("seater") int seater,@RequestParam("sleep_type") String sleep_type,@RequestParam("rate") String rate) throws ClassNotFoundException, SQLException 
	{
		String number=Dbnumber;
		System.out.println(Dbnumber);
		dao.addbus(number,fromDest,toDest,bDate,busName,startTime,endTime,ac_type,sleep_type,rate,seater);
		int seatNumber=dao.checkSeats(fromDest,toDest)-seater;
		dao.seatCount(seatNumber,fromDest,toDest);
		List<BookDTO> bookList=new ArrayList<>();
		dao.viewbooking(number,bookList);      
		model.addAttribute("bookList",bookList);
		model.addAttribute("Number", Dbnumber);
		model.addAttribute("Password", Dbpass);
			return "mybooking";	
	}
	/*
	 * this method is to cancel a ticket after booking done if user wants to cancel a trip
	 * once delete a updated the seat in bustrip
	 * calls deleterow() to delete the row from db
	 */
	@RequestMapping("/Delete")
	public String toDelete(Model model,@RequestParam("fromDest") String fromDest,@RequestParam("toDest") String toDest,@RequestParam("bDate") String bDate,
			@RequestParam("busName") String busName,@RequestParam("seater") int seater) throws ClassNotFoundException, SQLException
	{
		dao.deleteRow(fromDest,toDest,bDate,busName,Dbnumber);
		int seatNumber=dao.checkSeats(fromDest,toDest)+seater;
		dao.seatCount(seatNumber,fromDest,toDest);
		List<BookDTO> bookList=new ArrayList<>();
		dao.viewbooking(Dbnumber,bookList);      
		model.addAttribute("bookList",bookList);
		model.addAttribute("Number", Dbnumber);
		model.addAttribute("Password", Dbpass);
		System.out.println(Dbnumber+"..."+Dbpass);
		return "mybooking";
		
	}
	/*
	 * this is booking confirmation page ioonce you select the bus from the available bus from the list 
	 * it will show confirmation page with the bus details you selected 
	 * seatnumber will have available seats by calling checkseats function
	 */
	@RequestMapping("/book")
	public String book(Model model,@RequestParam("fromDest") String fromDest,@RequestParam("toDest") String toDest,@RequestParam("bDate") String bDate,
			@RequestParam("busName") String busName,@RequestParam("startTime") String startTime,@RequestParam("endTime") String endTime,
			@RequestParam("ac_type") String ac_type,@RequestParam("sleep_type") String sleep_type,@RequestParam("rate") int rate) throws ClassNotFoundException, SQLException 
	{
		int seatNumber=dao.checkSeats(fromDest,toDest);
		model.addAttribute("seatNumber",seatNumber);
		model.addAttribute("fromDest",fromDest);
		model.addAttribute("toDest",toDest);
		model.addAttribute("bDate",bDate);
		model.addAttribute("busName",busName);
		model.addAttribute("startTime",startTime);
		model.addAttribute("endTime",endTime);
		model.addAttribute("ac_type",ac_type);
		model.addAttribute("sleep_type",sleep_type);
		model.addAttribute("rate",rate);
		return "book";		
	}
	
	/*
	 * this method will call the fetchtrip() method to get the available bus for the mentioned source and destination
	 * this page is to show available busses for selected source and dest
	 */
	@RequestMapping("/trip")
	public String tripDetails(BusDTO bus,@RequestParam("fromDest") String fromDest,@RequestParam("toDest") String toDest, @RequestParam("date") String bDate ,Model model) throws ClassNotFoundException, SQLException 
	{
		model.addAttribute("Dbuser", Dbuser);
		List<BusDTO> busList=new ArrayList<>();
		dao.fetchtrip(fromDest,toDest, bus,busList);
		model.addAttribute("bDate", bDate);	      
		model.addAttribute("busList",busList);
		return "bustrip";
	}

}