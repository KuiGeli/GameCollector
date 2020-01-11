package com.sda.kui.gamecollector.services;

import java.util.List;

public class GeneralService {

    public static <T> String listView(List<T> list) {
        String string = "";
        for (T t : list) {

            System.out.println(t);
            string += t;
            string += ", ";
        }
        return string;
    }


}
