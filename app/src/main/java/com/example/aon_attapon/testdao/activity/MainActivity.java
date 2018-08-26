package com.example.aon_attapon.testdao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aon_attapon.testdao.R;
import com.example.aon_attapon.testdao.adapter.CarPositionListAdapter;
import com.example.aon_attapon.testdao.dao.carPositionCollection;
import com.example.aon_attapon.testdao.manager.CarPositionListManager;
import com.example.aon_attapon.testdao.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listViewCarPosition;
    CarPositionListAdapter listAdapter;
    CarPositionListManager carPositionListManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        listViewCarPosition = (ListView) findViewById(R.id.listView);
        listAdapter = new CarPositionListAdapter();
        listViewCarPosition.setAdapter(listAdapter);

        Call<carPositionCollection> call = HttpManager.getInstance()
                .getService()
                .getHistoryPositions("u6d4sik5bGumxojdZbOWXte36wSyU7og");
        call.enqueue(new Callback<carPositionCollection>() {
            @Override
            public void onResponse(Call<carPositionCollection> call, Response<carPositionCollection> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    carPositionCollection dao = response.body();
//                    carPositionListManager.setDao(dao);
//                    listAdapter.setDao(carPositionListManager.getDao());
                    listAdapter.setDao(dao);
                    listAdapter.notifyDataSetChanged();

//                    carPositionCollection carCollection = response.body();
//                    listViewCarPosition.setAdapter(new CarPositionListAdapter(MainActivity.this, carCollection));
                }
            }
            @Override
            public void onFailure(Call<carPositionCollection> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("TAGGGGGGGG","Pass this line error message is "+t);
            }
        });

    }
}
