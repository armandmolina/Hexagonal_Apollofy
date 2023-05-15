package cat.tecnocampus.apollofy.user.adapter.in.web.exceptionAdvice;


import cat.tecnocampus.apollofy.user.application.service.exception.UserAlreadyExists;
import cat.tecnocampus.apollofy.user.application.service.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdviceUser {
    @ResponseBody
    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserAlreadyExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String trackAlreadyExists(Exception ex) {
        return ex.getMessage();
    }

}
