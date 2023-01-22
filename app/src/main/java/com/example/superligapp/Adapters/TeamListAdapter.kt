package com.example.superligapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import com.example.superligapp.DetailActivity
import com.example.superligapp.Entities.Takim
import com.example.superligapp.R
import com.tfb.fbtoast.FBToast

    class TeamListAdapter(context: Context,teamList: ArrayList<Takim>) : BaseAdapter() {

        var teamList : ArrayList<Takim>
        var context : Context

        init {
            this.teamList = teamList
            this.context = context
        }

        override fun getCount(): Int {
        return teamList.size
    }

    override fun getItem(p0: Int): Any {
        return teamList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var inflater = LayoutInflater.from(context)
        var teamListLayout = inflater.inflate(R.layout.team_list_layout,p2,false)

        teamListLayout.findViewById<ImageView>(R.id.teamListLogoImg).setImageResource(teamList.get(p0).takimLogo)
        teamListLayout.findViewById<TextView>(R.id.teamListTeamName).text = teamList.get(p0).takimAdi

        teamListLayout.findViewById<LinearLayout>(R.id.teamListRootLayout).setOnClickListener {
            val intent  = Intent(this.context,DetailActivity::class.java)
            intent.putExtra("team",teamList.get(p0))
            startActivity(context,intent,null)
        }

        return teamListLayout
    }
}