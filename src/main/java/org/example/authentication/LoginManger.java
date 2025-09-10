package org.example.authentication;

public class LoginManger {

    private final AuthService authService;

    public LoginManger(AuthService authService) {
        this.authService = authService;
    }

    public String login(String userName, String password){
        if(authService.authenticate(userName,  password)){
            return "Login sucessful";
        }else {
            return "Login fail";
        }
    }
}
