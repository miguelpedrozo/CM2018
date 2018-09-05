package permisos.ejercicio.javeriana.com.ejerciciopermisos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSION_CAMERA = 1;
    public static final int PERMISSION_CONTACTS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission(
                this,
                Manifest.permission.READ_CONTACTS,
                MainActivity.PERMISSION_CONTACTS
        );
    }

    private void requestPermission(Activity context, String permission, int requestId){
        if (ContextCompat.checkSelfPermission(context,permission)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(context,permission)) {
                Toast.makeText(context, "Permiso denegado previamente", Toast.LENGTH_LONG);
            }
            ActivityCompat.requestPermissions(context, new String[]{permission}, requestId);
        }
    }

    private void buildComponents() {
        ImageView imvContacts = findViewById(R.id.imvContactos);
        imvContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ContactsActivity.class);
                startActivity(intent);
            }
        });
    }
}
