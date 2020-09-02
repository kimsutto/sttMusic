package com.kimsutto.sujinmusic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//import static com.kimsutto.sujinmusic.MainActivity.listener;
//import static com.kimsutto.sujinmusic.MainActivity.youtubeView;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent == null) {
            return Service.START_STICKY; //서비스가 종료되어도 자동으로 다시 실행시켜줘!
        } else {
            // intent가 null이 아니다.
            // 액티비티에서 intent를 통해 전달한 내용을 뽑아낸다.(if exists)
            //youtubeView.initialize("AIzaSyDfkcOSP6lv1e3gt3K7xvdgdYlPIZkB2Jw", listener);


        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
