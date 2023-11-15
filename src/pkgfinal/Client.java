package pkgfinal;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String ssn;
    private String password;
    private String pass;
    private String admin;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPassword() {
        return password;
    }

    public String getPass() {
        return pass;
    }

    public String getAdmin() {
        return admin;
    }
    
    public Client(String name, String email, String phone, String address, String ssn, String password, String pass, String admin) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.ssn = ssn;
        this.password = password;
        this.pass = pass;
        this.admin = admin;
    }
    
    public boolean validPassword(String password){
        String passPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        Pattern ptrn = Pattern.compile(passPattern);

        if (ptrn.matcher(password).matches())
            return true;
        else
            return false;
    }

    public boolean validateEmail(String e_mail){
        String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@"+
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern ptrn = Pattern.compile(emailFormat);

        if (ptrn.matcher(e_mail).matches())
            return true;
        else
            return false;
    }

    public boolean validPhone(String phoneNumber){
        String regex = "^(011|012|010|015)\\d{8}$";
        return phoneNumber.matches(regex);
    }
    
    public List<String> validation(){
        ArrayList<String> err = new ArrayList<String>();
        
        if (this.name.isEmpty())
            err.add("Name cannot be empty");
        if (this.email.isEmpty())
            err.add("Email cannot be empty");
        else if (!validateEmail(this.email))
            err.add("Email is not valid");
        if (this.ssn.isEmpty())
            err.add("SSN cannot be empty");
        if (this.phone.isEmpty())
            err.add("Phone cannot be empty");
        else if (!validPhone(this.phone))
            err.add("Not a valid phone number");
        if (this.password.isEmpty())
            err.add("Password cannot be empty");
        else if (!validPassword(this.password))
            err.add("Not a valid password\n Password Must be\n1. at least 8 characters\n2. has at least one lower case\n3. has at least one upper case\n4. has at least one special character\n5. NO WHITE SPACES ALLOWED");
        if (this.address.isEmpty())
            err.add("Address cannot be Empty");
        if (!this.pass.equals(this.password))
            err.add("Password doesnot match");
        if (!this.admin.equals("15@admin")){
            if (!this.admin.isEmpty())
                err.add("If admin enter code, if else enter no/leave it empty");
            else
                this.admin = "no";
        }
        
        return err;
    }   
}

