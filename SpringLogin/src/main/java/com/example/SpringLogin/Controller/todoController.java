package com.example.SpringLogin.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.SpringLogin.model.todoList;
import com.example.SpringLogin.service.TodoService;

@Controller
@SessionAttributes("name")
public class todoController {
	@Autowired
	TodoService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/todoList", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name =getLoggedInUserName(model);
		//model.put("name", name);
		model.put("todo", service.retrievetodos(name));
		return "listTodo";
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String) model.get("name");
	}
	


	@RequestMapping(value = "/add-Todo", method = RequestMethod.GET)
	public String showAddtodo(ModelMap model) {
		model.addAttribute("todoa", new todoList(0, getLoggedInUserName(model), "default course", new Date(), false));
		return "Todo";
	}

	@RequestMapping(value = "/add-Todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid @ModelAttribute("todoa") todoList todo, BindingResult result) {

		if (result.hasErrors()) {
			return "Todo";
		}
		service.addTodo(getLoggedInUserName(model), todo.getCourse(), todo.getDate(), false);
		return "redirect:/todoList";
	}

	@RequestMapping(value = "/update-Todo", method = RequestMethod.GET)
	public String retrieveTodo(@RequestParam int id, ModelMap model) {
		todoList todoUpdate = service.retrieveTodo(id);
		model.put("todo", todoUpdate);
		return "updateTodoPage";
	}

	@RequestMapping(value = "/update-Todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") todoList todo, BindingResult result) {
		if (result.hasErrors()) {
			return "updateTodoPage";
		}
		todo.setName(getLoggedInUserName(model));
		service.UpdateTodo(todo);
		return "redirect:/todoList";
	}

	@RequestMapping(value = "/delete-Todo")
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/todoList";
	}
}
