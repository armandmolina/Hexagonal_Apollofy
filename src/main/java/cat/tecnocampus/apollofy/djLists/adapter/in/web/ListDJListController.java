package cat.tecnocampus.apollofy.djLists.adapter.in.web;

import cat.tecnocampus.apollofy.djLists.application.port.in.DJListTrackFragmentListing;
import cat.tecnocampus.apollofy.djLists.application.port.in.ListDJList;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class ListDJListController {
    private final ListDJList listDjList;

    public ListDJListController(ListDJList listDjList) {
        this.listDjList = listDjList;
    }

    @PostMapping("/djlist/{id}/tracks")
    public void addTracksToPlayListWithTimeRange(Principal principal, @PathVariable Long id, @RequestBody List<DJListTrackFragmentListing> tracks) {
        listDjList.addTracksToPlaylistWithTimeRange(principal.getName(), id, tracks);
    }

}
