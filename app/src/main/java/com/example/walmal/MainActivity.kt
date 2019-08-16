package com.example.walmal

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newFragment = Home()
        val transaction = supportFragmentManager.beginTransaction().apply {
            add(R.id.frame, newFragment).commit()

        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu)


        /* val toggle = ActionBarDrawerToggle(
                 this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
         drawer_layout.addDrawerListener(toggle)
         toggle.syncState()*/

        nav_view.setNavigationItemSelectedListener(this)
        val toggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = drawerView.width * slideOffset
                //Slide
                //coordinator_layout.translationX = slideX
                frame.translationX = slideX

                //home_frame.translationX=slideX
                //fashion_frame.translationX=slideX
                //Next style
                //coordinator_layout.scaleX = 1-(slideOffset/5f)
                //coordinator_layout.scaleY = 1-(slideOffset/5f)

                //Next Next Style
                //coordinator_layout.scaleX = 1-slideOffset
                //coordinator_layout.scaleY = 1-slideOffset


            }

        }
        drawer_layout.addDrawerListener(toggle)
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        nav_view.setNavigationItemSelectedListener(this)
        /*img_drawer_menu.setOnClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.START))
                drawer_layout.closeDrawer(GravityCompat.START)
            else
                drawer_layout.openDrawer(GravityCompat.START)


        }*/


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_search -> {
                return true
            }
            R.id.action_cart -> {
                /*val newFragment = CategoryFragment()
                val transaction = supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame, newFragment)

                }
                transaction.commit()*/
                val i = Intent(this@MainActivity, ActivityCart::class.java)
                startActivity(i)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_login -> {
                val login = Intent(this@MainActivity, Login::class.java)
                startActivity(login)
            }
            R.id.nav_home -> {
                val newFragment = Home()
                val transaction = supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame, newFragment)

                }
                transaction.commit()

            }


            R.id.nav_share -> {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Hello")
                startActivity(Intent.createChooser(intent, "Share to:"))

            }
            R.id.nav_contact -> {
                val newFragment = Contact()
                val transaction = supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame, newFragment)

                }
                transaction.commit()
            }
            R.id.event -> {
                val newFragment = Event()
                val transaction = supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame, newFragment)

                }
                transaction.commit()
            }


        }


        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
