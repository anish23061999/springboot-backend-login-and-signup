package com.vectro.backend.controller;

import java.util.Random;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vectro.backend.model.App;
import com.vectro.backend.model.SmtpMailSender;
import com.vectro.backend.repository.AppRepository;
import com.vectro.backend.services.AppService;

@RestController
public class AppController {

	@Autowired
	private AppRepository appRepository;
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private SmtpMailSender smtpMailSender;
	
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	
	int i = gen();
	String st = "Thanks from TEAM VECTRO. Here is your one time password(OTP) for e-mail verification " + Integer.toString(i);

	@RequestMapping("/sendmail")
	public void sendMail(String str) throws MessagingException
	{
		smtpMailSender.send(str, "OTP", st);
	}
	@GetMapping(path="/saveuser")
	public String addNewUser(@RequestBody App app) {
	    App user1 = new App(app.getFname(),app.getEmail(),app.getFmail(),app.getPhno(),app.getLocation());
	    appRepository.save(user1);
	    return "User saved";
	}
	@ResponseBody
	@GetMapping("/applogin")
	public String loginApp(@RequestBody App app,HttpServletRequest request) throws MessagingException {
		if(appService.findByEmail(app.getEmail())!=null) {
			String str = app.getEmail();
			sendMail(str);
			return "Loginsuccessful";
		}	
		else
		{
			request.setAttribute("error", "Invalid comapny_mail_id or password");
			return "Please try again";
		}
	}
}
