package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTextSensor;
    SensorManager sensorMrg;
    List<Sensor> sensorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextSensor = findViewById(R.id.textSensor);
        //mTextSensor.setMovementMethod(new ScrollingMovementMethod());

        sensorMrg = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensorList = sensorMrg.getSensorList(Sensor.TYPE_ALL);

        mTextSensor.append("# Sensors:" + sensorList.size() + ") \n \n" );
        for(Sensor sensor : sensorList) {
            mTextSensor.append("Sensor name:" + sensor.getName()  + " \n");
            mTextSensor.append("Sensor type:" + sensor.getType()  + " \n\n");
        }
    }
}