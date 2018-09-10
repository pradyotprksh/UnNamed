package com.project.pradyotprakash.unnamed;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ncorti.slidetoact.SlideToActView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.sdsmdg.tastytoast.TastyToast;
import com.shawnlin.numberpicker.NumberPicker;

import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;

public class AccountSettings extends AppCompatActivity {
    private ImageButton locationButton;
    private MaterialEditText locationText;
    private SlideToActView submitSlide;
    private RadioRealButton genderMaleOption, genderFemaleOption;
    private RadioRealButtonGroup genderOption;
    private String genderString = null;
    private MaterialEditText nameText, usernameText, phoneText, alternatePhoneText, alternateEmailText;
    private NumberPicker agePicker;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        genderOption = findViewById(R.id.genderOption);
        genderMaleOption = findViewById(R.id.genderMaleOption);
        genderFemaleOption = findViewById(R.id.genderFemaleOption);
        genderOption.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                if (position == 0) {
                    genderString = "male";
                } else {
                    genderString = "female";
                }
            }
        });
        nameText = findViewById(R.id.nameText);
        usernameText = findViewById(R.id.usernameText);
        locationButton = findViewById(R.id.locationButton);
        locationText = findViewById(R.id.locationText);
        agePicker = findViewById(R.id.agePicker);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(AccountSettings.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(AccountSettings.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
                    } else {
                    }
                } else {
                }
            }
        });
        phoneText = findViewById(R.id.phoneText);
        alternatePhoneText = findViewById(R.id.alternativePhoneText);
        alternateEmailText = findViewById(R.id.alternateEmailText);
        submitSlide = findViewById(R.id.submit_slide);
        submitSlide.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                if (genderString == null || genderString.isEmpty()) {
                    TastyToast.makeText(getApplicationContext(), "Choose your Gender", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    submitSlide.resetSlider();
                } else if (TextUtils.isEmpty(nameText.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Enter Name", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    submitSlide.resetSlider();
                } else if (TextUtils.isEmpty(usernameText.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Enter Username", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    submitSlide.resetSlider();
                } else if (usernameText.getText().length() < 5) {
                    TastyToast.makeText(getApplicationContext(), "Enter Username of length greater than or equal to 5", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    submitSlide.resetSlider();
                } else if (usernameText.getText().length() > 15) {
                    TastyToast.makeText(getApplicationContext(), "Enter Username of length less than or equal to 15", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    submitSlide.resetSlider();
                } else if (TextUtils.isEmpty(locationText.getText())) {
                    TastyToast.makeText(getApplicationContext(), "Enter Location", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    submitSlide.resetSlider();
                } else {
                    Toast.makeText(AccountSettings.this, "Gender: " + genderString, Toast.LENGTH_SHORT).show();
                    Toast.makeText(AccountSettings.this, "Name: " + nameText.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AccountSettings.this, "Username: " + usernameText.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AccountSettings.this, "Location: " + locationText.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(AccountSettings.this, "Age: " + agePicker.getValue(), Toast.LENGTH_SHORT).show();
                    if (TextUtils.isEmpty(phoneText.getText())) {
                        Toast.makeText(AccountSettings.this, "Phone Number Not Given", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AccountSettings.this, "Phone Number: " + phoneText.getText(), Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(alternatePhoneText.getText())) {
                        Toast.makeText(AccountSettings.this, "Alternate Phone Number Not Given", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AccountSettings.this, "Alternate Phone Number: " + alternatePhoneText.getText(), Toast.LENGTH_SHORT).show();
                    }
                    if (TextUtils.isEmpty(alternateEmailText.getText())) {
                        Toast.makeText(AccountSettings.this, "Alternate EmailId Not Given", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AccountSettings.this, "Alternate EmailId: " + alternateEmailText.getText(), Toast.LENGTH_SHORT).show();
                    }
                    submitSlide.setOuterColor(Color.rgb(0, 255, 0));
                    TastyToast.makeText(getApplicationContext(), "Submitted", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                }
            }
        });
    }
}
