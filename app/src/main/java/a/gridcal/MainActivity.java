package a.gridcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit_1, edit_2;
    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4]
    // int[] ids = {R.id.but_0..... but_9까지 값을 초기화 해준다. => 미개한 방법} => for문 ids[i]
    Button but_plus, but_minus, but_multiply, but_division;
    TextView textResult;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<butNums.length; i++){
            butNums[i]=(Button)findViewById(R.id.but_0 + i);
            butNums[i].setOnClickListener();
        }
        for(int i=0; i<butOps.length; i++){
            butOps[i]=(Button)findViewById(R.id.but_0 + i);
            butOps[i].setOnClickListener();
        }

        edit_1 = (EditText) findViewById(R.id.edit_1);
        edit_2 = (EditText) findViewById(R.id.edit_2);

        but_plus = (Button) findViewById(R.id.but_plus);
        but_minus = (Button) findViewById(R.id.but_minus);
        but_multiply = (Button) findViewById(R.id.but_multiply);
        but_division = (Button) findViewById(R.id.but_division);

        textResult = (TextView) findViewById(R.id.text_result);

        // setOnClickListener가 있어야만 버튼 클릭이 가능해진다.
        but_plus.setOnClickListener(butHandler);
        but_minus.setOnClickListener(butHandler);
        but_multiply.setOnClickListener(butHandler);
        but_division.setOnClickListener(butHandler);
    }

    View.OnClickListener butNumHandler=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener butOpsHandler=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener butHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int first_num = Integer.parseInt(edit_1.getText().toString());
            int second_num = Integer.parseInt(edit_2.getText().toString());
            int result = 0;

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
                    result = first_num / second_num;
                    break;
            }
            textResult.setText("계산결과 : "+result + "");
        }
    };
}
