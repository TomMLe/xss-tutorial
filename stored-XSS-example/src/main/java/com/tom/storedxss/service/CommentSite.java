package com.tom.storedxss.service;

/**
 * Created by thongminhle on 7/26/17.
 */
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class CommentSite {
    private final List<String> commentList;

    public CommentSite(){
        commentList = new ArrayList<String>();
    }

    public void storeComment(String comment) {
        commentList.add(comment);
    }

    public int getCommentListSize() {
        return commentList.size();
    }

    public List<String> getCommentList() {
        return commentList;
    }
}
