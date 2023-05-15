package cat.tecnocampus.apollofy.djLists.application.port.in;


import java.util.List;

public interface ListDJList {
    void addTracksToPlaylistWithTimeRange(String name, Long id, List<DJListTrackFragmentListing> tracks);
}
