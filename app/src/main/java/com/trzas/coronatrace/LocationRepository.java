package com.trzas.coronatrace;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

public class LocationRepository {
    private String DB_NAME = "coronatrace_db";
    private CoronatraceDatabase myDataBase;

    public LocationRepository(Context context) {
        myDataBase = Room.databaseBuilder(context, CoronatraceDatabase.class, DB_NAME).build();
    }


    public void insertLocation(final UserLocation location) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDataBase.dao().insertLocation(location);
                return null;
            }
        }.execute();
    }

    public void updateLocation(final UserLocation location) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDataBase.dao().updateLocation(location);
                return null;
            }
        }.execute();
    }

    public void deleteLocation(final int id) {
        final LiveData<UserLocation> location = getLocation(id);
        if (location != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    myDataBase.dao().deleteLocation(location.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public void deleteLocation(final UserLocation location) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                myDataBase.dao().deleteLocation(location);
                return null;
            }
        }.execute();
    }

    public LiveData<UserLocation> getLocation(int id) {
        return myDataBase.dao().getLocation(id);
    }

    public LiveData<List<UserLocation>> getLocations() {
        return myDataBase.dao().fetchAllLocation();
    }

}
