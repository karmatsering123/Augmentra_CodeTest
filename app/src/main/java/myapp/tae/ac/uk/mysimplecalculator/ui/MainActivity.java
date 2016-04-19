package myapp.tae.ac.uk.mysimplecalculator.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myapp.tae.ac.uk.mysimplecalculator.R;
import myapp.tae.ac.uk.mysimplecalculator.presenter.CalculatorPresenter;
import myapp.tae.ac.uk.mysimplecalculator.presenter.CalculatorView;

/**
 * This simple calculator application can deal with operations maths problem like 4+5/2 or 12*2+6/3+2-3
 * In order to solve simple maths problem, the algorithm needs to make sure to follow BODMAS (where BO is
 * not yet implemented but can be easily implemented) order. For this task, the app sorts the problem entry into
 * reverse polish notation format first and then does orderly (SimpleMaths class does the math part).
 * <p/>
 * The app has also included tests to check the operations are performing correctly and user's inputs are valid.
 * <p/>
 * The app follows MVP design pattern. This design pattern gives the app concern separation feature and writing tests for
 * the app is easy and bug free with design pattern.
 */

public class MainActivity extends AppCompatActivity implements CalculatorView {
    @Bind(R.id.tvOperation)
    TextView tvOperation;
    @Bind(R.id.tvSolution)
    TextView tvSolution;
    @Bind(R.id.etEntry)
    EditText etEntry;
    @Bind(R.id.btCalculate)
    Button btCalculate;
//    @Bind(R.id.customKeyboard)
//    CalculatorKeyboard keyboard;

    CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new CalculatorPresenter(this);
//        keyboard.setButtonClickListener(this);
    }

    @Override
    @OnClick(R.id.btCalculate)
    public void onClickCalculate(View view) {
        presenter.onClickCalculateButton();
    }

    @Override
    public String getEntry() {
        return etEntry.getText().toString();
    }

    @Override
    public void showEmptyErrorMessage(int resId) {
        etEntry.setError(getString(resId));
    }

    @Override
    public void setResult(String result) {
        tvOperation.setText(getEntry());
        tvSolution.setText(result);
        etEntry.setText("");
    }

    @Override
    public String getSolution() {
        return tvSolution.getText().toString();
    }

    @Override
    public void showEntryFormatErrorMessage(int resId) {
        etEntry.setError(getString(resId));
    }


}
