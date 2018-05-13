package com.udsfgecw.ktusyllabus;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by AFLAH on 4/26/2018.
 */

public class Preference {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    
    String sub;
    String branch;
    String sem;
    String year;
    
    String opt;
    
    int optId;
    int branchId;
    int semId;

    public Preference(Context context) {
        this.context = context;
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
    }

    public String getSub() {
        sub=sharedPreferences.getString("sub","");
        return sub;
    }

    public void setSub(String sub) {
        editor.putString("sub",sub);
        editor.apply();
        editor.commit();
        this.sub = sub;
    }

    public String getOpt() {
        opt=sharedPreferences.getString("opt","");
        return opt;
    }

    public void setOpt(String opt) {
        editor.putString("opt",opt);
        editor.apply();
        editor.commit();
        this.opt= opt;
    }

    public String getBranch() {
        branch=sharedPreferences.getString("branch","");
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
        editor.putString("branch",branch);
        editor.apply();
        editor.commit();
    }

    public String getSem() {
        sem=sharedPreferences.getString("sem","");
        return sem;
    }

    public void setSem(String sem) {
        editor.putString("sem",sem);
        editor.apply();
        editor.commit();
        this.sem = sem;
    }

    public String getYear() {
        year=sharedPreferences.getString("year","");
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        editor.putString("year",year);
        editor.apply();
        editor.commit();
    }

    public int getOptId() {
        optId=sharedPreferences.getInt("optId",R.id.bsyl);
        return optId;
    }

    public void setOptId(int optId) {
        editor.putInt("optId",optId);
        editor.apply();
        editor.commit();
        this.optId= optId;
    }

    public int getBranchId() {
        branchId=sharedPreferences.getInt("branchId",R.id.bece);
        return branchId;
    }

    public void setBranchId(int branchId) {
        editor.putInt("branchId",branchId);
        editor.apply();
        editor.commit();
        this.branchId= branchId;
    }

    public int getSemId() {
        semId=sharedPreferences.getInt("semId",R.id.b12);
        return semId;
    }

    public void setSemId(int semId) {
        editor.putInt("semId",semId);
        editor.apply();
        editor.commit();
        this.semId= semId;
    }
}
