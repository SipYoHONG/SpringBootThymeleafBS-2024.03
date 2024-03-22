package com.example.abbs.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import com.example.abbs.entity.Address;

@Mapper
public interface AddressDao {
    // 주소 목록 조회
    @Select("SELECT address FROM board ORDER BY bid ASC")
    List<String> findAddresses();
    
    // 주소 추가
    @Insert("INSERT INTO board (address) VALUES (#{address})")
    void insertAddress(String address);
    
    // 주소 수정
    @Update("UPDATE board SET address = #{address} WHERE bid = #{bid}")
    void updateAddress(@Param("bid") Long bid, @Param("address") String address);
    
    // 주소 삭제
    @Delete("DELETE FROM board WHERE bid = #{bid}")
    void deleteAddress(Long bid);
}