package co.br.banco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Heroi heroiASerSalvo = new Heroi();
        heroiASerSalvo.setNome("Tony Stark");
        heroiASerSalvo.setPoder("Ser rico");

        HeroiRepository repositorio = new HeroiRepository(getApplicationContext());
        repositorio.salvar(heroiASerSalvo);
        ArrayList<Heroi> todosOsHerois;
        todosOsHerois = repositorio.listarTodos();
    }
}
