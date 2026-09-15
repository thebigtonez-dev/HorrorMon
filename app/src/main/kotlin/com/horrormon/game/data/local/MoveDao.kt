package com.horrormon.game.data.local

import androidx.room.*
import com.horrormon.game.data.model.Move
import kotlinx.coroutines.flow.Flow

@Dao
interface MoveDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moves: List<Move>)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(move: Move)
    
    @Query("SELECT * FROM moves")
    fun getAllMoves(): Flow<List<Move>>
    
    @Query("SELECT * FROM moves WHERE id = :id")
    suspend fun getMoveById(id: Int): Move?
    
    @Query("SELECT * FROM moves WHERE type = :type")
    fun getMovesByType(type: String): Flow<List<Move>>
    
    @Query("SELECT * FROM moves WHERE category = :category")
    fun getMovesByCategory(category: String): Flow<List<Move>>
    
    @Delete
    suspend fun delete(move: Move)
    
    @Query("DELETE FROM moves")
    suspend fun deleteAll()
}
