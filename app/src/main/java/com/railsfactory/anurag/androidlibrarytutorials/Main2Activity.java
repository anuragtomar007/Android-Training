package com.railsfactory.anurag.androidlibrarytutorials;

import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout relativeLayout;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = (Spinner) findViewById(R.id.spinner);
        relativeLayout = (RelativeLayout) findViewById(R.id.ParentLayout);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                if (position == 0) {
                    relativeLayout.setBackgroundResource(android.R.color.white);
                } else if (position == 1) {
                    relativeLayout.setBackgroundResource(R.drawable.virat);
                    Toast.makeText(getApplicationContext(), "Selected Sportsman : " + selectedItemText, Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    relativeLayout.setBackgroundResource(R.drawable.cr7);
                    Toast.makeText(getApplicationContext(), "Selected Sportsman : " + selectedItemText, Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    relativeLayout.setBackgroundResource(R.drawable.roger);
                    Toast.makeText(getApplicationContext(), "Selected Sportsman : " + selectedItemText, Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    relativeLayout.setBackgroundResource(R.drawable.lebron);
                    Toast.makeText(getApplicationContext(), "Selected Sportsman : " + selectedItemText, Toast.LENGTH_SHORT).show();
                }
                View v = spinner.getSelectedView();
                ((TextView) v).setTextColor(getResources().getColor(R.color.colorAccent));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Main2Activity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDagger:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.btnRetrofit:
                Intent intent1 = new Intent(this, MainActivity_retrofit.class);
                startActivity(intent1);
                break;

            case R.id.btnOtto:
                Intent intent2 = new Intent(this, MainActivity_Otto.class);
                startActivity(intent2);
                break;

            case R.id.btnImplicitIntent:
                Intent intent3 = new Intent(Intent.ACTION_SEND);
                intent3.setType("text/plain");
                intent3.putExtra(Intent.EXTRA_TEXT, "My name is Anurag");
                intent3.putExtra(Intent.EXTRA_SUBJECT, "Implicit Intent");
                Intent intent4 = Intent.createChooser(intent3, "Anurag created Chooser");
                startActivity(intent4);
                break;

            case R.id.btnWebSearch:
                Intent intent5 = new Intent(Intent.ACTION_WEB_SEARCH);
                intent5.putExtra(SearchManager.QUERY, "https://www.railsfactory.com/");
                startActivity(intent5);
                break;

            case R.id.btnCamera:
                Intent intent6 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent6);
                break;

            case R.id.btnWhatsapp:
                PackageManager pm = getPackageManager();
                try {
                    Intent waIntent = new Intent(Intent.ACTION_SEND);
                    waIntent.setType("text/plain");
                    String text = "Checking Opening Whatsapp";
                    PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    waIntent.setPackage("com.whatsapp");
                    waIntent.putExtra(Intent.EXTRA_TEXT, text);
                    startActivity(waIntent);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                            .show();
                }
                break;

            case R.id.btnContacts:
                Intent intents = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivity(intents);
                break;

            case R.id.btnActivity:
                Intent intentA = new Intent(this, Main3Activity.class);
                startActivity(intentA);
                break;

            case R.id.btnCheckRetrofit:
                Intent intentC = new Intent(this, MainActivity_CheckRetrofit.class);
                startActivity(intentC);
                break;
        }
    }
}