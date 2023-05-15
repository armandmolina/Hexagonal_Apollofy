package cat.tecnocampus.apollofy.track.adapter.in.web.exceptionAdvice;

import cat.tecnocampus.apollofy.track.application.service.exception.TrackAlreadyExists;
import cat.tecnocampus.apollofy.track.application.service.exception.TrackNotFound;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdviceTrack {
    @ResponseBody
    @ExceptionHandler(TrackNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TrackAlreadyExists.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String trackAlreadyExists(Exception ex) {
        return ex.getMessage();
    }

}
