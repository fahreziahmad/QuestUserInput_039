package com.example.questuserinput_039

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun FormRegistrasi() {
    var nama by remember { mutableStateOf("") }
    var kota by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var rt by remember { mutableStateOf("") }
    var rw by remember { mutableStateOf("") }
    var umur by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var disetujui by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            tanggalLahir = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFB3E5FC), Color(0xFF81C784))
                )
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Form Registrasi",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Nama Lengkap
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Lengkap") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Kota Asal
            OutlinedTextField(
                value = kota,
                onValueChange = { kota = it },
                label = { Text("Kota Asal") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Baris Tanggal Lahir - RT - RW
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = tanggalLahir,
                    onValueChange = {},
                    label = { Text("Tanggal Lahir") },
                    modifier = Modifier
                        .weight(2f)
                        .clickable { datePickerDialog.show() },
                    enabled = false, // tidak bisa diketik manual
                    readOnly = true
                )
                Spacer(modifier = Modifier.width(6.dp))
                OutlinedTextField(
                    value = rt,
                    onValueChange = { rt = it },
                    label = { Text("RT") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(6.dp))
                OutlinedTextField(
                    value = rw,
                    onValueChange = { rw = it },
                    label = { Text("RW") },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Umur
            OutlinedTextField(
                value = umur,
                onValueChange = { umur = it },
                label = { Text("Umur") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Jenis Kelamin
            Text(
                text = "Jenis Kelamin",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = jenisKelamin == "Laki-laki",
                    onClick = { jenisKelamin = "Laki-laki" }
                )
                Text("Laki-laki")
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = jenisKelamin == "Perempuan",
                    onClick = { jenisKelamin = "Perempuan" }
                )
                Text("Perempuan")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Checkbox Persetujuan
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = disetujui,
                    onCheckedChange = { disetujui = it }
                )
                Text(
                    text = "Saya setuju dengan syarat dan ketentuan yang berlaku",
                    fontSize = 13.sp,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Tombol Submit
            Button(
                onClick = { showDialog = true },
                enabled = disetujui,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (disetujui) Color(0xFF4CAF50) else Color.LightGray
                )
            ) {
                Text(text = "Submit", color = Color.White, fontSize = 16.sp)
            }

