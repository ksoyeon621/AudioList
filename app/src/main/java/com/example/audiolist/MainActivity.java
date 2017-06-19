package com.example.audiolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView music_List;
    Button playBut, stopBut, pauseBut;
    TextView textMusic;
    ProgressBar progress;
    String[] musics={"Never","Santa tell me"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music_List=(ListView)findViewById(R.id.music_List);
        playBut=(Button)findViewById(R.id.play);
        stopBut=(Button)findViewById(R.id.stop);
        pauseBut=(Button)findViewById(R.id.pause);
        textMusic=(TextView)findViewById(R.id.text_Music);
        progress=(ProgressBar)findViewById(R.id.progressMusic);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,/*모양을 결정한다.*/android.R.layout.simple_list_item_single_choice,/*ArrayList사용가능.*/musics);
        music_List.setAdapter(adapter);
        music_List.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//여러개 중에 하나만 선택 가능
        music_List.setItemChecked(0,true/*라디오가 선택된 상태*/);
    }
}
