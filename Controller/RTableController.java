package com.springbootproject.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootproject.model.RTable;
import com.springbootproject.repository.RTableRepo;
import com.springbootproject.service.RTableService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class RTableController {

	@Autowired
	private RTableService rTableService;
	
	@Autowired
	private RTableRepo repo;

	
	@GetMapping("/adminTableList")
	public String listOfTables(Model model) {
		model.addAttribute("tables", rTableService.getListTables());
		// in tables list of data is stored
		return "adminTableList";
	}
	
	@GetMapping("/userTableList")
	public String userTableList(Model model) {
		model.addAttribute("tables", rTableService.getListTables());
		return "userTableList";
	}

	@GetMapping("/add/table")
	public String createTableForm(Model model) {

		// create table object to hold table form data
		RTable rTable = new RTable();
		model.addAttribute("tableData", rTable);
		return "adminTable";

	}

	@PostMapping("/saveTable")
	public String saveTableDetails(@ModelAttribute("tableData") RTable table) {
	
		rTableService.saveTableDetails(table);

		return "adminTableList";


	}

	@PostMapping("/saveAdminTable")
	public String saveAdminTableDetails(@ModelAttribute("tableData") RTable table, Model model) {

		RTable rTable = new RTable(table.getId(), table.getTableNumber(), table.getSeatingCapacity(),
				table.getDuration(), "Available",table.getUserName());
		rTableService.saveTableDetails(rTable);
		
		model.addAttribute("tables", rTableService.getListTables());
		return "adminTableList";
	}

//	@GetMapping("/adminTableData")
//	public String adminTableList(Model model) {
//		model.addAttribute("tables", rTableService.getListTables());
//		return "adminTableList";
//	}

	@GetMapping("/edit/tables/{id}")
	public String editTable(@PathVariable Long id, Model model) {
		model.addAttribute("table", rTableService.getTableDetailsById(id));

		String time = rTableService.getTableDetailsById(id).getDuration();
		if (time == null) {

			return "edit_admin";
		} else {

			model.addAttribute("tables", rTableService.getListTables());

