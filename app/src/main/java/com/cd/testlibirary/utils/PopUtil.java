package com.cd.testlibirary.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cd.testlibirary.R;

import java.util.Calendar;

/**
 * 弹出框工具类
 */
public class PopUtil {

    private static Toast sToast = null;
    private static Dialog sProgress = null;
    private static AlertDialog mAlertDialog = null;

    /**
     * 显示弹出
     * @param context 上下文
     * @param text CharSequence对象
     */
    public static void showToast(Context context, CharSequence text) {
        if (sToast != null) {
            sToast.cancel();
        }

        sToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        sToast.show();
    }

    /**
     * 显示弹出
     * @param context 上下文
     * @param resId 资源ID
     */
    public static void showToast(Context context, int resId) {
        showToast(context, context.getText(resId));
    }

    /**
     * 显示弹出对话框
     * @param context 上下文
     * @param messageId 消息ID
     * @param listener 对话框监听器
     */
    public static void showAlertDialog(Context context, int messageId, DialogInterface.OnClickListener listener) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(messageId);
        builder.setPositiveButton(R.string.confirm, listener);
        builder.setCancelable(false);
        builder.create().show();
    }

    /**
     * 显示弹出对话框
     * @param context 上下文
     * @param titleId 标题ID
     * @param messageId 消息ID
     * @param listener 对话框监听器
     */
    public static void showAlertDialog(Context context, int titleId, int messageId, DialogInterface.OnClickListener listener) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setMessage(messageId);
        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.confirm, listener);
        builder.setCancelable(true);
        builder.create().show();
    }

    /**
     * 显示弹出对话框
     * @param context 上下文
     * @param titleId 标题ID
     * @param messageId 消息ID
     */
    public static void showAlertDialog(Context context, int titleId, int messageId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setMessage(messageId);
        builder.setPositiveButton(R.string.confirm, null);
        builder.setCancelable(true);
        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    /**
     * 显示弹出对话框
     * @param context 上下文
     * @param titleId 标题ID
     * @param messageId 消息ID
     */
    public static void showAlertDialog(Context context, int titleId, int messageId, DialogInterface.OnClickListener postivelistener, boolean isconfim) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setMessage(messageId);
        builder.setPositiveButton(R.string.confirm, postivelistener);
        builder.setCancelable(true);
        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    /**
     * 显示弹出对话框
     * @param context 上下文
     * @param titleId 标题ID
     * @param view 内嵌布局
     * @param negativeListener 取消监听器
     * @param positiveListener 确认监听器
     */
    public static void showAlertDialog(Context context, int titleId, View view,
                                       DialogInterface.OnClickListener negativeListener, DialogInterface.OnClickListener positiveListener) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(titleId);
        builder.setView(view);
        builder.setNegativeButton(R.string.cancel, negativeListener);
        builder.setPositiveButton(R.string.confirm, positiveListener);
        builder.setCancelable(true);
        builder.create().show();
    }

    /**
     * 显示等待框
     * @param context 上下文
     */
    public static void showWaitingDialog(Context context) {
        if (sProgress == null) {
            sProgress = new Dialog(context, R.style.LoadingDialog);
        }
        sProgress.setContentView(R.layout.progress);
        sProgress.setCancelable(false);
        sProgress.setOnCancelListener(null);

        Window dialogWindow = sProgress.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.dimAmount = 0.2f;

        dialogWindow.getAttributes().gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
        sProgress.show();
    }

    /**
     * 隐藏等待框
     */
    public static void dismissWaitingDialog() {
        if (sProgress != null) {
            sProgress.dismiss();
            sProgress = null;
        }
    }

    public static void showDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, onDateSetListener, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public static void showTimePickerDialog(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = null;
        timePickerDialog = new TimePickerDialog(context, onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY) ,calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    public static void hideAlertDialog() {
        if (mAlertDialog != null) {
            mAlertDialog.dismiss();
            mAlertDialog = null;
        }
    }

}
