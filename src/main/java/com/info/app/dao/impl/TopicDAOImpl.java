package com.info.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.info.app.dao.TopicDao;
import com.info.app.entities.Topic;

@Transactional
@Repository
public class TopicDAOImpl implements TopicDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		String hql="from Topic as t order by t.topicId"; 
		
		//Create an instance of Query for executing a Java Persistence query language statement.
		
		return (List<Topic>) entityManager.createQuery(hql).getResultList();
	}
	

	
	@Override
	public Topic getTopicById(int topicId) {
		//Find by primary key. Search for an entity of the specified class and primary key.
		//If the entity instance is contained in the persistence context, it is returned from there.
		
		
		return entityManager.find(Topic.class, topicId); 
		
	}

	@Override
	public void addTopic(Topic topic) {
		
		//Make an instance managed and persistent.
		entityManager.persist(topic);
		
	}

	@Override
	public void deleteTopic(int topicId) {
		Topic topic=getTopicById(topicId);
		if(topic!=null) {
			entityManager.remove(topic);
		}else {
			System.out.println("Topic coan not be removed");
		}
		
	}

	@Override
	public boolean topicExists(String title, String category) {
		String hql="from Topic as t where t.title=?1 and t.category=?2";
		int count=entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList().size();
		return count>0 ? true:false;
	}



	@Override
	public void updateTopic(Topic topic) {
		Topic topicFromDb =  getTopicById(topic.getTopicId());
		
		if(topicFromDb != null) {
			topicFromDb.setTitle(topic.getTitle());
			topicFromDb.setCategory(topic.getCategory());
			entityManager.flush();
		} else {
			System.out.println("topic does not exist");
		}
		
		
	}
	
	

}
