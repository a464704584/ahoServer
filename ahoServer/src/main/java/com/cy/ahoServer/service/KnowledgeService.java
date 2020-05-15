package com.cy.ahoServer.service;

import java.util.List;

import com.cy.ahoServer.base.BaseResponse;
import com.cy.ahoServer.beans.Knowledge;
import com.cy.ahoServer.beans.KnowledgeType;
import com.cy.ahoServer.beans.arg.KnowledgeTypeArg;

public interface KnowledgeService {

	BaseResponse<String> insertKnowledgeType(KnowledgeTypeArg arg);
	
	BaseResponse<List<KnowledgeType>> listKnowledgeType(String parentId);
	
	BaseResponse<List<Knowledge>> listKnowledgeByTypeId(String typeId);

	BaseResponse<Knowledge> insertKnowledge(Knowledge knowledge);

}
