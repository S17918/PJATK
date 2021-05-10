package pjatk.prm.s17918.managerfinansowykotlin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)

        drawerToggle.syncState()
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = getDate()

    }

    private fun getDate(): String{
        val cal = Calendar.getInstance()
        val date = SimpleDateFormat("LLLL", Locale.forLanguageTag("PL"))
        val month = date.format(cal.time)
        return month.substring(0, 1).toUpperCase() + month.substring(1)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.main_page -> {
                val navOptions = NavOptions.Builder().setPopUpTo(R.id.main, true).build()
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.events_fragment, null, navOptions)
                true
            }

            R.id.add_here ->{
                if(isValidDestination(R.id.add_here))
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.add_fragment)
                    true
            }

            R.id.search ->{
                if(isValidDestination(R.id.search))
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.search_fragment)
                true
            }

            R.id.expenses ->{
                if(isValidDestination(R.id.expenses))
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.expenses_fragment)
                true
            }

            R.id.incomes ->{
                if(isValidDestination(R.id.incomes))
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.income_fragment)
                true
            }

            R.id.monthStats ->{
                if(isValidDestination(R.id.monthStats))
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.month_stats)
                true
            }
        }

        item.isChecked = true
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.home -> {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }else{
                    false
                }
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun isValidDestination(destination: Int): Boolean{
        return destination != Navigation.findNavController(this, R.id.nav_host_fragment).currentDestination!!.id
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout)
    }
}
