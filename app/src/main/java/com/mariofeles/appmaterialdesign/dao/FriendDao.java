package com.mariofeles.appmaterialdesign.dao;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.mariofeles.appmaterialdesign.model.Friend;
import java.sql.SQLException;

/**
 * Created by Mario Feles Dos Santos Junior on 14/09/15.
 */
public class FriendDao extends BaseDaoImpl<Friend,Integer>{

    public FriendDao(ConnectionSource cs) throws SQLException {
        super(Friend.class);
        setConnectionSource(cs);
        initialize();
    }
}
