package quyen.it.dut.calculatortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declare Button, EditText, TextView;

    private EditText edt_Calculator;
    private TextView txt_result;

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    private Button btn_add;
    private Button btn_sub;
    private Button btn_mul;
    private Button btn_div;

    private Button btn_assign;
    private Button btn_point;
    private Button btn_clean;
    private Button btn_clean_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        setOnClickView();
    }

    //  assignment for variable is address id at activity.main
    public void initWidget(){

        edt_Calculator= (EditText)findViewById(R.id.edt_Calculator);
        txt_result= (TextView)findViewById(R.id.txt_result);

        btn_0= (Button)findViewById(R.id.btn_0);
        btn_1= (Button)findViewById(R.id.btn_1);
        btn_2= (Button)findViewById(R.id.btn_2);
        btn_3= (Button)findViewById(R.id.btn_3);
        btn_4= (Button)findViewById(R.id.btn_4);
        btn_5= (Button)findViewById(R.id.btn_5);
        btn_6= (Button)findViewById(R.id.btn_6);
        btn_7= (Button)findViewById(R.id.btn_7);
        btn_8= (Button)findViewById(R.id.btn_8);
        btn_9= (Button)findViewById(R.id.btn_9);

        btn_add= (Button)findViewById(R.id.btn_add);
        btn_div= (Button)findViewById(R.id.btn_div);
        btn_mul= (Button)findViewById(R.id.btn_mul);
        btn_sub= (Button)findViewById(R.id.btn_sub);

        btn_assign= (Button)findViewById(R.id.btn_assign);
        btn_point= (Button)findViewById(R.id.btn_point);
        btn_clean= (Button)findViewById(R.id.btn_clean);
        btn_clean_all= (Button)findViewById(R.id.btn_clean_all);

    }

    //  assignment event click for variable

    public void setOnClickView(){
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);


        btn_point.setOnClickListener(this);
        btn_assign.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        btn_clean_all.setOnClickListener(this);
    }

    // to do when click button
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0: {
                edt_Calculator.append("0");
                break;
            }
            case R.id.btn_1: {
                edt_Calculator.append("1");
                break;
            }
            case R.id.btn_2: {
                edt_Calculator.append("2");
                break;
            }
            case R.id.btn_3: {
                edt_Calculator.append("3");
                break;
            }
            case R.id.btn_4: {
                edt_Calculator.append("4");
                break;
            }
            case R.id.btn_5: {
                edt_Calculator.append("5");
                break;
            }
            case R.id.btn_6: {
                edt_Calculator.append("6");
                break;
            }
            case R.id.btn_7: {
                edt_Calculator.append("7");
                break;
            }
            case R.id.btn_8: {
                edt_Calculator.append("8");
                break;
            }
            case R.id.btn_9: {
                edt_Calculator.append("9");
                break;
            }
            case R.id.btn_add: {
                edt_Calculator.append("+");
                break;
            }
            case R.id.btn_sub: {
                edt_Calculator.append("-");
                break;
            }
            case R.id.btn_mul: {
                edt_Calculator.append("*");
                break;
            }
            case R.id.btn_div: {
                edt_Calculator.append("/");
                break;
            }

            case R.id.btn_point: {
                edt_Calculator.append(".");
                break;
            }
            case R.id.btn_clean_all: {
                edt_Calculator.setText("");
                txt_result.setText("");
                break;
            }
            //TO DO
            case R.id.btn_clean: {

                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edt_Calculator, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            }
            //TO DO
            case R.id.btn_assign: {

                DecimalFormat df = new DecimalFormat("####.#####");
                double result = 0;

                addOperation(edt_Calculator.getText().toString());
                addNumber(edt_Calculator.getText().toString());

                if (arrOperation.size() >= arrNumber.size() || arrOperation.size() < 1) {
                   txt_result.setText("Lỗi định dạng");
                } else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+": {
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            }

                            case "-": {
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            }

                            case "*": {
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            }

                            case "/": {
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            }
                        }
                    }
                   txt_result.setText(df.format(result) + "");
                }
            }
        }
    }

    public ArrayList<String> arrOperation;

    public ArrayList<Double> arrNumber;

    public int addOperation(String input){
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for(int i= 0 ; i< cArray.length; i++){
            switch (cArray[i]){
                case '+': {
                    arrOperation.add(cArray[i] + "");
                    break;
                }
                case '-': {
                    arrOperation.add(cArray[i] + "");
                    break;
                }
                case '*': {
                    arrOperation.add(cArray[i] + "");
                    break;
                }
                case '/': {
                    arrOperation.add(cArray[i] + "");
                    break;
                }
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput){
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher= regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

}
