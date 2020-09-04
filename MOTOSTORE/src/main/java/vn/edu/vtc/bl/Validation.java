package vn.edu.vtc.bl;

import java.util.regex.*; 
public class Validation { 
  
    public boolean isValidPassword(String password) 
    { 
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";        
        Pattern p = Pattern.compile(regex); 
        if (password == null) { 
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }  
    public boolean isValidPhoneNumber(String phoneNumber){
        String regex = "^(?=.*[0-9]).{10}$";
        Pattern p = Pattern.compile(regex); 
        if (phoneNumber == null) { 
            return false;
        }
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
}