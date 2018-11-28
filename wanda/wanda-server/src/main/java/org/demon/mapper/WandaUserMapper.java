package org.demon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demon.pojo.WandaUser;
import org.demon.pojo.WandaUserExample;

import java.util.List;

@Mapper
public interface WandaUserMapper {
    long countByExample(WandaUserExample example);

    int deleteByExample(WandaUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WandaUser record);

    int insertSelective(WandaUser record);

    List<WandaUser> selectByExample(WandaUserExample example);

    WandaUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WandaUser record, @Param("example") WandaUserExample example);

    int updateByExample(@Param("record") WandaUser record, @Param("example") WandaUserExample example);

    int updateByPrimaryKeySelective(WandaUser record);

    int updateByPrimaryKey(WandaUser record);
}