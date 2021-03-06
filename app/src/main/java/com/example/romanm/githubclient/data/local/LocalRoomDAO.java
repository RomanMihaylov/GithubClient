package com.example.romanm.githubclient.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.romanm.githubclient.data.local.model.ReposLocal;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;


@Dao
public interface LocalRoomDAO {


    @Insert
    void saveItem(ReposLocal repos);

    @Insert
    void saveItems(List<ReposLocal> list);

    @Query("SELECT * FROM ReposLocal LIMIT :start, :limit")
    Maybe<List<ReposLocal>> getItems(int start, int limit);

    @Query("SELECT * FROM ReposLocal WHERE id LIKE :start LIMIT :limit")
    Single<List<ReposLocal>> getItem(int start, int limit);

    @Query("SELECT * FROM ReposLocal")
    Maybe<List<ReposLocal>> getAll();


}
//