package com.example.piyush.indoornevigateion.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.piyush.indoornevigateion.R;

/**
 * Created by Piyush on 15-03-2015.
 */
public class ImageRetrieve extends Activity {

    ImageView img, dot;
    LinearLayout linear;
    PointF topRight,topLeft,bottomRight,bottomLeft;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageretrieve);

     /*  img=(ImageView)findViewById(R.id.imageView);
        linear = (LinearLayout)findViewById(R.id.linear);

       /* DBConnection db = new DBConnection();
        String result= db.setupConnection("getimage.php");

        try {
            Log.e("immage error","hello 1");
            JSONArray jArray = new JSONArray(result);
            Log.e("immage error","hello");
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Log.e("image error","json_data");
                String imageurl=json_data.getString("image");
                Log.e("image error","image url");
                Bitmap bitmap = GetBitmapfromUrl(imageurl);
                Log.e("image url",imageurl);

                img.setImageBitmap(bitmap);
                dot=new ImageView(ImageRetrieve.this);
                Resources res = getResources();

                Log.e("image ", "dot set");
                LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                //params.setMargins(200,300, 0,0);
                dot.setLayoutParams(params);
                Log.e("image","dot set pramameters");
                Drawable recycle_bin;

                recycle_bin = res.getDrawable(R.drawable.submit);
               // recycle_bin.setBounds(200,400,60,80);
                dot.setImageDrawable(recycle_bin);
                dot.setVisibility(View.VISIBLE);
                int id = generateViewId();
                dot.setId(id);


                linear.addView(dot);


                Log.e("image","dot add view  "+id);
                topLeft = getTopLeftCorner(dot);
                topRight = getTopRightCorner(dot);
                bottomLeft = getBottomLeftCorner(dot);
                bottomRight = getBottomRightCorner(dot);
                Log.e("topleft  ",topLeft.toString());
                Log.e("topRight  ",topRight.toString());
                Log.e("bottomLeft  ",bottomLeft.toString());
                Log.e("bottomright", bottomRight.toString());
        int pos[] = new int[2];
        img.getLocationOnScreen(pos);
        Log.e("points", pos[0] + "  " + pos[1]);
            }
       /* }catch(Exception e){
             e.printStackTrace();
        }

       public static PointF getTopLeftCorner(View view) {
           float src[] = new float[8];
           float[] dst = new float[]{0, 0, view.getWidth(), 0, 0, view.getHeight(), view.getWidth(), view.getHeight()};
           view.getMatrix().mapPoints(src, dst);
           PointF cornerPoint = new PointF(view.getX() + src[0], view.getY() + src[1]);
           return cornerPoint;
       }


    public static PointF getTopRightCorner(View view) {
        float src[] = new float[8];
        float[] dst = new float[]{0, 0, view.getWidth(), 0, 0, view.getHeight(), view.getWidth(), view.getHeight()};
        view.getMatrix().mapPoints(src, dst);
        PointF cornerPoint = new PointF(view.getX() + src[2], view.getY() + src[3]);
        return cornerPoint;
    }

    public static PointF getBottomLeftCorner(View view) {
        float src[] = new float[8];
        float[] dst = new float[]{0, 0, view.getWidth(), 0, 0, view.getHeight(), view.getWidth(), view.getHeight()};
        view.getMatrix().mapPoints(src, dst);
        PointF cornerPoint = new PointF(view.getX() + src[4], view.getY() + src[5]);
        return cornerPoint;
    }

    public static PointF getBottomRightCorner(View view) {
        float src[] = new float[8];
        float[] dst = new float[]{0, 0, view.getWidth(), 0, 0, view.getHeight(), view.getWidth(), view.getHeight()};
        view.getMatrix().mapPoints(src, dst);
        PointF cornerPoint = new PointF(view.getX() + src[6], view.getY() + src[7]);
        return cornerPoint;
    }

    public Bitmap GetBitmapfromUrl(String scr) {
        try {
            URL url = new URL(scr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bmp = BitmapFactory.decodeStream(input);
            return bmp;


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }*/


/*

getting correct output for 1 image.


        linear =(LinearLayout)findViewById(R.id.linear);
        Drawable back = getResources().getDrawable(R.drawable.floor_plan);
        linear.setBackground(back);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        Log.e("image Retrieve", "width and height are   "+width + "  "+height);
        int x1=(int)(((float)219/274)*width);
        int y1 = (int)(((float)123/467)*height);
        Log.e("image Retrieve", "width and height are   "+x1 + "  "+y1);

        int x2 = (int)(((float)127/274)*width);
        int y2 = (int)(((float)375/467)*height);


        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.dot);
        Log.e("image Retrieve", "set Image Resource");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
       params.setMargins(x1,y1,0,0);
        Log.e("image Retrieve", "set image params");
        iv.setLayoutParams(params);
        Log.e("image Retrieve", "set layout params");
        iv.setVisibility(View.VISIBLE);
        Log.e("image Retrieve", "set visible");
        iv.setId(View.generateViewId());

       // params.topMargin=y2;
       // params.leftMargin=x2;
        ImageView dot = new ImageView(this);
        dot.setImageResource(R.drawable.dot1);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(10, 10);
        params1.setMargins(x2,y2,0,0);
        dot.setLayoutParams(params1);
        dot.setVisibility(View.VISIBLE);
        Log.e("image Retrieve", "width and height are   " + x2 + "  " + y2);
        dot.setId(View.generateViewId());
        linear.addView(dot);
        linear.addView(iv);
        Log.e("image Retrive", "gooood");

*/

        linear = (LinearLayout)findViewById(R.id.linear);

        ImageView image = (ImageView) findViewById(R.id.imageView1);
        Drawable drawableFore = getResources().getDrawable(R.drawable.dot);
       // drawableFore.setBounds(200,300,0,0);
        Drawable drawableBack = getResources().getDrawable(R.drawable.floor_plan);

        Bitmap bitmapFore = ((BitmapDrawable) drawableFore).getBitmap();
        Bitmap bitmapBack = ((BitmapDrawable) drawableBack).getBitmap();


        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();


        Bitmap scaledBitmapFore = Bitmap.createScaledBitmap(bitmapFore, 10, 10, true);
        Bitmap scaledBitmapFore2 = Bitmap.createScaledBitmap(bitmapFore, 10, 10, true);
       // scaledBitmapFore.setPixel(200,300,0);
        Bitmap scaledBitmapBack = Bitmap.createScaledBitmap(bitmapBack, width, height, true);

        Bitmap combineImages = overlay(scaledBitmapBack,scaledBitmapFore2, scaledBitmapFore);
        image.setImageBitmap(combineImages);
       // Bitmap combineImages1 = overlay1(scaledBitmapBack, scaledBitmapFore);

       /* LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(10,10);
        params1.setMargins(200,300,0,0);
        image.setLayoutParams(params1);

        image.setImageBitmap(combineImages);
        ImageView img1= new ImageView((this));
        img1.setImageBitmap(combineImages1);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(10,10);
        image.setLayoutParams(params1);
        linear.addView(img1);
*/
    }
        public Bitmap overlay(Bitmap bmp1,Bitmap bmp2, Bitmap bmp3)
        {
            Display display = getWindowManager().getDefaultDisplay();
            int width = display.getWidth();
            int height = display.getHeight();
            try
            {
                Bitmap bmOverlay = Bitmap.createBitmap(width, height,  bmp1.getConfig());
                Canvas canvas = new Canvas(bmOverlay);
                canvas.drawBitmap(bmp1, new Matrix(), null);
                canvas.drawBitmap(bmp2, 300, 200, null);
                canvas.drawBitmap(bmp3,200,196,null);
                canvas.drawBitmap(bmp3,600,196,null);

                Paint paint = new Paint();
                paint.setStrokeWidth((float)4.0);
                paint.setColor(Color.GREEN+10);



                canvas.drawLine(300,204,200,200,paint);
                canvas.drawLine(600,200,200,200,paint);

                return bmOverlay;
            } catch (Exception e)
            {
                // TODO: handle exception
                e.printStackTrace();
                return null;
            }
        }


}
