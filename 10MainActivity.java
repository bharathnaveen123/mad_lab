package com.example.exno10;
 import android.app.Notification;
 import android.app.NotificationManager;
 import android.app.PendingIntent;
 import android.content.Intent; 
 import android.os.Bundle; 
 import android.support.v7.app.AppCompatActivity; 
 import android.view.View;
 import android.widget.Button; 
 import android.widget.EditText;
 import java.util.Calendar;
 
 public class MainActivity extends AppCompatActivity { 
 TimePicker alarmTimePicker; 
 PendingIntent pendingIntent; 
 AlarmManager alarmManager; 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
	 alarmTimePicker = (TimePicker) findViewById(R.id.timePicker); 
	 alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE); 
	 }
	 public void OnToggleClicked(View view) { 
	 longtime; 
	 if(((ToggleButton) view).isChecked()) {
		 Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show(); 
		 Calendar calendar = Calendar.getInstance(); 
		 calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour()); 
		 calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
		 Intent intent = newIntent(this, AlarmReceiver.class);
		 pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
		 time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000)); 
		 if(System.currentTimeMillis()>time) {
			 if(calendar.AM_PM == 0) time = time + (1000*60*60*12); else time = time + (1000*60*60*24);
			 } 
			 alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);
			 }
			else { 
			alarmManager.cancel(pendingIntent);
			Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
			} 
			} 
	}