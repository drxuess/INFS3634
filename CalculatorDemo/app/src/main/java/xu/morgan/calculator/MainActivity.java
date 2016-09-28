package xu.morgan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private StringBuilder equationBuilder;
    private StringBuilder displayBuilder;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equationBuilder = new StringBuilder();
        displayBuilder = new StringBuilder();
        display = (TextView) findViewById(R.id.display);
    }

    public void buttonOnClick(View view){
        Button button = (Button) view;
        String number = button.getText().toString();
        equationBuilder.append(number);
        displayBuilder.append(number);
        updateDisplay();
    }

    public void operatorOnClick(View view){
        Button button = (Button) view;
        String operand = button.getText().toString();
        displayBuilder.append(operand);
        switch (operand){
            case "+":
                equationBuilder.append("+");
                break;
            case "−":
                equationBuilder.append("-");
                break;
            case "×":
                equationBuilder.append("*");
                break;
            case "÷":
                equationBuilder.append("/");
                break;
        }
        updateDisplay();
    }

    public void equalsOnClick(View view){
        Expression exp = new ExpressionBuilder(equationBuilder.toString()).build();
        double result = exp.evaluate();
        equationBuilder = new StringBuilder(String.valueOf(result));
        displayBuilder = new StringBuilder(String.valueOf(result));
        updateDisplay();
    }

    public void clearOnClick(View view){
        equationBuilder = new StringBuilder();
        displayBuilder = new StringBuilder();
        updateDisplay();
    }

    public void updateDisplay(){
        if(displayBuilder.toString().isEmpty()){
            display.setText("0");
        } else{
            display.setText(displayBuilder.toString());
        }
    }
}
