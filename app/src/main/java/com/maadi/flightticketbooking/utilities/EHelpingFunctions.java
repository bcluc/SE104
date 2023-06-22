package com.maadi.flightticketbooking.utilities;

import static android.content.Context.WIFI_SERVICE;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class EHelpingFunctions {
    public static AlertDialog builder;
    public static String TAG = ECONSTANT.TAG;

    public static boolean isNetworkConnected(Context context) {
        try {
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
            }
        } catch (Exception ex) {
            Log.e(TAG, "isNetworkConnected: EXP : " + ex.toString());
        }
        return false;
    }


    public static ProgressDialog loadingD;
    public static void showLoading(Context context) {
        loadingD = ProgressDialog.show(context, "",
                "Loading. Please wait...", true);

    }

    public static void stopLoading() {
        loadingD.dismiss();
    }

    public static void loadImage(final Context context, String imageURL, ImageView imageView, final View progressView) {
        try {
            Glide.with(context)
                    .load(imageURL)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressView.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .fitCenter()
                    .into(imageView);
        } catch (Exception ex) {
            Log.e(TAG, "loadImage: EXP : " + context.getClass().getName() + "-->" + ex.toString());
        }
    }

    public static void showError(Context context, String title, String message) {
        try {
            new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(title)
                    .setContentText(message)
                    .show();


        } catch (Exception ex) {
            Log.e(TAG, "showError: " + ex.toString());
        }
    }

    public static String convertTime(long millis) {

        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a dd-MMM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return formatter.format(calendar.getTime());
    }

    public static String getSysIp(Context context){
       try{
           WifiManager wifiMgr = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
           WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
           int ip = wifiInfo.getIpAddress();
           return Formatter.formatIpAddress(ip);
       }
       catch (Exception e){
           Log.e(TAG, "getSysIp: EXP: "+e.toString());
           return null;
       }

    }
}
