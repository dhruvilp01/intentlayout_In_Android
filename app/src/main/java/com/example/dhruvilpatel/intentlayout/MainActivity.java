package com.example.dhruvilpatel.intentlayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Button takePic, dialAnumberButton, toastButton, showLocationButton, openWebPageButton;
    Button viewIntentButton, letsGetProButton, viaPackageManagerButton;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_layout);


        imageView = (ImageView) findViewById(R.id.imageDisplay);

        takePic = (Button) findViewById(R.id.takePhoto);
        dialAnumberButton = (Button) findViewById(R.id.dialButton);
        toastButton = (Button) findViewById(R.id.toast);
        showLocationButton = (Button) findViewById(R.id.showLocation);
        openWebPageButton = (Button) findViewById(R.id.openWebPage);
        viewIntentButton = (Button) findViewById(R.id.viewIntent);
        letsGetProButton = (Button) findViewById(R.id.letsgetpro);
        viaPackageManagerButton = (Button) findViewById(R.id.viaPackageManager);


        takePic.setOnClickListener(this);
        dialAnumberButton.setOnClickListener(this);
        toastButton.setOnClickListener(this);
        showLocationButton.setOnClickListener(this);
        openWebPageButton.setOnClickListener(this);
        viewIntentButton.setOnClickListener(this);
        letsGetProButton.setOnClickListener(this);
        viaPackageManagerButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.takePhoto:

                dispatchTakePictureIntent();

                break;

            case R.id.dialButton:

                DialButton();

                break;

            case R.id.toast:

                Toasta();

                break;

            case R.id.showLocation:

                ShowLocation();

                break;

            case R.id.openWebPage:

                OpenWebPage();

                break;

            case R.id.viewIntent:

                ViewIntent();

                break;

            case R.id.letsgetpro:

                LetsGetPro();

                break;

            case R.id.viaPackageManager:
                ViaPackageManager();

                break;

        }
        ;

    }

    private void dispatchTakePictureIntent() {

        // Media Intent ...
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private void ViaPackageManager() {
    }

    private void LetsGetPro() {
    }

    private void ViewIntent() {

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("mystreamer:"+"Play Song mysong.mp3"));
        intent.putExtra("FROM","\n This is from Yahoo..");
        startActivity(intent);
    }

    private void OpenWebPage() {

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.yahoo.com"));
        startActivity(intent);
    }

    private void Toasta() {

        Toast.makeText(this, "You clicked on Toast Button",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent("intent.marlabs.com.springintent.otherActivity");
        startActivity(intent);
    }

    private void ShowLocation() {

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:12.9778791,77.590441"));
        startActivity(intent);
    }

    private void DialButton() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
        startActivity(intent);
    }

}