package com.taipeizooplants.bases;

import android.util.Log;
import android.view.MenuItem;

import com.AppController;
import com.taipeizooplants.BuildConfig;
import com.taipeizooplants.R;
import com.taipeizooplants.callbacks.FragmentBackPressCallback;
import com.taipeizooplants.callbacks.FragmentInterface;
import com.taipeizooplants.utilities.Utility;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseFragmentActivity extends BaseActivity implements FragmentInterface, FragmentManager.OnBackStackChangedListener {

    private FragmentManager fm;
    private FragmentBackPressCallback fragmentBackPressCallback;

    @Override
    protected void init() {
        if (fm == null) {
            fm = getSupportFragmentManager();
            fm.addOnBackStackChangedListener(this);
        }
    }

    @Override
    public void onBackStackChanged() {
        int count = fm.getBackStackEntryCount();

        if (count > 0) {
            toggle.setDrawerIndicatorEnabled(false);
        }
        else {
            toggle.setDrawerIndicatorEnabled(true);
            setTitle(R.string.taipei_zoo);
        }

        Log.i(TAG, "BackStackCount: " + count);
    }

    public void setFragmentBackPressCallback(FragmentBackPressCallback callback) {
        this.fragmentBackPressCallback = callback;
    }

    protected void goToFragment(Fragment instance, String backName, int animEnter, int animExit) {
        if (fm != null) {
            Fragment lastFragment = fm.findFragmentById(R.id.fragment_container);

            if (lastFragment != null && lastFragment.equals(instance)) {
                return;
            }

            if (animEnter == 0 && animExit == 0) {
                if (backName != null) {
                    fm.beginTransaction().add(R.id.fragment_container, instance).addToBackStack(backName).commit();
                }
                else {
                    fm.beginTransaction().add(R.id.fragment_container, instance).commit();
                }
            }
            else {
                goToFragmentWithAnim(instance, backName, animEnter, animExit);
            }
        }
    }

    private void goToFragmentWithAnim(Fragment instance, String backName, int animEnter, int animExit) {
        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(animEnter, 0, 0, animExit);
        ft.add(R.id.fragment_container, instance);

        if (backName != null) {
            ft.addToBackStack(backName);
        }
        ft.commitAllowingStateLoss();
    }

    protected void backToPrevious(@Nullable String backName) {
        if (fm != null) {
            if (backName == null) {
                fm.popBackStackImmediate();
            }
            else {
                fm.popBackStackImmediate(backName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }

            resumeFragment();
        }
    }

    private void resumeFragment() {
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment != null) {
            fragment.onResume();
        }
    }

    private void clearFragments() {
        if (fm != null && fm.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry backLevel = fm.getBackStackEntryAt(0);
            fm.popBackStack(backLevel.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    protected boolean hasFragmentBackStack() {
        return fm != null && fm.getBackStackEntryCount() > 0;
    }

    @Override
    public void onFragmentSetTitle(String title) {
        setTitle(title);
    }

    @Override
    public void onFragmentOpen(Fragment instance, String backName) {
        goToFragment(instance, backName, 0, 0);
    }

    @Override
    public void onFragmentOpenWithAnim(Fragment instance, String backName, int animEnter, int animExit) {
        goToFragment(instance, backName, animEnter, animExit);
    }

    @Override
    public void onFragmentPopBack(@Nullable String backName) {
        backToPrevious(backName);
    }

    @Override
    public void onFragmentLoading(boolean inLoading) {
        getUiHandler().sendEmptyMessage(inLoading ? MESSAGE_LOADING_START : MESSAGE_LOADING_STOP);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                clearFragments();
                break;

            case R.id.nav_about:
                Utility.toastLong(AppController.getInstance().getString(R.string.version, BuildConfig.VERSION_NAME));
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
        else if (hasFragmentBackStack()) {
            fragmentBackPressCallback.onFragmentPressBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
