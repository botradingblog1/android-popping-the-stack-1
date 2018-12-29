package com.justmobiledev.androidpoppingstack1.broadcast_receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PopStackReceiver extends BroadcastReceiver {

    public final static String POP_STACK_BR_ACTION = "com.justmobiledev.androidpoppingstack1.POP_THE_STACK";

    public ICallback callback;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("cxs","onReceive");
        if (callback != null)
            callback.onReceive();
    }

    public void setCallback(ICallback callback){
        this.callback = callback;
    }

    public interface ICallback{
        void onReceive();
    }
}
