package com.taipeizooplants.bases;

import android.util.Log;

import com.taipeizooplants.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseFragmentActivity extends BaseActivity implements FragmentManager.OnBackStackChangedListener {

    private FragmentManager fm;

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

        Log.i(TAG, "BackStackCount: " + count);
    }

    protected void goToFragment(Fragment instance, String backName) {
        if (fm != null) {
            Fragment lastFragment = fm.findFragmentById(R.id.fragment_container);

            if (lastFragment != null && lastFragment.equals(instance)) {
                return;
            }

            fm.beginTransaction().add(R.id.fragment_container, instance).addToBackStack(backName).commit();
        }
    }

    protected void goToFragmentWithAnim(Fragment instance, String backName, int animEnter, int animExit) {
        FragmentTransaction ft = fm.beginTransaction();

        ft.setCustomAnimations(animEnter, 0, 0, animExit);
        ft.add(R.id.fragment_container, instance);
        ft.addToBackStack(backName);
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
        if (fm != null && fm.getBackStackEntryCount() > 0) {
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);

            if (fragment != null) {
                fragment.onResume();
            }
        }
    }

    @Override
    protected boolean hasMoreThanOneFragment() {
        return fm != null && fm.getBackStackEntryCount() > 1;
    }
}
