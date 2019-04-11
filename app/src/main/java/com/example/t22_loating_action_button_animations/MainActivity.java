package com.example.t22_loating_action_button_animations;

        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.content.Intent;
        import android.net.Uri;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Layout;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.LinearLayout;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private FloatingActionButton mCallfab;
    private FloatingActionButton mSmsfab;
    private LinearLayout mCllLayout;
    private LinearLayout mSmsLayout;
    
    private String phone= "111-111-1111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFab= (FloatingActionButton) findViewById(R.id.floatingActionButton);
        mCallfab= (FloatingActionButton) findViewById(R.id.callFab);
        mSmsfab= (FloatingActionButton) findViewById(R.id.smsFab);
        mCllLayout= (LinearLayout) findViewById(R.id.callLayout);
        mSmsLayout= (LinearLayout) findViewById(R.id.smslLayout);

        //
        final Animation mShowbutton= AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_button);
        final Animation mHidebutton= AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_button);
        final Animation mShowlayout= AnimationUtils.loadAnimation(MainActivity.this, R.anim.show_layout);
        final Animation mHidelayout= AnimationUtils.loadAnimation(MainActivity.this, R.anim.hide_layout);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCllLayout.getVisibility()== View.VISIBLE && mSmsLayout.getVisibility()== View.VISIBLE){

                    mCllLayout.setVisibility((View.GONE));
                    mSmsLayout.setVisibility((View.GONE));
                    //animation
                    mCllLayout.startAnimation(mHidelayout);
                    mSmsLayout.startAnimation(mHidelayout);
                    mFab.startAnimation(mHidebutton);
                } else{
                    mCllLayout.setVisibility((View.VISIBLE));
                    mSmsLayout.setVisibility((View.VISIBLE));
                    //animation
                    mCllLayout.startAnimation(mShowlayout);
                    mSmsLayout.startAnimation(mShowlayout);
                    mFab.startAnimation(mShowbutton);
                }

            }
        });


        mCallfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCllLayout.setVisibility((View.GONE));
                mSmsLayout.setVisibility((View.GONE));
                //animation
                mCllLayout.startAnimation(mHidelayout);  //animation
                mSmsLayout.startAnimation(mHidelayout);  //animation
                mFab.startAnimation(mHidebutton);  //animation
                // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel://"+ phone))); // from prev Tutorial 22
                Intent mIntent = new Intent (Intent.ACTION_DIAL);
                mIntent.setData( Uri.parse("tel://"+ phone));

                if(mIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(mIntent);
                } else{
                    Toast.makeText(MainActivity.this,
                            "There is no app that support this action",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        mSmsfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCllLayout.setVisibility((View.GONE));
                mSmsLayout.setVisibility((View.GONE));
                //animation
                mCllLayout.startAnimation(mHidelayout);  //animation
                mSmsLayout.startAnimation(mHidelayout);  //animation
                mFab.startAnimation(mHidebutton);  //animation
                // startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel://"+ phone))); // from prev Tutorial 22
                Intent mIntent = new Intent (Intent.ACTION_VIEW);
                mIntent.setData( Uri.parse("sms:"+ phone));

                if(mIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(mIntent);
                } else{
                    Toast.makeText(MainActivity.this,
                            "There is no app that support this action",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
