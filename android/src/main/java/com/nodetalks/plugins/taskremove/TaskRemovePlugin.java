package com.nodetalks.plugins.taskremove;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.os.Build;
import android.content.Intent;
import android.content.Context;
import com.getcapacitor.Bridge;
import android.util.Log;

@CapacitorPlugin(name = "TaskRemove")
public class TaskRemovePlugin extends Plugin {

    private TaskRemove implementation = new TaskRemove();

    @Override
    public void load() {
        super.load();
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent serviceIntent = new Intent(getContext(),TRServiceOreo.class);
            getContext().startForegroundService(serviceIntent);
        } else {
            Intent serviceIntent = new Intent(getContext(),TRService.class);
            getContext().startService(serviceIntent);
        }

    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
