package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {

   /* @Query("select t from Track t where t.trackName=:trackName")
    public Track trackByName(@Param("trackName")String trackName);*/

}
