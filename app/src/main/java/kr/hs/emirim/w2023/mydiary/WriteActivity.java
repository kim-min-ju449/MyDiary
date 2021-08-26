package kr.hs.emirim.w2023.mydiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();

    private EditText mwriteTitleText;
    private EditText mwriteContentsText;
    private EditText mwriteNameText;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mwriteTitleText = findViewById(R.id.write_title_text);
        mwriteContentsText = findViewById(R.id.write_contents_text);
        mwriteNameText = findViewById(R.id.write_name_text);

        findViewById(R.id.write_upload_button).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        id=mStore.collection("board").getId();
        Map<String, Object> post = new HashMap<>();
        post.put("id",id);
        post.put("title",mwriteTitleText.getText().toString());
        post.put("contents", mwriteContentsText.getText().toString());

        mStore.collection("board").document(id).set(post)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(WriteActivity.this,"업로드성공",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(WriteActivity.this,"업로드실패",Toast.LENGTH_SHORT).show();

                    }
                });






    }
}