package com.mariofeles.appmaterialdesign.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mario Feles Dos Santos Junior on 10/09/15.
 */
public class MyBroadcastReceived extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Teste BroadCastReceiver modo Avião Selecionado",Toast.LENGTH_LONG).show();
    }
}
