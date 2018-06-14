package com.glarimy.library.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

@Controller
public class LibraryController {
	@Autowired
	Library library;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("addForm", "command", new Book());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Book book,
			BindingResult bindingResult, ModelMap model) {
		try {
			if (bindingResult.hasErrors()) {
				System.out.println("Errors");
				return "add";
			}
			System.out.println("Valid");
			library.add(book);
			model.addAttribute("isbn", book.getIsbn());
			return "addResponse";
		} catch (LibraryException e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView find() {
		return new ModelAndView("findForm", "command", new Criteria());
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String find(@ModelAttribute Criteria criteria, ModelMap model) {
		Book book;
		try {
			book = library.find(criteria.getIsbn());
			model.addAttribute("book", book);
			return "findResponse";
		} catch (LibraryException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
