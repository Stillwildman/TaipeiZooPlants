package com.taipeizooplants.bases;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.taipeizooplants.R;
import com.taipeizooplants.databinding.ActivityMainBinding;
import com.taipeizooplants.utilities.Utility;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected final String TAG = getClass().getSimpleName();

    protected abstract void init();

    protected abstract boolean hasMoreThanOneFragment();

    private ActivityMainBinding mBinding;

    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initDrawer();

        init();
    }

    private void initDrawer() {
        setSupportActionBar(mBinding.includeAppBar.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout, mBinding.includeAppBar.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mBinding.navView.setNavigationItemSelectedListener(this);
    }

    protected void showLoadingCircle(boolean isShow) {
        mBinding.includeAppBar.toolbarLoadingCircle.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    protected void finishByDoubleClickBack() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Utility.toastShort(R.string.confirm_to_exit);
            exitTime = System.currentTimeMillis();
        }
        else {
            Utility.forceKillTask();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:

                break;

            case R.id.nav_about:

                break;
        }

        mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = mBinding.drawerLayout;

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (hasMoreThanOneFragment()) {
            super.onBackPressed();
        }
        else {
            finishByDoubleClickBack();
        }
    }
}
