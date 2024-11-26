package com.example.bookmark.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookmark.BookMarkAdapter;
import com.example.bookmark.Product;
import com.example.bookmark.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookMarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookMarkFragment extends Fragment {
    private RecyclerView recyclerView;
    private BookMarkAdapter adapter;
    private List<Product> productList;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookMarkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookMarkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookMarkFragment newInstance(String param1, String param2) {
        BookMarkFragment fragment = new BookMarkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_book_mark, container, false);
        recyclerView = rootView.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Giả sử bạn có một danh sách sản phẩm
        productList = new ArrayList<>();
        adapter = new BookMarkAdapter(getContext(), productList);
        recyclerView.setAdapter(adapter);

        // Thêm dữ liệu vào RecyclerView
        loadData();

        return rootView;
    }
    private void loadData() {
        // Thêm dữ liệu giả vào RecyclerView
        productList.add(new Product("Gà quay", 10000, R.raw.gaquay ));
        productList.add(new Product("Gà luộc", 10000, R.raw.gaquay ));
        productList.add(new Product("Gà kho", 10000, R.raw.gaquay ));
        // Cập nhật adapter
        adapter.notifyDataSetChanged();
    }
}