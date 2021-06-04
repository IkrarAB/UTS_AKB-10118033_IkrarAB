/*
 * Tanggal Pengerjaan : Selasa, 01 Juni 2021
 * Nama               : Ikrar Anugrah Bastary
 * NIM                : 10118033
 * Kelas              : IF-1/S1/VI
 *
 */

package com.ikrarab.myselfapps.daily;

import java.util.ArrayList;

public class Daily_Data {
    private static String[] data_kegiatan = {
            "Bangun Tidur",
            "Mandi",
            "Makan",
            "Kuliah",
            "Makan Siang",
            "Mabar",
            "Shalat",
            "Tidur"
    };

    public static ArrayList<Daily> getListData() {
        ArrayList<Daily> list = new ArrayList<>();
        for (int position = 0; position < data_kegiatan.length; position++) {
            Daily daily = new Daily();
            daily.setKegiatan(data_kegiatan[position]);
            list.add(daily);
        }
        return list;
    }
}