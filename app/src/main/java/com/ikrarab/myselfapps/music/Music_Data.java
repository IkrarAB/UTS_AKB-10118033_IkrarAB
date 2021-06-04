/*
 * Tanggal Pengerjaan : Selasa, 01 Juni 2021
 * Nama               : Ikrar Anugrah Bastary
 * NIM                : 10118033
 * Kelas              : IF-1/S1/VI
 *
 */

package com.ikrarab.myselfapps.music;

import java.util.ArrayList;

public class Music_Data {
    private static String[] data_musik = {
            "BMTH - Shadow Moses",
            "A7X - Dear God",
            "Linkin Park - Numb",
            "EMINEM - Godzilla",
            "Bloc Party - Helicopter",
            "Martin Garrix - Animals",
            "Marshmello - Alone"
    };

    public static ArrayList<Music_Item> getListData() {
        ArrayList<Music_Item> list = new ArrayList<>();
        for (int position = 0; position <data_musik.length; position++) {
            Music_Item musicItem = new Music_Item();
            musicItem.setMusicList(data_musik[position]);
            list.add(musicItem);
        }
        return list;
    }
}