package com.alexa.repreoductor.ViewHolder;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.alexa.repreoductor.Adapters.PlaylistAdapter;
import com.alexa.repreoductor.List.Playlist;
import com.alexa.repreoductor.R;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView tvName;
    private ImageView btinView;
    private ImageButton imageButton;
    private PlaylistAdapter playlistAdapter;


    public PlaylistViewHolder(View itemView) {
        super(itemView);

        this.imageView = itemView.findViewById(R.id.ivImagePlaylist);
        this.tvName = itemView.findViewById(R.id.tvPlaylistName);
        this.btinView = itemView.findViewById(R.id.ibtnMore);
        this.imageButton = itemView.findViewById(R.id.ibtnMore);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPupUp(view);
            }
        });

    }

    public void render(final Playlist playlist, int position) {
        imageView.setImageResource(R.drawable.ic_playlist_icon);
        tvName.setText(playlist.getName());
        btinView.setTag(position);
    }

    public void showPupUp(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.playlist_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.option_1:
                        int index = (int) view.getTag();
                        String data = Integer.toString(index);

                        playlistAdapter.mData.remove(index);
                        playlistAdapter.notifyItemRemoved(index);

                        Toast.makeText(view.getContext(), data, Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.option_2:
                        Toast.makeText(view.getContext(), "Editar", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

        popupMenu.show();
    }

    public PlaylistViewHolder linkAdapter(PlaylistAdapter playlistAdapter) {
        this.playlistAdapter = playlistAdapter;
        return this;
    }

}
