package cat.tecnocampus.apollofy.user.application.port.in;

import cat.tecnocampus.apollofy.user.domain.FanOf;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface CreateFanOf {
    void createFanOf(CreateFanOfCommand createFanOfCommand);
}
