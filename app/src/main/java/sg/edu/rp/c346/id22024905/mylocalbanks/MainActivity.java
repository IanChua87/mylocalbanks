package sg.edu.rp.c346.id22024905.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

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
            }
        } else {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                String url = "https://www.ocbc.com";
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentLink);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121L));
                startActivity(intentCall);
                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }
}