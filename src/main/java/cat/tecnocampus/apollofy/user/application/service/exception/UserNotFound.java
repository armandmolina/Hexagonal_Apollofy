package cat.tecnocampus.apollofy.user.application.service.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String email){
        super("User with email "+email+" not found");
    }
}
