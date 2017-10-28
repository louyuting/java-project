package com.example.demo.mapper;

import com.example.demo.model.WaybillPrecheckRuleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/25
 */
@Mapper
public interface PreCheckMapper {
    @Select("select * from waybill_precheck where id=#{id}")
    WaybillPrecheckRuleDO findById(@Param("id") long id);
}
