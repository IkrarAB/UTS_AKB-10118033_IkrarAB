/*
 * Tanggal Pengerjaan : Selasa, 01 Juni 2021
 * Nama               : Ikrar Anugrah Bastary
 * NIM                : 10118033
 * Kelas              : IF-1/S1/VI
 *
 */

package com.ikrarab.myselfapps;

import java.util.ArrayList;

public class Friends_Data {
    private static String[] data_nama={
            "Azis Komara",
            "Lingga Purnama Al Hamdi",
            "Rifian Joe Premilenio"
    };

    private static String[] data_username={
            "@azira16",
            "@lingga05",
            "@mightyfulan"
    };

    private static int[] data_img={
            R.drawable.azis,
            R.drawable.lingga,
            R.drawable.om
    };

     static ArrayList<Friends> getListData(){
        ArrayList<Friends> list = new ArrayList<>();
        for (int position = 0; position<data_nama.length; position++){
            Friends friends = new Friends();
            friends.setNama(data_nama[position]);
            friends.setUsername(data_username[position]);
            friends.setFoto(data_img[position]);
            list.add(friends);
        }
        return list;
    }

}
