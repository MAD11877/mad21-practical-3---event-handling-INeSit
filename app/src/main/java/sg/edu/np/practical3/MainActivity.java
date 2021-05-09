package sg.edu.np.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivedData = getIntent();
        String randomNum = receivedData.getStringExtra("Random");

        Button button = findViewById(R.id.button);
        button.setText("Follow");
        Button button2 = findViewById(R.id.button2);
        button2.setText("Message");

        User u = new User("Darius","Mad Practical 3", 1, Boolean.FALSE);

        TextView name = findViewById(R.id.textView);
        name.setText(u.getName() + " " + randomNum);

        TextView description = findViewById(R.id.textView2);
        description.setText(u.getDescription());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (u.getFollowed() == Boolean.FALSE) {
                    button.setText("UnFollow");
                    u.setFollowed(Boolean.TRUE);
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();

                }
                else{
                    button.setText("Follow");
                    u.setFollowed(Boolean.FALSE);
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}