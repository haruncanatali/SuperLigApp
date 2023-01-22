package com.example.superligapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.superligapp.Adapters.TeamListAdapter
import com.example.superligapp.Entities.Takim

class MainActivity : AppCompatActivity() {

    lateinit var rootListView: ListView
    lateinit var teamList : ArrayList<Takim>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Tanimla()
        VeriDoldur()
        AdapterTanimla()
    }

    fun Tanimla(){
        rootListView = findViewById(R.id.rootListView)
        teamList = ArrayList<Takim>(18)
    }

    fun VeriDoldur(){
        val takimAdlari = resources.getStringArray(R.array.takimIsimleri)
        val takimDetaylari =resources.getStringArray(R.array.takimDetay)
        val takimLogolari = arrayOf(R.drawable.fb1,R.drawable.gs2,R.drawable.bjk3,R.drawable.ts4,R.drawable.ant5,
                                    R.drawable.gfk6,R.drawable.bfk7,R.drawable.ada8,R.drawable.ala9,R.drawable.mke10,
                                    R.drawable.kon11,R.drawable.gre12,R.drawable.kas13,R.drawable.kay14,R.drawable.umr15,
                                    R.drawable.siv16,R.drawable.fkg17,R.drawable.hat18)

        for(i in 0..17){
            val team = Takim(takimAdlari.get(i),takimDetaylari.get(i),takimLogolari.get(i))
            teamList.add(team)
        }
    }

    fun AdapterTanimla(){
        var adapter = TeamListAdapter(this,teamList)
        rootListView.adapter = adapter
    }
}