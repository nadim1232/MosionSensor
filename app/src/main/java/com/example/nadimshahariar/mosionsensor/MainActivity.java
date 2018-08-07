package com.example.nadimshahariar.mosionsensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity implements SensorEventListener {

    TextView txtNumber;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber=findViewById(R.id.txt_number);

        sm=(SensorManager) this.getSystemService(Context.SENSOR_SERVICE);

        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            float values[]=event.values;
            float x=values[0];
            float y=values[1];
            float z=values[2];

            float asr=(x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);

            if(asr>=2){
                Random random=new Random();
                int number=random.nextInt(100);
                txtNumber.setText(""+number);
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
