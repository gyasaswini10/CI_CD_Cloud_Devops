package com.example.demo.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.UsersRepository;

import jakarta.servlet.http.HttpSession;
@Service
public class UsersManager {
	@Autowired
	UsersRepository UR;
	@Autowired
	EmailManager EM;
	@Autowired
	JWTManager JWT;
	public String addUser(Users U) {    
	    if(UR.validateEmail(U.getEmail()) > 0)
	      return "401::Email already exist";    
	    UR.save(U);
	    return "200::User Registered Successfully";
	}
	public String recoverPassword(String email) {
		Users U =UR.findById(email).get();
		String message = String.format("Dear %s,\n \n Your Password is: %s",U.getFullname(),U.getPassword() );
		return EM.sendEmail(U.getEmail(),"Jobportal: PasswordRecovery", message);
	}
	public String ValidateCredentials(String email, String password) {
	    if (UR.validateCresentials(email, password) > 0) {
	        String token = JWT.generateToken(email);  // Ensure this token is generated
	        return "200::" + token;  // Response should include the token
	    }
	    return "401::Invalid Credential(Check Email/Password)";
	}


	public String getFullname(String token) {
		String email = JWT.validateToken(token);
		if(email.compareTo("401")==0)
			return "401:token Expired!";
		Users U = UR.findById(email).get();
		return U.getFullname();
	}
	
	public String getEmail(String token) {
		String email = JWT.validateToken(token);
		if(email.compareTo("401")==0)
			return "401:token Expired!";
		Users U = UR.findById(email).get();
		return U.getEmail();
	}
	
	
}


