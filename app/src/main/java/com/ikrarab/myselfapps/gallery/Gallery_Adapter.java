/*
 * Tanggal Pengerjaan : Selasa, 01 Juni 2021
 * Nama               : Ikrar Anugrah Bastary
 * NIM                : 10118033
 * Kelas              : IF-1/S1/VI
 *
 */

package com.ikrarab.myselfapps.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ikrarab.myselfapps.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;


public class Gallery_Adapter extends RecyclerView.Adapter<Gallery_Adapter.GalleryViewHolder> {

    private List<Gallery_Item> gallery_items;

    public Gallery_Adapter(List<Gallery_Item> gallery_items){
        this.gallery_items = gallery_items;
    }

    @NonNull
    @Override
    public Gallery_Adapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull Gallery_Adapter.GalleryViewHolder holder, int position) {
        holder.setPostImage(gallery_items.get(position));
    }

    @Override
    public int getItemCount() {
        return gallery_items.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView imageView;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.galleryItemLayout);
        }

        void setPostImage(Gallery_Item gallery_item){
            imageView.setImageResource(gallery_item.getImage());
        }
    }
}
