package cat.tecnocampus.apollofy.user.application.service;

import cat.tecnocampus.apollofy.user.application.port.in.CreateFanOf;
import cat.tecnocampus.apollofy.user.application.port.in.CreateFanOfCommand;
import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;
import cat.tecnocampus.apollofy.user.application.port.out.StoreFanOfPort;
import cat.tecnocampus.apollofy.user.domain.FanOf;
import org.springframework.stereotype.Service;

@Service
public class CreateFanOfService implements CreateFanOf {

    private final ListUserPort listUserPort;
    private final StoreFanOfPort storeFanOfPort;

    public CreateFanOfService(ListUserPort listUserPort, StoreFanOfPort storeFanOfPort) {

        this.storeFanOfPort = storeFanOfPort;
        this.listUserPort=listUserPort;
    }

    @Override
    public void createFanOf(CreateFanOfCommand createFanOfCommand) {
        UserListing userListing1 = listUserPort.loadUserByName(createFanOfCommand.userName1());
        UserListing userListing2 = listUserPort.loadUserByName(createFanOfCommand.userName2());
        FanOf fanOf= new FanOf(MapperUserUserListing.userListingToUser(userListing1),MapperUserUserListing.userListingToUser(userListing2));
        storeFanOfPort.storeFanOf(fanOf);
    }
}
