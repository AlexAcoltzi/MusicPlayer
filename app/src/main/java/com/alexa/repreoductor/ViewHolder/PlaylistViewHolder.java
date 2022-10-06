package com.alexa.repreoductor.ViewHolder;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.alexa.repreoductor.Adapters.PlaylistAdapter;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.R;

//class to inflate view PlayList
public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView tvName;
    private ImageButton imageButton;


    public PlaylistViewHolder(View itemView, PlaylistAdapter.OnItemClickListener listener) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.ivImagePlaylist);
        this.tvName = itemView.findViewById(R.id.tvPlaylistName);
        this.imageButton = itemView.findViewById(R.id.ibtnMorePlaylist);

        LinearLayout linearLayout = itemView.findViewById(R.id.PlaylistItem);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.ClickItem(getAdapterPosition());
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.playlist_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.option_1:
                                listener.OnItemClick(getAdapterPosition());
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    public void render(final Playlist playlist) {
        imageView.setImageResource(R.drawable.ic_playlist_icon);
        tvName.setText(playlist.getName());
    }
}
