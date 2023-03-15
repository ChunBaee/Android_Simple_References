package com.kichu.androidreferences.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kichu.androidreferences.R

class SplashActivity : AppCompatActivity() {

    /** 여기서는 XML 파일이 없으므로, 따로 바인딩을 해주지 않아도 된다. **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ifCheckAutoSignIn()
    }

    private fun ifCheckAutoSignIn() {

        /** 만약 자동 로그인 등 처리할 로직이 있다면 이렇게 처리하면 된다.
         * 자동 로그인 로직이 끝난 후, Response 값에 따라서 intent로 어느 Activity로 갈 것인지 분기처리를 해주면 된다.*/

        //여기서는 임의로 1초간의 딜레이를 주도록 했다.
        Thread.sleep(1000)

        startActivity(Intent(this, MainActivity::class.java))

    }

}