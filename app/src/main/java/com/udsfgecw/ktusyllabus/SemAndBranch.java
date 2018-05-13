package com.udsfgecw.ktusyllabus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by AFLAH on 4/24/2018.
 */

public class SemAndBranch extends AppCompatActivity implements View.OnClickListener{
    
    String option="syllabus";
    String sem="firstYear";
    String branch="ece";

    int optType =R.id.bsyl;
    int optSem=R.id.b12;
    int optBranch=R.id.bece;
    
    Preference preference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semandbranch);
        
        preference=new Preference(this);

        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);


//        option=preference.getOpt();
//        branch=preference.getBranch();
//        sem=preference.getSem();
        
//        optType=preference.getOptId();
//        optSem =preference.getSemId();
//        optBranch=preference.getBranchId();

        preference.setBranchId(optBranch);
        preference.setSemId(optSem);
        preference.setOptId(optType);

        preference.setOpt(option);
        preference.setBranch(branch);
        preference.setSem(sem);

        try {
            (findViewById(optType)).setActivated(true);
            (findViewById(optSem)).setActivated(true);
            (findViewById(optBranch)).setActivated(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(optType==R.id.bqp){
            (findViewById(R.id.b6)).setVisibility(View.INVISIBLE);
            (findViewById(R.id.b7)).setVisibility(View.INVISIBLE);
            (findViewById(R.id.b8)).setVisibility(View.INVISIBLE);
        }
        else {
            (findViewById(R.id.b6)).setVisibility(View.VISIBLE);
            (findViewById(R.id.b7)).setVisibility(View.VISIBLE);
            (findViewById(R.id.b8)).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();

        if(id==R.id.bsyl||id==R.id.bqp){
            (findViewById(optType)).setActivated(false);
            optType =id;
            preference.setOptId(optType);
            (findViewById(optType)).setActivated(true);

            if(id==R.id.bqp){
                (findViewById(R.id.b6)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.b7)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.b8)).setVisibility(View.INVISIBLE);
            }
            else {
                (findViewById(R.id.b6)).setVisibility(View.VISIBLE);
                (findViewById(R.id.b7)).setVisibility(View.VISIBLE);
                (findViewById(R.id.b8)).setVisibility(View.VISIBLE);
            }
        }



        else if(id==R.id.b12||id==R.id.b3||id==R.id.b4||id==R.id.b5||id==R.id.b6||id==R.id.b7||id==R.id.b8){
            (findViewById(optSem)).setActivated(false);
            optSem=id;
            preference.setSemId(optSem);
            (findViewById(optSem)).setActivated(true);
        }


        else if(id==R.id.bece||id==R.id.bcse||id==R.id.beee||id==R.id.bme){
            (findViewById(optBranch)).setActivated(false);
            optBranch =id;
            preference.setBranchId(optBranch);
            (findViewById(optBranch)).setActivated(true);
        }


        switch (id){

            case R.id.bsyl:
                option="syllabus";
                break;

            case R.id.bqp:
                option="pqp";
                break;
            
            case R.id.b12:
                sem = "firstYear";
                break;

            case R.id.b3:
                sem = "semester3";
                
                break;

            case R.id.b4:
                sem = "semester4";
                
                break;

            case R.id.b5:
                sem = "semester5";
                
                break;

            case R.id.b6:
                sem = "semester6";
                
                break;


            case R.id.b7:
                sem = "semester7";
                
                break;

            case R.id.b8:
                sem = "semester8";
                break;

            case R.id.bece:
                branch="ece";
                break;

            case R.id.bcse:
                branch="cse";
                break;


            case R.id.beee:
                branch="eee";
                break;

            case R.id.bme:
                branch="mech";
                break;

            case R.id.bgo:
                if(preference.getOpt().equalsIgnoreCase("syllabus"))
                startActivity(new Intent(SemAndBranch.this,SubjectTabs.class));
                else startActivity(new Intent(SemAndBranch.this,QuestionPaperList.class));
                break;

//            case R.id.bsyl||id==R.id.bqp
//
//            id==R.id.b12||id==R.id.b3||id==R.id.b4||id==R.id.b5||id==R.id.b6||id==R.id.b7||id==R.id.b8
//
//            id==R.id.bece||id==R.id.bcse||id==R.id.beee||id==R.id.bme
        }

        preference.setSem(sem);
        preference.setBranch(branch);
        preference.setOpt(option);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(SemAndBranch.this,AboutApp.class));
                return true;
        }

        return false;
    }

}
