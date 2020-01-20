package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepo;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
        
        @Autowired
        ReactiveMongoOperations operations;

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepo.saveAll(Flux.just(user)).subscribe();
	}
	
	@Override
	public Mono<User> findOne(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}
	
	@Override
	public Flux<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	@Override
	public Mono<User> update(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}
	
	@Override
	public Mono<Void> delete(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.deleteById(id);
	}
	
	@Override
	public Flux<User> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName);
	}

}
