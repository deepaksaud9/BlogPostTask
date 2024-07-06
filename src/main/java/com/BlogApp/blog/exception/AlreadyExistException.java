package com.BlogApp.blog.exception;

public class AlreadyExistException extends RuntimeException{

   public AlreadyExistException(String message){
       super(message);
   }
}
