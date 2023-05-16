package minhphuc.serverjva.mapper.hr;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import minhphuc.serverjva.domain.hr.HrStatistical;
import minhphuc.serverjva.model.response.StatisticalRowDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HrStatisticalMapper extends BaseMapper<HrStatistical> {

    @Select("SELECT count(swipe_id) from view_person_shift WHERE year(PS_DATE) = #{year} and month(ps_date)=#{month}")
    Integer getOffsetByMonth(@Param("year") Integer year, @Param("month") Integer month);

    @Select("SELECT COUNT(DISTINCT PER_ID) from view_person_shift WHERE year(PS_DATE) = #{year} and month(ps_date)=#{month}")
    Integer getPersonByMonth(@Param("year") Integer year, @Param("month") Integer month);

    @Select("SELECT SUM(total) AS grand_total FROM (\n" +
            " SELECT COUNT(DISTINCT PersonNO) as total from boxdoor_door_record WHERE CredentialType=169 and  year(ActionTime) =  #{year} and month(ActionTime)=#{month}\n" +
            "  UNION ALL\n" +
            " SELECT COUNT(DISTINCT PersonNO) as total from boxdoor_door_record_2023 WHERE CredentialType=169 and  year(ActionTime) =  #{year} and month(ActionTime)=#{month} \n" +
            ") AS subquery;")
    Integer getTrackingByMonth(@Param("year") Integer year, @Param("month") Integer month);


    @Select("SELECT \n" +
            "  t.date_range as week, \n" +
            "  t.count_swipe_id AS amount\n" +
            "FROM \n" +
            "  (\n" +
            "    SELECT '1' AS date_range, COUNT(swipe_id) AS count_swipe_id\n" +
            "    FROM view_person_shift\n" +
            "    WHERE YEAR(ps_date) = #{year} AND MONTH(ps_date) = #{month} AND DAY(ps_date) BETWEEN 1 AND 7\n" +
            "    UNION\n" +
            "    SELECT '2' AS date_range, COUNT(swipe_id) AS count_swipe_id\n" +
            "    FROM view_person_shift\n" +
            "    WHERE YEAR(ps_date) = #{year} AND MONTH(ps_date) = #{month} AND DAY(ps_date) BETWEEN 8 AND 14\n" +
            "    UNION\n" +
            "    SELECT '3' AS date_range, COUNT(swipe_id) AS count_swipe_id\n" +
            "    FROM view_person_shift\n" +
            "    WHERE YEAR(ps_date) = #{year} AND MONTH(ps_date) = #{month} AND DAY(ps_date) BETWEEN 15 AND 21\n" +
            "    UNION\n" +
            "    SELECT '4' AS date_range, COUNT(swipe_id) AS count_swipe_id\n" +
            "    FROM view_person_shift\n" +
            "    WHERE YEAR(ps_date) = #{year} AND MONTH(ps_date) = #{month} AND DAY(ps_date) BETWEEN 22 AND 28\n" +
            "    UNION\n" +
            "    SELECT '5' AS date_range, COUNT(swipe_id) AS count_swipe_id\n" +
            "    FROM view_person_shift\n" +
            "    WHERE YEAR(ps_date) = #{year} AND MONTH(ps_date) = #{month} AND DAY(ps_date) BETWEEN 28 AND 31 \n" +
            "  ) AS t \n" +
            "\tORDER BY date_range")
    List<StatisticalRowDetail> getOffsetDetail(@Param("year") Integer year, @Param("month") Integer month);

    @Select("WITH recursive_menu AS (\n" +
            " SELECT UCML_OrganizeOID, OrgName ,OrgNO\n" +
            " FROM UCML_Organize \n" +
            " WHERE UCML_OrganizeOID = #{organize}\n" +
            " UNION ALL\n" +
            " SELECT m.UCML_OrganizeOID, m.OrgName,m.OrgNO \n" +
            " FROM UCML_Organize m\n" +
            " JOIN recursive_menu rm ON rm.UCML_OrganizeOID = m.ParentOID\n" +
            "),\n" +
            " p as (\n" +
            "SELECT \n" +
            "  b.UCML_Organize_FK as department_id, \n" +
            "  COUNT(a.PER_ID) as total_employee\n" +
            "FROM \n" +
            "  PER_TIMERECORDER_APPLY a \n" +
            "  INNER JOIN PER_PERSON b ON a.PER_ID = b.PER_ID AND a.SYS_Deleted is NULL\n" +
            "\tWHERE\n" +
            "\t(YEAR(SWIPE_DATE1) = #{year} and MONTH(SWIPE_DATE1)=#{month}) OR \n" +
            "\t(YEAR(SWIPE_DATE2) = #{year} and MONTH(SWIPE_DATE2)=#{month}) OR \n" +
            "\t(YEAR(SWIPE_DATE3) = #{year} and MONTH(SWIPE_DATE3)=#{month}) OR \n" +
            "\t(YEAR(SWIPE_DATE4) = #{year} and MONTH(SWIPE_DATE4)=#{month})  \n" +
            "GROUP BY \n" +
            "  b.UCML_Organize_FK\n" +
            ")\n" +
            "SELECT sum(total_employee) as result  FROM recursive_menu,p WHERE UCML_OrganizeOID=p.department_id \n"
    )
    Integer getDetailOrgannize(@Param("year") Integer year, @Param("month") Integer month, @Param("organize") String organize);
}
