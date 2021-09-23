package com.example.dictionaryapplication


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WordsDataInterface {

    @GET("sozluk/tum_kelimeler.php")
    fun allWords() : Call<WordsAnswer>

    @POST("sozluk/kelime_ara.php")
    @FormUrlEncoded
    fun wordSearching(@Field ("ingilizce") ingilizce:String) : Call<WordsAnswer>
}