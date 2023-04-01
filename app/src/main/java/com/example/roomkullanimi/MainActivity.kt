package com.example.roomkullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomkullanimi.ui.theme.RoomKullanimiTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val context = LocalContext.current
    val vt = Veritabani.veritabaniErisim(context)!!

    LaunchedEffect(key1 = true) {
//        ekle(vt)
//        guncelle(vt)
//        sil(vt)
//        rastgele(vt)
//        ara(vt)
//        getir(vt)
        kontrol(vt)
//        tumKisiler(vt)

    }
}

fun tumKisiler(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().tumKisiler()
        for (k in liste) {
            Log.e("Kisi Bilgi", "************")
            Log.e("Kisi ID", k.kisi_id.toString())
            Log.e("Kisi Adı", k.kisi_adi)
            Log.e("Kisi Tel", k.kisi_tel)
        }
    }
}

fun ekle(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val yeniKisi = Kisiler(0, "Fatih", "4444444444")
        vt.kisilerDao().kisiEkle(yeniKisi)
    }
}

fun guncelle(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val guncellenenKisi = Kisiler(4, "YeniFatih", "5555555555")
        vt.kisilerDao().kisiGuncelle(guncellenenKisi)
    }
}

fun sil(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val silinecekKisi = Kisiler(4, "", "")
        vt.kisilerDao().kisiSil(silinecekKisi)
    }
}

fun rastgele(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().rastgeleBirKisiGetir()
        for (k in liste) {
            Log.e("Kisi Bilgi", "************")
            Log.e("Kisi ID", k.kisi_id.toString())
            Log.e("Kisi Adı", k.kisi_adi)
            Log.e("Kisi Tel", k.kisi_tel)
        }
    }
}
fun ara(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().kisiAra("ah")
        for (k in liste) {
            Log.e("Kisi Bilgi", "************")
            Log.e("Kisi ID", k.kisi_id.toString())
            Log.e("Kisi Adı", k.kisi_adi)
            Log.e("Kisi Tel", k.kisi_tel)
        }
    }
}
fun getir(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val kisi = vt.kisilerDao().kisiGetir(1)
            Log.e("Kisi Bilgi", "************")
            Log.e("Kisi ID", kisi.kisi_id.toString())
            Log.e("Kisi Adı", kisi.kisi_adi)
            Log.e("Kisi Tel", kisi.kisi_tel)
    }
}
fun kontrol(vt: Veritabani) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val sonuc = vt.kisilerDao().kayitKontrol("Ahmet")
            Log.e("Kisi Sonuç", sonuc.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomKullanimiTheme {
        Sayfa()
    }
}