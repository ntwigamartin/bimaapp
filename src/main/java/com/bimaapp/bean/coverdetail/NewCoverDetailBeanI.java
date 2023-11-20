package com.bimaapp.bean.coverdetail;

import java.sql.SQLException;
import java.util.Map;

public interface NewCoverDetailBeanI {
    void createCoverDetail(Map<String, String> paramMap) throws SQLException;
}
