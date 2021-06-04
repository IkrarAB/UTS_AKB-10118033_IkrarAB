/*
 * Tanggal Pengerjaan : Selasa, 01 Juni 2021
 * Nama               : Ikrar Anugrah Bastary
 * NIM                : 10118033
 * Kelas              : IF-1/S1/VI
 *
 */

package com.ikrarab.myselfapps;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.constraintlayout.widget.ConstraintLayout;
    import androidx.core.view.GravityCompat;
    import androidx.drawerlayout.widget.DrawerLayout;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;
    import androidx.recyclerview.widget.StaggeredGridLayoutManager;

    import android.app.Dialog;
    import android.content.Intent;
    import android.graphics.drawable.Drawable;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.MediaController;
    import android.widget.RelativeLayout;
    import android.widget.Toast;
    import android.widget.VideoView;

    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.LocationSource;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.SupportMapFragment;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.MarkerOptions;
    import com.google.android.material.appbar.MaterialToolbar;
    import com.google.android.material.navigation.NavigationView;
    import com.ikrarab.myselfapps.daily.Daily;
    import com.ikrarab.myselfapps.daily.Daily_Adapter;
    import com.ikrarab.myselfapps.daily.Daily_Data;
    import com.ikrarab.myselfapps.gallery.Gallery_Adapter;
    import com.ikrarab.myselfapps.gallery.Gallery_Item;
    import com.ikrarab.myselfapps.music.Music_Adapter;
    import com.ikrarab.myselfapps.music.Music_Data;
    import com.ikrarab.myselfapps.music.Music_Item;

    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;

    public class Menu extends AppCompatActivity implements OnMapReadyCallback {

        GoogleMap gMap;
        private RecyclerView rvFrd,rvDa,rvGa,rvMsc;
        private ArrayList<Friends> frd = new ArrayList<>();
        private ArrayList<Daily> dai = new ArrayList<>();
        private ArrayList<Music_Item> msc = new ArrayList<>();

        LinearLayout home,daily,mv,profile;
        ImageView facebook,instagram,twitter,info;
        ConstraintLayout gallery;
        MaterialToolbar title;
        VideoView videoView;
        Dialog dialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            facebook = findViewById(R.id.fb);
            instagram = findViewById(R.id.ig);
            twitter = findViewById(R.id.twt);
            info = findViewById(R.id.info);

            dialog = new Dialog(this);
            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDialog();
                }
            });

            SupportMapFragment supportMapFragment = (SupportMapFragment)
                    getSupportFragmentManager().findFragmentById(R.id.gmaps);
            supportMapFragment.getMapAsync(this);

            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToLink("https://facebook.com/ikrar.anugrahb");
                }
            });

            instagram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToLink("https://instagram.com/i_krar");
                }
            });

            twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToLink("https://twitter.com/ikrar_ab");
                }
            });

            MaterialToolbar toolbar = findViewById(R.id.topAppbar);
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });

            navigationView.getMenu().getItem(0).setChecked(true);

            home = findViewById(R.id.home_layout);
            daily = findViewById(R.id.daily_layout);
            gallery = findViewById(R.id.gallery_layout);
            mv = findViewById(R.id.mv_layout);
            profile = findViewById(R.id.profile_layout);
            title = findViewById(R.id.topAppbar);

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    switch (id){
                        case R.id.nav_home:
                            home.setVisibility(View.VISIBLE);
                            daily.setVisibility(View.GONE);
                            gallery.setVisibility(View.GONE);
                            mv.setVisibility(View.GONE);
                            profile.setVisibility(View.GONE);
                            title.setTitle("Home");
                            break;

                        case R.id.nav_daily:
                            home.setVisibility(View.GONE);
                            daily.setVisibility(View.VISIBLE);
                            gallery.setVisibility(View.GONE);
                            mv.setVisibility(View.GONE);
                            profile.setVisibility(View.GONE);
                            title.setTitle("Daily Activity");
                            break;

                        case R.id.nav_gallery:
                            home.setVisibility(View.GONE);
                            daily.setVisibility(View.GONE);
                            gallery.setVisibility(View.VISIBLE);
                            mv.setVisibility(View.GONE);
                            profile.setVisibility(View.GONE);
                            title.setTitle("Gallery");
                            break;

                        case R.id.nav_musicvid:
                            home.setVisibility(View.GONE);
                            daily.setVisibility(View.GONE);
                            gallery.setVisibility(View.GONE);
                            mv.setVisibility(View.VISIBLE);
                            profile.setVisibility(View.GONE);
                            title.setTitle("Music Video");
                            break;

                        case R.id.nav_profile:
                            home.setVisibility(View.GONE);
                            daily.setVisibility(View.GONE);
                            gallery.setVisibility(View.GONE);
                            mv.setVisibility(View.GONE);
                            profile.setVisibility(View.VISIBLE);
                            title.setTitle("Profile");
                            break;

                        default:
                            return true;
                    }
                    return true;
                }

            });

            rvFrd = findViewById(R.id.rvFrd);
            rvFrd.setHasFixedSize(true);
            frd.addAll(Friends_Data.getListData());
            showFriendlist();

            rvDa = findViewById(R.id.rvDa);
            rvDa.setHasFixedSize(true);
            dai.addAll(Daily_Data.getListData());
            showDailyList();

            rvMsc = findViewById(R.id.rvMsc);
            rvMsc.setHasFixedSize(true);;
            msc.addAll(Music_Data.getListData());
            showMusicList();

            rvGa = findViewById(R.id.rvGa);
            rvGa.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

            //List
            List<Gallery_Item> gallery_items = new ArrayList<>();
            gallery_items.add(new Gallery_Item(R.drawable.foto1));
            gallery_items.add(new Gallery_Item(R.drawable.foto2));
            gallery_items.add(new Gallery_Item(R.drawable.foto3));
            gallery_items.add(new Gallery_Item(R.drawable.foto4));
            gallery_items.add(new Gallery_Item(R.drawable.foto5));
            gallery_items.add(new Gallery_Item(R.drawable.foto6));
            gallery_items.add(new Gallery_Item(R.drawable.foto7));
            gallery_items.add(new Gallery_Item(R.drawable.foto8));

            rvGa.setAdapter(new Gallery_Adapter(gallery_items));

            videoView = findViewById(R.id.video1);
            MediaController mediaController = new MediaController(this);
            mediaController.setMediaPlayer(videoView);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vid1));
            videoView.start();

        }

        private void openDialog() {
            dialog.setContentView(R.layout.dialog_info);
            dialog.getWindow();
            dialog.show();
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            gMap = googleMap;

            LatLng home = new LatLng(-6.924146, 107.731214);
            gMap.addMarker(new MarkerOptions().position(home).title("Ikrar's Home"));
            gMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        }

        private void goToLink(String s) {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }

        private void showFriendlist(){
            rvFrd.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            Friendlist_Adapter flAdapter = new Friendlist_Adapter(frd);
            rvFrd.setAdapter(flAdapter);
        }

        private void showDailyList(){
            rvDa.setLayoutManager(new LinearLayoutManager(this));
            Daily_Adapter daiAdapter = new Daily_Adapter(dai);
            rvDa.setAdapter(daiAdapter);
        }

        private void showMusicList(){
            rvMsc.setLayoutManager(new LinearLayoutManager(this));
            Music_Adapter mscAdapter = new Music_Adapter(msc);
            rvMsc.setAdapter(mscAdapter);
        }

    }