package com.analytics.dau.dao;

import com.analytics.dau.entity.RetentionType;
import com.analytics.dau.entity.User;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.analytics.dau.Util.getStrFromDate;

@Repository
public class UserDaoImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	public List<User> getDailyActiveUsers(List<Date> dateList) {

		List<User> users = jdbcTemplate.query(buildQuery(dateList),
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int i) throws SQLException {
						return new User(rs.getString("user_id"), rs.getDate("request_date"));

					}

				});

		return users;
	}

	private String buildQuery(List<Date> dateList) {
		StringBuilder queryBuilder = new StringBuilder("SELECT * FROM analitics.requests WHERE date(request_date) IN (");
		for (int i = 0; i < dateList.size() - 1; ++i) {
			queryBuilder.append('\'');
			queryBuilder.append(getStrFromDate(dateList.get(i)));
			queryBuilder.append('\'');
			queryBuilder.append(", ");
		}
		queryBuilder.append('\'');
		queryBuilder.append(getStrFromDate(dateList.get(dateList.size() - 1)));
		queryBuilder.append("');");

		return queryBuilder.toString();
	}

	public List<User> getRetention(RetentionType type, Date date) {
		return getDailyActiveUsers(getRetentionDates(type, date));
	}

	private List<Date> getRetentionDates(RetentionType type, Date date) {
		List<Date> retDate = new ArrayList<>();
		for (int i = 1; i <= type.getDays(); i++) {
			retDate.add(date);
			date = DateUtils.addDays(date, 1);
		}

		return retDate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
