package com.example.a9011_20.aba_ep1_trial;

import android.os.Parcel;
import android.os.Parcelable;

public class Word implements Parcelable {

    String data;
    String imageUrl;
    boolean enable;
    boolean isInput;

    public Word(String data) {
        this.data = data;
        this.imageUrl = null;
        this.enable = true;
        this.isInput = false;
    }

    public Word(String data, String imageUrl) {
        this.data = data;
        this.imageUrl = imageUrl;
        this.enable = true;
        this.isInput = false;
    }

    protected Word(Parcel in) {
        data = in.readString();
        imageUrl = in.readString();
        enable = in.readByte() != 0;
        isInput = in.readByte() != 0;
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isInput() {
        return isInput;
    }

    public void setInput(boolean input) {
        isInput = input;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(data);
        dest.writeString(imageUrl);
        dest.writeByte((byte) (enable ? 1 : 0));
        dest.writeByte((byte) (isInput ? 1 : 0));
    }
}
