package com.example.zeeshan.listviews;




        import android.Manifest;
        import android.content.Context;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.support.annotation.NonNull;
        import android.support.v4.app.ActivityCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        TextView name;
        TextView phone;
        TextView gender;
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Contact contact = getItem(position);
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.contactlist, parent, false);
            holder = new ViewHolder();
            holder.name = view.findViewById(R.id.name);
            holder.phone = view.findViewById(R.id.phone);
            holder.gender = view.findViewById(R.id.gender);
            holder.img = view.findViewById(R.id.imageView);
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri call = Uri.parse("tel:" + contact.getPhone());
                    Intent intent = new Intent(Intent.ACTION_DIAL, call);
                    getContext().startActivity(intent);
                }
            });
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();

        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
        holder.gender.setText(contact.getGender());

        return view;
    }
}
