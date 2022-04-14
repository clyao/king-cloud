package com.clyao.basis.testexception;

public class TestException {

    public static void main(String[] args) {
        throw new CustomException("错误");
    }

}

class CustomException extends RuntimeException{

    public CustomException(String message) {
        super(message);
    }
}

