package search_flight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.se104.R;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchByFlightActivity extends AppCompatActivity {

    ListView search_id;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_flight);
        SearchView searchView = findViewById(R.id.searchView);
        search_id = (ListView) findViewById(R.id.list_id);
        ArrayList <String> array_id = new ArrayList<>();
        array_id.addAll(Arrays.asList(getResources().getStringArray(R.array.flight_id)));

        adapter = new ArrayAdapter<>(
                SearchByFlightActivity.this,
                android.R.layout.simple_list_item_1,
                array_id
        );
        search_id.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }


        });
    }



}