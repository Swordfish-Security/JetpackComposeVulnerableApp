package ru.ptsecurity.navigation_example

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ptsecurity.navigation_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("navigation", "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment).navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_first, R.id.navigation_deferred
            )
        )
        supportActionBar?.hide()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.apply {
            popBackStack(R.id.navigation_home, true)
            navigate(R.id.navigation_passcode)
            addOnDestinationChangedListener { _, destination, _ ->
                binding.navView.isVisible = destination.id != R.id.navigation_passcode
            }
        }
        Log.d("navigation", "==============================================");
        Log.d("navigation", "id navigation xml:" + R.id.mobileNavigation);
        Log.d("navigation", "id navigation deferred xml:" + R.id.deferredNavigation);
        Log.d("navigation", "navigation home:" + R.id.navigation_home);
        Log.d("navigation", "fragment private:" + R.id.navigation_private);
        Log.d("navigation", "fragment inner home:" + R.id.navigation_inner_home);
        Log.d("navigation", "fragment second:" + R.id.navigation_second);
        Log.d("navigation", "fragment deferred:" + R.id.navigation_deferred);
        Log.d("navigation", "fragment webview:" + R.id.navigation_webview);
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "new intent", Toast.LENGTH_SHORT).show();
        Log.d("navigation", "on new intent")
    }
}