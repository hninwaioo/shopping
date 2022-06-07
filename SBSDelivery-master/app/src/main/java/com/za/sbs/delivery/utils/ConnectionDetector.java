package com.za.sbs.delivery.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionDetector {

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity != null) {
            NetworkInfo activeNetworkInfo = connectivity.getActiveNetworkInfo();

            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static void isNetworkAvailable(final Activity context, final ConnectionListener listener){
        new CheckConnectionTask(context, listener).execute();
    }

    private static boolean isInternetAvailable() {
        try {
            Socket sock = new Socket();
            sock.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
            sock.close();
            return true;
        } catch (IOException e) { return false; }
//        Runtime runtime = Runtime.getRuntime();
//        try {
//            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
//            int     exitValue = ipProcess.waitFor();
//            return (exitValue == 0);
//        }
//        catch (IOException e)          { e.printStackTrace(); }
//        catch (InterruptedException e) { e.printStackTrace(); }
//
//        return false;
    }

    private static class CheckConnectionTask extends AsyncTask<Void, Void, Boolean> {

        private Activity activity;

        private ConnectionListener listener;

        public CheckConnectionTask(Activity activity, ConnectionListener listener) {
            this.activity = activity;
            this.listener = listener;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            ConnectivityManager connectivity = (ConnectivityManager) activity
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connectivity != null) {
                NetworkInfo activeNetworkInfo = connectivity.getActiveNetworkInfo();

                return activeNetworkInfo != null && activeNetworkInfo.isConnected()
                        && isInternetAvailable();
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean isConnected) {
            super.onPostExecute(isConnected);
            if (isConnected) {
                listener.onConnected();
            } else {
                listener.onDisconnected();
            }
        }
    }

    public interface ConnectionListener {
        void onConnected();

        void onDisconnected();
    }
}
