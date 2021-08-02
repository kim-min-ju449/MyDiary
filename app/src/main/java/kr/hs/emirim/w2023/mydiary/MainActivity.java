package kr.hs.emirim.w2023.mydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mMianRecycleView;
    private MainAdapter mAdapter;
    private List<Board> mBoardList;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMianRecycleView = findViewById(R.id.main_recycle_view);
        findViewById(R.id.main_write_button).setOnClickListener(this);

        mBoardList = new ArrayList<>();
        mBoardList.add(new Board(null,"fff",null));
        mBoardList.add(new Board(null,"fff",null));
        mBoardList.add(new Board(null,"ㅋㅋㅋㅋ",null));
        mBoardList.add(new Board(null,"OK",null));
        mBoardList.add(new Board(null,"반갑다",null));

        mAdapter = new MainAdapter(mBoardList);
        mMianRecycleView.setAdapter(mAdapter);


    }

    @Override
    public void onClick(View v) {

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