package fr.esiea.anime;

import android.app.Application;
import android.databinding.DataBindingUtil;

import fr.esiea.anime.Helpers.RecyclerViewDataBinding;

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        DataBindingUtil.setDefaultComponent(new android.databinding.DataBindingComponent() {
            @Override
            public RecyclerViewDataBinding getRecyclerViewDataBinding() {
                return new RecyclerViewDataBinding();
            }
        });
    }
}
