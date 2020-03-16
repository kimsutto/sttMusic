package com.kimsutto.sujinmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //리스트뷰로 내가 원하는 노래 재생목록들 만들어서 정리 .. ->
        //싱스트리트
        //https://youtu.be/LbVM97O1-zs
        //<iframe width="1020" height="574" src="https://www.youtube.com/embed/LbVM97O1-zs" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        //내가 직접 웹을 만들고 거 위에 iframe 위에 추가한다음 웹뷰 띄울까?
        //동숲
        //https://www.youtube.com/watch?v=Cxkmd8YLo3w
        //<iframe width="1020" height="574" src="https://www.youtube.com/embed/Cxkmd8YLo3w" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    }
}
