package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/")
public class TrackController{

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

   @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            Track track1=trackService.saveTrack(track);
            if(track1==null) {
                responseEntity = new ResponseEntity<String>("already exist", HttpStatus.OK);
            }
            else {
                responseEntity=new ResponseEntity<String>("successfully added",HttpStatus.OK);
            }
        }catch (Exception e){
            responseEntity=new ResponseEntity<String>("already exist",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

@GetMapping("track")
    public ResponseEntity<?> getAllTrack(){
        List<Track> trackList = trackService.getAllTrack();
        return new ResponseEntity(trackList,HttpStatus.OK);
    }

    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) throws Exception{
        trackService.deleteTrack(trackId);
        return new ResponseEntity<List<Track>>(trackService.displayTrack(),HttpStatus.OK);
    }

    @PutMapping("track/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable int trackId)throws TrackNotFoundException {
        Track trackList=trackService.updateTrackComments(track,trackId);
        return new ResponseEntity<Track>(trackList,HttpStatus.OK);
    }

   /* @GetMapping("track/{trackName}")
    public ResponseEntity<?> trackByName(@PathVariable String trackName){
        Track trackList=trackService.trackByName(trackName);
        return new ResponseEntity<Track>(trackList,HttpStatus.OK);
    }
*/



}
