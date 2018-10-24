package com.example.user.testapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static java.lang.System.out;

public class ReportActivity_manager extends Fragment {


    DataAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String data;

        ArrayList<DataFormat> return_ifno = new ArrayList<>();
        return_ifno.add(new DataFormat("홍길동1","010-111-111", "1시", "이상무", 1, 1) );
        return_ifno.add(new DataFormat("홍길동2","010-222-222", "2시", "이상무", 2, 2) );
        return_ifno.add(new DataFormat("홍길동3","010-333-333", "3시", "이상무", 3, 3) );
        return_ifno.add(new DataFormat("홍길동4","010-444-444", "4시", "이상무", 4, 4) );

        //set up the RecyclerView
        View v = inflater.inflate(R.layout.activity_report_manager, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        adapter = new DataAdapter(return_ifno);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        //set up map image
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView1);


        Bitmap image_map = BitmapFactory.decodeResource(getResources(), R.mipmap.sample_map);
        Bitmap imgae_pin = BitmapFactory.decodeResource(getResources(), R.mipmap.pin);

        Bitmap bmpImages = overlayBitmap(image_map, imgae_pin);
        imageView.setImageBitmap(bmpImages);

        return v;
    }

    public static Bitmap overlayBitmap(Bitmap bitmapBackground, Bitmap bitmapImage) {

        int bitmap1Width = bitmapBackground.getWidth();
        int bitmap1Height = bitmapBackground.getHeight();
        int bitmap2Width = bitmapImage.getWidth();
        int bitmap2Height = bitmapImage.getHeight();

        float marginLeft = (float) (bitmap1Width * 0.5 - bitmap2Width * 0.5);
        float marginTop = (float) (bitmap1Height * 0.5 - bitmap2Height * 0.5);

        Bitmap overlayBitmap = Bitmap.createBitmap(bitmap1Width, bitmap1Height, bitmapBackground.getConfig());
        Canvas canvas = new Canvas(overlayBitmap);
        canvas.drawBitmap(bitmapBackground, new Matrix(), null);
        canvas.drawBitmap(bitmapImage, marginLeft, marginTop, null);

        return overlayBitmap;
    }

    public void set_Date(ArrayList<String> return_number) {
        TextView textview1 = (TextView) getView().findViewById(R.id.return_number1);  //UPDATE
        textview1.setText(return_number.indexOf(0));
        TextView textview2 = (TextView) getView().findViewById(R.id.return_number1);  //UPDATE
        textview2.setText(return_number.indexOf(1));
        TextView textview3 = (TextView) getView().findViewById(R.id.return_number1);  //UPDATE
        textview3.setText(return_number.indexOf(2));
        TextView textview4 = (TextView) getView().findViewById(R.id.return_number1);  //UPDATE
        textview4.setText(return_number.indexOf(3));
        TextView textview5 = (TextView) getView().findViewById(R.id.return_number1);  //UPDATE
        textview5.setText(return_number.indexOf(4));
        TextView textview6 = (TextView) getView().findViewById(R.id.return_number1);  //UPDATE
        textview6.setText(return_number.indexOf(5));
    }

}
