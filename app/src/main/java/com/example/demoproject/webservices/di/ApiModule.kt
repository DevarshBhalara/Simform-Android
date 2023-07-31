package com.example.demoproject.webservices.di

import android.content.Context
import androidx.navigation.Navigator
import androidx.room.Room
import com.example.demoproject.roomdb.repository.UserRepository
import com.example.demoproject.roomdb.room.UserDao
import com.example.demoproject.roomdb.room.UserDatabase
import com.example.demoproject.webservices.BseApplication
import com.example.demoproject.webservices.data.UserMockApi
import com.example.demoproject.webservices.interfaces.UserMockApiService
import com.example.demoproject.webservices.newsapp.ui.repository.NewsRepository
import com.example.demoproject.webservices.newsapp.ui.retrofit.NewsInterface
import com.example.demoproject.webservices.repository.DownloadRepository
import com.example.demoproject.webservices.repository.UploadImageRepository
import com.example.demoproject.webservices.repository.UserListRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private const val IMAGE_URL = "https://api.imgbb.com/1/"
    private const val USER_MOCK_API_URL = "https://648c3d218620b8bae7ec85b9.mockapi.io/"
    private const val USER_TODO = "https://dummyjson.com/"
    private const val NEWS = "https://newsapi.org/v2/"

    private val database = Room.databaseBuilder(BseApplication.getAppContext()!!, UserDatabase::class.java, "user").build()

    @Provides
    @Singleton
    fun providesGson(): Gson =
        GsonBuilder().create()

    @Provides
    @Singleton
    @Named("IMAGE_UPLOAD")
    fun provideImageUploadRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(IMAGE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()

    @Provides
    @Singleton
    @Named("ImageUploadService")
    fun provideImageUploadService(@Named("IMAGE_UPLOAD") retrofit: Retrofit): UserMockApiService =
        retrofit.create(UserMockApiService::class.java)

    @Provides
    @Singleton
    @Named("UploadImage")
    fun providesUploadImageRepository(@Named("ImageUploadService") imageService: UserMockApiService): UploadImageRepository =
        UploadImageRepository(imageService)


    @Provides
    @Singleton
    @Named("USERS_LIST")
    fun provideFetchUserRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(USER_MOCK_API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    @Named("USER_TODO")
    fun provideFetchUserTodoRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(USER_TODO)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun provideFetchUserRepository(@Named("UserListService") userService: UserMockApiService, @Named("UserTodoService") userTodoService: UserMockApiService ): UserListRepository =
        UserListRepository(userService, userTodoService)

    @Provides
    @Singleton
    @Named("UserListService")
    fun providesUserFetchService(@Named("USERS_LIST") retrofit: Retrofit): UserMockApiService =
        retrofit.create(UserMockApiService::class.java)

    @Provides
    @Singleton
    @Named("UserTodoService")
    fun providesUserFetchTodoService(@Named("USER_TODO") retrofit: Retrofit): UserMockApiService =
        retrofit.create(UserMockApiService::class.java)


    @Provides
    @Singleton
    @Named("DOWNLOAD_FILE")
    fun provideDownloadFileRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(USER_TODO)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    @Named("DownloadService")
    fun  provideDownloadService(@Named("DOWNLOAD_FILE") retrofit: Retrofit): UserMockApiService =
        retrofit.create(UserMockApiService::class.java)

    @Provides
    @Singleton
    fun provideDownloadRepository(@Named("DownloadService") downloadService: UserMockApiService): DownloadRepository =
        DownloadRepository(downloadService)


    @Provides
    @Singleton
    @Named("NEWS")
    fun provideFetchNews(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(NEWS)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    @Named("NewsService")
    fun provideNewService(@Named("NEWS") retrofit: Retrofit): NewsInterface =
        retrofit.create(NewsInterface::class.java)

    @Provides
    @Singleton
    fun provideNewRepository(@Named("NewsService") newsInterface: NewsInterface): NewsRepository =
        NewsRepository(newsInterface)

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository =
        UserRepository(userDao)

    @Provides
    @Singleton
    fun provideUserDaoService(): UserDao =
        database.userDao()

}