package com.renthut.laba5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CircleAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Circle> list = Arrays.asList(
                new Circle(58, R.color.blue),
                new Circle(65, R.color.green),
                new Circle(75, R.color.orange),
                new Circle(23, R.color.purple),
                new Circle(12, R.color.red),
                new Circle(53, R.color.cyan),
                new Circle(75, R.color.green),
                new Circle(78, R.color.purple),
                new Circle(53, R.color.cyan),
                new Circle(21, R.color.red),
                new Circle(43, R.color.orange),
                new Circle(99, R.color.blue),
                new Circle(80, R.color.purple),
                new Circle(1, R.color.green),
                new Circle(42, R.color.orange),
                new Circle(37, R.color.blue),
                new Circle(15, R.color.green),
                new Circle(6, R.color.orange),
                new Circle(73, R.color.purple),
                new Circle(82, R.color.red),
                new Circle(9, R.color.cyan),
                new Circle(16, R.color.green),
                new Circle(93, R.color.purple),
                new Circle(90, R.color.cyan),
                new Circle(67, R.color.red),
                new Circle(41, R.color.orange),
                new Circle(88, R.color.blue),
                new Circle(13, R.color.purple),
                new Circle(2, R.color.green),
                new Circle(39, R.color.orange)
        );

        RecyclerView recyclerView = findViewById(R.id.number_list);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);

        recyclerView.setAdapter(new CircleAdapter(list, this));
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClicked(String number) {
        InfoDialog infoDialog = InfoDialog.newInstance(number);
        infoDialog.show(getSupportFragmentManager(), "dialog");
    }
}
