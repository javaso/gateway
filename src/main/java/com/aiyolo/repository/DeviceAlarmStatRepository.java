package com.aiyolo.repository;

import com.aiyolo.entity.DeviceAlarmStat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceAlarmStatRepository extends CrudRepository<DeviceAlarmStat, Long> {

    DeviceAlarmStat findOneByDateAndAreaCodeAndType(String date, String areaCode, String type);

    @Query(value = "select s.type as type, sum(num) as num from DeviceAlarmStat s where " +
            "s.date=?1 and regexp(s.areaCode, ?2)=1 group by s.type")
    List<DeviceAlarmStat> findTotalByDateAndAreaCode(String date, String areaCodePat);

    @Query(value = "select s.areaCode as areaCode, s.type as type, sum(num) as num from DeviceAlarmStat s where " +
            "regexp(s.date, ?1)=1 and regexp(s.areaCode, ?2)=1 group by s.areaCode,s.type")
    List<DeviceAlarmStat> findTotalByYearAndAreaCode(String year, String areaCodePat);

}
