package com.udsfgecw.ktusyllabus;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SubjectTabs extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public Preference preference;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_tabs);

        preference=new Preference(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(preference.getSem().toUpperCase()+" "+preference.getBranch().toUpperCase());
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout= (TabLayout) findViewById(R.id.tablayout);

        tabLayout.setupWithViewPager(mViewPager);


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
                startActivity(new Intent(SubjectTabs.this,AboutApp.class));
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return false;
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(String syllabus) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString("syllabus", syllabus);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_subject_tabs, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getArguments().getString("syllabus"));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        ArrayList<String> subjectlist =new ArrayList<>();
        String line = "notSetProperly";

        String subjects;




        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

            if(preference.getSem()!=null)
            if(preference.getSem().equalsIgnoreCase("firstYear")){
                subjects = preference.getOpt()+"/"+preference.getSem()+".txt";//Sem.dir+Sem.sem+"/"+subjectlist.get(position);
            }
            else{
                subjects=preference.getOpt()+"/"+preference.getBranch()+"/"+preference.getSem()+".txt";
            }


            try {
                InputStream ips = getAssets().open(subjects);
                BufferedReader buffer = new BufferedReader(new InputStreamReader(
                        ips));
                // String line="NiL";

                do {
                    line = buffer.readLine();
                    subjectlist.add(line);

                } while (line != null);

            } catch (Exception e) {

                e.getMessage();
            }
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).


            String syllabus="";
            String text = "empty";

            if(preference.getSem()!=null)
                if(preference.getSem().equalsIgnoreCase("firstYear")){
                    syllabus = readAssetText(preference.getOpt()+"/"+preference.getSem()+"/"+"subject"+(position+1)+".txt");//Sem.dir+Sem.sem+"/"+subjectlist.get(position);
            }
            else{
                syllabus=readAssetText(preference.getOpt()+"/"+preference.getBranch()+"/"+preference.getSem()+"/"+"subject"+(position+1)+".txt");
            }


            return PlaceholderFragment.newInstance(syllabus);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return subjectlist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
                return subjectlist.get(position);
        }

        public String readAssetText(String path){
            AssetManager assetmanager = getAssets();
            InputStream input;
            String out="";

            try {
                input = assetmanager.open(path);
                int size = input.available();
                byte[] buffer = new byte[size];
                input.read(buffer);
                input.close();
                out = new String(buffer);
            }

            catch (Exception e) {
                // TODO: handle exception;
                e.printStackTrace();

            }
            return out;
        }
    }
}
