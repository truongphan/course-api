package com.java.springboot.utils;

import com.java.springboot.topic.Topic;
import com.java.springboot.topic.TopicEntity;

public class TopicUtils {

	public static Topic toTopicModel(TopicEntity entity) {
		return Topic.builder().id(entity.getId()).name(entity.getName()).description(entity.getDescription()).build();
	}
	
	public static TopicEntity toTopicEntity(Topic model) {
		return TopicEntity.builder().id(model.getId()).name(model.getName()).description(model.getDescription()).build();
	}
}
