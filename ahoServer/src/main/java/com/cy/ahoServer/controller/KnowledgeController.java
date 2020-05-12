package com.cy.ahoServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cy.ahoServer.base.BaseResponse;
import com.cy.ahoServer.beans.KnowledgeType;
import com.cy.ahoServer.beans.arg.KnowledgeTypeArg;
import com.cy.ahoServer.service.KnowledgeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("k")
@RestController
@RequestMapping("k")
public class KnowledgeController {
	
	@Autowired
	private KnowledgeService knowledgeService;
	
	@ApiOperation("it")   
	@PostMapping("it")
	private BaseResponse<String> addKnowledgeType(@RequestBody KnowledgeTypeArg arg){
		return knowledgeService.insertKnowledgeType(arg);
	}
	
	
	@ApiOperation("st")   
	@GetMapping("st")
	private BaseResponse<List<KnowledgeType>> listKnowledgeType(@RequestParam(name = "parentId",required = false) String parentId){
		return knowledgeService.listKnowledgeType(parentId);
	}

}
