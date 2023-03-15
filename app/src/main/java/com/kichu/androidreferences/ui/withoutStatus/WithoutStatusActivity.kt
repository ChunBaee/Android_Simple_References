package com.kichu.androidreferences.ui.withoutStatus

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.kichu.androidreferences.R

class WithoutStatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_without_status)

        setStatusGone()
    }

    /** fun Activity.setStatusGone() 와 같은 확장함수 형태로 만들면, fragment등에서 requireActivity.setStatusGone() 와 같은 형태로 적용도 가능하다.*/

    private fun setStatusGone() {
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        /** TargetSDK가 30 이상인 경우에는 굳이 조건문을 걸 필요 없이 바로 추가하자 */
        if(Build.VERSION.SDK_INT >= 30)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }


}