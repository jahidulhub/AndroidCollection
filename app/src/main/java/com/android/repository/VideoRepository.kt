package com.android.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.android.database.AppDatabase
import com.android.database.DevByteVideo
import com.android.database.asDomainModel
import com.android.network.DevByteNetwork
import com.android.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideoRepository(
    private val database: AppDatabase
) {
    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = DevByteNetwork.devbytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }
}