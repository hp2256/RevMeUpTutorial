package com.harsh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.listener.DismissListener;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnProfile, btnDeals, btnSearch, btnNotifs, btnTrending, btnFollowing, btnFeed, btnRewards,
            btnPost, btnMessage, btnStalkList, btnRatings, btnAddStalk, btnBuy;
    FancyShowCaseQueue mQueue;
    DismissListener dismissListener = new DismissListener() {

        @Override
        public void onSkipped(String s) {

        }

        @Override
        public void onDismiss(String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = (Button) findViewById(R.id.btn_profile);
        btnDeals = findViewById(R.id.btn_deals);
        btnSearch = findViewById(R.id.btn_search);
        btnNotifs = findViewById(R.id.btn_notifications);
        btnTrending = findViewById(R.id.btn_trending);
        btnFollowing = findViewById(R.id.btn_following);
        btnFeed = findViewById(R.id.btn_feed);
        btnRewards = findViewById(R.id.btn_rewards);
        btnPost = findViewById(R.id.btn_newpost);
        btnMessage = findViewById(R.id.btn_message);
        btnStalkList = findViewById(R.id.btn_stalk);
        btnRatings = findViewById(R.id.btn_ratings);
        btnAddStalk = findViewById(R.id.btn_addstalk);
        btnBuy = findViewById(R.id.btn_buy);

        displayTutorial();

        btnRewards.setOnClickListener(this);

    }

    private void displayTutorial() {
       /* Button b[] = {btnProfile, btnDeals, btnSearch, btnNotifs, btnTrending, btnFollowing, btnFeed, btnRewards,
                btnPost, btnMessage, btnStalkList, btnRatings, btnAddStalk, btnBuy};
        final FancyShowCaseView[] fancyShowCaseView = new FancyShowCaseView[b.length];
        for (int i = 0; i < b.length; i++) {
            fancyShowCaseView[i] = new FancyShowCaseView.Builder(this)
                    .focusOn(b[i])
                    .customView(R.layout.text_view, new OnViewInflateListener() {
                        @Override
                        public void onViewInflated(View view) {

                        }
                    })
                    .build();
            mQueue = new FancyShowCaseQueue().add(fancyShowCaseView[i]);
        }
        mQueue.show();*/

        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("This is your profile.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnProfile)
                .build();

        final FancyShowCaseView fancyShowCaseView2 = new FancyShowCaseView.Builder(this)
                //.title("Click here for lastest Deals")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Go here for lastest Deals");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnDeals)
                .build();

        final FancyShowCaseView fancyShowCaseView3 = new FancyShowCaseView.Builder(this)
                // .title("Your notifications are here.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Your notifications are here.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnNotifs)
                .build();

        final FancyShowCaseView fancyShowCaseView4 = new FancyShowCaseView.Builder(this)
                // .title("These are the trending posts.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("These are the trending posts.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnTrending)
                .build();

        final FancyShowCaseView fancyShowCaseView5 = new FancyShowCaseView.Builder(this)
                // .title("Tap here to see your followers posts.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Tap here to see your followers posts.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnFollowing)
                .build();

        final FancyShowCaseView fancyShowCaseView6 = new FancyShowCaseView.Builder(this)
                //.title("Tap this to view the ratings of this product.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Tap this to view the ratings of this product.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnRatings)
                .build();

        final FancyShowCaseView fancyShowCaseView7 = new FancyShowCaseView.Builder(this)
                // .title("Tap this to add this item to your stalking list.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Tap this to add this item to your stalking list.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnAddStalk)
                .build();

        final FancyShowCaseView fancyShowCaseView8 = new FancyShowCaseView.Builder(this)
                //.title("Purchase this product by tapping this.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Purchase this product by tapping this.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnBuy)
                .build();

        final FancyShowCaseView fancyShowCaseView9 = new FancyShowCaseView.Builder(this)
                //   .title("This is your post feed where you currently are.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("This is your post feed where you currently are.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnFeed)
                .build();

        final FancyShowCaseView fancyShowCaseView10 = new FancyShowCaseView.Builder(this)
                // .title("Go here to view your rewards.")
                .focusOn(btnRewards)
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Go here to view your rewards.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .build();

        final FancyShowCaseView fancyShowCaseView11 = new FancyShowCaseView.Builder(this)
                //  .title("Add a new post.")
                .focusOn(btnPost)
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Add a new post.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .build();

        final FancyShowCaseView fancyShowCaseView12 = new FancyShowCaseView.Builder(this)
                // .title("Go here to message your followers.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("Go here to message your followers.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnMessage)
                .build();
        final FancyShowCaseView fancyShowCaseView13 = new FancyShowCaseView.Builder(this)
                // .title("View the items added to your stalk list.")
                .customView(R.layout.text_view, new OnViewInflateListener() {
                    @Override
                    public void onViewInflated(View view) {
                        TextView tv = view.findViewById(R.id.info_text);
                        tv.setText("View the items added to your stalk list.");
                        view.findViewById(R.id.skip).setOnClickListener(mClickListener);
                    }
                })
                .focusOn(btnStalkList)
                .build();
        final FancyShowCaseView fancyShowCaseView14 = new FancyShowCaseView.Builder(this)
                .title("Checkout the Rewards and Stalklist page next.")
                .build();


        mQueue = new FancyShowCaseQueue()
                .add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .add(fancyShowCaseView3)
                .add(fancyShowCaseView4)
                .add(fancyShowCaseView5)
                .add(fancyShowCaseView6)
                .add(fancyShowCaseView7)
                .add(fancyShowCaseView8)
                .add(fancyShowCaseView9)
                .add(fancyShowCaseView10)
                .add(fancyShowCaseView11)
                .add(fancyShowCaseView12)
                .add(fancyShowCaseView13)
                .add(fancyShowCaseView14);
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
            case R.id.btn_rewards:
                intent = new Intent(this, Rewards.class);
                startActivity(intent);
                break;
            case R.id.btn_newpost:
                intent = new Intent(this, NewPost.class);
                startActivity(intent);
                break;
        }
    }
}