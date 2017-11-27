package com.sadi.sreda;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sadi.sreda.adapter.Adapter;
import com.sadi.sreda.fragement.RegenerationReportFragement;
import com.sadi.sreda.utils.OnFragmentInteractionListener;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    Context con;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView mNavigationView;
    Activity activity;
    private Handler handler;
    private boolean isTimerRunning;
    Runnable Update;
    Timer swipeTimer;
    private ViewPager launchViewpager;
    public static int[] imageRSC = {R.drawable.banar,R.drawable.banar};

    private Fragment backFragement;
    TextView tvTitle;
    Button btnReport,btnGovAgency,btnPrivateIndiVi,btnStakeHolder,btnHome,
    btnReportReGen,btnReportTechno,btnReportYear,btnReportLarge,btnReportSmall,btnReportSearch;
    LinearLayout linReport,linGovAgency,linPrivateIndiVi,linStakeHolder;
    private FrameLayout containerView;
    Animation shake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t1);

        con = this;
        //Toast.makeText(con, "onCreate", Toast.LENGTH_SHORT).show();
        initialization();
    }

    private void initialization() {


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


//        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
//        mDrawerLayout.addDrawerListener(mDrawerToggle);
//        mDrawerToggle.syncState();



        slideshow();

        tvTitle = (TextView)findViewById(R.id.tvTitle);

        linReport = (LinearLayout) findViewById(R.id.linReport);
        linGovAgency = (LinearLayout) findViewById(R.id.linGovAgency);
        linPrivateIndiVi = (LinearLayout) findViewById(R.id.linPrivateIndiVi);
        linStakeHolder = (LinearLayout) findViewById(R.id.linStakeHolder);
        //linPieView = (LinearLayout) findViewById(R.id.linPieView);
        containerView = (FrameLayout) findViewById(R.id.containerView);


        shake = AnimationUtils.loadAnimation(this, R.anim.shake);


        btnHome = (Button)findViewById(R.id.btnHome);
        btnReport = (Button)findViewById(R.id.btnReport);
        btnGovAgency = (Button)findViewById(R.id.btnGovAgency);
        btnPrivateIndiVi = (Button)findViewById(R.id.btnPrivateIndiVi);
        btnStakeHolder = (Button)findViewById(R.id.btnStakeHolder);

        btnReportReGen = (Button)findViewById(R.id.btnReportReGen);
        btnReportTechno = (Button)findViewById(R.id.btnReportTechno);
        btnReportYear = (Button)findViewById(R.id.btnReportYear);
        btnReportLarge = (Button)findViewById(R.id.btnReportLarge);
        btnReportSmall = (Button)findViewById(R.id.btnReportSmall);
        btnReportSearch = (Button)findViewById(R.id.btnReportSearch);


        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
//                containerView.setVisibility(View.GONE);
//                linPieView.setVisibility(View.VISIBLE);
            }
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                containerView.setVisibility(View.GONE);
               // linPieView.setVisibility(View.VISIBLE);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        btnReportReGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnReportReGen.startAnimation(shake);
                containerView.setVisibility(View.VISIBLE);
                //linPieView.setVisibility(View.GONE);
                setContentFragment(new RegenerationReportFragement(), false,"RE Generation Summery Report");
                tvTitle.setText("Report\nRE Generation");
                mDrawerLayout.closeDrawers();
                backFragement = new RegenerationReportFragement();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnHome.startAnimation(shake);
                mDrawerLayout.closeDrawers();
                containerView.setVisibility(View.GONE);
               // linPieView.setVisibility(View.VISIBLE);
                tvTitle.setText("");
                linReport.setVisibility(View.GONE);
                linGovAgency.setVisibility(View.GONE);
                linPrivateIndiVi.setVisibility(View.GONE);
                linStakeHolder.setVisibility(View.GONE);

            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnReport.startAnimation(shake);
                if(linReport.getVisibility()==View.GONE){
                    linReport.setVisibility(View.VISIBLE);
                    linGovAgency.setVisibility(View.GONE);
                    linPrivateIndiVi.setVisibility(View.GONE);
                }else if(linReport.getVisibility()==View.VISIBLE){
                    linReport.setVisibility(View.GONE);
                }
            }
        });

        btnGovAgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGovAgency.startAnimation(shake);
                if(linGovAgency.getVisibility()==View.GONE){
                    linGovAgency.setVisibility(View.VISIBLE);
                    linReport.setVisibility(View.GONE);
                    linPrivateIndiVi.setVisibility(View.GONE);
                    linStakeHolder.setVisibility(View.GONE);
                }else if(linGovAgency.getVisibility()==View.VISIBLE){
                    linGovAgency.setVisibility(View.GONE);
                }
            }
        });

        btnPrivateIndiVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linPrivateIndiVi.getVisibility()==View.GONE){
                    linPrivateIndiVi.setVisibility(View.VISIBLE);
                    linReport.setVisibility(View.GONE);
                    linGovAgency.setVisibility(View.GONE);
                    linStakeHolder.setVisibility(View.GONE);
                }else if(linPrivateIndiVi.getVisibility()==View.VISIBLE){
                    linPrivateIndiVi.setVisibility(View.GONE);
                }
            }
        });

        btnStakeHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linStakeHolder.getVisibility()==View.GONE){
                    linStakeHolder.setVisibility(View.VISIBLE);
                    linReport.setVisibility(View.GONE);
                    linGovAgency.setVisibility(View.GONE);
                    linPrivateIndiVi.setVisibility(View.GONE);

                }else if(linStakeHolder.getVisibility()==View.VISIBLE){
                    linStakeHolder.setVisibility(View.GONE);
                }
            }
        });
    }



    private void slideshow() {

        handler = new Handler();
        createSwipeTimer();
        isTimerRunning = true;
        activity =this;
//        TextView textViewDescription = (TextView)getView ().findViewById(R.id.textViewDescription);
//        textViewDescription.setText(Html.fromHtml(getString(R.string.text_cose_kimik)));
        launchViewpager = (ViewPager) findViewById(R.id.launchViewpager);
        launchViewpager.setAdapter(new Adapter(con, imageRSC, activity));
        launchViewpager.setCurrentItem(0);
        launchViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                    isTimerRunning = false;
                    swipeTimer.cancel();
                } else {
                    if (!isTimerRunning) {
                        createSwipeTimer();
                        isTimerRunning = true;
                    }
                }
            }
        });


        Update = new Runnable() {
            @Override
            public void run() {

                if (imageRSC != null && imageRSC.length > 0) {
                    int currentImg = launchViewpager.getCurrentItem();
                    currentImg++;
                    if (currentImg == imageRSC.length) {
                        currentImg = 0;
                    }
                    launchViewpager.setCurrentItem(currentImg, true);
                }

				/*
				 * if (currentPage == AllMenuImgInfo.getAllMenuImgInfo().size())
				 * { currentPage = 0; }
				 * MainViewPager.setCurrentItem(currentPage++, true);
				 */
            }
        };
    }

    private void createSwipeTimer() {
        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


    }

    @Override
    public void setContentFragment(Fragment fragment, boolean addToBackStack,String title) {
        if (fragment == null) {
            return;
        }

        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.containerView);

        if (currentFragment != null && fragment.getClass().isAssignableFrom(currentFragment.getClass())) {
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, fragment, fragment.getClass().getName());
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();

    }


    @Override
    public void addContentFragment(Fragment fragment, boolean addToBackStack,String title) {
        if (fragment == null) {
            return;
        }


        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.containerView);

        if (currentFragment != null && fragment.getClass().isAssignableFrom(currentFragment.getClass())) {
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerView, fragment, fragment.getClass().getName());
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }

    }

    public void exitFromApp() {
        final CharSequence[] items = { "NO", "YES" };
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit from app?");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        return;
                    case 1:
                        // onStopRecording();

                        finish();


                        break;
                    default:
                        return;
                }
            }
        });
        builder.show();
        builder.create();
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if(buttonView.getVisibility()==View.GONE){
//                buttonView.setVisibility(View.VISIBLE);
//            }else {
                exitFromApp();
           // }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Toast.makeText(con, "onStart()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(con, "onResume()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(con, "onStop()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        Toast.makeText(con, "PostResume()", Toast.LENGTH_SHORT).show();
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(con, "onPause()", Toast.LENGTH_SHORT).show();
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(con, "onDestroy()", Toast.LENGTH_SHORT).show();
//    }


}
