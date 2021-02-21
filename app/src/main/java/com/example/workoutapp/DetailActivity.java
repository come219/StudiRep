package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView title;
    private TextView wod;
    private WebView videoView;
    private LinearLayout parentLayout;
    private LinearLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title_tv);
        wod = findViewById(R.id.wod_tv);
        videoView = findViewById(R.id.videoView);
        contentLayout = findViewById(R.id.contentLayout);
        parentLayout = findViewById(R.id.parentLayout);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            //if there is nothing it does notheing
            String t = extra.getString("EXTRA_TITLE");
            String w = extra.getString("EXTRA_WOD");
            String youtubeURL = extra.getString("video");
            //String youtubeURL = "https://www.youtube.com/watch?v=W4eKVKwf3rQ";
            int indexOfID = youtubeURL.indexOf("?v=");
            String youtubeVideoID = youtubeURL.substring(indexOfID+3);
            String videoURL = "https://www.youtube.com/embed/" + youtubeVideoID;

            String content = "<iframe width=\"100%\" height=\"100%\" src=\"" + videoURL + "\" frameborder=\"0\" allowfullscreen></iframe>";

            title.setText(t);
            wod.setText(w);

            videoView.getSettings().setJavaScriptEnabled(true);
            videoView.loadData(content, "text/html", "utf-8");
            videoView.setWebChromeClient(new CustomWebView(parentLayout, contentLayout) {

            });
        }
    }

    // Custom Web View Class to allow for full screen
    private class CustomWebView extends WebChromeClient {

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        ViewGroup parent;
        ViewGroup content;
        View customView;

        public CustomWebView(ViewGroup parent, ViewGroup content){
            this.parent = parent;
            this.content = content;
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);

            customView = view;
            view.setLayoutParams(layoutParams);
            parent.addView(view);
            content.setVisibility(View.GONE);
        }

        @Override
        public void onHideCustomView() {
            super.onHideCustomView();

            content.setVisibility(View.VISIBLE);
            parent.removeView(customView);
            customView = null;
        }
    }
}

