package cat.tecnocampus.apollofy.track.application.service;
import cat.tecnocampus.apollofy.track.application.port.in.ListLikeTrack;
import cat.tecnocampus.apollofy.track.application.port.in.PopularTrackListing;
import cat.tecnocampus.apollofy.track.application.port.in.TrackListing;

import cat.tecnocampus.apollofy.track.application.port.out.ListLikeTrackPort;

import cat.tecnocampus.apollofy.user.application.port.in.UserListing;
import cat.tecnocampus.apollofy.user.application.port.out.ListUserPort;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListLikeTrackService implements ListLikeTrack {
    private final ListLikeTrackPort listLikeTrackPort;
    private final ListUserPort listUserPort;


    public ListLikeTrackService(ListLikeTrackPort listLikeTrackPort, ListUserPort listUserPort) {
        this.listLikeTrackPort = listLikeTrackPort;
        this.listUserPort = listUserPort;

    }


    @Override
    public List<TrackListing> getUserLikedTracks(String name) {
        UserListing userListing = listUserPort.loadUserByName(name);
        return listLikeTrackPort.loadLikeTracksByUser(userListing.name());
    }




    @Override
    public List<PopularTrackListing> getPopularTracks(int size, LocalDateTime from, LocalDateTime to){
        Pageable pageable=PageRequest.of(1,size);
        List<PopularTrackListing> popularTrackListings = listLikeTrackPort.popularTracks(from, to, pageable );
        return popularTrackListings;
    }

}
