package riwi.devSync.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO2faService {
    @Autowired
    private JdbcTemplate jbcTemplate;
    //I can do this with jpa, but In the future I change this
    public void update2faProperties(Integer userId,String twoFaCode){
        jbcTemplate.update("update user set code2fa=?,expire_time2fa=? where id=?", new Object[]{
                twoFaCode,
                (System.currentTimeMillis()/1000) +120,
                userId
        });
    }
}
