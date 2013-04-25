package com.epiuse.drools.util;

import org.drools.KnowledgeBase;
import org.drools.base.ClassObjectType;
import org.drools.builder.DecisionTableConfiguration;
import org.drools.builder.DecisionTableInputType;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class DroolsUtils {

	private static DroolsUtils instance = null;
	
	private KnowledgeBuilder knowledgeBuilder = null;
	
	private KnowledgeBase knowledgeBase = null;
	
	
	private DroolsUtils(){
		knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		DecisionTableConfiguration dtconf = KnowledgeBuilderFactory.newDecisionTableConfiguration();
		dtconf.setInputType(DecisionTableInputType.XLS);
		
		Resource resource = ResourceFactory.newClassPathResource("ExamplePolicyPricing.xls");
		
		knowledgeBuilder.add(resource,ResourceType.DTABLE, dtconf);
		knowledgeBase = knowledgeBuilder.newKnowledgeBase();
		
//		PricingRuleDTExample rule = new PricingRuleDTExample();
//		rule.setKbase(kbase);
//		rule.setKsession(ksession)
	}
	
	public static void init(){
		if (instance != null){
			throw new RuntimeException("DroolsUtils already initialized");
		}
		
		instance = new DroolsUtils();
	}
	
	public static DroolsUtils getInstance(){
		if (instance == null){
			throw new RuntimeException("DroolsUtils is null");
		}
		return instance;
	}
	
	public StatelessKnowledgeSession getNewKnowledgeSession(){
		return knowledgeBase.newStatelessKnowledgeSession();
	}
	
}
