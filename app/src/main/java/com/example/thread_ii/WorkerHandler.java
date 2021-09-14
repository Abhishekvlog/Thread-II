package com.example.thread_ii;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class WorkerHandler extends HandlerThread {
    private Handler mainHandlerThread;

    public WorkerHandler(String name,Handler mainHandlerThread) {
        super(name);
        this.mainHandlerThread = mainHandlerThread;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress =0;
        for (int i =0;i<=10;i++){
            try {
                Thread.sleep(1000);
                progress = progress + 10;
                Message message = Message.obtain();
                message.obj = progress;
                message.what = 1;
                mainHandlerThread.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
