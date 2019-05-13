package com.deals.api.services;

import java.awt.print.Printable;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	public static final String secretKey= "4C8kum4LxyKWYLM78sKdXrzbBjDCFyfX";
	
	@Override
	public String validate(String token) {	
			Claims claims = Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
				       .parseClaimsJws(token).getBody();
			return claims.getSubject();	
	
	}
}
