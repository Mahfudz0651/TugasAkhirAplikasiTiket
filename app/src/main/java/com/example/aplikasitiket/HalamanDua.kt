package com.example.aplikasitiket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.aplikasitiket.database.OrderUIState

@Composable
fun HalamanDua (
    orderUIState: OrderUIState,
    onCancelButtonCliked: () -> Unit,
    modifier: Modifier = Modifier
){
    val items = listOf(
        Pair(stringResource(R.string.nama), orderUIState.nama),
        Pair(stringResource(R.string.NoTelp), orderUIState.noTelp),
        Pair(stringResource(R.string.tujuan), orderUIState.Tujuan),
        Pair(stringResource(R.string.quantity), orderUIState.jumlah),
        Pair(stringResource(R.string.kelas), orderUIState.kelas),
    )
}