package kr.hs.emirim.s2019w39.toastlocation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        Button btnDialog = findViewById(R.id.btn_dialog);
        btn.setOnClickListener(btnListener);
        btnDialog.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn:
                    Toast toast = Toast.makeText(getApplicationContext(), "토스트 연습", Toast.LENGTH_SHORT);
                    Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                    int xOffset = (int)(Math.random() * display.getWidth());
                    int yOffset = (int)(Math.random() * display.getHeight());
//          toast.setGravity(Gravity.TOP|Gravity.LEFT, xOffset, yOffset);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 100);
                    toast.show();
                    break;
                case R.id.btn_dialog:
                    //getApplicationContext 사용하면 안됨.
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("알림사항");
                    dialog.setMessage("코로나 학진자 진행상황입니다.");
                    dialog.setIcon(R.mipmap.ic_flower2);
                    dialog.setPositiveButton("확인", dialogListener);
                    dialog.show();
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(MainActivity.this, "대화상자의 확인 버튼을 클릭했네요.", Toast.LENGTH_SHORT).show();
        }
    };
}