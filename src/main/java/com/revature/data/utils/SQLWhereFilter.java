package com.revature.data.utils;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SQLWhereFilter<T> {
  final T columnValue;
  final String columnName;
  final String sqlWhereClause;

  public T getColumnValue() {
    return columnValue;
  }

  public String getColumnName() {
    return columnName;
  }

  public String getSqlWhereClause() {
    return sqlWhereClause;
  }

  public SQLWhereFilter(T columnValue, String columnName, String sqlWhereClause) {
    this.columnValue = columnValue;
    this.columnName = columnName;
    this.sqlWhereClause = sqlWhereClause;
  }

  public static String getWhereClause(List<SQLWhereFilter<?>> items) {
    final Stream<SQLWhereFilter<?>> notNullItems = filterNulls(items);

    return notNullItems.map(s -> s.sqlWhereClause).collect(Collectors.joining(" "));

  }

  public static Stream<SQLWhereFilter<?>> filterNulls(List<SQLWhereFilter<?>> items) {
    return items.stream().filter(item -> item.getColumnValue() != null ? true : false)
        .filter(item -> item.getColumnValue().getClass().equals(String.class)
            && item.getColumnValue().toString().isEmpty() ? false : true);
  }
}
