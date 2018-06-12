package ua.android.cozy.cozyandroid.viewlayer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlin.reflect.KClass

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    lateinit var modelClass: Class<T>

    abstract val layout: Int

    private var fragmentView: View? = null

    abstract fun initViewModel(): KClass<T>


    fun takeViewModel(): T {
        return ViewModelProviders.of(this).get(initViewModel().java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (fragmentView == null) {
            fragmentView = inflater.inflate(layout, null)
        }
        return fragmentView
    }


    fun setArgumentString(key: String, value: String): BaseFragment<T> {
        if (arguments == null) {
            arguments = Bundle()
        }

        arguments?.putString(key, value)

        return this
    }

    fun getArgumentString(key: String): String {
        return arguments?.getString(key) ?: ""
    }


}