package cat.tecnocampus.apollofy.track.application.service.exception;

public class TrackNotFound extends RuntimeException{
    public TrackNotFound(Long id){
        super("Track with "+id+" not found");
    }
}
