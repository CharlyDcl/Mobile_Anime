package fr.esiea.anime.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import fr.esiea.anime.Model.Anime.Anime;
import fr.esiea.anime.View.FavoriteActivity;

public class EditViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> synopsis = new ObservableField<>();
    public ObservableField<String> score = new ObservableField<>();
    public ObservableField<String> background = new ObservableField<>();
    public String id_database;
    Context context;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("animes");

    public EditViewModel(Context context, String id_database) {
        this.context = context;
        this.id_database = id_database;
        ReadAnimeDetail();
    }

    public void ReadAnimeDetail() {
        myRef.child(id_database).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("data edit verif", "onDataChange: " + dataSnapshot.getValue(Anime.class).getTitle());
                title.set(dataSnapshot.getValue(Anime.class).getTitle());
                synopsis.set(dataSnapshot.getValue(Anime.class).getSynopsis());
                score.set(dataSnapshot.getValue(Anime.class).getScore());
                background.set(dataSnapshot.getValue(Anime.class).getBackground());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("error reading detail anime", "onCancelled: " + databaseError.getDetails());
            }
        });
    }

    public void openActivity() {
        context.startActivity( new Intent(context, FavoriteActivity.class));
    }

    public void DeleteFromFirebase() {
        myRef.child(id_database).removeValue();
        openActivity();
    }

    public void updateToFirebase() {
        DatabaseReference updateRef = myRef.child(id_database);
        Map<String, Object> Updates = new HashMap<>();
        Updates.put("title", title.get());
        Updates.put("synopsis", synopsis.get());
        Updates.put("score", score.get());
        Updates.put("background", background.get());
        updateRef.updateChildren(Updates);
        openActivity();
    }

}
