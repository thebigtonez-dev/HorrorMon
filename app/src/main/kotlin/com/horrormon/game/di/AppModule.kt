package com.horrormon.game.di

import android.content.Context
import androidx.room.Room
import com.horrormon.game.data.local.AppDatabase
import com.horrormon.game.data.local.HorrorMonDao
import com.horrormon.game.data.local.MoveDao
import com.horrormon.game.data.local.PlayerPokemonDao
import com.horrormon.game.data.repository.BattleRepositoryImpl
import com.horrormon.game.data.repository.HorrorMonRepositoryImpl
import com.horrormon.game.domain.repository.BattleRepository
import com.horrormon.game.domain.repository.HorrorMonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getDatabase(context)
    }
    
    @Provides
    @Singleton
    fun provideHorrorMonDao(database: AppDatabase): HorrorMonDao {
        return database.horrorMonDao()
    }
    
    @Provides
    @Singleton
    fun providePlayerPokemonDao(database: AppDatabase): PlayerPokemonDao {
        return database.playerPokemonDao()
    }
    
    @Provides
    @Singleton
    fun provideMoveDao(database: AppDatabase): MoveDao {
        return database.moveDao()
    }
    
    @Provides
    @Singleton
    fun provideHorrorMonRepository(
        horrorMonDao: HorrorMonDao,
        playerPokemonDao: PlayerPokemonDao
    ): HorrorMonRepository {
        return HorrorMonRepositoryImpl(horrorMonDao, playerPokemonDao)
    }
    
    @Provides
    @Singleton
    fun provideBattleRepository(): BattleRepository {
        return BattleRepositoryImpl()
    }
}
