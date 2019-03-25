package com.example.runma;

public class GameMethod {

    public static String getString(Integer location){
        StringBuilder sb = new StringBuilder("                     ");
        return (sb.replace(sb.length()-location-1,sb.length()-location,"\uD83D\uDC34").toString());
    }
}
