package com.example.bottomnavi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavi.R;
import com.example.bottomnavi.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;
/*
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.hello;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
*/
/*
public class HomeFragment extends Fragment {
    RecyclerView homeFoodRec;
    List<HomeViewModel> homeViewModelList;
    HomeFoodAdapter homeFoodAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);
        homeFoodRec = root.findViewById(R.id.recyclerView1);

        homeViewModelList = new ArrayList<>();
        homeViewModelList.add(new HomeViewModel(R.drawable.banhmi,"Banh mi","40000"));
        homeViewModelList.add(new HomeViewModel(R.drawable.pho,"Pho","40000"));
        homeViewModelList.add(new HomeViewModel(R.drawable.bunbo,"Bun bo","40000"));

        homeFoodAdapter = new HomeFoodAdapter(getActivity(),homeViewModelList);
        homeFoodRec.setAdapter(homeFoodAdapter);
        homeFoodRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        homeFoodRec.setHasFixedSize(true);
        homeFoodRec.setNestedScrollingEnabled(false);

                return root;
    }
}*/
public class HomeFragment extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_home);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Banh my","banhmi.png"));
        category.add(new CategoryDomain("Pho","pho"));
        category.add(new CategoryDomain("hamburger","hamburger.jpg"));
        category.add(new CategoryDomain("bun bo","bun bo"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Banh mi","banhmi","very good",3.2));
        foodList.add(new FoodDomain("Pho","pho","very good",5.4));
        foodList.add(new FoodDomain("Bun bo","bun bo","very good",5.0));
        foodList.add(new FoodDomain("Hamburger","hamburger","very good",2.0));

        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}

