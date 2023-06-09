package flight_listview;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.se104.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Contact> list;
    int index;
    ActivityResultLauncher<Intent> launcher;
    ActivityResultLauncher<Intent> launcherEdit;
    Adaptor myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_chooosen);
        // registerForContextMenu(listView);
        listView = findViewById(R.id.listView);

        list = new ArrayList<>();
        list.add(new Contact("Anh"));
        list.add(new Contact("Binh"));
        list.add(new Contact("Dinh"));

        myAdapter = new Adaptor(MainActivity.this, R.layout.item_flight_listview, list);
        listView.setAdapter(myAdapter);

//        launcher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == Activity.RESULT_OK) {
//                            Intent intent = result.getData();
//                            String Name = intent.getStringExtra("Name");
//
//                            Log.d("MainActivity", "Name: " + Name);
//                            myAdapter.notifyDataSetChanged();
//                            //Toast.makeText(getApplicationContext(), dataClassList.size(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//        );
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        launcherEdit = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if(result.getResultCode() == Activity.RESULT_OK) {
//                            Intent intent = result.getData();
//                            String Name = intent.getStringExtra("Name");
//                            Log.d("MainActivity", "Name: " + Name);
//
//                            list.set(index, new Contact(Name));
//                            myAdapter.notifyDataSetChanged();
//                        }
//                    }
//                }
//        );
        listView.setOnItemClickListener(new Adaptor());
        registerForContextMenu(listView);
    }

}