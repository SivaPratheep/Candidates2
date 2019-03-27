package com.example.candidates;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.candidates.Utils.LetterImageView;
import com.example.candidates.Utils.LetterImageView;

public class MaduraiActivity extends AppCompatActivity {

    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences sharedPreferences;
    public static String SEL_FACULTY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madurai);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.toolBarMadurai);
        listView = (ListView)findViewById(R.id.lvMadurai);
        sharedPreferences = getSharedPreferences("MADURAI",MODE_PRIVATE);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Candidates");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        String[] faculty_name = getResources().getStringArray(R.array.Madurai);

        FacultyAdapter adapter = new FacultyAdapter(this, R.layout.madurai_single_item, faculty_name);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        startActivity(new Intent(MaduraiActivity.this,MaduraiDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY,0).apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(MaduraiActivity.this,MaduraiDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY,1).apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(MaduraiActivity.this,MaduraiDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY,2).apply();
                        break;
                    }
                    default:break;
                }
            }
        });

    }
    public class FacultyAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] Faculty = new String[]{};

        public FacultyAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.Faculty = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView) convertView.findViewById(R.id.ivLetterMadurai);
                holder.tvFaculty = (TextView)convertView.findViewById(R.id.tvCandidateName);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(Faculty[position].charAt(0));
            holder.tvFaculty.setText(Faculty[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvFaculty;
        }
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
