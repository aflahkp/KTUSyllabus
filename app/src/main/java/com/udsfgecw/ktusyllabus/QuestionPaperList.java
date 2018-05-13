package com.udsfgecw.ktusyllabus;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

/**
 * Created by AFLAH on 5/5/2018.
 */

public class QuestionPaperList extends AppCompatActivity {

    RecyclerView rv_qps;
    QuestionPapersAdapter adapter;
    List<QuestionPaperModel> list=new ArrayList<>();
    String source_file_path;
    Preference preference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_paper_list);

        preference=new Preference(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(preference.getSem().toUpperCase()+" "+preference.getBranch().toUpperCase());


        rv_qps= (RecyclerView) findViewById(R.id.rv_qps);
        adapter=new QuestionPapersAdapter(this,list);
        rv_qps.setLayoutManager(new LinearLayoutManager(this));
        rv_qps.setAdapter(adapter);


        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);



        if(preference.getSem()=="firstYear"){
            source_file_path = preference.getOpt()+"/"+preference.getSem();//Sem.dir+Sem.sem+"/"+subjectlist.get(position);
        }
        else{
            source_file_path=preference.getOpt()+"/"+preference.getBranch()+"/"+preference.getSem();
        }


        try {
            String line = "notSetProperly";
            InputStream ips = getAssets().open(source_file_path+".txt");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(
                    ips));
            // String line="NiL";

            do {
                line = buffer.readLine();
                if(!TextUtils.isEmpty(line.trim()))
                list.add(new QuestionPaperModel(line,source_file_path+"/"+line+".pdf"));

            } while (line != null);
            adapter.notifyDataSetChanged();

        } catch (Exception e) {

            e.getMessage();
        }

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
                startActivity(new Intent(QuestionPaperList.this,AboutApp.class));
                return true;

            case android.R.id.home:
                onBackPressed();
            return true;
        }

        return false;
    }
}
