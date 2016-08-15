package org.cuong.util;
import org.cuong.model.Users;
import org.cuong.socialsecurity.user.SocialUserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
 
public class SecurityUtil {
 
  
   // Tự động đăng nhập.
   public static void logInUser(Users user) {
 
       SocialUserDetailsImpl userDetails = new SocialUserDetailsImpl(user);
 
       Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
               userDetails.getAuthorities());
       SecurityContextHolder.getContext().setAuthentication(authentication);
   }
  
}

