package com.abhishek.apod.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abhishek.apod.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : Activity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    Observable.interval(2, TimeUnit.SECONDS)
    .take(1)
    .observeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe { aLong -> navigateToHome() }
}

private fun navigateToHome() {
    val homeIntent = Intent(this, MainActivity::class.java)
    startActivity(homeIntent)
    finish()
}

}
