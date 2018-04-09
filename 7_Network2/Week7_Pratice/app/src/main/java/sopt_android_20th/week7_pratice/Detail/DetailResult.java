package sopt_android_20th.week7_pratice.Detail;

import java.util.ArrayList;

/**
 * Created by pc on 2017. 5. 14..
 */
public class DetailResult {
    public ResultData result;
    public String message;

    public class ResultData{
        public DetailData post;
        public ArrayList<CommentData> comment;

    }

    class DetailData{
        public int id;
        public String writer;
        public String title;
        public String image_url;
        public String content;
    }
    class CommentData{
        public String writer;
        public String written_time;
        public String content;
    }
}
