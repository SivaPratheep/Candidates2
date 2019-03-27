package com.example.candidates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CoimbatoreDetails extends AppCompatActivity {


    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNUmber;
    private TextView email;
    private TextView place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coimbatore_details);

        setupUIViews();
        initToolbar();
        setupDetails();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.toolBarCovaiDetails);
        facultyImage = (CircleImageView)findViewById(R.id.ivCovai);
        facultyName = (TextView)findViewById(R.id.tvCovaiSelName);
        phoneNUmber = (TextView)findViewById(R.id.tvPhoneNumberCovai);
        email = (TextView)findViewById(R.id.tvEmaiIdCovai);
        place = (TextView)findViewById(R.id.tvStaffRoomCovai);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Candidate Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupDetails(){
        int facultyPos = CoimbatoreActivity.sharedPreferences.getInt(CoimbatoreActivity.SEL_FACU,0);
        String[] facultyNames = getResources().getStringArray(R.array.Coimbatore);
        int[] facultyImages = new int[]{R.drawable.rajan , R.drawable.krishnan,R.drawable.karan};
        int[] facultyArray = new int[] {R.array.Natarajan,R.array.Radhakrishnan,R.array.Appadurai};
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
