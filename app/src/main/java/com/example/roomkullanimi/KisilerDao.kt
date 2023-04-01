package com.example.roomkullanimi

import androidx.room.*

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler(): List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisiler: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisiler: Kisiler)

    @Delete
    suspend fun kisiSil(kisiler: Kisiler)

    @Query("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT 1")
    suspend fun rastgeleBirKisiGetir(): List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' ||:aramaKelimesi || '%'")
    suspend fun kisiAra(aramaKelimesi: String): List<Kisiler>

    @Query("SELECT * FROM kisiler WHERE kisi_id=:kisi_id")
    suspend fun kisiGetir(kisi_id:Int): Kisiler

    @Query("SELECT count(*) FROM kisiler WHERE kisi_adi=:kisi_adi")
    suspend fun kayitKontrol(kisi_ad:String): Kisiler
}