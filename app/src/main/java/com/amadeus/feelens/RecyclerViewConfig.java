package com.amadeus.feelens;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.io.InputStream;
import java.util.List;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


public class RecyclerViewConfig {
    private Context mContext;
    private TaskAdapter mTaskAdapter;


    public void setConfig(RecyclerView recyclerView, Context context, List<Task> tasks, List<String> keys){
        mContext = context;
        mTaskAdapter = new TaskAdapter(tasks, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mTaskAdapter);
    }

    class TaskItemView extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mExp;
        private ImageView mImageView;
        private String mId;

        private String key;

        public TaskItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.task_list_item, parent, false));

            mTitle = (TextView) itemView.findViewById(R.id.task_name_txt);
            mExp = (TextView) itemView.findViewById(R.id.task_exp_txt);
            mImageView = (ImageView) itemView.findViewById(R.id.task_image_view);

        }

        public void bind(Task task, String key){
            mTitle.setText(task.getTaskName());
            mExp.setText(task.getTaskExp());
            mId = task.getTaskId();
//            GlideApp.with(mContext).load(TasksActivity.getTaskUrl("001")).into(mImageView);
            this.key = key;
        }
    }

    class TaskAdapter extends RecyclerView.Adapter<TaskItemView> {
        private List<Task> mTaskList;
        private List<String> mKeys;

        public TaskAdapter(List<Task> mTaskList, List<String> mKeys) {
            this.mTaskList = mTaskList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public TaskItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TaskItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskItemView holder, int position) {
            holder.bind(mTaskList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mTaskList.size();
        }
    }


}


