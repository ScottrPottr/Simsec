package tech.simsec.android.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import tech.simsec.android.R

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_accounts -> {
                message.setText(R.string.title_accounts)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_send -> {
                message.setText(R.string.title_send)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_receive -> {
                message.setText(R.string.title_receive)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                message.setText(R.string.title_settings)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
