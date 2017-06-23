package ru.popov.bodya.filterablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Based on <a href="https://github.com/filippella/FilterableRecyclerViewAdapter"/>
 */


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText searchEditText;
    private CheeseAdapter cheeseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        configRecyclerVIew();
        addListenerToSearchEditText();

    }

    private void addListenerToSearchEditText() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                cheeseAdapter.filter(s.toString());
            }
        });
    }

    private void configRecyclerVIew() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        cheeseAdapter = new CheeseAdapter();
        recyclerView.setAdapter(cheeseAdapter);
    }

    private void initViews() {
        searchEditText = (EditText) findViewById(R.id.search_field);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }


}
