package com.kotlin.mvvmdemo.views

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.mvvmdemo.R
import com.kotlin.mvvmdemo.adapters.ImagesAdapter
import com.kotlin.mvvmdemo.model.ImageDO
import com.kotlin.mvvmdemo.viewModels.ImageListViewModel

class ImagesActivity : AppCompatActivity() {

    private var rvList: RecyclerView? = null;
    private var listAdapter: ImagesAdapter? = null;
    private var images: ArrayList<ImageDO> = ArrayList()
    private var tvError: TextView? = null
    private var viewModel: ImageListViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()

        observerViewModel()
    }

    private fun observerViewModel()
    {
        viewModel!!.getImages()!!.observe(this, Observer { imagesList ->

            rvList!!.visibility = View.VISIBLE
            tvError!!.visibility = View.GONE

            this.images.clear()
            this.images.addAll(imagesList!!)
            listAdapter!!.notifyDataSetChanged()
        })

        viewModel!!.getError()!!.observe(this, Observer { errorMessage ->

            rvList!!.visibility = View.GONE
            tvError!!.visibility = View.VISIBLE

            tvError!!.text = errorMessage
        })

    }
    private fun initControls() {

        viewModel = ViewModelProviders.of(this).get(ImageListViewModel::class.java)

        tvError = findViewById(R.id.tvError)

        // Page Title
        title = "MVVM Demo"

        // Initialize Recycler views
        rvList = findViewById(R.id.rvList)
        rvList!!.layoutManager = GridLayoutManager(this, 2)
        rvList!!.addItemDecoration(GridItemDecoration(10, 2))

        // Setup Adapter
        listAdapter = ImagesAdapter(this, images = images);
        rvList!!.adapter = listAdapter;

    }

}
