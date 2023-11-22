package com.bimaapp.app.bean.coverdetailbean;

import java.sql.SQLException;
import java.util.Map;

public interface NewCoverDetailBeanI {
    void createCoverDetail(Map<String, String> paramMap) throws SQLException;
}
