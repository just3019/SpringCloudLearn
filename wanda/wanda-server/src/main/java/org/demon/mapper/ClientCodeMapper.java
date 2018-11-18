package org.demon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demon.pojo.ClientCode;
import org.demon.pojo.ClientCodeExample;

@Mapper
public interface ClientCodeMapper {
    long countByExample(ClientCodeExample example);

    int deleteByExample(ClientCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClientCode record);

    int insertSelective(ClientCode record);

    List<ClientCode> selectByExample(ClientCodeExample example);

    ClientCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClientCode record, @Param("example") ClientCodeExample example);

    int updateByExample(@Param("record") ClientCode record, @Param("example") ClientCodeExample example);

    int updateByPrimaryKeySelective(ClientCode record);

    int updateByPrimaryKey(ClientCode record);
}