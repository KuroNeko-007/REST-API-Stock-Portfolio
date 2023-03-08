package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Portfolio;
import com.example.demo.repository.PortRepo;
import com.example.demo.service.PortService;

@RestController
@CrossOrigin
public class PortController {

	@Autowired
	PortRepo serviceRepository;
	@Autowired
	PortService service;
	@GetMapping("/")
	List<Portfolio> getList(){
		return serviceRepository.findAll();
	}
	@PostMapping("/")
	public Portfolio create(@RequestBody Portfolio stu) {
		return serviceRepository.save(stu);
	}
	@GetMapping("/{id}")
	public Optional<Portfolio> getbyid(@PathVariable int id){
		return service.getPortfolio(id);
	}
	@PutMapping("/{id}")
	public String update(@PathVariable int id, @RequestBody Portfolio stu) {
		if(serviceRepository.existsById(id)) {
			Portfolio t= new Portfolio();
			t.setId(id);
			t.setChg(stu.getChg());
			t.setChgper(stu.getChgper());
			t.setHoldings(stu.getHoldings());
			t.setPrice(stu.getPrice());
			t.setName(stu.getName());
			serviceRepository.save(t);
			return "UPDATED";
		}
		else {
			return "ERROR ID NOT FOUND";
		}
	}
	@DeleteMapping("/{id}")
		public String delete(@PathVariable int id) {
			return service.deleteDetails(id);
		}
	@GetMapping("/{offset}/{PageSize}")
	public List<Portfolio> PortfolioWithPagination(@PathVariable int offset,@PathVariable int PageSize){
		return service.setPages(offset,PageSize);
		
	}
	@GetMapping("/asc/{field}")
	public List<Portfolio> PortfolioSortList(@PathVariable String field){
		return service.getSort(field);
	}
	@GetMapping("/desc/{field}")
	public List<Portfolio> PortfolioSortListDesc(@PathVariable String field){
		return service.getSortDesc(field);
	}
}
