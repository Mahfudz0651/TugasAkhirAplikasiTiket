package com.example.aplikasitiket.view.history

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasitiket.R
import com.example.aplikasitiket.model.ModelDatabase
import com.example.aplikasitiket.viewmodel.HistoryViewModel


class HistoryActivity : AppCompatActivity() {
    var modelDatabaseList: MutableList<ModelDatabase> = ArrayList()
    lateinit var historyAdapter: HistoryAdapter
    lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setStatusBar()
    }
    private fun setStatusBar(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (Build.VERSION.SDK_INT >= 21){

        }
    }
}