/*
 * Copyright (c) 2015 GDG VIT Vellore.
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sumatone.cloud.securecloud;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shalini on 28-06-2015.
 */
public class DownloadFragment extends Fragment {

    private RecyclerView recyclerView;
    private SpotlightListAdapter adapter;
    private TextView noContentView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.download_fragment, container, false);
        init(rootView);
        setInit();
        setData();
        return rootView;
    }


    private void init(ViewGroup rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        noContentView = (TextView) rootView.findViewById(R.id.nocontent_text);
    }


    private void setInit() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    private void setData() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private class SpotlightListAdapter extends RecyclerView.Adapter<SpotlightListAdapter.SpotlightViewHolder> {
        private final List<String> data;
        private LayoutInflater inflater;
        private Context c;

        public SpotlightListAdapter(Context context, List<String> list) {
            data = list;
            c = context;
            inflater = LayoutInflater.from(c);
        }

        @Override
        public SpotlightListAdapter.SpotlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.pager_recycler_row, parent, false);
            SpotlightViewHolder spotlightViewHolder = new SpotlightViewHolder(view);
            return spotlightViewHolder;
        }


        @Override
        public void onBindViewHolder(SpotlightViewHolder holder, int position) {
            String info = data.get(position);
            holder.spotlightText.setText(info);

        }

        @Override
        public int getItemCount() {

            return data.size();
        }

        class SpotlightViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView spotlightText;

            public SpotlightViewHolder(View itemView) {
                super(itemView);
                spotlightText = (TextView) itemView.findViewById(R.id.f_name);
                //goToUrlText = (TextView) itemView.findViewById(R.id.gotourl_text);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                String mes = data.get(getAdapterPosition());


            }

        }
    }
}
