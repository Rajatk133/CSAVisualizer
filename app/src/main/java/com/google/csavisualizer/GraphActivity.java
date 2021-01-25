package com.google.csavisualizer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    Handler handler = new Handler();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        int k=1;

       int[] arr2=new int[]{5,1,3,6,4,7,8,9,2,10};
        int[] status=new int[]{0,0,0,0,0,0,0,0,0,0,0};
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
        barEntries = new ArrayList<>();
        barChart = findViewById(R.id.BarChart);
        barEntries.add(new BarEntry(arr[1],status[arr[1]]+1));
        status[1]++;
        barDataSet = new BarDataSet(barEntries, "Processes");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10);

        for (int i = 2; i <= 55; i++) {
            int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),Integer.toString(arr[finalI])+" "+Integer.toString(status[finalI]+1),Toast.LENGTH_LONG).show();

        barEntries.add(new BarEntry(arr[finalI],status[arr[finalI]]+1));
        status[finalI]++;

        barData.addDataSet(barDataSet);
        barChart.setData(barData);
        //barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        //barDataSet.setValueTextColor(Color.BLACK);
       // barDataSet.setValueTextSize(10);
                }

            }, 1000 *(i+1));
        }
    }

}