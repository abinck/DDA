package edu.dda.utils;

import java.util.regex.*;

public class Validation {

    public boolean emailValidation(String email) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);
        boolean valid = m.matches();

        return valid;
    }

    public boolean fnameValidation(String fname) {
        Pattern p = Pattern.compile("[A-Z][a-z A-Z]*");
        Matcher m = p.matcher(fname);
        boolean valid = m.matches();

        return valid;
    }

    public boolean lnameValidation(String lname) {
        Pattern p = Pattern.compile("[A-Z][\\s]*[.]*[A-Z]*");
        Matcher m = p.matcher(lname);
        boolean valid = m.matches();
       
        return valid;
        
    }
    public boolean phoneValidation(String phone) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(phone);
        boolean valid = m.matches();
       
        return valid;
        
    }
   

}
