package com.example.audiolist;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    int[] musicResIds={R.raw.never,R.raw.santa_tell_me};
    int selectedMusicId;
    MediaPlayer mediaPlayer;
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
        selectedMusicId=musicResIds[0];
        mediaPlayer=MediaPlayer.create(this,selectedMusicId);

        music_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i/*선택된 항목의 인덱스 번호*/, long id) {
                selectedMusicId=musicResIds[i];
            }
        });
        playBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.create(MainActivity.this, selectedMusicId);
                mediaPlayer.start();
            }
        });
        stopBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
        pauseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }
    @Override
    protected void onStop() { //액티비티 중지
        super.onStop();
        mediaPlayer.stop();
    }
}
