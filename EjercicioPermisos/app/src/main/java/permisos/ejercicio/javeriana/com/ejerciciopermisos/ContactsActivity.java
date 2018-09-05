package permisos.ejercicio.javeriana.com.ejerciciopermisos;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class ContactsActivity extends AppCompatActivity {
    private String[] projection;
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        requestPermission(
                this,
                Manifest.permission.READ_CONTACTS,
                MainActivity.PERMISSION_CONTACTS
        );
        buildComponents();
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
        ListView listView = findViewById(R.id.lvwContacts);
        projection = new String[] {
                ContactsContract.Profile._ID,
                ContactsContract.Profile.DISPLAY_NAME
        };
        adapter = new ContactsAdapter(this, null, 0);
        listView.setAdapter(adapter);

    }

    private void loacContactsList() {
        Cursor cursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                projection,
                null,
                null,
                null
        );
        adapter.changeCursor(cursor);
    }
}
