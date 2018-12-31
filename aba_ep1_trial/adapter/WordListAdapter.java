package com.example.a9011_20.aba_ep1_trial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.a9011_20.aba_ep1_trial.R;
import com.example.a9011_20.aba_ep1_trial.Word;

import java.util.ArrayList;

public class WordListAdapter extends BaseAdapter {

    ArrayList<Word> list;
    Context context;

    public WordListAdapter(ArrayList<Word> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.word_list_item,null);

        TextView tvWord = convertView.findViewById(R.id.tv_word);
        CheckBox checkBox = convertView.findViewById(R.id.cb_list);

        tvWord.setText(list.get(position).getData());
        checkBox.setChecked(list.get(position).isEnable());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(!isChecked){
                    list.get(position).setEnable(false);
                }else{
                    list.get(position).setEnable(true);
                }


            }
        });



        return convertView;
    }
}
