package com.taipeizooplants.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.taipeizooplants.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class LoadingDialog extends AlertDialog {

    public LoadingDialog(@NonNull Context context) {
        super(context);

        if (context instanceof AppCompatActivity) {
            this.setOwnerActivity((AppCompatActivity) context);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.inflate_loading_window, null);
        setView(view);

        setCancelable(false);

        if (this.getWindow() != null) {
            this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            this.getWindow().setDimAmount(0.3f);
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (getOwnerActivity() == null) {
            this.setOwnerActivity((AppCompatActivity) getContext());
        }
    }

    public void safeDismiss() {
        if (this.isShowing() && this.getOwnerActivity() != null && !this.getOwnerActivity().isFinishing()) {
            this.dismiss();
        }
    }
}
