package programacao.mobile.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero;
    private Button numeroUno;
    private Button numeroDois;
    private Button numeroTres;
    private Button numeroQuatro;
    private Button numeroCinco;
    private Button numeroSeis;
    private Button numeroSete;
    private Button numeroOito;
    private Button numeroNove;
    private Button ponto;
    private Button soma;
    private Button subtracao;
    private Button multiplicacao;
    private Button divissao;
    private Button igual;
    private Button botao_limpar;

    private TextView txtExpressao;
    private TextView txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUno.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);

        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divissao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length() - 1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).bulid();
                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch(Exception e){

                }
            }
        });
    }

    private void iniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUno = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtacao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divissao = findViewById(R.id.bt_divissao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void acrescentarUmaExpressao(String string, boolean limpar_dados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                acrescentarUmaExpressao("0", true);
                break;

            case R.id.numero_um:
                acrescentarUmaExpressao("1", true);
                break;

            case R.id.numero_dois:
                acrescentarUmaExpressao("2", true);
                break;

            case R.id.numero_tres:
                acrescentarUmaExpressao("3", true);
                break;

            case R.id.numero_quatro:
                acrescentarUmaExpressao("4", true);
                break;

            case R.id.numero_cinco:
                acrescentarUmaExpressao("5", true);
                break;

            case R.id.numero_seis:
                acrescentarUmaExpressao("6", true);
                break;

            case R.id.numero_sete:
                acrescentarUmaExpressao("7", true);
                break;

            case R.id.numero_oito:
                acrescentarUmaExpressao("8", true);
                break;

            case R.id.numero_nove:
                acrescentarUmaExpressao("9", true);
                break;

            case R.id.ponto:
                acrescentarUmaExpressao(".", true);
                break;

            case R.id.soma:
                acrescentarUmaExpressao("+", false);
                break;

            case R.id.subtacao:
                acrescentarUmaExpressao("-", false);
                break;

            case R.id.multiplicacao:
                acrescentarUmaExpressao("*", false);
                break;

            case R.id.bt_divissao:
                acrescentarUmaExpressao("/", false);
                break;
        }
    }
}