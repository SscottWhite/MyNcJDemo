package com.example.newpackage.mapper;

import com.example.newpackage.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("select * from nc_user")
    @Results({
            @Result(column = "user_no", property = "userNo", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_name", property = "userName",jdbcType = JdbcType.NVARCHAR),
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER)
    })
    List<UserDTO> getUSer();

}
