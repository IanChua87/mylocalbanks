package sg.edu.rp.c346.id22024905.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    private boolean favoriteDBS = false;
    private boolean favoriteOCBC = false;
    private boolean favoriteUOB = false;
    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");

        if(v == tvDBS){
            wordClicked = "DBS";
        } else if(v == tvOCBC){
            wordClicked = "OCBC";
        } else{
            wordClicked = "UOB";
        }
    }
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                String url = "https://www.dbs.com.sg";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+18001111111L));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            } else{
                favoriteDBS = true;
                setFavouriteBank(tvDBS, favoriteDBS);

                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                String url = "https://www.ocbc.com";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+18003633333L));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            } else{
                favoriteOCBC = true;
                setFavouriteBank(tvOCBC, favoriteOCBC);

                return true;
            }
        } else {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                String url = "https://www.uob.com.sg";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            } else{
                favoriteUOB = true;
                setFavouriteBank(tvUOB, favoriteUOB);
                return true;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            setLocale("en");
            return true;
        } else if (id == R.id.ChineseSelection) {
            setLocale("zh");
            return true;
        } else{
            setLocale("th");
        }

        return super.onOptionsItemSelected(item);
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        tvDBS.setText(R.string.d_bs);
        tvOCBC.setText(R.string.o_cbc);
        tvUOB.setText(R.string.u_ob);
    }

    private void setFavouriteBank(TextView bankTextView, boolean favouriteBank) {
        int color;
        if (favouriteBank) {
            color = ContextCompat.getColor(this, R.color.red);
        } else {
            color = ContextCompat.getColor(this, R.color.black);
        }
        bankTextView.setTextColor(color);
    }
}