package com.example.piyush.indoornevigateion.view;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.piyush.indoornevigateion.R;

import controller.Algorithm;
import controller.List;
import controller.Point;
import controller.WifiFinder;

import static java.lang.Thread.sleep;

/**
 * Created by Piyush on 25-02-2015.
 */
public class MapView extends Activity implements View.OnClickListener {
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();
    PointF startPoint = new PointF();
    PointF midPoint = new PointF();
    float oldDist = 1f;
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE,change=0;

    Bitmap bmOverlay;
    TextView text;
    static final long WIFI_SCAN_DELAY_MILLIS = 2000;
    ImageView img, dot;
    LinearLayout linear;
    Point[] point;
    String source, destination;
    PointF topRight,topLeft,bottomRight,bottomLeft;
    private Button submit;
    Canvas canvas;
    int position;
    String key;
    int width,height;
    String pos;
    WifiFinder wifi;
    ImageView image;
    public static WifiManager wifiManager;
    Bitmap scaledBitmapBack;
    Bitmap scaledBitmapFore;
    private LinearLayout.LayoutParams layoutParams ;
    private Bitmap scaleBitmapFloor2;
    int flag;
    private Button next;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);


        Bundle b = getIntent().getExtras();
        flag = b.getInt("flag");
        destination = b.getString("destination");
        if (flag == 0){
            source = b.getString("source");
            Log.e("MAPVIEW" ,"hello hello hello hello how r u "+source);
        }

        if(flag==1){
            Log.e("MapView 2","hello im in next image");
            position = b.getInt("position");
            Log.e("MapView 2","position  =  "+position);
            point = new Point[position];
            for (int i = 0; i < position; i++) {
                point[i] = (Point) getIntent().getSerializableExtra("Editing" + i);
            }
        }

        linear = (LinearLayout) findViewById(R.id.linear);
        //  text= (TextView)findViewById(R.id.text);
        image = (ImageView) findViewById(R.id.imageView1);
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(this);
        image.setOnTouchListener(new View.OnTouchListener() {
            private float dx; // postTranslate X distance
            private float dy; // postTranslate Y distance
            private float[] matrixValues = new float[9];

            DisplayMetrics displaymetrics = new DisplayMetrics();
            int screenHeight = displaymetrics.heightPixels;
            int screenWidth = displaymetrics.widthPixels;
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                ImageView view = (ImageView) v;
                view.setScaleType(ImageView.ScaleType.MATRIX);
                //System.out.println("matrix=" + savedMatrix.toString());
                float scale;

                dumpEvent(event);
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:

                        savedMatrix.set(matrix);
                        startPoint.set(event.getX(), event.getY());
                        mode = DRAG;
                        Log.e("Map View", "i m using action Down");
                        break;
                   // case MotionEvent.ACTION_RIGHT:
                    case MotionEvent.ACTION_POINTER_DOWN:

                        oldDist = spacing(event);

                        if (oldDist > 10f) {
                            savedMatrix.set(matrix);
                            midPoint(midPoint, event);
                            Log.e("Map View", "i m using ACTION_POINTER_DOWN");
                            mode = ZOOM;
                        }
                        break;

                    case MotionEvent.ACTION_UP:

                    case MotionEvent.ACTION_POINTER_UP:
                        mode = NONE;

                        break;

                    case MotionEvent.ACTION_MOVE:
                        if (mode == DRAG) {
//

                            matrix.set(savedMatrix);
                            matrix.postTranslate(event.getX() - startPoint.x,
                                    event.getY() - startPoint.y);
                            Log.e("Map View", "i m using ACTION_MOVE = DRAG");

                        } else if (mode == ZOOM) {
                            float newDist = spacing(event);
                            if (newDist > 10f) {
                                matrix.set(savedMatrix);
                                scale = newDist / oldDist;
                                matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                            }
                            Log.e("Map View", "i m using ACTION_Move = ZOOM");
                        }
                        break;

                }
//                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                view.setLayoutParams(params);
                view.setImageMatrix(matrix);

                return true;
            }

           // @SuppressLint("FloatMath")
            private float spacing(MotionEvent event) {
                float x = event.getX(0) - event.getX(1);
                float y = event.getY(0) - event.getY(1);
                return FloatMath.sqrt(x * x + y * y);
            }



            private void midPoint(PointF point, MotionEvent event) {
                float x = event.getX(0) + event.getX(1);
                float y = event.getY(0) + event.getY(1);
                point.set(x / 2, y / 2);
            }
            private void dumpEvent(MotionEvent event)
            {
                String names[] = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE","POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
                StringBuilder sb = new StringBuilder();
                int action = event.getAction();
                int actionCode = action & MotionEvent.ACTION_MASK;
                sb.append("event ACTION_").append(names[actionCode]);

                if (actionCode == MotionEvent.ACTION_POINTER_DOWN || actionCode == MotionEvent.ACTION_POINTER_UP)
                {
                    sb.append("(pid ").append(action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
                    sb.append(")");
                }

                sb.append("[");
                for (int i = 0; i < event.getPointerCount(); i++)
                {
                    sb.append("#").append(i);
                    sb.append("(pid ").append(event.getPointerId(i));
                    sb.append(")=").append((int) event.getX(i));
                    sb.append(",").append((int) event.getY(i));
                    if (i + 1 < event.getPointerCount())
                        sb.append(";");
                }

                sb.append("]");
                Log.d("Touch Events ---------", sb.toString());
            }

        });

        if(flag==0) {
            Algorithm algorithm = new Algorithm();
            point = algorithm.algo(source, destination);
        }


        Drawable drawableFore = getResources().getDrawable(R.drawable.dot);
        // drawableFore.setBounds(200,300,0,0);

        Log.e("Map View","floor num of source "+point[point.length-1].z);
        Drawable drawableBack;
        if(point[point.length-1].z==0)
            drawableBack = getResources().getDrawable(R.drawable.ground_floor);
        else
            drawableBack = getResources().getDrawable(R.drawable.a1);

        Bitmap bitmapFore = ((BitmapDrawable) drawableFore).getBitmap();
        Bitmap bitmapBack = ((BitmapDrawable) drawableBack).getBitmap();


        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();

        scaledBitmapFore= Bitmap.createScaledBitmap(bitmapFore, 14, 14, true);
        // scaledBitmapFore.setPixel(200,300,0);
        scaledBitmapBack= Bitmap.createScaledBitmap(bitmapBack, width, height, true);



        Log.e("Map View"," Hello how r u");
        Log.e("Map View ","number of points "+point.length);
        for(int i=0 ; i<point.length;i++){

            Log.e("MapView"," Checking points  "+point[i].p);
        }
        Bitmap combineImages = overlay(scaledBitmapFore, 0, 0);

        image.setImageBitmap(combineImages);
        Thread t = new Thread(separateThread);
        t.start();
        }
//    }


    private void updateUI() {
        for(int i=0;;i++) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wifi = new WifiFinder();
            wifiManager = (WifiManager) getSystemService(Service.WIFI_SERVICE);
            String pos = wifi.getPosition(this);
            Message msg = new Message();
            Bundle b = new Bundle();
            b.putString("pos", pos);
            b.putInt("i", 1);
            msg.setData(b);
            handler.sendMessage(msg);
        }
//        long endTime = System.currentTimeMillis() + 5 * 1000;
//        while (System.currentTimeMillis() < endTime) {
//            String time = getTime();
//            Message msg = new Message();
//            Bundle b = new Bundle();
//            b.putString("timeKey", time);
//            msg.setData(b);
//            handler.sendMessage(msg);
//            Log.d(TAG, "time " + time);
//
//        }
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle b = msg.getData();
            key = b.getString("pos");
            int j  = b.getInt("i");
            int i;
            if(!key.equals(("none"))){
                Point[] location;
                List list = new List();
                location = list.entry();
                int size= location.length;
                for( i=0;i<size;i++){
                    if(location[i].p.equals(key)){
                        Log.e("Map View", "i m insode the point view");
                       // if(j==1)
                            changeColor(canvas, location[i].x, location[i].y, R.drawable.currentlocation,key);

                }
                }
                Toast.makeText(getApplicationContext(),"You are at "+ key,Toast.LENGTH_SHORT).show();


        }
        }



    };

    private Runnable separateThread = new Runnable() {
        @Override
        public void run() {

            updateUI();
        }

    };

    private Runnable updateThread = new Runnable() {
        @Override
        public void run() {
            try {

                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg = new Message();
            Bundle b = new Bundle();
            b.putString("pos", pos);
            b.putInt("i", 0);
            msg.setData(b);
            handler.sendMessage(msg);
        }
    };
    private void changeColor(Canvas canvas, int x, int y, int redDot,String key) {
        Paint paint = new Paint();
        paint.setTextSize(40);
        paint.setColor(Color.RED);
        //Bitmap olderbitmap  =  bmOverlay;
        Drawable drawableFore1 = getResources().getDrawable(redDot);

        Bitmap bitmapFore1 = ((BitmapDrawable) drawableFore1).getBitmap();
        Bitmap scaledBitmapFore;
//        if(a==1)
//            scaledBitmapFore = Bitmap.createScaledBitmap(bitmapFore, 20, 20, true);
//        else
            scaledBitmapFore = Bitmap.createScaledBitmap(bitmapFore1, 40, 40, true);
        int x1 = (int) (((float) x / 1040) * width);
        int y1 = (int) (((float)y / 3196) * height);

        //canvas.drawBitmap(scaledBitmapFore, x1, y1, null);
        Log.e("Map View","hello i m in change Color");
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);

        Bitmap combineImages;

            combineImages= overlay(scaledBitmapFore,x1,y1);
//        else
//            combineImages = overlay( scaledBitmapFore,0,0);
        //canvas.drawBitmap(scaledBitmapFore, x1, y1, null);
        image.setImageBitmap(combineImages);
//        if(a==1){
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Message msg = new Message();
//        Bundle b = new Bundle();
//        b.putString("pos", key);
//        b.putInt("i", 0);
//        msg.setData(b);
//        handler.sendMessage(msg);

//        Thread t = new Thread(updateThread, key);
//
//        t.start();
       // }
//            try {
//                sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Bitmap scaledBitmapForeBlack = Bitmap.createScaledBitmap(bitmapForeBlack,10,10,true);
//            canvas.drawBitmap(scaledBitmapForeBlack, x1, y1, null);
//            image.setImageBitmap(bmOverlay);

    }






    public Bitmap overlay(Bitmap bmp2, int rx, int ry)
    {
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        try
        {

            bmOverlay= Bitmap.createBitmap(width, height, scaledBitmapBack.getConfig());
            canvas = new Canvas(bmOverlay);
            canvas.drawBitmap(scaledBitmapBack, new Matrix(), null);
            int l= point.length;
            Log.e("Map view",point[l-1].p);
            int i=l-1;
            int floorNo = point[l-1].z;
            Log.e("MAP VIEW ", "floor num issssssssssssss               "+floorNo);
//            if (point[l-1].z==0) {
            int imageHeight,imageWidth;
            if(floorNo==0){
                Log.e("Map View ","hello i m in floor no 0");
                imageWidth= 1040;
                imageHeight = 3196;
            }
            else
            {
                imageHeight=977;
                imageWidth = 299 ;
            }
//            int x= point[0].x;
//            int y= point[0].y;   1040,3196
                int x1 = (int) (((float) point[l - 1].x / imageWidth) * width);
                int y1 = (int) (((float) point[l - 1].y / imageHeight) * height);
                int x2, y2;
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);

                Log.e("MapView","x1="+x1+"y1+"+y1+"rx= "+rx+"ry="+ry);
                paint.setTextSize((float) 25.0);
                if(rx==x1 && ry==y1) {

                    canvas.drawBitmap(bmp2, x1-22, y1-15, null);
                }
//                else
//                    canvas.drawBitmap(bmp2, x1, y1, null);

//              Log.e("Map View ","hello")


                canvas.drawText("Source",x1,y1-10,paint);
                System.out.println(point[0].p + "   " + x1 + "  " + y1);
                Log.e("Map View", point[1].p + "  " + point[1].z);
                for (i = l-2; i >=0  ; i--) {
                    if(floorNo==point[i].z) {
                        x2 = (int) (((float) point[i].x / imageWidth) * width);
                        y2 = (int) (((float) point[i].y / imageHeight) * height);
                        System.out.println(point[i].p + "  " + point[i].x + "  " + point[i].y);
                        if (rx == x2 && ry == y2) {
                            canvas.drawBitmap(bmp2, x2 - 60, y2, null);
                        }
//                    else
//                        canvas.drawBitmap(, x2, y2, null);
                        Bitmap scaledBitmapDest;
                        paint.setColor(Color.BLUE);
                        paint.setStrokeWidth((float) 4.0);
                        canvas.drawLine(x1, y1, x2, y2, paint);
                        if (point[i].p.equalsIgnoreCase(destination)) {
                            Drawable drawableDest = getResources().getDrawable(R.drawable.destination);
                            Bitmap bitmapDest = ((BitmapDrawable) drawableDest).getBitmap();
                            scaledBitmapDest = Bitmap.createScaledBitmap(bitmapDest, 60, 60, true);
                            canvas.drawBitmap(scaledBitmapDest, x2 - 30, y2 - 44, null);
                        }

                        x1 = x2;
                        y1 = y2;
                    }
                   if(floorNo!=point[i].z)
                   {
                       Log.e("Map View ", "checking floor num " + point[i].p + "   " + point[i].z);
                       change=1;
                       position =i;
                       break;
                   }
               }
                if(change==0) {
                    paint.setStrokeWidth((float) 10.00);
                    paint.setColor(Color.BLACK);
                    paint.setTextSize((float) 25.0);
                    canvas.drawText("Destination", x1, y1 - 10, paint);
                }



            return bmOverlay;
        } catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onClick(View v) {
        Log.e("Map View","hello i m before if");
        if(change ==1){
            Log.e("Map View","hello i m inside if");
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Log.e("MapView", point[position-1].p);
            Intent i = new Intent(this, MapView.class);
            i.putExtra("flag",1);
            i.putExtra("position",position+1);
            for(int j=0;j<=position+1;j++) {
                i.putExtra("Editing"+j, point[j]);
            }
            i.putExtra("destination",destination);
            startActivity(i);
        }
    }



}
