import java.util.Scanner;
import java.lang.Exception; 

class AuthenticationFailure extends Exception {
    AuthenticationFailure(String s) {
        super(s);
    }
}

public class Password_Authentication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = "comp123";
        String user_password;
        int attempts = 0;

        while (true) {
            try {
                System.out.print("Enter your password: ");
                user_password = sc.next();

                if (!user_password.equals(password)) {
                    attempts++;
                    if (attempts >= 3) {
                        System.out.println("Too many failed attempts!! Please try after 10 seconds");
                        Thread.sleep(10000); 
                        attempts = 0; 
                    } else {
                        throw new AuthenticationFailure("Incorrect password");
                    }
                } else {
                    System.out.println("Authentication Successful");
                    break; 
                }
            } catch (AuthenticationFailure e) {
                System.out.println("Authentication Failed: " + e.getMessage());
            } catch (InterruptedException i) {
            }
        }
        sc.close();
    }
}
