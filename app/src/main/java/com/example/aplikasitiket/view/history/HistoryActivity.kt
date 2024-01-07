package com.example.aplikasitiket.view.history

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.aplikasitiket.R
import com.example.aplikasitiket.model.ModelDatabase

class HistoryActivity : AppCompatActivity() {
    var modelDatabaseList: MutableList<ModelDatabase> = ArrayList()
    lateinit var historyAdapter: HistoryAdapter
    lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setStatusBar()
        setToolBar()
        setInitLayout()
        setViewModel()
        setUpItemTouchHelper()
    }
    private fun setToolBar() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

    private fun setInitLayout() {
        historyAdapter = HistoryAdapter(modelDatabaseList)
        rvHistory.setHasFixedSize(true)
        rvHistory.setLayoutManager(LinearLayoutManager(this))
        rvHistory.setAdapter(historyAdapter)
    }

    private fun setViewModel() {
        val simpleCallback: ItemTouchHelper.SimpleCallback = object :
        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START or ItemTouchHelper.END) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override  fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                val swipedPosition = viewHolder.adapterPosition
                val modelDatabase = historyAdapter.setSwipeRemove(swipedPosition)
                val uid = modelDatabase.uid
                historyViewModel.deleteDataById(uid)
                Toast.makeText(
                    this@HistoryActivity,
                    "Data Yang dipilih Berhasil Dihapus"
                )
            }
        }
    }
}