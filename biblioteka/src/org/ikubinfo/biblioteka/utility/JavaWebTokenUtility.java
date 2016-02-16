package org.ikubinfo.biblioteka.utility;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.joda.time.DateTime;
import org.joda.time.Days;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

public class JavaWebTokenUtility {

	/**
	 * Krijon nje kod aktivizimi duke perdorur librarine JJWT qe eshte
	 * implementimi ne JAVA i standartit JsonWebToken (RFC 7519).
	 * https://jwt.io/
	 * 
	 * @param userEmail
	 *            Emaili i perdoruesit qe sapo ka kryer regjistrimin.
	 * @param registrationTime
	 *            Koha kur perdoruesi eshte regjistruar. (ne milisekonda)
	 * 
	 * @return String Kodi i aktivizimit, (url-friendly).
	 */
	public static String generateActivationCode(String userEmail, long registrationTime, byte[] salt) {

		// SignatureAlgoritm - Algoritmi qe do te perdoret per krijimin e nje
		// kodi te enkriptuar.
		// Enkriptimi do te marre parasysh emailin e perdoruesit, kohen e
		// regjistrimit, periudhen e
		// vlefshmerise.
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long currentTime = System.currentTimeMillis();
		Date now = new Date(currentTime);

		Key signingKey = new SecretKeySpec(salt, signatureAlgorithm.getJcaName());

		// JWT Claims
		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setIssuer(userEmail).signWith(signatureAlgorithm,
				signingKey);

		if (registrationTime >= 0) {
			long expirationTime = registrationTime + 86400000; // 24h
			Date exp = new Date(expirationTime);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public static boolean authenticateJWT(String jwt, byte[] salt) {

		boolean result = false;
		Claims claims = null;
		DateTime currentTime = new DateTime();
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Key signingKey = new SecretKeySpec(salt, signatureAlgorithm.getJcaName());
		DateTime registrationTime;

		// Nqs kodi i verifikimit nuk eshte autentik hidhet nje perjashtim.

		try {
			claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt).getBody();
			registrationTime = new DateTime(claims.getExpiration());

			// Kodi eshte autentik por linku ka skaduar.
			if (Days.daysBetween(registrationTime.toLocalDate(), currentTime.toLocalDate()).getDays() > 1) {
				result = false;
			} else {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		/*
		 * System.out.println("Issuer: " + claims.getIssuer());
		 * System.out.println("Expiration: " + claims.getExpiration());
		 */

		return result;
	}

}
