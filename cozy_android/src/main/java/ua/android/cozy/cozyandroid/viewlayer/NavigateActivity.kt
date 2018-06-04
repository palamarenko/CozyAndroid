package ua.android.cozy.cozyandroid.viewlayer

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout

import ua.android.cozy.cozyandroid.navigator.Navigator

open class NavigateActivity : AppCompatActivity() {

    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        simpleInit()
    }

    fun simpleInit() {
        val frameLayout = FrameLayout(this)
        frameLayout.id = View.generateViewId()
        setContentView(frameLayout)
        navigator = Navigator(frameLayout.id, supportFragmentManager)
    }


    override fun onBackPressed() {
        val manager = navigator.fragmentManager
        val count = manager.backStackEntryCount
        if (count == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}
