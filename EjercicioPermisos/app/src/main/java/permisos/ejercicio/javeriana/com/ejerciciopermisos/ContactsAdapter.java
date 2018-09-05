package permisos.ejercicio.javeriana.com.ejerciciopermisos;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ContactsAdapter extends CursorAdapter {
    private static final int CONTACT_ID_INDEX = 0;
    private static final int DISPLAY_NAME_INDEX = 1;

    public ContactsAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup){
        return LayoutInflater
                .from(context)
                .inflate(R.layout.contact_item_layout, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txvContactId = view.findViewById(R.id.txvContactId);
        TextView txvContactName = view.findViewById(R.id.txvContactName);
        int id = cursor.getInt(ContactsAdapter.CONTACT_ID_INDEX);
        String nombre = cursor.getString(ContactsAdapter.DISPLAY_NAME_INDEX);
        txvContactId.setText(id);
        txvContactName.setText(nombre);
    }
}
