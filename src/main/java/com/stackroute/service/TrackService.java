package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {
    public List<Track> getAllTrack();
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public void deleteTrack(int trackId);
    public List<Track> displayTrack();
    public Track updateTrackComments(Track track,int trackId)throws TrackNotFoundException;
   /* public Track trackByName(String trackName);*/


}
