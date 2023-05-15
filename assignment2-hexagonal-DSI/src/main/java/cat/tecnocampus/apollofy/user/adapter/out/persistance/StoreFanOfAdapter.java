package cat.tecnocampus.apollofy.user.adapter.out.persistance;

import cat.tecnocampus.apollofy.user.application.port.in.CreateFanOfCommand;
import cat.tecnocampus.apollofy.user.application.port.in.CreateUserCommand;
import cat.tecnocampus.apollofy.user.application.port.out.StoreFanOfPort;
import cat.tecnocampus.apollofy.user.application.service.MapperUserFyUserEntity;
import cat.tecnocampus.apollofy.user.domain.FanOf;
import org.springframework.stereotype.Component;

@Component
public class StoreFanOfAdapter implements StoreFanOfPort {
    private final FanOfRepository fanOfRepository;

    public StoreFanOfAdapter(FanOfRepository fanOfRepository) {
        this.fanOfRepository = fanOfRepository;
    }

    @Override
    public void storeFanOf(FanOf fanOf) {
        fanOfRepository.save(fanOf2fanOfEntity(fanOf));
    }

    private FanOfEntity fanOf2fanOfEntity(FanOf fanOf) {
        FanOfEntity fanOfEntity = new FanOfEntity();
        fanOfEntity.setOrigin(MapperUserFyUserEntity.userFyToUserEntity(fanOf.getOrigin()));
        fanOfEntity.setDestination(MapperUserFyUserEntity.userFyToUserEntity(fanOf.getDestination()));

        return fanOfEntity;
    }
}
