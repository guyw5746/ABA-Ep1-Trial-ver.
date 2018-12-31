package com.example.a9011_20.aba_ep1_trial.adapter;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a9011_20.aba_ep1_trial.MainActivity;
import com.example.a9011_20.aba_ep1_trial.R;
import com.example.a9011_20.aba_ep1_trial.WordListActivity;

import java.util.ArrayList;

public class WordChoiceAdapter extends BaseAdapter {

    ArrayList<Character> charList;
    Context context;

    public WordChoiceAdapter(ArrayList<Character> charList, Context context) {
        this.charList = charList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return charList.size();
    }

    @Override
    public Object getItem(int position) {
        return charList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.word_choice_item,null);
        }

        Button btnChar = convertView.findViewById(R.id.btn_char);
        btnChar.setText(String.valueOf(charList.get(position)));

        btnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(context, "["+charList.get(position)+"] 이 눌렸습니다.", Toast.LENGTH_SHORT).show();

                context.startActivity(new Intent(context, WordListActivity.class).putExtra("choice",charList.get(position)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP));

            }
        });

        return convertView;
    }
}
