package com.mariofeles.appmaterialdesign.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.mariofeles.appmaterialdesign.R;
import com.melnykov.fab.FloatingActionButton;

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
    ListViewCompat lvFriends;
    @Bind(R.id.faButtonNewFriend)
    FloatingActionButton faBtNewFriend;

    View v;
    List<String> lsFriends;

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
        // Inflate the layout for this fragment
        ButterKnife.bind(this, v);

        faBtNewFriend.attachToListView(lvFriends);

        alimentaListView();

        return v;
    }

    @OnClick(R.id.faButtonNewFriend)
    public void clickNewFriend() {
        Toast.makeText(getActivity(), "New Friend", Toast.LENGTH_LONG).show();
    }

    private void alimentaListView() {
        lvFriends.setAdapter(null);

        lsFriends = new ArrayList<>();
        //Colocando alguns nomes na lista
        lsFriends.add("Mario");
        lsFriends.add("Jose");
        lsFriends.add("Pedro");
        lsFriends.add("Juninho");
        lsFriends.add("Mario");
        lsFriends.add("Jose");
        lsFriends.add("Pedro");
        lsFriends.add("Juninho");
        lsFriends.add("Mario");
        lsFriends.add("Jose");
        lsFriends.add("Pedro");
        lsFriends.add("Juninho");

        FriendAdaper adapter = new FriendAdaper(lsFriends);
        lvFriends.setAdapter(adapter);


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
        private List<String> list;

        public FriendAdaper(List<String> list) {
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
            final String nome = list.get(position);

            holder = new ViewHolder(view);

            holder.tvFriAda.setText(nome);



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
