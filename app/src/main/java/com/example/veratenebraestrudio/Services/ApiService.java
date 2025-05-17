package com.example.veratenebraestrudio.Services;

import DTOs.LoginDTO;
import DTOs.UserDTO;
import DataFiles.UserEntity;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApiService {
    @GET("users")
    Call<List<UserEntity>> getUsers();

    @POST("auth/login")
    Call<UserDTO> login(@Body LoginDTO loginDTO);

    @POST("users")
    Call<UserDTO> createUser(@Body UserDTO userDTO);

    @GET("users/{id}")
    Call<UserEntity> getUserById(@Path("id") Long id);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") Long id);
}