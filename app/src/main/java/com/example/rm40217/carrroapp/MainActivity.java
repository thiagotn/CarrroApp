package com.example.rm40217.carrroapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.rm40217.carrroapp.adapter.TabsAdapter;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager Pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(R.string.tbClassicos));
        tabs.addTab(tabs.newTab().setText(R.string.tbEsportivo));
        tabs.addTab(tabs.newTab().setText(R.string.tbLuxuosos));

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        Pager = (ViewPager) findViewById(R.id.pager);


        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        Pager.setAdapter(tabsAdapter);

        Pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.mn_cadastrar:
                Toast.makeText(this, "Cadastrar", Toast.LENGTH_LONG).show();
                break;
            case R.id.mn_configuracao:
                Toast.makeText(this, "Configurações", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);

    }
}
