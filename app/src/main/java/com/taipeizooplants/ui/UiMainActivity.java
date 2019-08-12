package com.taipeizooplants.ui;

import android.os.Message;

import com.taipeizooplants.bases.BaseFragmentActivity;
import com.taipeizooplants.ui.fragments.UiZooVenueListFragment;

public class UiMainActivity extends BaseFragmentActivity {

    @Override
    protected void init() {
        super.init();
        openFirstFragment();
    }

    private void openFirstFragment() {
        goToFragment(new UiZooVenueListFragment(), null, 0, 0);
    }

    @Override
    protected void onUiHandleMessage(Message msg) {
        switch (msg.what) {
            case MESSAGE_LOADING_START:
                showLoadingCircle(true);
                break;

            case MESSAGE_LOADING_STOP:
                showLoadingCircle(false);
                break;
        }
    }
}
