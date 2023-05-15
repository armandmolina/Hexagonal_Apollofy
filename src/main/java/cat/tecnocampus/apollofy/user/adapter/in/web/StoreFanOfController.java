package cat.tecnocampus.apollofy.user.adapter.in.web;

import cat.tecnocampus.apollofy.user.application.port.in.CreateFanOf;
import cat.tecnocampus.apollofy.user.application.port.in.CreateFanOfCommand;
import cat.tecnocampus.apollofy.user.domain.FanOf;
import cat.tecnocampus.apollofy.user.domain.UserFy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class StoreFanOfController {

    private final CreateFanOf createFanOf;

    public StoreFanOfController(CreateFanOf createFanOf){
        this.createFanOf = createFanOf;
    }

    @PostMapping("/user/fanOf/{destination}")
    public void storeFanOf(@RequestBody CreateFanOfCommand createFanOfCommand){
        createFanOf.createFanOf(createFanOfCommand);
    }
}
