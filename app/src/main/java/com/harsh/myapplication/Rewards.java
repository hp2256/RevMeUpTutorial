package com.harsh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

public class Rewards extends AppCompatActivity implements View.OnClickListener {
    Button btnRevcoins, btnCashtab, btnVouchers, btnExclusives, btnCash, rwdFeed, rwdPost, rwdStalk;
    FancyShowCaseQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        btnRevcoins = findViewById(R.id.btn_revcoins);
        btnCashtab = findViewById(R.id.tab_cash);
        btnVouchers = findViewById(R.id.vouchers);
        btnExclusives = findViewById(R.id.exclusive);
        btnCash = findViewById(R.id.cash);
        rwdFeed = findViewById(R.id.rwd_feed);
        rwdStalk = findViewById(R.id.rwd_stalk);
        rwdPost = findViewById(R.id.rwd_newpost);

        rwdFeed.setOnClickListener(this);
        rwdStalk.setOnClickListener(this);
        rwdPost.setOnClickListener(this);
        displayRewardstutorial();

    }

    private void displayRewardstutorial() {
        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                // .title("These are your accumulated revcoins.")
                .customView(R.layout.rewards_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("These are your accumulated revcoins.");

                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnRevcoins)
                .build();

        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                // .title("You can trade revcoins for cash on this tab")
                .customView(R.layout.rewards_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("You can trade revcoins for cash on this tab");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnCashtab)
                .build();

        final FancyShowCaseView fancyShowCaseView3 = new FancyShowCaseView.Builder(this)
                // .title("Trade revcoins for vouchers here.")
                .customView(R.layout.rewards_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Trade revcoins for vouchers here.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnVouchers)
                .build();

        final FancyShowCaseView fancyShowCaseView4 = new FancyShowCaseView.Builder(this)
                // .title("Check out our exclusive items.")
                .customView(R.layout.rewards_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Check out our exclusive items.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnExclusives)
                .build();

        final FancyShowCaseView fancyShowCaseView5 = new FancyShowCaseView.Builder(this)
                // .title("A cash reward; trade 3000 revcoins for 300 cash.")
                .customView(R.layout.rewards_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("A cash reward; trade 3000 revcoins for 300 cash.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnCash)
                .build();
        final FancyShowCaseView fancyShowCaseView6 = new FancyShowCaseView.Builder(this)
                .title("Try to add a new post to earn revcoins.")
                .focusOn(rwdPost)
                .build();


        mQueue = new FancyShowCaseQueue()
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .add(fancyShowCaseView3)
                .add(fancyShowCaseView4)
                .add(fancyShowCaseView5)
                .add(fancyShowCaseView6);
        mQueue.show();

    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mQueue.cancel(true);
        }
    };

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.rwd_stalk:
                intent = new Intent(this, StalkList.class);
                startActivity(intent);
                break;
            case R.id.rwd_newpost:
                intent = new Intent(this, NewPost.class);
                startActivity(intent);
                break;
            case R.id.rwd_feed:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}