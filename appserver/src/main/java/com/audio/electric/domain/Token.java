package com.audio.electric.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/18 0018 16:31
 */
public class Token {
    @Id
    private String _id;
    private String sessionId;
    private String tokenId;
    private Date date;
    private String privateKey;

    public Token() {
    }

    public Token(String _id, String sessionId, String tokenId, Date date, String privateKey) {
        this._id = _id;
        this.sessionId = sessionId;
        this.tokenId = tokenId;
        this.date = date;
        this.privateKey = privateKey;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
