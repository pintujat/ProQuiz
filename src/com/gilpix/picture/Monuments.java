

	package com.gilpix.picture;


	import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gilpix.result.Result;
import com.gilpix.test.R;

	@SuppressLint("NewApi")
	public class Monuments extends Activity implements OnClickListener{
		
		private int currentQuestion;
		private String [] answers;
		private String [] ans1;
		private String [] ans2;
		private String [] questions;
		private String [] ans3;
		private String [] ans4;
		private Button answerButton;
		private Button questionButton;
		private TextView questionView;
		//private TextView answerView;
		public int correct;
		public  String[] res;
		public ArrayList<String> content = new ArrayList<String>();
		 public static  String msg = "SEND MESSAGE";
		 public static String msg2 = "outtt";
		 public static String right = "R";
		 public static String wrong = "W";
		 
		CheckBox opt1,opt2,opt3,opt4;
		String r;
	     int point=0;
	     int neg = 0;
	     public ImageButton question;	
	     public ImageButton image;
          	   

	
		int count =0;
		int[] ques={R.drawable.mon_1,R.drawable.mon_2,R.drawable.mon_3,R.drawable.mon_4,R.drawable.mon_5,R.drawable.mon_6,R.drawable.mon_7,R.drawable.mon_8,R.drawable.mon_9,
				R.drawable.mon_10,R.drawable.mon_11,R.drawable.mon_12,R.drawable.mon_13,R.drawable.mon_14,R.drawable.mon_15};
		
 
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.picture);
			
			image = (ImageButton) findViewById(R.id.imageButton1);
			Button next = (Button) findViewById(R.id.next);
			Button submit = (Button) findViewById(R.id.submit);
				
			answerButton = (Button)findViewById(R.id.submit);
			questionButton = (Button)findViewById(R.id.next);
			questionView = (TextView)findViewById(R.id.ques);
			//answerView = (TextView) findViewById(R.id.result);
			
			 opt1 = (CheckBox)findViewById(R.id.checkBox1);
			 opt1.setOnCheckedChangeListener(listener);
			 
			 opt2 = (CheckBox)findViewById(R.id.checkBox2);
			 opt2.setOnCheckedChangeListener(listener);
			 
			 opt3 = (CheckBox)findViewById(R.id.checkBox3);
			 opt3.setOnCheckedChangeListener(listener);
			 
			 opt4 = (CheckBox)findViewById(R.id.checkBox4);
			 opt4.setOnCheckedChangeListener(listener);
			
		/*
			//----------ACTION BAR----------//
			    ActionBar actionbar = getActionBar();
			    actionbar.setDisplayUseLogoEnabled(false);//
		        actionbar.setDisplayHomeAsUpEnabled(true);//use icon with back graphics
		        Drawable d=getResources().getDrawable(R.drawable.action2);  
		        getActionBar().setBackgroundDrawable(d);
		        //----------ACTION BAR----------//
		*/
			 DisplayMetrics metrics = getResources().getDisplayMetrics();
		      //----------ACTION BAR----------//
			    ActionBar actionbar = getActionBar();
			    //actionbar.setDisplayUseLogoEnabled(false);//
		        //actionbar.setDisplayHomeAsUpEnabled(true);//use icon with back graphics
		        Drawable d=getResources().getDrawable(R.drawable.action2);  
		        getActionBar().setBackgroundDrawable(d);
		        //----------ACTION BAR----------//
		        getActionBar().setIcon(android.R.color.transparent);
		       
		    
			        if (metrics.densityDpi >=240 )
			        {
			        	TextView title;
			 	        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
			 	        getActionBar().setCustomView(R.layout.actiobar); 
			 	        title= (TextView)findViewById(R.id.title);
			 	        title.setText("MONUMENTS");   
			        }
			        else if(metrics.densityDpi <240)
			        {
			        	getActionBar().hide();
			        }
		        
			 
			        CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
			        
			        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
					checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
					checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
					checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
			        
			        final float scale1 = this.getResources().getDisplayMetrics().density;
			        checkBox1.setPadding(checkBox1.getPaddingLeft() + (int)(10.0f * scale1 + 0.5f),
			          		checkBox1.getPaddingTop(),
			                checkBox1.getPaddingRight(),
			                checkBox1.getPaddingBottom());
			        final float scale2 = this.getResources().getDisplayMetrics().density;
			        checkBox2.setPadding(checkBox2.getPaddingLeft() + (int)(10.0f * scale2 + 0.5f),
			          		checkBox2.getPaddingTop(),
			                checkBox2.getPaddingRight(),
			                checkBox2.getPaddingBottom());
			        final float scale3 = this.getResources().getDisplayMetrics().density;
			        checkBox3.setPadding(checkBox3.getPaddingLeft() + (int)(10.0f * scale3 + 0.5f),
			          		checkBox3.getPaddingTop(),
			                checkBox3.getPaddingRight(),
			                checkBox3.getPaddingBottom());
			        final float scale4 = this.getResources().getDisplayMetrics().density;
			        checkBox4.setPadding(checkBox4.getPaddingLeft() + (int)(10.0f * scale4 + 0.5f),
			          		checkBox4.getPaddingTop(),
			                checkBox4.getPaddingRight(),
			                checkBox4.getPaddingBottom());
			        
			 
			 
			 
		        
		        answerButton.setOnClickListener((OnClickListener) this);         
			 questionButton.setOnClickListener((OnClickListener) this);         

			 init(); 
		}

		public OnCheckedChangeListener listener = new OnCheckedChangeListener() {
			 
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
			if(isChecked){
			switch(arg0.getId())
			  {
			    case R.id.checkBox1:
			    	opt1.setChecked(true);
			    	opt2.setChecked(false);
			    	opt3.setChecked(false);
			    	opt4.setChecked(false);
			         break;
			    case R.id.checkBox2:
			    	opt2.setChecked(true);
			    	opt1.setChecked(false);
			    	opt3.setChecked(false);
			    	opt4.setChecked(false);
			         break;
			   case R.id.checkBox3:
				   opt3.setChecked(true);
				   opt1.setChecked(false);
			        opt2.setChecked(false);
			        opt4.setChecked(false);
			        break;
			   case R.id.checkBox4:
				   opt4.setChecked(true);
				   opt1.setChecked(false);
			        opt2.setChecked(false);
			        opt3.setChecked(false);
			        break;
			  }
			}
			 
			}
			};
		
			@Override
		    public void onBackPressed() {
		        AlertDialog.Builder builder = new AlertDialog.Builder(Monuments.this);
		        builder.setMessage("Do you really want to exit?.").setCancelable(
		                false).setPositiveButton("Quit",
		                        new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int id) {
		                    	Monuments.this.finish();
		                    	Intent intent = new Intent(Monuments.this,Pcategories.class);
			     		           startActivity(intent);

		                    }
		                }).setNegativeButton("Cancel",
		                        new DialogInterface.OnClickListener() {
		                    public void onClick(DialogInterface dialog, int id) {

		                    }
		                });
		        AlertDialog alert = builder.create();
		        alert.show();

		    }
			//set back button
			 @Override
			 public boolean onOptionsItemSelected(MenuItem item){
				 switch (item.getItemId())
				 {
				 case (android.R.id.home) :
				 Intent intent= new Intent(this,Pcategories.class);
				 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				 startActivity(intent);
				 return true;
			     default :
			    	 return super.onOptionsItemSelected(item);
				 
				 }
				 		 
			 }
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		

		private void init() {
			
			// TODO Auto-generated method stub
			questions = getResources().getStringArray(R.array.mon_ques);
			 ans1 = getResources().getStringArray(R.array.mon_cho_A);
			 ans2 = getResources().getStringArray(R.array.mon_cho_B);
			 ans3 = getResources().getStringArray(R.array.mon_cho_C);
			 ans4 = getResources().getStringArray(R.array.mon_cho_D);
			 answers = getResources().getStringArray(R.array.mon_ans);
			 
			 currentQuestion = 0;


		 image.setImageResource(ques[currentQuestion]);
		 opt1.setText(ans1[currentQuestion]);
		 opt2.setText(ans2[currentQuestion]);
		 opt3.setText(ans3[currentQuestion]);
		 opt4.setText(ans4[currentQuestion]);
		 
		 
		 questionView.setText(questions[currentQuestion]);
			
			 
			 Lable1: {	 answerButton.setOnClickListener(new OnClickListener(){
		 		 @Override
		 		 public void onClick(View v) {

		 			 //String r = "";
		 		     if(opt1.isChecked()||opt2.isChecked()||opt3.isChecked()||opt4.isChecked()){  
		 			 if (opt1.isChecked()) {
		 				 
		 		        opt2.setChecked(false);
		 		        opt3.setChecked(false);
		 		        opt4.setChecked(false);
		 	 	        r = opt1.getText().toString();
		 		      }
		 		      if (opt2.isChecked()) {
		 		      
		 		        opt1.setChecked(false);
		 		        opt3.setChecked(false);
		 		        opt4.setChecked(false);
		 		        r = opt2.getText().toString();
		 		      }
		 		      if (opt3.isChecked()) {
		 		      
		 		        opt2.setChecked(false);
		 		        opt1.setChecked(false);
		 		        opt4.setChecked(false);
		 		        r = opt3.getText().toString();
		 		      }
		 		      if (opt4.isChecked()) {
		 		      
		 		       opt2.setChecked(false);
		 		        opt3.setChecked(false);
		 		        opt1.setChecked(false);
		 		       r = opt4.getText().toString();
		 		      }
		 		      checkAnswer(r);
		 		      opt1.setChecked(false);
		 			    opt2.setChecked(false);
		 		        opt3.setChecked(false);
		 			    opt4.setChecked(false);
		 			    showQuestion();
		 		     }
		 		    else {
				    	Toast toast= Toast.makeText(getApplicationContext(), 
		 						"Select Atleast one Option", Toast.LENGTH_SHORT);  
		 						toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
		 						toast.show();
				    }
			
			     
			}});
		break Lable1;
		 	}
			 
			 
			 questionButton.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v) {
						
						 image.setImageResource(ques[count+1]);
						opt1.setChecked(false);
					    opt2.setChecked(false);
				        opt3.setChecked(false);
					    opt4.setChecked(false);
					    showQuestion();					
					}});
					}
		 public void showQuestion()
			{
		   currentQuestion++;
		   
		   if(currentQuestion == (questions.length)){
				correct = point;
				String ms = Integer.toString(correct);
				msg=ms; 
				currentQuestion =0;
				 point = 0;
				 
				 
				 Bundle b=new Bundle();
				b.putStringArray("mes", new String[]{answers[0],answers[1]});
			    
				Intent in=new Intent(Monuments.this,Result.class);
				in.putExtra("string",msg );
				
				 in.putExtras(b);
				 startActivity(in);
				 finish();		
				
				
				
			}

			
		     image.setImageResource(ques[currentQuestion]);
			questionView.setText(questions[currentQuestion]);
			//answerView.setText("");
			opt1.setText(ans1[currentQuestion]);
		    opt2.setText(ans2[currentQuestion]);
		    opt3.setText(ans3[currentQuestion]);
		    opt4.setText(ans4[currentQuestion]);
			
			}
			
		
			public boolean isCorrect(String r)
			{
			return (r.equalsIgnoreCase(answers[currentQuestion]));
			}
			
			
			public void checkAnswer(String r)
			{	
			if(isCorrect(r)){
		      	point++;
		    	Toast toast2= Toast.makeText(getApplicationContext(), 
						"Correct", Toast.LENGTH_SHORT);  
						toast2.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
						toast2.show();	
			}
			else{
			neg++;
			Toast toast3= Toast.makeText(getApplicationContext(), 
					"Correct answer is: "+answers[currentQuestion], Toast.LENGTH_SHORT);  
					toast3.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
					//toast3.setView(incorrect);
					toast3.show();
			}}


		public void onClick(View v) {
			// TODO Auto-generated method stub
			 switch (v.getId()){
			 case R.id.next:
				
				 image.setImageResource(ques[currentQuestion]);
				 break;
}
		}
		
	}	
	