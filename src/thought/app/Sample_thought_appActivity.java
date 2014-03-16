package thought.app;

import java.lang.reflect.Field;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.MonthDisplayHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sample_thought_appActivity extends Activity implements OnClickListener {
	TextView date;
	TextView thought_set;
	String[] array_thought;
	int[] array_day={31,28,31,30,31,30,31,31,30,31,30,31};
	int index_of_thought_array=0;
	int final_index_of_thought_array;
	int day_of_month;
	int day;
	Button btn_cancel;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        array_thought= getResources().getStringArray(R.array.array_of_thoughts);
        int build_year = 2014;
        setTitle("THOUGHT OF THE DAY");
        date = (TextView) findViewById(R.id.txt_date);
        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        Random r1 = new Random();
       int no= r1.nextInt(13);
       day_of_month = c1.get(Calendar.MONTH);
       thought_set=(TextView)findViewById(R.id.txt_thought_to_show);
     btn_cancel = (Button)findViewById(R.id.cancel);
     btn_cancel.setOnClickListener(this);
   
    
     btn_cancel.requestFocus();
     
        
        
//        c1.get
       // date.setText(Html.fromHtml(getResources().getString(R.id.txt_date)));
        SimpleDateFormat month_date = new SimpleDateFormat("MMMMMMMMM");
  String month_name = month_date.format(c1.getTime());
       
       
      
        day=c1.get(Calendar.DAY_OF_MONTH);
        date.setText( year+ "\n" +day+ "\n"+ month_name );
        
        	for(int i=0;i<day_of_month;i++)
        	{
        		index_of_thought_array = index_of_thought_array + array_day[i];
        }
        	final_index_of_thought_array= index_of_thought_array +day-1;
        	Toast.makeText(getApplicationContext(), ""+final_index_of_thought_array, Toast.LENGTH_LONG).show();
        	if(year==build_year)
        	{
        		thought_set.setText(array_thought[final_index_of_thought_array]);
        	}
}
	@Override
	public void onClick(View arg0) {
		Intent sharingIntent = new Intent();
		sharingIntent.setAction(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_EMAIL, "value");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "hello");
        startActivity(Intent.createChooser(sharingIntent,"Share using"));
		// TODO Auto-generated method stub
//		finish();
		
	}
}