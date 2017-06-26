package ru.popov.bodya.navdrawerdemo;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationListAdapter.OnItemClickListener{

    private DrawerLayout navDrawer;
    private RecyclerView navList;
    private TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResourcesStorage resourcesStorage = ((ModelProvider) getApplication()).getResourcesStorage();

        navDrawer = (DrawerLayout) findViewById(R.id.nvd_act_main);
        NavigationListAdapter adapter = new NavigationListAdapter(this, resourcesStorage.getIcons(), resourcesStorage.getLabels());
        adapter.setOnClickListener(this);

        navList = (RecyclerView) findViewById(R.id.nav_drawer_recycler_view);
        navList.setAdapter(adapter);

        title = (TextView) findViewById(R.id.main_content_text_view);

    }

    @Override
    public void onNavigationItemClick(int position) {
        switch (position) {
            case 0:
                title.setText(getString(R.string.dashboard_activity));
                break;
            case 1:
                title.setText(getString(R.string.android_activity));
                break;
            case 2:
                title.setText(getString(R.string.preferences_activity));
                break;
        }
    }
}
