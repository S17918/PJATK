package pjatk.prm.s17918.currentweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNavigation()
    }

    private fun initBottomNavigation(){
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            .setupWithNavController(navController)

        bottom_nav.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.menu_current_weather -> findNavController(R.id.nav_host_fragment).navigate(R.id.current_weather_fragment)
                R.id.menu_search -> findNavController(R.id.nav_host_fragment).navigate(R.id.search_fragment)
                R.id.menu_fav -> findNavController(R.id.nav_host_fragment).navigate(R.id.favourite_fragment)
            }
            true
        }
    }
}