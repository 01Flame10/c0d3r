package com.coder.main;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class AuthData
{
   private AuthUser currentUser;

   public AuthUser getCurrentUser() {
        
      return currentUser;
   }

   public void setCurrentUser(AuthUser currentUser) {

      this.currentUser = currentUser;
   }
}
