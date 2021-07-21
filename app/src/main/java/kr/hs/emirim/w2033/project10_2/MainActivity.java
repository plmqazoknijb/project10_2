package kr.hs.emirim.w2033.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
//Change ViewFlipper

public class MainActivity extends AppCompatActivity {
    String[] imgNames ={"바른 연애 길잡이","어느 날 공주가 되어버렸다","신비","칼 가는 소녀","이번생도 잘부탁해","청춘블라썸","구남친이 내게 반했다","연애혁명","하루만 네가 되고싶어"};
    int[] imgVIds = {R.id.img01,R.id.img02,R.id.img03,R.id.img04,R.id.img05,R.id.img06,R.id.img07,R.id.img08,R.id.img09};
    int [] voteCount = new int[imgVIds.length];
    ImageView[] image = new ImageView[imgVIds.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title);
        setContentView(R.layout.activity_main);

        for(int i=0; i < imgVIds.length; i++){
            final int index;
            index = i;
            image[index] = findViewById(imgVIds[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgNames[index] + " 총 "+voteCount[index]+"표",Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = findViewById(R.id.btn_done);
        btnFinish.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
            intent.putExtra("voteCount",voteCount);
            intent.putExtra("imgNames",imgNames);
            startActivity(intent);
        }
    };
}