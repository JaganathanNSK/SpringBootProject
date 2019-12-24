package com.example.SpringLogin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringLogin.model.todoList;

@Service
public class TodoService {

	public static List<todoList> todos=new ArrayList<todoList>();
	public static int todoCount=5;
	
	static {
		todos.add(new todoList(1, "Sudhakar", "Study history", new Date(), false));
		todos.add(new todoList(2,"Sudhakar","Study geography",new Date(),false));
		todos.add(new todoList(3,"Sudhakar","Study GK",new Date(),false));
		todos.add(new todoList(4,"Mani","Study Java",new Date(),false));
		todos.add(new todoList(5,"Mani","Study script",new Date(),false));
	}
	
	public List<todoList> retrievetodos(String name){
	
		List<todoList> retrieved=new ArrayList<todoList>();
		for (todoList todo : todos) {
			
			if(todo.getName().equalsIgnoreCase(name)) {
				retrieved.add(todo);
			}
		}
		return retrieved;
	}
	
	public void addTodo(String name,String Course,Date date,boolean isDone) {
		todos.add(new todoList(++todoCount,name,Course,date,isDone));
	}
	
	public todoList retrieveTodo(int id){
		
		for (todoList todo : todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;		
	}
	
	public List<todoList> UpdateTodo(todoList todo){
		/*for (todoList td : todos) {
			if(td.getId()==todo.getId()) {
				td.setCourse(todo.getCourse());
				td.setDate(todo.getDate());
			}
		}*/
		
		todos.remove(todo);
		todos.add(todo);
		return todos;
	}
	
	public void deleteTodo(int id) {
		Iterator<todoList> it = todos.iterator();
		while(it.hasNext()){
			todoList td=it.next();
			if(td.getId()==id) {
				it.remove();
			}
		}
	}
}
