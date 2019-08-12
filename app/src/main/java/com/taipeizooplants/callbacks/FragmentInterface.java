package com.taipeizooplants.callbacks;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public interface FragmentInterface {

    void onFragmentSetTitle(String title);

    void onFragmentOpen(Fragment instance, String backName);

    void onFragmentOpenWithAnim(Fragment instance, String backName, int animEnter, int animExit);

    void onFragmentPopBack(@Nullable String backName);

    void onFragmentLoading(boolean inLoading);
}
