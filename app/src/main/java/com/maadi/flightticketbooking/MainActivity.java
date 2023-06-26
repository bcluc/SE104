package com.maadi.flightticketbooking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.appizona.yehiahd.fastsave.FastSave;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.glide.slider.library.SliderLayout;
import com.glide.slider.library.animations.DescriptionAnimation;
import com.glide.slider.library.slidertypes.BaseSliderView;
import com.glide.slider.library.slidertypes.TextSliderView;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.maadi.flightticketbooking.activities.AboutUs;
import com.maadi.flightticketbooking.activities.BookingHistory;
import com.maadi.flightticketbooking.activities.ContactUs;
import com.maadi.flightticketbooking.activities.Login;
import com.maadi.flightticketbooking.activities.Profile;
import com.maadi.flightticketbooking.activities.SearchVehical;
import com.maadi.flightticketbooking.models.Banner;
import com.maadi.flightticketbooking.utilities.ECONSTANT;
import com.maadi.flightticketbooking.utilities.MyNetwork;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = ECONSTANT.TAG;
    private CircleImageView userImage;
    private SliderLayout sliderLayout;
    private List<String> imageList;
    private Banner[] banners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        setTitle("Home");
        sliderLayout = findViewById(R.id.slider);
        sliderLayout.setDuration(5000);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        imageList = new ArrayList<>();
        findViewById(R.id.cardAbout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutUs.class));
            }
        });
        findViewById(R.id.cardBookingHis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BookingHistory.class));
            }
        });
        findViewById(R.id.cardContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactUs.class));
            }
        });
        findViewById(R.id.cardSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchVehical.class));
            }
        });
        findViewById(R.id.cardProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Profile.class));
            }
        });
        findViewById(R.id.tv_showNotif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(findViewById(R.id.slider).getVisibility() == View.VISIBLE )
                {
                    findViewById(R.id.slider).setVisibility(View.GONE);
                }
                else if(findViewById(R.id.slider).getVisibility() == View.GONE )
                {
                    findViewById(R.id.slider).setVisibility(View.VISIBLE);
                }
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
        View headerLayout = navigationView.getHeaderView(0);
        userImage = headerLayout.findViewById(R.id.ivNavUser);
        Glide.with(this).load(
                        ECONSTANT.URL_IMG_USER + ECONSTANT.logedUser.getUser_image())
                .into(userImage);
        ((TextView) findViewById(R.id.tv_userName)).setText(ECONSTANT.logedUser.getUser_name());
        ((TextView) headerLayout.findViewById(R.id.tvNavName)).setText(ECONSTANT.logedUser.getUser_name());
        ((TextView) headerLayout.findViewById(R.id.tvNavEmail)).setText(ECONSTANT.logedUser.getUser_email());
        navigationView.inflateMenu(R.menu.menuf);

        getBanner();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        switch (id) {
            case R.id.nav_add:
                startActivity(new Intent(MainActivity.this, SearchVehical.class));
                break;
            case R.id.nav_home:
                break;
            case R.id.nav_booking:
                startActivity(new Intent(MainActivity.this, BookingHistory.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(MainActivity.this, Profile.class));
                break;

            case R.id.nav_logout: {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure...?")
                        .setContentText("Đăng xuất?")
                        .setConfirmButton("Xác nhận đăng xuất", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                                FastSave.getInstance().clearSession();
                                startActivity(new Intent(MainActivity.this, Welcome.class));
                                finish();
                            }
                        })
                        .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                            }
                        }).show();
            }
            break;

        }

        return true;
    }

    private void getBanner() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                    ECONSTANT.URL_GET_BANNER,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.e(TAG, "onResponse: " + response);
                            final Gson gson = new Gson();
                            try {
                                banners = gson.fromJson(String.valueOf(response.getJSONArray("data")), Banner[].class);
                                RequestOptions requestOptions = new RequestOptions();
                                requestOptions.autoClone();
                                for (final Banner banner : banners) {
                                    TextSliderView textSliderView = new TextSliderView(MainActivity.this);
                                    textSliderView
                                            .description("")
                                            .setRequestOption(requestOptions)
                                            .image(ECONSTANT.URL_IMG_BANNERS + banner.getImage())
                                            .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                                                @Override
                                                public void onSliderClick(BaseSliderView slider) {
                                                }
                                            });
                                    sliderLayout.addSlider(textSliderView);
                                }


                            } catch (JSONException e) {
                                Log.e(TAG, "onResponse: " + e.toString());
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "onErrorResponse: " + error.toString());
                }
            });
            MyNetwork.getInstance(this).addToRequestQueue(jsonObjectRequest);
        } catch (Exception e) {
            Log.e(TAG, "getBanner: " + e.toString());
        }
    }
}