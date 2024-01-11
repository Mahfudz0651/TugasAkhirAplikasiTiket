package com.example.aplikasitiket

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihanBus: List<String>,
    onSelectionChanged: (String) -> Unit,
    onConfirmButtonCliked: (Int) -> Unit,
    onNextButtonCliked: () -> Unit,
    onCancelButtonCliked: () -> Unit,
    modifier: Modifier = Modifier
){
    var busygDipilih by rememberSaveable { mutableStateOf("")}
    var textJmlBeli by remember { mutableStateOf("")}
}