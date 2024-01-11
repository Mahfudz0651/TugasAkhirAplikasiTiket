package com.example.aplikasitiket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplikasitiket.ui.theme.AplikasiTiketTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonCliked: (MutableList<String>) -> Unit,
){
    var nama by rememberSaveable { mutableStateOf("")}
    var noHp by remember{ mutableStateOf("")}
    var tujuan by remember{ mutableStateOf("")}
    var listData: MutableList<String> = mutableListOf(nama, noHp, tujuan)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text(text = "Nama")}
        )
        OutlinedTextField(
            value = noHp,
            onValueChange = {noHp = it},
            label = { Text(text = "Nomor Telepon")}
        )
        OutlinedTextField(
            value = tujuan,
            onValueChange = {tujuan = it},
            label = { Text(text = "Tujuan")}
        )
    }
}

