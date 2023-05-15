package cat.tecnocampus.apollofy.djLists.application.service;

import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.DJListEntity;
import cat.tecnocampus.apollofy.djLists.domain.DJList;
import cat.tecnocampus.apollofy.user.application.service.MapperUserFyUserEntity;
import cat.tecnocampus.apollofy.user.application.service.MapperUserUserListing;

public class MapperDjListDjListEntity {
    public static DJListEntity djListToDJListEntity(DJList djList){
        DJListEntity djListEntity= new DJListEntity();
        djListEntity.setDescription(djList.getDescription());
        djListEntity.setId(djList.getId());
        djListEntity.setTitle(djList.getTitle());

        return djListEntity;
    }
    public static DJList djListEntityToDJList(DJListEntity djListEntity){
        DJList djList= new DJList();
        djList.setId(djListEntity.getId());
        djList.setDescription(djListEntity.getDescription());
        djList.setTitle(djListEntity.getTitle());
        djList.setOwner(MapperUserFyUserEntity.userEntityToUserFy(djListEntity.getOwner()));

        return djList;

    }

}
