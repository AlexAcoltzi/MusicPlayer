package com.alexa.repreoductor.Data;

import android.net.Uri;

import com.alexa.repreoductor.ListElement;

import java.util.ArrayList;
import java.util.List;

public class DataFile {

    public List<ListElement> Song(){
        List<ListElement> list = new ArrayList<>();
        for (int i = 0; i <20; i++){
            list.add(i,new ListElement(Uri.EMPTY, "Song ", "SubTitle + "));
        }
        return list;
    }
}
