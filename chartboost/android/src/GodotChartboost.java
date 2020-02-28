package org.godotengine.godot;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.util.DisplayMetrics;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.Display;
import java.math.BigDecimal;
import java.io.IOException;
import java.io.File;
import java.util.Currency;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Date;
import java.lang.Exception;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.CBLocation;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Tracking.CBAnalytics;
import com.chartboost.sdk.CBImpressionActivity;

public class GodotChartboost extends Godot.SingletonBase {

    private Godot activity = null;
    private Integer callbackId = 0;

    static public Godot.SingletonBase initialize(Activity p_activity) 
    { 
        return new GodotChartboost(p_activity); 
    } 

    public GodotChartboost(Activity p_activity) 
    {
        registerClass("GodotChartboost", new String[]{
                "init",
            });
        activity = (Godot)p_activity;
    }

    // Public methods

    public void init(final String appId, final String appSignature)
    {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Chartboost.startWithAppId(activity, appId, appSignature);
                } catch (Exception e) {
                    Log.e("godot", "Exception: " + e.getMessage());  
                }
            }
        });
    }

    // Internal methods

    public void callbackSuccess(String ticket, String signature, String sku) {
		//GodotLib.callobject(facebookCallbackId, "purchase_success", new Object[]{ticket, signature, sku});
        //GodotLib.calldeferred(purchaseCallbackId, "consume_fail", new Object[]{});
	}

    @Override protected void onMainActivityResult (int requestCode, int resultCode, Intent data)
    {
    }
}
