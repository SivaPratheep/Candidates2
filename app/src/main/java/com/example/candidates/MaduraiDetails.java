package com.example.candidates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MaduraiDetails extends AppCompatActivity {


    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNUmber;
    private TextView email;
    private TextView place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madurai_details);

        setupUIViews();
        initToolbar();
        setupDetails();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.toolBarMaduraiDetails);
        facultyImage = (CircleImageView)findViewById(R.id.ivMadurai);
        facultyName = (TextView)findViewById(R.id.tvMaduraiSelName);
        phoneNUmber = (TextView)findViewById(R.id.tvPhoneNumber);
        email = (TextView)findViewById(R.id.tvEmaiId);
        place = (TextView)findViewById(R.id.tvStaffRoom);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Candidate Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupDetails(){
        int facultyPos = MaduraiActivity.sharedPreferences.getInt(MaduraiActivity.SEL_FACULTY,0);
        String[] facultyNames = getResources().getStringArray(R.array.Madurai);
        int[] facultyImages = new int[]{R.drawable.nkatesan , R.drawable.athyan,R.drawable.adurai};
        int[] facultyArray = new int[] {R.array.Venkatesan,R.array.Sathyan,R.array.Annadurai};
        String[] facultyDetails = getResources().getStringArray(facultyArray[facultyPos]);
        phoneNUmber.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        place.setText(facultyDetails[2]);
        facultyImage.setImageResource(facultyImages[facultyPos]);
        facultyName.setText(facultyNames[facultyPos]);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
