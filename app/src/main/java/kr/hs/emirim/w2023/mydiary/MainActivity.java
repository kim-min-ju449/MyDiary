package kr.hs.emirim.w2023.mydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mMianRecycleView;
    private MainAdapter mAdapter;
    private List<Board> mBoardList;
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        mMianRecycleView = findViewById(R.id.main_recycle_view);
        findViewById(R.id.main_write_button).setOnClickListener(this);
        mStore.collection("board").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String id = (String) document.getData().get("id");
                                String title = (String) document.getData().get("title");
                                String contents = (String) document.getData().get("contents");
                                Board data = new Board(id, title, contents);
                                mBoardList = new ArrayList<>();
                                mBoardList.add(data);
                                mBoardList.add(new Board(null, "fff", null));
//                                mBoardList.add(new Board(null,"ㅋㅋㅋㅋ",null));
//                                mBoardList.add(new Board(null,"OK",null));
//                                mBoardList.add(new Board(null,"반갑다",null));

                            }
                            mAdapter = new MainAdapter(mBoardList);
                            mMianRecycleView.setAdapter(mAdapter);

                        }
                    }
                });


    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, WriteActivity.class));
    }

    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        private List<Board> mBoardList;
        public MainAdapter(List<Board> mBoardList){
            this.mBoardList=mBoardList;
        }
        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = mBoardList.get(position);
            holder.mtitleTextView.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());

        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder{

            private TextView mtitleTextView;
            private TextView mNameTextView;
            public MainViewHolder(View itemView){
                super(itemView);

                mtitleTextView = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_list);
            }
        }
    }
}
