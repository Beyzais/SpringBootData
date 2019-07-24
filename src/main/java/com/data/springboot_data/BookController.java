package com.data.springboot_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/books") //show all books
    String findAll(Model model){
         List<Book> bookList = (List<Book>) repository.findAll();
         model.addAttribute("Kitaplar", bookList);
         return "view";
     }


}


