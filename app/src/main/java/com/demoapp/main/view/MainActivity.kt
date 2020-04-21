package com.demoapp.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoapp.R
import com.demoapp.main.adapter.MainAdapter
import com.demoapp.main.viewModel.MainViewModel
import com.mindorks.framework.mvvm.utils.Status
import com.niravjoshi.proof_of_concept.concepts.model.FeedDetailDTO
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initControls()
    }

    fun initControls() {

        setupViewModel()

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        /*recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )*/
        recyclerView.adapter = adapter

        setupAPICall()
    }


    private fun setupAPICall() {
        mainViewModel.getFeedsList().observe(this, Observer {
            when (it.status) {
                (Status.SUCCESS) -> {
                    progressBar.visibility = View.GONE
                    renderList(it.data?.mFeedsList as ArrayList<FeedDetailDTO>)
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                (Status.ERROR) -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        mainViewModel.getFeeds()
    }

    private fun renderList(feedDetailDTO: ArrayList<FeedDetailDTO>) {
        adapter.addData(feedDetailDTO)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this
        ).get(MainViewModel::class.java)
    }
}

