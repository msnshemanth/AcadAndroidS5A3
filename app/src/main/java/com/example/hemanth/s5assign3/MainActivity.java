package com.example.hemanth.s5assign3;

import android.content.ClipData;
import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lview;
    ListAdapter lviewAdapter;

    private final static String name[] = {"Hemanth", "Thraitha", "Krishna", "Dilip", "Vishnu",
    };

    private final static String number[] = {"9988778877", "9988778874", "9988778844",
            "7988778877", "9968778877"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lview = (ListView) findViewById(R.id.list1);
        lviewAdapter = new ListAdapter(this, name, number);
        System.out.println("adapter => " + lviewAdapter.getCount());

        lview.setAdapter(lviewAdapter);
        //lview.setOnClickListener(this);
        registerForContextMenu(lview);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle()== "Call"){
            Toast.makeText(this,"Calling Code",Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle()=="SMS")
        {
            Toast.makeText(this,"Sending Sms Code",Toast.LENGTH_SHORT).show();
        }
        else
        {
            return false;
        }

        return super.onContextItemSelected(item);
    }
}
