package com.mariofeles.appmaterialdesign.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.widget.ListViewCompat;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.mariofeles.appmaterialdesign.R;
import com.mariofeles.appmaterialdesign.dao.DatabaseHelper;
import com.mariofeles.appmaterialdesign.dao.FriendDao;
import com.mariofeles.appmaterialdesign.model.Friend;
import com.melnykov.fab.FloatingActionButton;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Mario Feles dos Santos Junior on 10/09/15.
 */
public class FriendsFragment extends Fragment {


    @Bind(R.id.lvFriends)
    ListView lvFriends;
    @Bind(R.id.faButtonNewFriend)
    FloatingActionButton faBtNewFriend;

    View v;
    private DatabaseHelper dh;
    private FriendDao friendDao;
    private List<Friend> friendList = new ArrayList<>();
    private Friend friend;


    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_friends, container, false);


        //Base Dados
        try {
            dh = new DatabaseHelper(getActivity());
            friendDao = new FriendDao(dh.getConnectionSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Inflate the layout for this fragment
        ButterKnife.bind(this, v);
        faBtNewFriend.attachToListView(lvFriends);

        alimentaListView();

        return v;
    }

    @OnClick(R.id.faButtonNewFriend)
    public void clickNewFriend() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_new_friend);
        dialog.setTitle(R.string.newfriend);
        EditText etName = (EditText) dialog.findViewById(R.id.vNameFriend);
        etName.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        EditText etFone = (EditText) dialog.findViewById(R.id.vFoneFriend);
        etFone.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
        Button btCancel = (Button) dialog.findViewById(R.id.btCancelFriend);
        Button btSave = (Button) dialog.findViewById(R.id.btSaveFriend);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"SALVAR",Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();

    }

    private void alimentaListView() {
        try {
            lvFriends.setAdapter(null);
            friendList = friendDao.queryForAll();
            FriendAdaper adapter = new FriendAdaper(friendList);
            lvFriends.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    ///////////////////////////////////////////////////////////////
    ////////////////////////////CLASSES////////////////////////////
    ///////////////////////////////////////////////////////////////
    public class FriendAdaper extends BaseAdapter {
        private List<Friend> list;

        public FriendAdaper(List<Friend> list) {
            this.list = list;
            ButterKnife.bind(this,v);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.adap_friend, null);

            final Friend fd = list.get(position);

            holder = new ViewHolder(view);

            holder.tvFriAda.setText(fd.getNome());



            return view;
        }

        /**
         * This class contains all butterknife-injected Views & Layouts from layout file 'adap_friend.xml'
         * for easy to all layout elements.
         *
         * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
         */
        class ViewHolder {
            @Bind(R.id.tvFriAda)
            TextView tvFriAda;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
