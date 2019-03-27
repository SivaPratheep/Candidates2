package com.example.candidates;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class TheniDetails extends AppCompatActivity {


    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNUmber;
    private TextView email;
    private TextView place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theni_details);

        setupUIViews();
        initToolbar();
        setupDetails();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.toolBarTheniDetails);
        facultyImage = (CircleImageView)findViewById(R.id.ivTheni);
        facultyName = (TextView)findViewById(R.id.tvTheniSelName);
        phoneNUmber = (TextView)findViewById(R.id.tvPhoneNumberTheni);
        email = (TextView)findViewById(R.id.tvEmaiIdTheni);
        place = (TextView)findViewById(R.id.tvStaffRoomTheni);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Candidate Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupDetails(){
        int facultyPos = TheniActivity.sharedPreferences.getInt(TheniActivity.SEL_FAC,0);
        String[] facultyNames = getResources().getStringArray(R.array.Theni);
        int[] facultyImages = new int[]{R.drawable.mar , R.drawable.langovan,R.drawable.elvan};
        int[] facultyArray = new int[] {R.array.Kumar,R.array.Elangovan,R.array.Selvan};
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
