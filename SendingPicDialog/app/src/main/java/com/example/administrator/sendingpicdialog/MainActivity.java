package com.example.administrator.sendingpicdialog;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView send;
    private SendingDialog dialog;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                if(dialog.isShowing()){
                    dialog.dismiss();
                    send.setText("图片发送成功");
                }
            }else{
                dialog.dismiss();
                send.setText("图片发送失败");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (TextView) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new SendingDialog(MainActivity.this,"图片消息发送中");
                dialog.show();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(3000);
                            handler.sendEmptyMessage(0);
                        } catch (Exception e) {
                            handler.sendEmptyMessage(1);
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
