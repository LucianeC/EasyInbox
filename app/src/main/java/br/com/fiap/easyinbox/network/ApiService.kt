package br.com.fiap.easyinbox.network

import android.telecom.Call
import br.com.fiap.easyinbox.model.Email
import br.com.fiap.easyinbox.model.Preference


interface ApiService {

    @GET("/api/emails")
    fun getEmails(): Call

    @GET("/api/emails/{id}")
    fun getEmailById(@Path("id") id: String)

    @POST("/api/emails")
    fun sendEmail(@Body email: Email)

    @GET("/api/preferences/{userId}")
    fun getPreference(@Path("userId") userId: String)

    @POST("/api/preferences")
    fun savePreference(@Body preference: Preference)
}

annotation class Path(val value: String)

annotation class Body

annotation class POST(val value: String)

annotation class GET(val value: String)
