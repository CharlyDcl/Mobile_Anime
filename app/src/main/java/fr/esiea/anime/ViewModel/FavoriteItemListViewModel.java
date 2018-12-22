package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import fr.esiea.anime.Model.Anime.Anime;
import fr.esiea.anime.View.EditActivity;

public class FavoriteItemListViewModel {

    public ObservableArrayList<FavoriteItemViewModel> items = new ObservableArrayList<>();
    Context context;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("animes");

    public FavoriteItemListViewModel(Context context) {

        this.context = context;
        ReadFromDatabase();
    }

    public void ReadFromDatabase() {
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    items.add(new FavoriteItemViewModel(ds.getValue(Anime.class).getTitle(), ds.getValue(Anime.class).getSynopsis(), ds.getValue(Anime.class).getEpisodes(), ds.getValue(Anime.class).getScore(), ds.getValue(Anime.class).getFirebase_id()));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error reading data", "onCancelled: " + databaseError.getDetails());
            }
        });
    }

    public void onItemTapped(Object item) {
        Log.d("itemclick", "onItemTapped: " + ((FavoriteItemViewModel)item).id_database);
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("ID_DATABASE",((FavoriteItemViewModel)item).id_database);
        context.startActivity(intent);
    }

}
