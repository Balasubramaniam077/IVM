package com.webapp.demo.Controller;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.Model.Inventory;
import com.webapp.demo.Repository.Inventorydao;
import com.webapp.demo.Service.InventoryService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;

	@Autowired
	Inventorydao in;

	@PostMapping("/inventory")
	public ResponseEntity<Inventory> postInventory(@RequestBody Inventory i) {
		inventoryService.createInventory(i);
		return ResponseEntity.status(HttpStatus.CREATED).body(i);
	}

	@GetMapping("/inventory")
	public List<Inventory> getInventory() {
		return inventoryService.getAllInventory();
	}

	
	@GetMapping("/inventory/{id}")
	public Inventory getInventory(@PathVariable Long id) {
		return inventoryService.getInventoryById(id);
	}



	@PutMapping("/inventory")
	public void putinv(@RequestBody Inventory i) {
		inventoryService.editInInventory(i);
	}

	@DeleteMapping("/inventory")
	public void delinv(Long id) {
		inventoryService.deleteInInventory(id);
	}

	@DeleteMapping("/del")
	public void deleteOldDates() {
	 Calendar calendar = Calendar.getInstance();
	 Date myDate = new Date(); 
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_MONTH, -90);
       
		in.deleteByDateBefore(calendar.getTime());
	}

}
