package com.diksh.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run:Run)

    @Delete
    suspend fun deleteRun(run:Run)

    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC")
    fun  getAllRunsSortedByDates():LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY averageSpeed DESC")
    fun  getAllRunsSortedByAvgSpeed():LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun  getAllRunsSortedByDistInMeters():LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun  getAllRunsSortedByTimeInMillis():LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun  getAllRunsSortedByCaloriesBurned():LiveData<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistInMeters(): LiveData<Int>

    @Query("SELECT AVG(averageSpeed) FROM running_table")
    fun getTotalTimeAvgSpeed(): LiveData<Float>


}