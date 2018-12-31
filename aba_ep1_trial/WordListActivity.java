package com.example.a9011_20.aba_ep1_trial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a9011_20.aba_ep1_trial.adapter.FragmentWithPagerAdapter;
import com.example.a9011_20.aba_ep1_trial.adapter.WordListAdapter;
import com.example.a9011_20.aba_ep1_trial.fragment.ConsonantsFragment;
import com.example.a9011_20.aba_ep1_trial.fragment.SupportsFragment;
import com.example.a9011_20.aba_ep1_trial.fragment.VowelsFragment;
import com.example.a9011_20.aba_ep1_trial.sql.SQLiteHelper;

import java.util.ArrayList;

public class WordListActivity extends AppCompatActivity {

    TabLayout wordListTabLayout;
    ViewPager wordListViewPager;

    ArrayList<Word> chooseList;
    WordParser parser;

    int startPosition = -1;
    int wordPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        bind();

        setTabWithPager();

        parser = new WordParser(new SQLiteHelper(this).readData());

    }




    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if(intent.getExtras()!=null){

            char data = intent.getCharExtra("choice",' ');

            settingForStart(data);

        }

    }


    public void settingForStart(final char data){

        View settingView = LayoutInflater.from(this).inflate(R.layout.choice_dialog,null);
        ListView lvPosition = settingView.findViewById(R.id.lv_position_list);
        final ListView lvWord = settingView.findViewById(R.id.lv_word_list);
        lvPosition.setSelector(R.color.selector);

        Button btn = settingView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(startPosition==-1){
                    Toast.makeText(WordListActivity.this, "글자의 위치를 선택해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                new AlertDialog.Builder(WordListActivity.this).setTitle("시작하기").setMessage("시작할까요?")
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String good = "";
                                for(Word word : chooseList){

                                    good += word.getData()+":"+word.isEnable()+"\n";


                                }

                                Toast.makeText(WordListActivity.this,good, Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();

            }
        });

        ArrayList<String> list = new ArrayList<>();
        list.add("처음");
        list.add("중간");
        list.add("끝");



        lvPosition.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list));

        lvPosition.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startPosition = position;
                wordPosition = wordListTabLayout.getSelectedTabPosition();

//                Toast.makeText(WordListActivity.this, data+":"+startPosition+":"+wordPosition, Toast.LENGTH_SHORT).show();

                chooseList = parser.wordSet(data,startPosition,wordPosition);

                lvWord.setAdapter(new WordListAdapter(chooseList,WordListActivity.this));



            }
        });

        new AlertDialog.Builder(this).setView(settingView).create().show();

    }



















    ////////////////////////////////////////////// 이 아래는 findViewById 의 서식지입니다./////////////////////////////////////////////////////


    public void bind(){

        wordListTabLayout = findViewById(R.id.word_list_tab);
        wordListViewPager = findViewById(R.id.word_list_pager);


    }

    ////////////////////////////////////////////////// 이 아래는 Adapter 연결의 공간입니다.//////////////////////////////////////////////////

    public void setTabWithPager(){

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();

        fragmentList.add(new ConsonantsFragment());
        fragmentList.add(new VowelsFragment());
        fragmentList.add(new SupportsFragment());

        titleList.add("자음");
        titleList.add("모음");
        titleList.add("받침");

        wordListViewPager.setAdapter(new FragmentWithPagerAdapter(getSupportFragmentManager(),fragmentList,titleList));
        wordListTabLayout.setupWithViewPager(wordListViewPager);

    }


}
