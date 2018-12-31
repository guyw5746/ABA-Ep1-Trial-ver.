package com.example.a9011_20.aba_ep1_trial.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.a9011_20.aba_ep1_trial.R;
import com.example.a9011_20.aba_ep1_trial.adapter.WordChoiceAdapter;

import java.util.ArrayList;

public class SupportsFragment extends Fragment {

    GridView gridView;
    ArrayList<Character> charList = new ArrayList<>();
    char [] datas = {'ㄱ','ㄲ','ㄳ','ㄴ','ㄵ','ㄶ','ㄷ','ㄹ','ㄺ','ㄻ','ㄼ','ㄽ','ㄾ','ㄿ','ㅀ','ㅁ','ㅂ','ㅄ','ㅅ','ㅆ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(char data:datas){
            charList.add(data);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_supports, container, false);

        gridView = rootView.findViewById(R.id.grid_view);
        gridView.setAdapter(new WordChoiceAdapter(charList,getContext()));

        return rootView;
    }

}
