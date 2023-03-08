package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Portfolio;
import com.example.demo.repository.PortRepo;

@Service
public class PortService {
	
	@Autowired
	PortRepo repository;
	
	public Optional<Portfolio> getPortfolio(int id){
		return repository.findById(id);
	}
	public String updateDetails(Portfolio stu) {
		repository.save(stu);
		return "updated";
	}
	public String deleteDetails(int id) {
		if(repository.existsById(id)) {
		repository.deleteById(id);
		return "ID Deleted";
		}
		else {
			return "ERROR ID NOT FOUND";
		}
	}
	public List<Portfolio> setPages(@PathVariable int offset,@PathVariable int PageSize){
		Page<Portfolio> page= repository.findAll(PageRequest.of(offset, PageSize));
		return page.getContent();
	}
	public List<Portfolio> getSort(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	public List<Portfolio> getSortDesc(String field){
		return repository.findAll(Sort.by(Sort.Direction.DESC,field));
	}

}
