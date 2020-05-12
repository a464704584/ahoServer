package com.cy.ahoServer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.ahoServer.beans.KnowledgeType;

@Mapper
public interface KnowledgeTypeDao {
	@Insert("insert into knowledge_type (id,name,parentId) values (#{id},#{name},#{parentId})")
	int insertKnowledgeType(KnowledgeType arg);
	
	@Select("<script>"
			+ "select * from knowledge_type where"
			+ "<choose>"
			+ "	<when test='parentId==null'>"
			+ "		parentId is null"
			+ "</when>"
			+ "<otherwise>"
			+ "		parentId=#{parentId}"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script> ")
	List<KnowledgeType> selectKnowledgeType(@Param("parentId") String parentId);
}
