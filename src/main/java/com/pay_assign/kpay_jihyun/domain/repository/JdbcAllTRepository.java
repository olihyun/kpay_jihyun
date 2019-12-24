package com.pay_assign.kpay_jihyun.domain.repository;

import com.pay_assign.kpay_jihyun.domain.model.OneT;
import com.pay_assign.kpay_jihyun.domain.model.BrThreeFourTForQuery;
import com.pay_assign.kpay_jihyun.domain.model.TwoT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcAllTRepository implements AllTRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<OneT> findByYear(String year) {
        return jdbcTemplate.query(
                "SELECT a.tr_year" +
                        "     , a.acno" +
                        "     , (select ac_nm from ac_list z where a.acno=z.acno ) as name" +
                        "     , sum(a.amt) as sum_amt" +
                        "  FROM (" +
                        "select x.acno" +
                        "     , SUBSTRING(x.tr_dt,1,4) as tr_year" +
                        "     , x.tr_a - x.fee as amt" +
                        "  from tr_list x" +
                        " where SUBSTRING(x.tr_dt,1,4) = ?" +
                        "   and x.cncl_yn = 'N' " +
                        "       ) a" +
                        " group by tr_year, acno" ,
                new Object[]{year},
                (rs, rowNum) ->
                        new OneT(
                                rs.getString("tr_year"),
                                rs.getString("acno"),
                                rs.getString("name"),
                                rs.getLong("sum_amt")
                        )
        );
    }

    @Override
    public List<TwoT> findByYearTwo(String year) {
        return jdbcTemplate.query(
                "select ? as tr_year" +
                        "     , a.ac_nm" +
                        "     , a.acno" +
                        "  from ac_list a" +
                        " where a.acno not in " +
                        "  ( select DISTINCT acno from tr_list" +
                        "     where SUBSTRING(tr_dt,1,4)=?" +
                        "       and cncl_yn = 'N'" +
                        "  )" ,
                new Object[]{year, year},
                (rs, rowNum) ->
                        new TwoT(
                                rs.getString("tr_year"),
                                rs.getString("ac_nm"),
                                rs.getString("acno")
                        )
        );
    }

    @Override
    public List<BrThreeFourTForQuery> findByYearThree(String year) {
        return jdbcTemplate.query(
                "select a.br_cod" +
                        "              , sum(b.tr_a) as sum_amt" +
                        "              , c.br_nm" +
                        "          from ac_list a, tr_list b, br_list c" +
                        "         where b.cncl_yn = 'N'" +
                        "           and a.acno = b.acno" +
                        "           and a.br_cod = c.br_cod" +
                        "           and SUBSTRING(b.tr_dt,1,4) = ?" +
                        "         group by br_cod" +
                        "         order by sum_amt desc" ,
                new Object[]{year},
                (rs, rowNum) ->
                        new BrThreeFourTForQuery(
                                rs.getString("br_cod"),
                                rs.getString("br_nm"),
                                rs.getLong("sum_amt")
                        )
        );
    }

    @Override
    public List<BrThreeFourTForQuery> findByBrNmFour(String brName) {
        return jdbcTemplate.query(
                "select b.br_cod, NULLIF(sum(a.tr_a),0) as sum_amt, c.br_nm" +
                        "  from tr_list a" +
                        "     , ( select acno, IF(br_cod='B','A',br_cod) as br_cod from ac_list ) b" +
                        "     , br_list c" +
                        " where a.cncl_yn = 'N'" +
                        "   and a.acno = b.acno" +
                        "   and b.br_cod = c.br_cod" +
                        "   and br_nm LIKE CONCAT('%',?,'%')" +
                        "  group by b.br_cod" ,
                new Object[]{brName},
                (rs, rowNum) ->
                        new BrThreeFourTForQuery(
                                rs.getString("br_cod"),
                                rs.getString("br_nm"),
                                rs.getLong("sum_amt")
                        )
        );
    }
}
