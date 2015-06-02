package com.valik.service;

import com.valik.domain.Book;
import com.valik.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ApplicationServiceImpl implements AplicationService {
    @Autowired
    BookRepository bookRepository;

    public ApplicationServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public int removeBooksWithKNames() {
        List<Book> list = bookRepository.getAllBooks();
        int count = 0;
        for(Book book:list){
            if(book.getName().startsWith("K")){
                bookRepository.removeBook(book);
                count++;
            }
        }

        return count;
    }
    @Override
    @Transactional
    public int removeBoksIdNotFibanachi() {
        List<Book> list = bookRepository.getAllBooks();
        LinkedList<Integer> fibanachi = new LinkedList<>();
        fibanachi.add(0);
        fibanachi.add(1);
        int count = 0;
        for(Book book:list){
            if(book.getId()>1&&book.getId()==fibanachi.getLast()+fibanachi.get(fibanachi.size()-2)){
                fibanachi.add(book.getId());
            }else{
                bookRepository.removeBook(book);
                count++;
            }
        }
        return count;
    }
}
