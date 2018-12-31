package com.example.a9011_20.aba_ep1_trial.fragment;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class VowelsFragment extends Fragment {


    GridView gridView;
    ArrayList<Character> charList = new ArrayList<>();
    char [] datas = {'ㅏ','ㅐ','ㅑ','ㅒ','ㅓ','ㅔ','ㅕ','ㅖ','ㅗ','ㅘ','ㅙ','ㅚ','ㅛ','ㅜ','ㅝ','ㅞ','ㅟ','ㅠ','ㅡ','ㅢ','ㅣ'};

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

        View rootView =inflater.inflate(R.layout.fragment_vowels, container, false);

        gridView = rootView.findViewById(R.id.grid_view);
        gridView.setAdapter(new WordChoiceAdapter(charList,getContext()));

        return rootView;
    }
}
