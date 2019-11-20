package com.amadeus.feelens;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.io.InputStream;
import java.util.List;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


public class RecyclerViewConfig {
    private Context mContext;
    private TaskAdapter mTaskAdapter;
    private ImageView mImageView;

    public void setConfig(RecyclerView recyclerView, Context context, List<Task> tasks, List<String> keys){
        mContext = context;
        mTaskAdapter = new TaskAdapter(tasks, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mTaskAdapter);
    }

    class TaskItemView extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mExp;
        private TextView mDesc;

        private String mId;

        private String key;

        public TaskItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.task_list_item, parent, false));

            mTitle = (TextView) itemView.findViewById(R.id.task_name_txt);
            mExp = (TextView) itemView.findViewById(R.id.task_exp_txt);
            mImageView = (ImageView) itemView.findViewById(R.id.task_image_view);
            mDesc = (TextView) itemView.findViewById(R.id.task_desc_txt);

        }

        public void bind(Task task, String key){
            mTitle.setText(task.getTaskName());
            mExp.setText(task.getTaskExp());
            mId = task.getTaskId();
            mDesc.setText(task.getTaskDesc());
//            GlideApp.with(mContext).load(TasksActivity.getTaskUrl("001")).into(mImageView);
            this.key = key;
            System.out.println("NUMERO DE CHAVE: " + key);


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
            System.out.println("POSICAO DA CHAVE: " + mKeys.get(position));
            StorageReference mImageRef = FirebaseStorage.getInstance().getReference("images/taskid:" + mKeys.get(position));

            mImageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    System.out.println("URL FINAL: "+uri);
                    Glide.with(mContext).load(uri).into(mImageView);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mTaskList.size();
        }


    }
}


