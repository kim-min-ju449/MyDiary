package kr.hs.emirim.w2023.mydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mMianRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMianRecycleView = findViewById(R.id.main_recycle_view);
        findViewById(R.id.main_write_button).setOnClickListener(this);
        //41:25

    }
    @Override
    public void OnClick(View v){

    }

    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class MainViewHolder extends RecyclerView.ViewHolder{
            public MainViewHolder(View itemView){
                super(itemView);
            }
        }
    }
}