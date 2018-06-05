package cn.cibntv.ott.layoutmanagerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import cn.cibntv.ott.lib.layoutmanager.CarouselLayoutManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarouselLayoutManager carouselLayoutManager;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        adapter = new DataAdapter();
        recyclerView.setAdapter(adapter);
        carouselLayoutManager = new CarouselLayoutManager(this, Util.Dp2px(this, 260));
        recyclerView.setMAX_SCROLL_DURATION(300);
        recyclerView.setLayoutManager(carouselLayoutManager);
    }
}
