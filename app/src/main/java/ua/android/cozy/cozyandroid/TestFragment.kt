package ua.android.cozy.cozyandroid


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.fragment_test.*
import ua.android.cozy.cozyandroid.recycler.implementation.SuperSimpleRecyclerAdapter
import ua.android.cozy.cozyandroid.viewlayer.BaseFragment
import kotlin.reflect.KClass

/**
 * Created by Palamarenko Andrey on
 * 15.04.2018 13:22
 */

class TestFragment : BaseFragment<TestViewModel>() {

    override fun initViewModel(): KClass<TestViewModel> {
        return TestViewModel::class
    }

    override val layout: Int = R.layout.fragment_test


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler.layoutManager = LinearLayoutManager(context)

        var list : ArrayList<String>? = ArrayList()
        list?.apply {
            add("hello1")
            add("hello2")
            add("hello3")
            add("hello")
            add("hello")
            add("hello")
            add("hello")
            add("ddd1")
            recycler.adapter = SuperSimpleRecyclerAdapter(list,ViewHolder::class)
                    .setOnClickListener ({ Log.d("HELLO",it)})
        }




    }
}
