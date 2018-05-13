package com.udsfgecw.ktusyllabus;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.FileProvider;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;


/**
 * Created by AFLAH on 5/5/2018.
 */

public class QuestionPapersAdapter extends RecyclerView.Adapter<QuestionPapersAdapter.MyViewHolder> {
    Context context;
    List<QuestionPaperModel> list;

    public QuestionPapersAdapter(Context context, List<QuestionPaperModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.question_paper_item_view,null,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.qp_name_textView.setText(list.get(position).qp_name);


        String strDir =context.getExternalCacheDir()+"/.afl";
        File fileDir = new File(strDir);
        final boolean isAvailable;
        final File localFile;
        localFile = new File(fileDir,"/"+list.get(position).qp_name+".pdf");
        isAvailable=localFile.exists();
        if(isAvailable){
            holder.download_button.setVisibility(View.GONE);
        }
        else {
            holder.download_button.setVisibility(View.VISIBLE);

        }

        holder.ll_qp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAvailable) {
                    Uri path = Uri.fromFile(localFile);

/////		Toast.makeText(getApplicationContext(), path.toString(), Toast.LENGTH_LONG).show();
                    //Uri path = Uri.parse(strDir+"/s66.pdf");

                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    Intent nopdf = new Intent(Pdf.this,NOPDF.class);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
//                    copyReadAssets(list.get(position).qp_path, list.get(position).qp_name);

                }
                else {
                    Toast.makeText(context, "File not available offline. Download first.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.download_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.download_button.setVisibility(View.GONE);
                holder.progress.setVisibility(View.VISIBLE);
                new DownloadInBackground().execute(list.get(position).qp_name,list.get(position).qp_path);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView qp_name_textView;
        LinearLayout ll_qp;
        ImageView download_button;
        ProgressBar progress;
        public MyViewHolder(View itemView) {
            super(itemView);
            qp_name_textView= (TextView) itemView.findViewById(R.id.qp_name_textView);
            ll_qp= (LinearLayout) itemView.findViewById(R.id.ll_qp);
            download_button= (ImageView) itemView.findViewById(R.id.download);
            progress=(ProgressBar) itemView.findViewById(R.id.progress);
        }
    }


    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }



    public void copyReadAssets(String filename,String name) {

    File file;
        AssetManager assetManager = context.getAssets();

        InputStream in = null;
        OutputStream out = null;

        //String strDir = Environment
        //	.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        //+ File.separator + "Pdfs";
        String strDir =context.getExternalCacheDir()+"/.afl";
        File fileDir = new File(strDir);
        if(!fileDir.exists())
        fileDir.mkdirs(); //
        file = new File(fileDir,name+".pdf");


        try {


            in = assetManager.open(filename);
            out = new BufferedOutputStream(new FileOutputStream(file));



            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

        //	Intent intent = new Intent(Intent.ACTION_VIEW);
        //	intent.setDataAndType(
        //			Uri.parse(strDir+"/s66.pdf"),
        //			"application/pdf");
        //	startActivity(intent);



        //File file = new File("sdcard/s6.pdf");
        Uri path = Uri.fromFile(file);

/////		Toast.makeText(getApplicationContext(), path.toString(), Toast.LENGTH_LONG).show();
        //Uri path = Uri.parse(strDir+"/s66.pdf");

        Intent intent = new Intent(Intent.ACTION_VIEW);
//                    Intent nopdf = new Intent(Pdf.this,NOPDF.class);
        intent.setDataAndType(path, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context,
                    "No application available to view PDF", Toast.LENGTH_LONG)
                    .show();
//                        startActivity(nopdf);
        }


    }




    public class DownloadInBackground extends AsyncTask<String, Void, String> {

        URL url = null;
        String urlstring;
        File file;
        String mimeType;

        @Override
        protected void onPreExecute() {
            //Setup precondition to execute some task

        }

        @Override
        protected String doInBackground(String... params) {
            //Do some task

//            file = new File(context.getExternalCacheDir() + "/" + "Documents", params[0]);
            file = new File(context.getExternalCacheDir()+ "/.afl/" + params[0]+".pdf");
            urlstring="https://github.com/aflahkp/ktufiles/blob/master/"+params[1]+"?raw=true";

            try {
                url = new URL(urlstring); //Actual url
                FileUtils.copyURLToFile(url, file);
//                Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".extras.GenericFileProvider", file);

            } catch (IOException e) {
                e.printStackTrace();
                file.delete();
            }
            return "";
        }


        @Override
        protected void onPostExecute(String s) {
            //Show the result obtained from doInBackground
            notifyDataSetChanged();
        }
    }



//                context.startActivity(new Intent());

}
