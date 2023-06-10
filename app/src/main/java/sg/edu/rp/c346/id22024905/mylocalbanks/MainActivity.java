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
                favoriteDBS = !favoriteDBS;
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
                favoriteOCBC = !favoriteOCBC ;
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
                favoriteUOB = !favoriteUOB;
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
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("大华银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("星展银行");
            return true;
        } else{
            tvDBS.setText("ธนาคารยูโอบี");
            tvOCBC.setText("สกอ");
            tvUOB.setText("ทบ");
        }

        return super.onOptionsItemSelected(item);
    }



    private void setFavouriteBank(TextView bankTextView, boolean favouriteBank) {
        int color;
        if (favouriteBank) {
            color = ContextCompat.getColor(this, R.color.red);
        } else {
            color = ContextCompat.getColor(this, R.color.lime);
        }
        bankTextView.setTextColor(color);
    }
}