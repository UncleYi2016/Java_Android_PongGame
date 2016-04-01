package com.example.java_android_ponggame;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class PongDrawingView extends View {
	private Paint p;
	private Circle c;
	private long delay;
	private Handler h;
	private float minusX;
	private float minusY;
	private boolean clicking;

	
	public PongDrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		delay = 5;
		p = new Paint();
		c = new Circle(100f,100f,10f);
		minusX = -1f;
		minusY = -1f;
		clicking = false;
		
		
		p.setColor(Color.BLUE);
		p.setStyle(Paint.Style.STROKE);
		
		h = new Handler(new Callback(){
			public boolean handleMessage(Message arg0) {
				PongDrawingView pdv = (PongDrawingView)findViewById(R.id.drawView);
				pdv.moveCricle();
				Message m = h.obtainMessage(0);
				h.sendMessageDelayed(m, delay);
				return false;
			}
		});
		
		this.setOnTouchListener(new OnTouchListener(){
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN){
					clicking = true;
					return true;
				}
				else if(event.getAction() == MotionEvent.ACTION_MOVE){
					clicking = false;
					return true;
				}
				else if(event.getAction() == MotionEvent.ACTION_UP){
					if(clicking){
						c.setX(event.getX());
						c.setY(event.getY());
						invalidate();
						clicking = false;
					}
					return true;
				}
				return false;
			}
		});
	}
	
	public void startTicker(){
		Message m = h.obtainMessage(0);
		h.sendMessageDelayed(m, delay);
	}
	
	public void stopTicker(){
		h.removeMessages(0);
	}
	
	public void moveCricle(){
		c.moveCircle(minusX * 1f, minusY * 1f);
		if(c.getX() + c.getRadius() >= (float) this.getWidth()){
			minusX *= -1f;
		}else if(c.getX() - c.getRadius() <= 0){
			minusX *= -1f;
		}
		if(c.getY() + c.getRadius() >= (float) this.getHeight()){
			minusY *= -1f;
		}else if(c.getY() - c.getRadius() <= 0){
			minusY *= -1f;
		}
		invalidate();
	}
	
	protected void onDraw(Canvas canvas){
		canvas.drawCircle(c.getX(), c.getY(), c.getRadius(), p);
	}
	
	
}
