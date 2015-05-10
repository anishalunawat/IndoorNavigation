package com.example.piyush.indoornevigateion.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.ImageView;

import com.example.piyush.indoornevigateion.R;

import java.net.URL;

import controller.Point;

/**
 * Created by Piyush on 15-04-2015.
 */
public class NextFloors extends Activity {

    int i, position, floorNum;
    Point point[];
    ImageView image;
    Button nextFloor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextfloor);

        image= (ImageView)findViewById(R.id.floor);
        Bundle b = getIntent().getExtras();
        floorNum = b.getInt("floorNum");
        position = b.getInt("position");
        point = new Point[position];
        for (i = 0; i < position; i++) {
            point[i] = (Point) getIntent().getSerializableExtra("Editing" + i);
        }
        //Point model = (Point) getIntent().getSerializableExtra("Editing");
        for (i = 0; i < position; i++) {
            Log.e("MapView", point[i].p);
        }
        setimage();
    }
    public Drawable getDrawable(String bitmapUrl) {
        try {
            URL url = new URL(bitmapUrl);
            Drawable d =new BitmapDrawable(BitmapFactory.decodeStream(url.openConnection().getInputStream()));
            return d;
        }
        catch(Exception ex) {return null;}
    }
    private void setimage() {

     //   InputStream path=



        Drawable drawableFore = getResources().getDrawable(R.drawable.dot);
        Drawable drawableBack = getResources().getDrawable(R.drawable.a1);




        Bitmap bitmapFore = ((BitmapDrawable) drawableFore).getBitmap();
        Bitmap bitmapBack = ((BitmapDrawable) drawableBack).getBitmap();

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();


        Bitmap scaledBitmapFore = Bitmap.createScaledBitmap(bitmapFore, 10, 10, true);
        Bitmap scaledBitmapFore2 = Bitmap.createScaledBitmap(bitmapFore, 10, 10, true);

        Bitmap scaledBitmapBack = Bitmap.createScaledBitmap(bitmapBack, width, height, true);


       Bitmap combineImages = overlay(scaledBitmapBack,  scaledBitmapFore);
        image.setImageBitmap(combineImages);
    }

   private Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {

        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        try
        {

            Bitmap bmOverlay = Bitmap.createBitmap(width, height, bmp1.getConfig());
            Canvas canvas = new Canvas(bmOverlay);
            canvas.drawBitmap(bmp1, new Matrix(), null);
            int l= point.length;
            Log.e("Map view",point[l-1].p);
            int i=l-1;

//            int x= point[0].x;
//            int y= point[0].y;   1040,3196
                int x1 = (int) (((float) point[l-1].x / 1040) * width);
                int y1 = (int) (((float) point[l-1].y / 3196) * height);
                int x2, y2;
//              Log.e("Map View ","hello")
                Paint paint = new Paint();
                paint.setStrokeWidth((float) 4.0);
                paint.setColor(Color.GREEN + 10);
                canvas.drawBitmap(bmp2, x1, y1, null);
                System.out.println(point[0].p + "   " + x1 + "  " + y1);
                Log.e("Map View", point[1].p + "  " + point[1].z);
                for (i = l-2; i >=0 ; i--) {

                    x2 = (int) (((float) point[i].x / 1040) * width);
                    y2 = (int) (((float) point[i].y / 3196) * height);
                    System.out.println(point[i].p + "  " + point[i].x + "  " + point[i].y);
                    canvas.drawBitmap(bmp2, x2, y2, null);
                    canvas.drawLine(x1, y1, x2, y2, paint);
                    x1 = x2;
                    y1 = y2;

                }


            if(i!=0){
                position = i;
            }
            return bmOverlay;
        } catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

}





