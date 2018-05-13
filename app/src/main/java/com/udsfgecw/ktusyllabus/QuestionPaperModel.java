package com.udsfgecw.ktusyllabus;

import java.io.File;

/**
 * Created by AFLAH on 5/5/2018.
 */

public class QuestionPaperModel {
    String qp_path;
    String qp_name;
    File file;


    public QuestionPaperModel(String qp_name, String qp_path) {
        this.qp_name = qp_name;
        this.qp_path = qp_path;
    }


}
