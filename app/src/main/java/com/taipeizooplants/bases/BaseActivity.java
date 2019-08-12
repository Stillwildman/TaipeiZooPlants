package com.taipeizooplants.bases;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.taipeizooplants.R;
import com.taipeizooplants.databinding.ActivityMainBinding;
import com.taipeizooplants.model.CommonConstants;
import com.taipeizooplants.utilities.DialogHelper;
import com.taipeizooplants.utilities.Utility;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, CommonConstants {

    protected final String TAG = getClass().getSimpleName();

    protected abstract void init();

    protected abstract boolean hasFragmentBackStack();

    protected abstract void onUiHandleMessage(Message msg);

    protected ActivityMainBinding mBinding;

    protected ActionBarDrawerToggle toggle;

    private Handler uiHandler;

    private boolean hasInit;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initToolbarAndDrawer();
    }

    private void initToolbarAndDrawer() {
        setSupportActionBar(mBinding.includeAppBar.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout, mBinding.includeAppBar.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.setToolbarNavigationClickListener(this);
        mBinding.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkNetwork();
    }

    private void checkNetwork() {
        if (Utility.isNetworkEnabled()) {
            if (!hasInit) {
                init();
                hasInit = true;
            }
        }
        else {
            DialogHelper.showNetworkRequestDialog(this);
        }
    }

    protected void showLoadingCircle(boolean isShow) {
        mBinding.includeAppBar.toolbarLoadingCircle.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public Handler getUiHandler() {
        if (uiHandler == null)
            uiHandler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    onUiHandleMessage(msg);
                }
            };
        return uiHandler;
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
    public void onClick(View v) {
        if (v.getId() == TOOLBAR_BACK) {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        finishByDoubleClickBack();
    }
}
