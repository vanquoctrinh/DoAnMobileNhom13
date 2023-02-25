package com.example.bottomnavi;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class ChooseTrainActivity extends AppCompatActivity {

    int preSelectedIndex = -1;
    EditText inputSeat;
    Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnConfirm = findViewById(R.id.btnConfirm);
        inputSeat = findViewById(R.id.seatNumber);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_train);

        ListView listView = (ListView) findViewById(R.id.listViewTrain);

        final List<TrainModel> trains = new ArrayList<>();
        trains.add(new TrainModel(false, "SE01"));
        trains.add(new TrainModel(false, "SE03"));
        trains.add(new TrainModel(false, "SE05"));
        trains.add(new TrainModel(false, "TN02"));
        trains.add(new TrainModel(false, "TN07"));

        final TrainAdapter adapter = new TrainAdapter(this,trains);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TrainModel model = trains.get(i);

                model.setSelected(true);

                trains.set(i, model);

                if (preSelectedIndex > -1){
                    TrainModel preRecord = trains.get(preSelectedIndex);
                    preRecord.setSelected(false);

                    trains.set(preSelectedIndex,preRecord);
                }

                preSelectedIndex = i;

                adapter.updateRecords(trains);
            }
        });

    }

}