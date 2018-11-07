package com.example.administrator.sendingpicdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/11/7.
 */

public class SendingDialog extends Dialog{
    private String msg;//要显示的内容
    private Context context;
    private AnimationDrawable animationDrawable;
    public SendingDialog(@NonNull Context context) {
        super(context);
    }
    public SendingDialog(@NonNull Context context,String msg) {
        super(context);
        this.msg = msg;
        this.context = context;
    }

    public SendingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected SendingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDialog();
    }

    private void initDialog() {
        setCancelable(false);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pop_sending, null);
        setContentView(view);
        TextView tvMsg = (TextView) view.findViewById(R.id.onLoad_tv);
        ImageView ivAnim = (ImageView) view.findViewById(R.id.pro_iv);
        tvMsg.setText(msg);
        setXmlFrameAnim(ivAnim);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }
    private void setXmlFrameAnim(ImageView iv) {
        animationDrawable = (AnimationDrawable) iv.getDrawable();
        animationDrawable.start();
    }
}
