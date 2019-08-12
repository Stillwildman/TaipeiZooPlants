package com.taipeizooplants.utilities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

import com.AppController;
import com.taipeizooplants.R;
import com.taipeizooplants.widgets.LoadingDialog;

import androidx.appcompat.app.AlertDialog;

public class DialogHelper {

    private static AlertDialog dialog;
    private static LoadingDialog loadingDialog;

    public static void showLoadingDialog(Context context) {
        if (context != null) {
            if (loadingDialog != null) {
                loadingDialog.safeDismiss();
            }

            loadingDialog = new LoadingDialog(context);

            if (!loadingDialog.isShowing()) {
                loadingDialog.show();
            }
        }
    }

    private static void showDialog(AlertDialog.Builder dialogBuilder, boolean customizedBackground, final float widthProportion) {
        closeDialogIfIsShowing();

        dialog = dialogBuilder.create();

        if (widthProportion != 0 && widthProportion != 1) {
            dialog.setOnShowListener((DialogInterface dialog) ->
            {
                if (DialogHelper.dialog != null) {
                    Window window = DialogHelper.dialog.getWindow();

                    if (window != null) {
                        int width = (int) (Utility.getScreenWidth() * widthProportion);
                        WindowManager.LayoutParams params = window.getAttributes();
                        params.width = width;

                        window.setAttributes(params);
                    }

                    DialogHelper.dialog.setOnShowListener(null);
                }
            });
        }

        if (customizedBackground && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialog.show();
    }

    private static void closeDialogIfIsShowing() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public static void dismissDialog() {
        if (loadingDialog != null) {
            loadingDialog.safeDismiss();
            loadingDialog = null;
        }
        else if (dialog != null && dialog.isShowing()) {
            dialog.setOnShowListener(null);
            dialog.dismiss();
            dialog = null;
        }
    }

    public static void dismissAllDialog() {
        if (loadingDialog != null) {
            loadingDialog.safeDismiss();
            loadingDialog = null;
        }
        if (dialog != null && dialog.isShowing()) {
            dialog.setOnShowListener(null);
            dialog.dismiss();
            dialog = null;
        }
    }

    public static void showNetworkRequestDialog(final Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

        dialogBuilder.setTitle(R.string.network_is_unable_title);
        dialogBuilder.setMessage(R.string.network_is_unable_content);
        dialogBuilder.setCancelable(false);

        dialogBuilder.setNeutralButton(R.string.cancel, null);

        DialogInterface.OnClickListener btnClick = (dialog, which) -> {
            Intent intent = new Intent();

            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    intent.setAction(Settings.ACTION_WIFI_SETTINGS);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    intent.setAction(Settings.ACTION_SETTINGS);
                    break;
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            AppController.getInstance().startActivity(intent);

            dismissDialog();
        };

        dialogBuilder.setPositiveButton(R.string.go_to_wifi_setting, btnClick);
        dialogBuilder.setNegativeButton(R.string.go_to_setting, btnClick);

        showDialog(dialogBuilder, false, 0);
    }
}
