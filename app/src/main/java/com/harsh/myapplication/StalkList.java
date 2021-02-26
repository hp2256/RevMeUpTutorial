package com.harsh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;

public class StalkList extends AppCompatActivity implements View.OnClickListener {
    Button btnBuy, stkFeed, stkRewards, stkPost;
    FancyShowCaseQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stalk_list);
        btnBuy = findViewById(R.id.stalkbuy);
        stkFeed = findViewById(R.id.stk_feed);
        stkRewards = findViewById(R.id.stk_rewards);
        stkPost = findViewById(R.id.stk_newpost);
        stkFeed.setOnClickListener(this);
        stkRewards.setOnClickListener(this);
        stkPost.setOnClickListener(this);
        stalkTutorial();

    }

    private void stalkTutorial() {
        final FancyShowCaseView fancyShowCaseView1 = new FancyShowCaseView.Builder(this)
                .title("Purchase the item added to your stalk list with this.")
                .focusOn(btnBuy)
                .build();
        mQueue = new FancyShowCaseQueue().add(fancyShowCaseView1);
        mQueue.show();

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.stk_rewards:
                intent = new Intent(this, Rewards.class);
                startActivity(intent);
                break;
            case R.id.stk_newpost:
                intent = new Intent(this, NewPost.class);
                startActivity(intent);
                break;
            case R.id.stk_feed:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}