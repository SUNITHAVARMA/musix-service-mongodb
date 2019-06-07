package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository=trackRepository;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack=trackRepository.save(track);

        if(savedTrack==null){
            throw new TrackAlreadyExistsException("Track already exist");
        }
        return savedTrack;
    }

    @Override
    public void deleteTrack(int trackId){
       trackRepository.deleteById(trackId);
       // throw new Exception("Track not found");
    }

    @Override
    public List<Track> displayTrack(){
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrackComments(Track track, int trackId) throws TrackNotFoundException {
        if(!trackRepository.existsById(track.getTrackId())){
            throw new TrackNotFoundException("track not found");
        }
        Track trackList=trackRepository.findById(trackId).get();
        trackList.setTrackComments(track.getTrackComments());
        return trackList;
    }

   /* @Override
    public Track trackByName(String trackName) {
        return trackRepository.trackByName(trackName);
    }*/
/* @Override
    public Track updateTrack(Track track) {

        return null;
    }

    @Override
    public Track retrieveTrack(String trackName) {
        return null;
    }*/
}
