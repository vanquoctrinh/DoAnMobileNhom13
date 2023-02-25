package com.example.bottomnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bottomnavi.Helper.ManagementCart;
import com.example.bottomnavi.ui.home.FoodDomain;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView btnAddToCart;
    private TextView title_food,money,descriptionTxt,numberOrder;
    private ImageView btnPlus,btnMinus,picFood;
    private FoodDomain object;
    int NumberOrder = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

//        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        title_food.setText(object.getTitle());
        money.setText("$"+object.getMoney());
        descriptionTxt.setText(object.getDescription());
        numberOrder.setText(String.valueOf(NumberOrder));

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberOrder = NumberOrder +1;
                numberOrder.setText(String.valueOf(NumberOrder));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NumberOrder>1){
                NumberOrder = NumberOrder - 1;}

                numberOrder.setText(String.valueOf(NumberOrder));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(NumberOrder);
                //managementCart.insertFood(object);
            }
        });
    }

    private void initView() {
        btnAddToCart = findViewById(R.id.btnAddToCart);
        title_food = findViewById(R.id.title_food);
        money = findViewById(R.id.money);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrder = findViewById(R.id.numberOrder);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        picFood = findViewById(R.id.picFood);
    }
}