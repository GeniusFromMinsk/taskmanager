package com.itacademy.courses.services;

import com.itacademy.courses.dao.TagDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Tag;

import java.sql.SQLException;
import java.util.List;

public class TagService {
    private TagDAO tagDAO;

    public TagService() {
        this.tagDAO = new TagDAO();
    }

    public void createTag(Tag tag) {
        try {
            tagDAO.insertTag(tag);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }

    public boolean updateTag(Tag tag) {
        try {
            return tagDAO.updateTag(tag);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }

    public boolean deleteTag(int tagId) {
        try {
            return tagDAO.deleteTag(tagId);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }
}