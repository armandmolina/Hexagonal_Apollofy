package cat.tecnocampus.apollofy.track.application.port.in;

import cat.tecnocampus.apollofy.track.domain.Track;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public record CreateTrackCommand(
        @NotNull
        @Pattern(regexp="^[A-Z][a-z0-9\s_-]*$",message = "Must look like an email")
        String title,
        @NotNull
        @Size(min=5, max=300, message="track duration must be between 5 and 300")
        Long durationSeconds,
        List<String> genreNames) {
}
