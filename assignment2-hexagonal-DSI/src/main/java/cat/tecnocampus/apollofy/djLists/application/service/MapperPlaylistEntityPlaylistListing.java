package cat.tecnocampus.apollofy.djLists.application.service;

import cat.tecnocampus.apollofy.djLists.adapter.out.persistance.PlaylistEntity;
import cat.tecnocampus.apollofy.djLists.application.port.in.PlaylistListing;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;
import cat.tecnocampus.apollofy.user.application.service.MapperUserFyUserEntity;

import java.util.ArrayList;
import java.util.List;

public class MapperPlaylistEntityPlaylistListing {
    public static PlaylistListing playlistEntityToPlaylistListing(PlaylistEntity playlistEntity){
        PlaylistListing playlistListing=
                new PlaylistListing(playlistEntity.getId(), playlistEntity.getTitle(), playlistEntity.getDescription(),playlistEntity.getOpen(), MapperUserFyUserEntity.userEntityToUserFy(playlistEntity.getOwner()));
        return playlistListing;
    }
    public static List<PlaylistListing> playlistEntityListToPlaylistListingList(List<PlaylistEntity> playlistEntities){
        List<PlaylistListing> playlistListings= new ArrayList<>();
        playlistEntities.forEach(le -> playlistListings.add(playlistEntityToPlaylistListing(le)));
        return playlistListings;
    }
}
