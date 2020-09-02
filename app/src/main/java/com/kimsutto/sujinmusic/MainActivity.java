package com.kimsutto.sujinmusic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
/*
public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("MyTag","surfaceCreated");

        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        } else {
            mediaPlayer.reset();
        }

        try {

            String path = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
            mediaPlayer.setDataSource(path);

            //mediaPlayer.setVolume(0, 0); //볼륨 제거
            mediaPlayer.setDisplay(surfaceHolder); // 화면 호출
            mediaPlayer.prepare(); // 비디오 load 준비

            //mediaPlayer.setOnCompletionListener(completionListener); // 비디오 재생 완료 리스너

            mediaPlayer.start();

        } catch (Exception e) {
            Log.e("MyTag","surface view error : " + e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        Log.d("MyTag","surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.e("MyTag","surfaceDestroyed");
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
*/
/*YouTubeBaseActivity

 */
public class MainActivity extends AppCompatActivity {

    //static YouTubePlayerView youtubeView;
    //Button button;
    //static YouTubePlayer.OnInitializedListener listener;

    ArrayList<MusicData> musicDataList;
    private WebView mWebView; // 웹뷰 선언
    private WebSettings mWebSettings; //웹뷰세팅

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MusicAdapter myAdapter = new MusicAdapter(this,musicDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView parent, View v, int position, long id) {

                                                //Intent intent = new Intent(getApplicationContext(), MyService.class); // 실행시키고픈 서비스클래스 이름
                                                //intent.putExtra("url", "https://www.youtube.com/embed/Cxkmd8YLo3w");

                                                //StartService(intent); // 서비스 실행!
                                                // 웹뷰 시작
                                                mWebView = (WebView) findViewById(R.id.webView);

                                                mWebView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
                                                mWebSettings = mWebView.getSettings(); //세부 세팅 등록
                                                mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
                                                mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
                                                mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
                                                mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
                                                mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
                                                mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
                                                mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
                                                mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
                                                mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
                                                mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부

                                                mWebView.loadUrl("file:///android_asset/www/index.html"); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작
                                            }
                                        }
            );
    }
        public void InitializeMovieData()
        {
            musicDataList = new ArrayList<MusicData>();

            musicDataList.add(new MusicData(R.mipmap.ic_launcher, "싱스트리트", "시간 초"));
            musicDataList.add(new MusicData(R.mipmap.ic_launcher, "메이플 OST", "19세 이상관람가"));
            musicDataList.add(new MusicData(R.mipmap.ic_launcher, "동물의숲 OST", "12세 이상관람가"));
        }
    }

        //button = (Button) findViewById(R.id.youtubeButton);
        //youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
/*
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                YouTubePlayer youTubePlayer,
                                                boolean b) {
                youTubePlayer.loadVideo("Cxkmd8YLo3w");
            }
            @Override
            public void onInitializationFailure(
                    YouTubePlayer.Provider provider,
                    YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MyService.class); // 실행시키고픈 서비스클래스 이름
                startService(intent); // 서비스 실행!

                youtubeView.initialize("AIzaSyDfkcOSP6lv1e3gt3K7xvdgdYlPIZkB2Jw", listener);
            }
        });
    }
}
*/






                // onResume과 onPause에 Class.forName("android.webkit.WebView")
                //            .getMethod("onResume", (Class[]) null)
                //            .invoke(webView, (Object[]) null); 넣으면 백그라운드에서 영상이 재생되는 것을 막음



