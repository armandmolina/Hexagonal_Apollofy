package cat.tecnocampus.apollofy.user.application.port.out;

import cat.tecnocampus.apollofy.user.application.port.in.CreateFanOfCommand;
import cat.tecnocampus.apollofy.user.domain.FanOf;

public interface StoreFanOfPort {
    void storeFanOf(FanOf fanOf);
}
