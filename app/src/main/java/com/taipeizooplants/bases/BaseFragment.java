package com.taipeizooplants.bases;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.taipeizooplants.callbacks.FragmentBackPressCallback;
import com.taipeizooplants.callbacks.FragmentInterface;
import com.taipeizooplants.model.CommonConstants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<ViewBinding extends ViewDataBinding> extends Fragment implements FragmentBackPressCallback,
        View.OnTouchListener, View.OnClickListener, CommonConstants {

    protected final String TAG = getClass().getSimpleName();

    protected abstract int getLayoutID();

    protected abstract String getTitle();

    protected abstract void init();

    protected abstract void clearReferences();

    private FragmentInterface fragmentInterface;

    protected ViewBinding mBinding;

    private View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            fragmentInterface = (FragmentInterface) context;
        }
        catch (ClassCastException e) {
            e.printStackTrace();
            Log.e(TAG, context.getClass().getSimpleName() + " must implement " + FragmentInterface.class.getSimpleName());
        }

        ((BaseFragmentActivity) context).setFragmentBackPressCallback(this);

        Log.d(TAG, "onAttach!!!");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate!!!");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false);

        init();

        Log.d(TAG, "onCreateView!!!");

        return mBinding.getRoot();
    }

    protected void showLoadingCircle(boolean inLoading) {
        fragmentInterface.onFragmentLoading(inLoading);
    }

    protected void goToFragment(Fragment instance, String backName) {
        fragmentInterface.onFragmentOpen(instance, backName);
    }

    protected void goToFragmentWithAnim(Fragment instance, String backName, int animEnter, int animExit) {
        fragmentInterface.onFragmentOpenWithAnim(instance, backName, animEnter, animExit);
    }

    @Override
    public void onFragmentPressBack() {
        fragmentInterface.onFragmentPopBack(null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setBackgroundColor(Color.WHITE);
        rootView = view;
        rootView.setOnTouchListener(this);

        Log.d(TAG, "onViewCreated!!!");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart!!!");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume!!!");

        fragmentInterface.onFragmentSetTitle(getTitle());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause!!!");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop!!!");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (rootView != null) {
            rootView.setOnTouchListener(null);
            rootView = null;
        }
        clearReferences();

        Log.d(TAG, "onDestroyView!!!");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy!!!");
    }
}
