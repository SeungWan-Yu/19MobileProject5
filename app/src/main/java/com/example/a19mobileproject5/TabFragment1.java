package com.example.a19mobileproject5;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabFragment1 extends Fragment implements View.OnClickListener {

    private RecyclerView mMainRecyclerView;
    private Button main_write_button;
    private MainAdapter mAdapter;
    private List<Board> mBoardList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        mMainRecyclerView = view.findViewById(R.id.main_recycler_view);

        view.findViewById(R.id.main_write_button).setOnClickListener(this);


        mBoardList = new ArrayList<>();
        mBoardList.add(new Board(null, "반갑습니다 여러분", null,"android"));
        mBoardList.add(new Board(null, "Hello", null,"server"));
        mBoardList.add(new Board(null, "OK", null,"java"));
        mBoardList.add(new Board(null, "안녕하세요", null,"php"));
        mBoardList.add(new Board(null, "ㅋㅋㅋㅋ ", null,"python"));

        mAdapter = new MainAdapter(mBoardList);
        mMainRecyclerView.setAdapter(mAdapter);

        return  view;

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(requireActivity(), WriteActivity.class));
    }


    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        private List<Board> mBoardList;

        public MainAdapter(List<Board> mBoardList) {
            this.mBoardList = mBoardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = mBoardList.get(position);
            holder.mTitleTextView.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends  RecyclerView.ViewHolder{

            private TextView mTitleTextView;
            private TextView mNameTextView;

            public MainViewHolder(View itemView) {
                super(itemView);

                mTitleTextView = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_text);
            }
        }
    }
}