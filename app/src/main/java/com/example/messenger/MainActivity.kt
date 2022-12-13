package com.example.messenger

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.messenger.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.example.messenger.SettingsFragment
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Cообщения")
                    .withIcon(R.drawable.messeng)
            )
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Создать группу")
                    .withIcon(R.drawable.groups)
            )
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Контакты")
                    .withIcon(R.drawable.contact)
            )
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Настройки")
                    .withIcon(R.drawable.setting)
            ).withOnDrawerItemClickListener(object :Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position) {
                    4 ->  supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                        .replace(R.id.dataContainer,
                            SettingsFragment()
                        ).commit()
                }
                return false
            }
    }).build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Artyom Yushkov")
                    .withEmail("@rtmuskov")
            )
            .build()

    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }

    fun onClickGoSettings(view: View) {
        val intent = Intent(this, settings::class.java)
        startActivity(intent)
    }
}