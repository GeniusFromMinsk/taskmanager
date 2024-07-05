package com.itacademy.courses.services;

import com.itacademy.courses.dao.FilterDAO;
import com.itacademy.courses.dao.TaskDAO;
import com.itacademy.courses.models.Filter;
import com.itacademy.courses.models.Task;

import java.sql.SQLException;
import java.util.List;

public class FilterService {
    private FilterDAO filterDAO;

    public void createFilter(Filter filter) {
        try {
            filterDAO.insertFilter(filter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FilterService() {
        this.filterDAO = new FilterDAO();
    }

    public boolean updateFilter(Filter filter) {
        try {
            return filterDAO.updateFilter(filter);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFilter(int filterId) {
        try {
            return filterDAO.deleteFilter(filterId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
