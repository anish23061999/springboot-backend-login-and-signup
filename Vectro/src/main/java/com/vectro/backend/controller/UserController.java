package com.vectro.backend.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vectro.backend.model.SmtpMailSender;
//import com.vectro.backend.configuration.WebMvcConfig;
import com.vectro.backend.model.User;
import com.vectro.backend.repository.UserRepository;
import com.vectro.backend.services.UserService;


@RestController

public class UserController {
	
	@PostMapping("register")
	public String welcome() {
		return "welcomepage";
	}
	@Autowired 
	private UserService userService;
	
	@PostMapping("/")
	public String hello()
	{
		return "This is home page";
	}
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	public String str1;
	
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	
	int i = gen();
	String st = "Thanks from TEAM VECTRO. Here is your one time password(OTP) for e-mail verification " + Integer.toString(i);

	@RequestMapping("/send-mail")
	public void sendMail(String str) throws MessagingException
	{
		smtpMailSender.send(str, "OTP", st);
	}
	String str3 = Integer.toString(i);
		
	/*@RequestMapping("/otp")
	public String otpChecker(@RequestBody User user.getOtp())
	{
		if(str3.equals(user.getOtp()))
		{
			return "user is verified";
		}
		else
			return "Invalid OTP";
	}*/
	
	@Autowired
	private UserRepository userRepository;
	@CrossOrigin(origins="localhost:9000" )
	@PostMapping(path="/save-user")
	public String addNewUser (@RequestBody User user) throws MessagingException {
	    User user2 = new User(user.getName(),user.getMail(),user.getGst(),user.getWeb(),user.getPassword());
	    String str = user.getMail();
		sendMail(str);
		userRepository.save(user2);
		return "User saved";
		
		//else	
			//return "Invalid OTP";
	    
	}
	@GetMapping("/login1")
	public String loginUser(@RequestBody User user,HttpServletRequest request) {
		if(userService.findByMailAndPassword(user.getMail(), user.getPassword())!=null)
			return "Loginsuccessful";
		else
		{
			request.setAttribute("error", "Invalid comapny_mail_id or password");
			return "Please try again";
		}
	}
	@RequestMapping("home")
	public String homepage()
	{
		return "home";
	}
	
	
	
}
