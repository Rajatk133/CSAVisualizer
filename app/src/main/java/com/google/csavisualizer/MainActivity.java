package com.google.csavisualizer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
   int i;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("S J F");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Handler handler = new Handler();
        int k=1;

        int[] arr2=new int[]{5,1,3,6,4,7,8,9,2,10};

        int arr[]=new int[56];

        ArrayList<helper> list=new ArrayList<>();

        for(int i=0;i<10;i++){
            list.add(new helper(i,arr2[i]));
        }

        list.sort(new sorter());

       int z=1;
       int t2=0;
       while(z<56){
          int var=list.get(t2).getVal();
          int temp2=z+var;
         while(z<temp2){
              arr[z]=list.get(t2).getPid()+1;
         z++;}

          t2++;
       }

       for (int i = 1; i <= 55; i++) {
            int finalI = i;
            handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        String layoutid = "l" + Integer.toString(arr[finalI]);
                        TextView textView = new TextView(getApplicationContext());

                        int resid = getResources().getIdentifier(layoutid, "id", getPackageName());
                        LinearLayout llMain = findViewById(resid);
                        textView.setWidth(50);
                        textView.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
                        textView.setBackgroundColor(Color.parseColor("#FFFFF7"));

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.MATCH_PARENT
                        );

                        params.setMargins(5, 5, 0, 5);
                        textView.setLayoutParams(params);
                        llMain.addView(textView);
                    }

                }, 1000 *(i+1));
        }

    }
    }