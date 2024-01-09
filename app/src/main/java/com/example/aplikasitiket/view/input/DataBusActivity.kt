package com.example.aplikasitiket.view.input

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasitiket.R
import com.example.aplikasitiket.viewmodel.InputDataViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DataBusActivity : AppCompatActivity() {
    val strAsal = arrayOf("Jakarta", "Semarang", "Surabaya", "Yogyakarta")
    val strTujuan = arrayOf("Jakarta", "Semarang", "Surabaya", "Yogyakarta")
    val strKelas = arrayOf("Super Top", "Super Eksekutif", "VIP")
    lateinit var inputDataViewModel: InputDataViewModel
    lateinit var sAsal: String
    lateinit var sTujuan: String
    lateinit var sTanggal: String
    lateinit var sNama: String
    lateinit var sTelp: String
    lateinit var sKelas: String
    var hargaDewasa = 0
    var hargaAnak = 0
    var hargaKelas = 0
    var hargaTotalDewasa = 0
    var hargaTotalAnak = 0
    var hargaTotal = 0
    var jmlDewasa = 0
    var jmlAnak = 0
    var countAnak = 0
    var countDewasa = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)

       setViewModel()
       setToolbar()
       setSpinnerAdapter()
}
    private fun setViewModel() {
        inputDataViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(InputDataViewModel::class.java)
    }
    private fun setToolbar(){
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
    private fun setInitView() {
        inputTanggal.setOnClickListener { view: View? ->
            val tanggalJemput = Calendar.getInstance()
            val date =
                DatePickerDialog.OnDateSetListener { view1: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    tanggalJemput[Calendar.YEAR] = year
                    tanggalJemput[Calendar.MONTH] = monthOfYear
                    tanggalJemput[Calendar.DAY_OF_MONTH] = dayOfMonth
                    val strFormatDefault = "d MMMM yyyy"
                    val simpleDateFormat = SimpleDateFormat(strFormatDefault, Locale.getDefault())
                    inputTanggal.setText(simpleDateFormat.format(tanggalJemput.time))
                }
            DatePickerDialog(
                this@DataBusActivity, date,
                tanggalJemput[Calendar.YEAR],
                tanggalJemput[Calendar.MONTH],
                tanggalJemput[Calendar.DAY_OF_MONTH]
            ).show()

    }
}
    private fun setSpinnerAdapter() {
    }