package com.trzas.coronatrace;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserLocation.class}, version = 1, exportSchema = false)
public abstract class CoronatraceDatabase extends RoomDatabase {
    public abstract LocationDao dao();
}
