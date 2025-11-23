package ys.mobile.finoteapp.ui.transaction

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ys.mobile.finoteapp.viewmodel.TransactionViewModel

@Composable
fun AddTransactionScreen(
    onBack: () -> Unit,
    onScanReceipt: () -> Unit,
    viewModel: TransactionViewModel = viewModel()
) {
    val context = LocalContext.current
    val nominal by viewModel.nominal
    val category by viewModel.category
    val note by viewModel.note
    val date by viewModel.date

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Tambah Transaksi", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nominal,
            onValueChange = viewModel::updateNominal,
            label = { Text("Nominal") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = category,
            onValueChange = viewModel::updateCategory,
            label = { Text("Kategori") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = note,
            onValueChange = viewModel::updateNote,
            label = { Text("Catatan") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = date,
            onValueChange = viewModel::updateDate,
            label = { Text("Tanggal") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onScanReceipt) {
            Text(text = "Scan Struk")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            Toast.makeText(context, "Saved (Week 1)", Toast.LENGTH_SHORT).show()
            onBack()
        }) {
            Text(text = "Simpan")
        }
    }
}
