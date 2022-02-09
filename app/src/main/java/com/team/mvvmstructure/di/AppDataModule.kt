package com.team.mvvmstructure.di

import android.content.Context
import com.team.data.local.DataStoreManager
import com.team.data.local.MainDao
import com.team.data.local.MainDatabase
import com.team.data.remote.IRemoteData
import com.team.data.repo.Repo
import com.team.domain.domainRepo.IDomainRepo
import com.team.domain.excuter.PostExecutionThread
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppDataModule {

    @Provides
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    fun provideRepo(repo: Repo): IDomainRepo {
        return repo
    }

    @Singleton
    @Provides
    fun provideRetrofit(retrofit: Retrofit): IRemoteData {
        return retrofit.create(IRemoteData::class.java)
    }

    @Singleton
    @Provides
    fun provideMainDAO(blogDatabase: MainDatabase): MainDao {
        return blogDatabase.mainDao()
    }

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

}