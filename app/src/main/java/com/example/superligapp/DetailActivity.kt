package com.example.superligapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.superligapp.Entities.Takim
import com.google.android.material.appbar.CollapsingToolbarLayout

class DetailActivity : AppCompatActivity() {

    lateinit var anaResimImg : ImageView
    lateinit var baslik : CollapsingToolbarLayout
    lateinit var aciklama : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ToolbarTanimla()
        Tanimla()

        val gelenDeger = intent.extras?.get("team") as Takim

        anaResimImg.setImageResource(gelenDeger.takimLogo)
        baslik.title = gelenDeger.takimAdi
        aciklama.text = gelenDeger.takimDetay

    }

    private fun Tanimla(){
        anaResimImg = findViewById(R.id.detayResimImg)
        baslik = findViewById(R.id.baslikTxt)
        aciklama = findViewById(R.id.detayAciklamaTxt)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    private fun ToolbarTanimla() {
        setSupportActionBar(findViewById(R.id.actionBarr))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}