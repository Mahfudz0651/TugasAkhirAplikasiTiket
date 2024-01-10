package com.example.aplikasitiket.theme

import androidx.lifecycle.ViewModel
import com.example.aplikasitiket.database.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val HARGA_TIKET = 250000
class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlKursi: Int) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlKursi,
                harga = hitungHarga(jumlah = jmlKursi)
            )
        }
    }

    fun setRasa(busPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(kelas = busPilihan)
        }
    }

    fun setContact(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                Tujuan = listData[1],
                noTelp = listData[2]
            )
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String {
        val kalkulasiHarga = jumlah * HARGA_TIKET

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }
}
