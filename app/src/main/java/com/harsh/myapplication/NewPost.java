package com.harsh.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

public class NewPost extends AppCompatActivity {
    Button btnSearchItem, btnReviewType;
    FancyShowCaseQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        btnSearchItem = findViewById(R.id.search_items);
        btnReviewType = findViewById(R.id.review_type);
        displayPostTutorial();
    }

    private void displayPostTutorial() {
        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                //.title("Enter your item name here and select if available in the catalogue or add")
                  .customView(R.layout.rewards_view, new OnViewInflateListener() {
                      @Override
                      public void onViewInflated(View view) {
                          TextView tv = view.findViewById(R.id.info_text);
                          tv.setText("Enter your item name here and select if available in the catalogue or add");
                          view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                      }
                  })
                .focusOn(btnSearchItem)
                .build();

        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                //.title("Select either basic for just a text review or selfie mode to add a picture along with your review.")
                .customView(R.layout.rewards_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("You can trade revcoins for cash on this tab");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnReviewType)
                .build();
        mQueue = new FancyShowCaseQueue()
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2);
        mQueue.show();

    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mQueue.cancel(true);
        }
    };
}