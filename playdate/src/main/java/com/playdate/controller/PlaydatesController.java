package com.playdate.controller;

import com.playdate.model.PlaydatesRequested;
import com.playdate.model.UserDetails;
import com.playdate.model.UpcomingPlaydateInfo;
import com.playdate.repositories.UserRepository;
import com.playdate.service.PlayDatesUpdationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/playdate")
@Validated
@RequiredArgsConstructor
public class PlaydatesController {

    @Autowired
    PlayDatesUpdationService playDatesUpdationService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/update/playDateDetails")
    public boolean updatePlaydateRequestedInfo(@RequestBody PlaydatesRequested playdatesRequested){
        String emailOfRequesteduser = playdatesRequested.getRequestedBy();
        String emailOfUserThatWasRequestedForAPlaydate = playdatesRequested.getRequestedTo();


        playDatesUpdationService.updatePlayDateInformation(playdatesRequested);
        return false;
    }

    @GetMapping("/upcomingPlaydates/{email}")
    public List<UpcomingPlaydateInfo> getUpcomingPlayDates(@PathVariable String email){
//        //TODO: this should be continued after upcoming playdates is added in the mongo document
//        UserDetails userDetails = userRepository.findByEmail(email);
//        List<PlaydatesRequested> playdatesRequestedByOthersList = userDetails.getPlaydatesRequestedByOthers();
//        List<PlaydatesRequested>playdatesRequestedByOthersListAndStillInRequestedStatus = playdatesRequestedByOthersList.stream().filter(playdateRequestedByOther->playdateRequestedByOther.getStatus()=="REQUESTED").collect(Collectors.toList());
        return null;
    }

    @GetMapping("/RequestAwaitingPlayDates/{email}")
    public List<PlaydatesRequested> requestAwaitingPlaydates(@PathVariable String email){
//        UserDetails userDetails = userRepository.findByEmail(email);
//        List<PlaydatesRequested> playdatesRequestedList = userDetails.getPlaydatesRequestedByOthers();
//        return playdatesRequestedList;
        return null;
    }

    @GetMapping("/upcomingPlaydates/{EmailOfUserWhoSentTheRequest}/{EmailOfTheUserWhoRecievedtheRequest}/{status}")
    public List<UpcomingPlaydateInfo> AcceptOrRejectPlayDates(@PathVariable String EmailOfUserWhoSentTheRequest,
                                                              @PathVariable String EmailOfTheUserWhoRecievedtheRequest,
                                                              @PathVariable String status){
        //status can be either "ACCEPTED" or "REJECTED"
        //EmailOfTheUserWhoRecievedtheRequest will either accept or reject

        UserDetails UserWhoSentTheRequestUserDetails = userRepository.findByEmail(EmailOfUserWhoSentTheRequest);
        UserDetails UserWhoRecievedtheRequestUserDetails = userRepository.findByEmail(EmailOfTheUserWhoRecievedtheRequest);


//        UserWhoSentTheRequestUserDetails.getPlaydatesRequestedByMe().stream().
//                filter(playDateRequestedByme -> playDateRequestedByme.getRequestedTo().equals(EmailOfTheUserWhoRecievedtheRequest))
//                .forEach(playDateRequestedByme->
//                {
//                    playDateRequestedByme.setStatus(status);
//                    //TODO: replace dummy image
//                    playDateRequestedByme.setBase64Image(Constants.CONSTANT_IMAGE);
//                }
//                );
//
//        UserWhoRecievedtheRequestUserDetails.getPlaydatesRequestedByOthers().stream().
//                filter(playDateRequestedToMe ->
//                        playDateRequestedToMe.getRequestedBy().equals(EmailOfUserWhoSentTheRequest))
//                .forEach(playDateRequestedToMe->{playDateRequestedToMe.setStatus(status);
//                    //TODO: replace dummy image
//                    playDateRequestedToMe.setBase64Image(Constants.CONSTANT_IMAGE);
//                    });


        userRepository.save(UserWhoSentTheRequestUserDetails);
        userRepository.save(UserWhoRecievedtheRequestUserDetails);

        return null;
    }


    @GetMapping("/request/{sentBy}/{sentTo}")
    public boolean updatePlayDateRequestInfo(@PathVariable String sentBy, @PathVariable String sentTo){
        UserDetails requestSentByUser = userRepository.findByEmail(sentBy);
        UserDetails requestSentTo = userRepository.findByEmail(sentTo);

        //Update that request is sent by user(sentBy) in RequestSentByUser object
        //TODO:replace dummy image
//        requestSentByUser.getPlaydatesRequestedByMe().add(PlaydatesRequested.builder().requestedTo(sentTo).base64Image(Constants.CONSTANT_IMAGE).build());
//        requestSentTo.getPlaydatesRequestedByOthers().add(PlaydatesRequested.builder().requestedBy(sentBy).base64Image(Constants.CONSTANT_IMAGE).build());
//
//        userRepository.save(requestSentByUser);
//        userRepository.save(requestSentTo);
        //TODO: send true if it is successfully saved
        return true;
    }
}
