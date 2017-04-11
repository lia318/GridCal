package a.gridcal;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit_1, edit_2;
    Button[] butNums = new Button[10];
    Button[] butOps = new Button[4];
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int SelectEdit = SELECT_EDIT1;
    String numStr = "";
    // int[] ids = {R.id.but_0..... but_9까지 값을 초기화 해준다. => 미개한 방법} => for문 ids[i]
    Button but_plus, but_minus, but_multiply, but_division;
    TextView text_result;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 순서중요
        edit_1 = (EditText) findViewById(R.id.edit_1);
        edit_2 = (EditText) findViewById(R.id.edit_2);
        edit_1.setOnTouchListener(edithandler);
        edit_2.setOnTouchListener(edithandler);
        text_result=(TextView)findViewById(R.id.text_result);

        for (int i = 0; i < butNums.length; i++) {
            butNums[i] = (Button) findViewById(R.id.but_0 + i);
            butNums[i].setOnClickListener(butOpsHandler);
        }
        for (int i = 0; i < butOps.length; i++) {
            butOps[i] = (Button) findViewById(R.id.but_0 + i);
            butOps[i].setOnClickListener(butOpsHandler);
        }
    }

    View.OnClickListener butNumHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button but = (Button)v;
            numStr +=but.getText(); // 버튼이 클릭될 때마다 누적

            switch(SelectEdit){
                case SELECT_EDIT1:
                    edit_1.setText(numStr);
                    break;
                case SELECT_EDIT2:
                    edit_2.setText(numStr);
                    break;
            }
        }
    };

    View.OnClickListener butOpsHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int first_num = Integer.parseInt(edit_1.getText().toString());
            int second_num = Integer.parseInt(edit_2.getText().toString());
            double result = 0;

            switch (v.getId()) {
                case R.id.but_plus:
                    result = first_num + second_num;
                    break;
                case R.id.but_minus:
                    result = first_num - second_num;
                    break;
                case R.id.but_multiply:
                    result = first_num * second_num;
                    break;
                case R.id.but_division:
                    result = (double)first_num / second_num;
                    break;

            } // end of switch
            text_result.setText("계산 결과 : "+result);
        }
    };

    View.OnTouchListener edithandler = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            numStr = "";

            switch(v.getId()){
                case R.id.edit_1:
                    SelectEdit = SELECT_EDIT1;
                    edit_1.setText(numStr);
                    break;
                case R.id.edit_2:
                    edit_2.setText(numStr);
                    SelectEdit = SELECT_EDIT2;
                    break;
            }
            return true;
        }
    };
}