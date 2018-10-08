package sanaebadi.info.databindinginkolinworld.activity

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import sanaebadi.info.databindinginkolinworld.R
import sanaebadi.info.databindinginkolinworld.adapter.DataAdapter
import sanaebadi.info.databindinginkolinworld.databinding.ActivityMainBinding
import sanaebadi.info.databindinginkolinworld.model.DataModel

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView
    lateinit var dataRecyclerView: RecyclerView
    val dataList = ArrayList<DataModel>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        toolbar = binding.mainDrawerContent.toolbar
        drawerLayout = binding.drawerLayout
        navigationView = binding.navigationView
        dataRecyclerView = binding.mainDrawerContent.mainContent.dataRecycler

        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.app_name)

        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawerLayout
                , toolbar, R.string.Open, R.string.Close) {

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }
        }

        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Set navigation view navigation item selected listener
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_data_binding -> toast("DataBinding")
                R.id.nav_jet_pack -> toast("JetPack")
                R.id.nav_kotlin -> toast("Kotlin")
                R.id.nav_android -> toast("Android")
                else -> {
                    toast("No Checked !")
                }
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


        //RecyclerView config
        dataRecyclerView.setHasFixedSize(true)
        dataRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        putData()


        val adapter = DataAdapter(dataList)
        dataRecyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    // Extension function to show toast message easily
    private fun Context.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    fun putData() {

        dataList.add(DataModel("http://sanaebadi.info/DataBinding/pics/telegram.jpg",
                getString(R.string.telegram), getString(R.string.telegram_msg)))
        dataList.add(DataModel("http://sanaebadi.info/DataBinding/pics/flutter.jpg",
                getString(R.string.flutter), getString(R.string.flutter_meg)))
        dataList.add(DataModel("http://sanaebadi.info/DataBinding/pics/freechat.jpg",
                getString(R.string.freeChat), getString(R.string.freeChat_meg)))
        dataList.add(DataModel("http://sanaebadi.info/DataBinding/pics/barca.jpeg",
                getString(R.string.barcelona), getString(R.string.barcelona_meg)))
        dataList.add(DataModel("http://sanaebadi.info/DataBinding/pics/supergr.jpg",
                getString(R.string.super_gr), getString(R.string.super_gr_msg)))
        dataList.add(DataModel("http://sanaebadi.info/DataBinding/pics/android.jpg",
                getString(R.string.android_gr), getString(R.string.android_gr_meg)))


    }
}


