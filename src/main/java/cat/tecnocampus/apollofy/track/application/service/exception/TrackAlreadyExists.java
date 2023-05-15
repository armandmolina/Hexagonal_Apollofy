package cat.tecnocampus.apollofy.track.application.service.exception;

public class TrackAlreadyExists extends RuntimeException{
        public TrackAlreadyExists(Long id) {
            super("Track with id "+id+" already exists");
        }
}
