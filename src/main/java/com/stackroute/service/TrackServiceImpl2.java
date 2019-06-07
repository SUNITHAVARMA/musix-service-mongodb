package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public class TrackServiceImpl2 implements TrackService {
    @Override
    public List<Track> getAllTrack() {
        return null;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        return null;
    }

    @Override
    public void deleteTrack(int trackId) {

    }

    @Override
    public List<Track> displayTrack() {
        return null;
    }

    @Override
    public Track updateTrackComments(Track track, int trackId) throws TrackNotFoundException {
        return null;
    }

    /*@Override
    public Track trackByName(String trackName) {
        return null;
    }*/
}
