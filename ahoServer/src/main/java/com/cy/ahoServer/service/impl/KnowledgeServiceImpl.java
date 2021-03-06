package com.cy.ahoServer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cy.ahoServer.base.BaseResponse;
import com.cy.ahoServer.beans.Knowledge;
import com.cy.ahoServer.beans.KnowledgeType;
import com.cy.ahoServer.beans.arg.KnowledgeTypeArg;
import com.cy.ahoServer.dao.KnowledgeDao;
import com.cy.ahoServer.dao.KnowledgeTypeDao;
import com.cy.ahoServer.service.KnowledgeService;

import utils.B2BUtil;
import utils.MyUtils;

@Service
public class KnowledgeServiceImpl implements KnowledgeService{
	@Resource
	private KnowledgeTypeDao knowledgetypeDao;
	
	@Resource
	private KnowledgeDao knowledgeDao;
	
	
	@Override
	public BaseResponse<String> insertKnowledgeType(KnowledgeTypeArg arg) {
		// TODO Auto-generated method stub
		BaseResponse<String> response=new BaseResponse<>();
		KnowledgeType knowledgeType=(KnowledgeType) B2BUtil.b2b(arg,KnowledgeType.class);
		knowledgeType.setId(MyUtils.getUUID());
		int i=knowledgetypeDao.insertKnowledgeType(knowledgeType);
		if (i>0) {
			response.setBody(knowledgeType.getId());
		}
		
		return response;
	}


	@Override
	public BaseResponse<List<KnowledgeType>> listKnowledgeType(String parentId) {
		// TODO Auto-generated method stub
		BaseResponse<List<KnowledgeType>> response=new BaseResponse<>();
		
		List<KnowledgeType> knowledgeTypes=knowledgetypeDao.selectKnowledgeType(parentId);
		
		response.setBody(knowledgeTypes);
		
		return response;
	}


	@Override
	public BaseResponse<List<Knowledge>> listKnowledgeByTypeId(String typeId) {
		// TODO Auto-generated method stub
		
		BaseResponse<List<Knowledge>> response=new BaseResponse<>();
		List<Knowledge> knowledges=knowledgeDao.selectKnowledge(typeId);
		response.setBody(knowledges);
		
		return response;
	}


	@Override
	public BaseResponse<Knowledge> insertKnowledge(Knowledge knowledge) {
		// TODO Auto-generated method stub
		BaseResponse<Knowledge> response=new BaseResponse<>();
		knowledge.setId(MyUtils.getUUID());
		int i=knowledgeDao.insertKnowledge(knowledge);
		if (i>0) {
			response.setBody(knowledge);
		}
		return response;
	}


}
