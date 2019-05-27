package com.info.app.generate.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
	public static void main(String[] args) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		//In database we are keeping encoded password. BCryptPasswordEncoder helps to encode password.
		//On Every run it generates a different password
		
		System.out.println(bCryptPasswordEncoder.encode("m@123"));//password for martin
		System.out.println(bCryptPasswordEncoder.encode("s@123"));//password for sean
	}
}
