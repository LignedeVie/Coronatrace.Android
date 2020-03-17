package com.trzas.coronatrace;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface LocationDao {
    @Insert
    Long insertLocation(UserLocation location);


    @Query("SELECT * FROM UserLocation")
    LiveData<List<UserLocation>> fetchAllLocation();


    @Query("SELECT * FROM UserLocation WHERE id =:id")
    LiveData<UserLocation> getLocation(int id);


    @Update
    void updateLocation(UserLocation location);


    @Delete
    void deleteLocation(UserLocation location);
}