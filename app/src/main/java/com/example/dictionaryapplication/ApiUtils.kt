package com.example.dictionaryapplication

class ApiUtils {

    companion object{

        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getWordsDataInterface(): WordsDataInterface {
            return RetrofitClient.getClient(BASE_URL).create(WordsDataInterface::class.java)
        }
    }
}